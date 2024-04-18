/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpersonal;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
/**
 *
 * @author Jesús Ballesta
 */
public class TestPersonal {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Personal personal = new Personal();
        Auxiliar n = new Auxiliar();
        
        
        Persona persona1 = new Persona("Jesus", "Ballesta", "ballesta@gmail.com", "masc", "10/10/2005", "España");
        Persona persona2 = new Persona("Jesus2", "Ballesta2", "prueba", "masc", "10/10/2005", "España");
        personal.addPersona(persona1);
        personal.addPersona(persona2);
        
        ArrayList<Persona> prueba = new ArrayList<>();
        
        
        int opcion;
        boolean cerrado = false;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Pedir el nombre de un país y mostrar los datos de todas las personas de ese país.");
            System.out.println("2. Borrar una persona, pidiendo por teclado el mail de esta.");
            System.out.println("3. Pedir día y mes y mostrar todas las personas que cumplen años ese día");
            System.out.println("4. Mostrar la persona (o personas) más joven(es) de todas (Actual Muestra TOdo)");
            System.out.println("5. Leer personas de otro fichero");
            System.out.println("6. Guardar personas en un fichero csv");
            opcion = teclado.nextInt();

            try {
                if (opcion > 9){
                    throw new NMDR(opcion);
                }
                switch (opcion) {
                    case 0:
                        cerrado = true;
                        System.out.println("Se ha salido del programa");
                        break;
                    case 1:
                        System.out.println("Introduce un pais");
                        teclado.nextLine();
                        String pais = teclado.nextLine();
                        personal.personasPais(pais);
                        break;
                    case 2:
                        System.out.println("Introduce el email de la persona a borrar:");
                        teclado.nextLine();
                        String email = teclado.nextLine();
                        personal.borrarPorEmail(email);
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        personal.mostrarTodo();
                        break;
                        
                    case 5:
                        System.out.println("Introduce la ruta donde se encuntra el fichero");
                        teclado.nextLine();
                        String ruta = teclado.nextLine();
                        System.out.println("Ahora introduce el nombre del fichero");
                        String fichero = teclado.nextLine();
                        System.out.println("Se va a utilizar la siguiente ruta: " + ruta + fichero);
                        String ficheroFinal = ruta + fichero;
                        Auxiliar.leerPersonas(ficheroFinal);
                        
                    case 6:
                        prueba.add(persona1);
                        prueba.add(persona2);
                        Auxiliar.guardarPersonas(prueba);
                        

                }
            } catch (Exception NMDR) {
                System.out.println("Numero incorrecto , introduce una opcion correcta");
            }
        } while (cerrado != true);

    }
    
    public static class NMDR extends Exception{
        private int num; 

        NMDR(int n) {
            if (this.num > 4 || this.num < 0)
            this.num = n;
        }
        
        public String toString(){
            return "Numero fuera de rango[" + this.num + "]";
        }
        
    }
    
   
    
    

}
