/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.text.Normalizer;

/**
 *
 * @author jesbalber
 */
public class Ahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> listaPalabras;
        
        ArrayList<Jugador> listaJugadores;
        
        ArrayList<Partida> listaPartidas;
        String objetivo;
        listaPalabras = leerPalabras("./src/Recursos/castellano.txt");
        System.out.println("Total de palabras " + listaPalabras.size());
        
        listaJugadores = leerJugadores("./src/Recursos/jugadores.txt");
        System.out.println("Total de jugadores " + listaJugadores.size());
        
        listaPartidas = leerPartidas("./src/Recursos/partidas.txt");
        System.out.println("Total de partidas " + listaPartidas.size());
        
        if (!listaPalabras.isEmpty()){
            objetivo = obtenerObjetivo(listaPalabras);
        }
        
        String respuesta = obtenerObjetivo(listaPalabras);
        System.out.println("Palabra: " + respuesta);
        
        int opcion = 0;
        do {  
            System.out.println("1. Seleccionar Jugadores");
            System.out.println("2. Jugar");
            System.out.println("3. Elegir Palabra");
            System.out.println("4. Cambiar fichero de palabras");
            System.out.println("5. Ranking (10 primeros");
            System.out.println("6. Dar de alta jugador");
            System.out.println("7. Listar jugadores (alfabético)");
            System.out.println("8. Estadisticas de todos los jugadores");
            System.out.println("9. Establecer puntos por partida");
            System.out.println("0. Salir");
            
        } while ();
    }

    public static ArrayList<String> leerPalabras(String archivo) {
        ArrayList<String> listaPalabras = new ArrayList<>();

        File f = new File(archivo);
        try {
            Scanner lector = new Scanner(f);
            while(lector.hasNext()){
                String palabra = lector.nextLine();
                listaPalabras.add(palabra);
            }
            System.out.println("Se ha cargado el fichero");
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error" + e);
            
           /* try {
                
                if (f.createNewFile()){
                    System.out.println("Archivo creado: " + f.getName());
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }*/
        }
        return listaPalabras;
    }

    private static String obtenerObjetivo(ArrayList<String> listaPalabras) {
        String objetivo = "";
        do {
        int random = (int)(Math.random() * listaPalabras.size());
        objetivo = listaPalabras.get(random);
        }while(objetivo.length() < 4);
        return normalizar(objetivo);
    
    }

    private static String normalizar(String palabraSeleccionada) {
        palabraSeleccionada = Normalizer.normalize(palabraSeleccionada, Normalizer.Form.NFD);
        palabraSeleccionada = palabraSeleccionada.replaceAll("[\u0300-\u0301]", "");
        return palabraSeleccionada;
    }
    
    public static ArrayList<Jugador> leerJugadores(String archivo){
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        try {
            File f = new File(archivo);
            Scanner lector = new Scanner(f);
            while(lector.hasNext()){
                String linea = lector.nextLine();
                String [] datosJugador = linea.split(";");
                String nombre = datosJugador[0];
                int ganadas = Integer.parseInt(datosJugador[1]);
                int perdidas = Integer.parseInt(datosJugador[2]);
                int puntos = Integer.parseInt(datosJugador[3]);
                listaJugadores.add(new Jugador(nombre,ganadas,perdidas,puntos));
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("eror" + e);
            e.printStackTrace();
        }
        return listaJugadores;
    }
    
    public static ArrayList<Partida> leerPartidas(String archivo){
        ArrayList<Partida> listaPartidas = new ArrayList<>();
        try {
            File f = new File(archivo);
            Scanner lector = new Scanner(f);
            while(lector.hasNext()){
                String linea = lector.nextLine();
                String [] datosPartida = linea.split(";");
                int numPartida= Integer.parseInt(datosPartida[0]);
                String jugadorPalabra = datosPartida[1];
                String jugadorAdivina = datosPartida[2];
                String palabra = datosPartida[3];             
                String ganador = datosPartida[4]; 
                listaPartidas.add(new Partida(numPartida, jugadorPalabra, jugadorAdivina, palabra, ganador));
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("eror" + e);
            e.printStackTrace();
        }
        return listaPartidas;
    }
    

}
