/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tresenraya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Jesús Ballesta
 */
public class TresenrayaController implements Initializable {

    @FXML
    private Button boton1;
    @FXML
    private Button boton2;
    @FXML
    private Button boton3;
    @FXML
    private Button boton4;
    @FXML
    private Button boton5;
    @FXML
    private Button boton6;
    @FXML
    private Button boton7;
    @FXML
    private Button boton8;
    @FXML
    private Button boton9;
    @FXML
    private Button limpiar;
    @FXML
    private Button empezar;
    @FXML
    private TextField puntuacionX;
    @FXML
    private TextField puntuacionO;

    private boolean turnoX = true;
    private int puntosX = 0;
    private int puntosO = 0;
    @FXML
    private Label jugadorX;
    @FXML
    private Label jugadorO;
    @FXML
    private GridPane panel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        deshabilitarJuego();
        
    }
    
    
    // No se porque pero al iniciar el juego se me ha desajustado y no se ve claro , lo he intenado solucionar pero no hay forma

    @FXML
    private void pulsarBoton(ActionEvent event) {

        Button boton = (Button) event.getSource();
        if (boton.getText().isEmpty()) {
            boton.setText(turnoX ? "X" : "O");            
            turnoX = !turnoX;
            actualizarNombreJugador();
            comprobarGanador();

        }
    }

    @FXML
    private void limpiarBoton(ActionEvent event) {
        limpiarTablero();
        turnoX = true; 
        actualizarNombreJugador();
    }

    @FXML
    private void empezarBoton(ActionEvent event) {
        habilitarJuego();
        limpiarTablero();
        reiniciarPuntuacion();
        jugadorX.setTextFill(Color.GREEN);

    }

    private void limpiarTablero() {
        boton1.setText("");
        boton2.setText("");
        boton3.setText("");
        boton4.setText("");
        boton5.setText("");
        boton6.setText("");
        boton7.setText("");
        boton8.setText("");
        boton9.setText("");
    }

    private void deshabilitarJuego() {
        panel.setDisable(true);

    }

    private void habilitarJuego() {
        panel.setDisable(false);
    }

    private void actualizarNombreJugador() {        
       if (turnoX) {
            jugadorX.setTextFill(Color.GREEN);
            jugadorO.setTextFill(Color.BLACK);
        } else {
            jugadorX.setTextFill(Color.BLACK);
            jugadorO.setTextFill(Color.GREEN);
        }    

    }

    private void reiniciarPuntuacion() {
        puntosX = 0;
        puntosO = 0;
        actualizarPuntuacion();
    }

    private void actualizarPuntuacion() {
        puntuacionX.setText(String.valueOf(puntosX));
        puntuacionO.setText(String.valueOf(puntosO));
    }

    private void comprobarGanador() {
        String[][] tablero = new String[3][3];
        tablero[0][0] = boton1.getText();
        tablero[0][1] = boton2.getText();
        tablero[0][2] = boton3.getText();
        tablero[1][0] = boton4.getText();
        tablero[1][1] = boton5.getText();
        tablero[1][2] = boton6.getText();
        tablero[2][0] = boton7.getText();
        tablero[2][1] = boton8.getText();
        tablero[2][2] = boton9.getText();

       
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].isEmpty() && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                if (tablero[i][0].equals("X")) {
                    puntosX++;
                } else {
                    puntosO++;
                }
                actualizarPuntuacion();
                limpiarTablero();
                return;
            }
        }

        
        for (int i = 0; i < 3; i++) {
            if (!tablero[0][i].isEmpty() && tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i])) {                
                if (tablero[0][i].equals("X")) {
                    puntosX++;
                } else {
                    puntosO++;
                }
                actualizarPuntuacion();
                limpiarTablero();
                return;
            }
        }

        if (!tablero[1][1].isEmpty()) {
            if ((tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]))
                    || (tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]))) {
                if (tablero[1][1].equals("X")) {
                    puntosX++;
                } else {
                    puntosO++;
                }
                actualizarPuntuacion();
                limpiarTablero();
                return;
            }
        }

        if (tableroCompleto(tablero)) {
            puntuacionX.setText("EMPATE");
            puntuacionO.setText("EMPATE");
        }
    }

    private boolean tableroCompleto(String[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].isEmpty()) {                    
                    return false;
                }
            }
        }       
        return true;
    }
}
