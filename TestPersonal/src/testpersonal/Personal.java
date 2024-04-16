/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpersonal;

import java.util.ArrayList;
/**
 *
 * @author Jesús Ballesta
 */
public class Personal {
    private ArrayList<Persona> persona;

    public Personal() {
        this.persona = new ArrayList<>();
    }
    
    public void addPersona(Persona añadir){
        this.persona.add(añadir);
        System.out.println(getPersona() + " ha sido añadido a la lista de persona");
              
    }
    
    public void borrarPorEmail(String email){
        for (Persona persona1 : persona) {
            if (persona1.getEmail().equals(email)){
                this.persona.remove(email);
            }
                
        }
    }
    
    public void personasPais(String pais){
        for (Persona persona1: persona){
            if(persona1.getPais().equals(pais)){
                System.out.println(persona1.toString());
            }
                
        }
    }

    public ArrayList<Persona> getPersona() {
        return persona;
    }

    public void setPersona(ArrayList<Persona> persona) {
        this.persona = persona;
    }
    
    public void borrarPersona(String email){
        for (Persona persona1 : persona) {
            if(persona1.getEmail().equals(email)){
                this.persona.remove(persona1);
            }
        }
    }
    
}
