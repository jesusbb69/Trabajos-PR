/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Representa un bloque en el laberinto.
 * Cada bloque puede contener un valor asociado.
 * @author JBB
 */



@XmlRootElement
public class Block implements  Serializable {
    private String value;
    
    /**
     * Constructor por defecto de la clase Block.
     * Crea un bloque sin valor.
     */
    
    public Block(){
        this.value=null;
    }
    
      /**
     * Obtiene el valor del bloque.
     * @return El valor del bloque.
     */
    
    public String getValue(){
        return this.value;
    }
    
    /**
     * Establece el valor del bloque.
     * 
     * @param value El nuevo valor del bloque.
     */
    
    public void setValue(String value){
        this.value=value;
    }
    
    /**
     * Verifica si el bloque está vacío (sin valor).
     * @return true si el bloque está vacío, false si tiene un valor.
     */
    
    public boolean isEmpty(){
        return this.value==null;
    }
}
