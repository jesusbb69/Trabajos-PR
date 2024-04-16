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


/**
 *
 * @author Jesús Ballesta
 */
public class Auxiliar {
    
    public static void leerPersonas(String path){
        ArrayList<Persona> listaPersonas = new ArrayList<>();
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
                listaPersonas.add(new Persona(nombre, apellidos, email, genero, nacimiento, pais));
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("eror" + e);
            e.printStackTrace();
        }       
    }
    
    
    public static void guardarPersonas(Persona persona){
        
    }
}
