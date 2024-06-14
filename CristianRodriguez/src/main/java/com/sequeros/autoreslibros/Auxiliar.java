/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.autoreslibros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Auxiliar {

    public static ArrayList<Autor> leerAutores(String nomFich) {
        //ArrayList<Persona> personal = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();
        try {
            // Intentamos abrir el fichero
            File f = new File(nomFich);
            Scanner lector = new Scanner(f);

            // Si llega aquí es que ha abierto el fichero :)
            while (lector.hasNext()) {
                String valor = lector.nextLine();
                String[] autor = valor.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = LocalDate.parse(autor[3], formatter);
                Autor a = new Autor(autor[0], autor[1], autor[2], fecha, autor[4]);
                autores.add(a);
            }

            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        }
        return autores;
    }

    public static void grabarAutores(String archivo, ArrayList<Autor> lista) {
        try {
            FileWriter fw = new FileWriter(archivo);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            for (Autor autor : lista) {
                String fecha =autor.getNacimiento().get().format(formatter);
                fw.write(autor.getDni() + "," + autor.getNombre() + "," + autor.getApellidos() + "," + fecha + "," + autor.getPathImagen());
                fw.write("\n"); // escribimos nueva línea
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
