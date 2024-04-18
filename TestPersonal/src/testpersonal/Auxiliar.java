/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpersonal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.util.List;


/**
 *
 * @author Jesús Ballesta
 */
public class Auxiliar {
    
    public static void leerPersonas(String path){
        try {
            File f = new File(path);
            Scanner lector = new Scanner(f);
            while(lector.hasNext()){
                String linea = lector.nextLine();
                String [] datosPersona = linea.split(",");
                String nombre = datosPersona[0];
                String apellidos = datosPersona[1];
                String email = datosPersona[2];
                String genero = datosPersona[3];
                String nacimiento = datosPersona[4];
                String pais = datosPersona[5];               
                Persona persona1 = new Persona(nombre, apellidos, email, genero, nacimiento, pais);
                System.out.println(persona1.toString());
            }
            
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("eror" + e);
            e.printStackTrace();
        }       
    }
    
    
    public static void guardarPersonas(List<Persona> personas){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String nombreArchivo = "./src/Recursos/personal_" + fechaHoraActual.format(formatter) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                String linea = persona.getNombre() + "," +
                               persona.getApellido() + "," +
                               persona.getEmail() + "," +
                               persona.getGenero() + "," +
                               persona.getNacimiento() + "," +
                               persona.getPais();
                if (i != personas.size() - 1) {
                    linea += "\n"; 
                }
                writer.write(linea);
            }
            System.out.println("Personas guardadas en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    
    }
}
