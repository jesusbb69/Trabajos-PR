/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * Representa un tamaño con ancho y alt
 * Esta clase se utiliza para definir las dimensiones de un objeto en el espacio bidimensional
 * 
 * @author JBB
 */

@XmlRootElement
public class Size implements Cloneable, Comparable<Size>, Serializable {
    private int width; 
    private int height;
    
    /**
     * Constructor por defecto de la clase Size
     * Crea un objeto Size con ancho y alto
     */
   
    public Size(){
    }
    
    /**
     * Constructor de la clase Size
     * Crea un objeto Size con el ancho y alto especificados
     * 
     * @param width El ancho del objeto Size
     * @param height El alto del objeto Size
     */

    public Size(int width,int height){
        this.width=width;
        this.height=height;
    }
    
    /**
     * Crea y devuelve una copia del objeto Size
     * @return Una copia del objeto Size
     * @throws CloneNotSupportedException Si la clonación no está permitida para este objeto
     */
    
    public Object clone() throws CloneNotSupportedException{
        return new Size(this.getWidth(), this.getHeight());
    }
    
    
    
    @Override
    public boolean equals(Object o){
        if(! (o instanceof Size)){
            return false;
        }
        if (this.getWidth()==((Size)(o)).getWidth() && this.getHeight()==((Size)(o)).getHeight()){
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     * Compara este objeto Size con otro objeto Size
     * @param o El objeto Size a comparar
     * @return 0 si los tamaños son iguales, -1 si este tamaño es menor que el tamaño dado, 1 si este tamaño es mayor
     */
    
     @Override
    public int compareTo(Size o) {
        if(this.getWidth()==o.getWidth() && this.getHeight()==o.getHeight())
            return 0;
        if(this.getWidth()<o.getWidth())
            return -1;
        else
            return 1;
    }
    
    /**
     * Devuelve una cadena del objeto en String 
     * @return Una cadena que representa el objeto Size W: ancho H: alto
     */
    
    public String toString(){
        return "W:"+this.width+" H:"+this.height;
    }
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
 

}
