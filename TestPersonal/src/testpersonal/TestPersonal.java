/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpersonal;

import java.util.Scanner;

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
        int opcion;
        boolean cerrado = false;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Pedir el nombre de un país y mostrar los datos de todas las personas de ese país.");
            System.out.println("2. Borrar una persona, pidiendo por teclado el mail de esta.");
            System.out.println("3. Pedir día y mes y mostrar todas las personas que cumplen años ese día");
            System.out.println("4. Mostrar la persona (o personas) más joven(es) de todas");
            opcion = teclado.nextInt();

            try {
                if (opcion > 4){
                    throw new NMDR(opcion);
                }
                switch (opcion) {
                    case 0:
                        cerrado = true;
                        System.out.println("Se ha salido del programa");
                        break;
                    case 1:
                        System.out.println("Introduce el nombre del pais:");
                        teclado.nextLine();
                        String pais = teclado.nextLine();
                        
                        
                        break;
                    case 2:

                        System.out.println("Introduce el email de la persona a borrar:");
                        teclado.nextLine();
                        String email = teclado.nextLine();
                        
                        break;
                    case 3:

                        break;
                    case 4:
                        break;

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
