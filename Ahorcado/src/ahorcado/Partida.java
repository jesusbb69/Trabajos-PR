/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author jesbalber
 */
public class Partida {
    private int numPartida;
    private String jugadorPalabra;
    private String jugadorAdivina;
    private String palabra;
    private final int puntos = 10;
    private String ganador;

    public Partida(int numPartida, String jugadorPalabra, String jugadorAdivina, String palabra, String ganador) {
        this.numPartida = numPartida;
        this.jugadorPalabra = jugadorPalabra;
        this.jugadorAdivina = jugadorAdivina;
        this.palabra = palabra;       
        this.ganador = ganador;
    }

    public int getNumPartida() {
        return numPartida;
    }

    public void setNumPartida(int numPartida) {
        this.numPartida = numPartida;
    }

    public String getJugadorPalabra() {
        return jugadorPalabra;
    }

    public void setJugadorPalabra(String jugadorPalabra) {
        this.jugadorPalabra = jugadorPalabra;
    }

    public String getJugadorAdivina() {
        return jugadorAdivina;
    }

    public void setJugadorAdivina(String jugadorAdivina) {
        this.jugadorAdivina = jugadorAdivina;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Partida{" + "numPartida=" + numPartida + ", jugadorPalabra=" + jugadorPalabra + ", jugadorAdivina=" + jugadorAdivina + ", palabra=" + palabra + ", puntos=" + puntos + ", ganador=" + ganador + '}';
    }
    
    
    
         
}
