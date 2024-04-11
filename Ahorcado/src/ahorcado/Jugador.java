/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author jesbalber
 */
public class Jugador {
    private String nombre;
    private int ganadas;
    private int perdidas;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.ganadas = 0;
        this.perdidas = 0;
        this.puntos = 0;
    }

    public Jugador(String nombre, int ganadas, int perdidas, int puntos) {
        this.nombre = nombre;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.puntos = puntos;
    }
    
    
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", ganadas=" + ganadas + ", perdidas=" + perdidas + ", puntos=" + puntos + '}';
    }
    
    
}
