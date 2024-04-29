/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.sumaryrestar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class PrimaryController implements Initializable {

    @FXML
    private Text resultado;
    @FXML
    private Button uno;
    @FXML
    private Button cinco;
    @FXML
    private Button diez;
    @FXML
    private TextField operacion;
    @FXML
    private Button suma;
    @FXML
    private CheckBox restar;

    @FXML
    private Text textoResta;

    private int valor = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void pulsarBoton(ActionEvent event) {
        int cantidad = 0;
        Button boton = (Button) event.getSource();
        if (boton == uno) {
            cantidad = 1;
        } else if (boton == cinco) {
            cantidad = 5;
        } else if (boton == diez) {
            cantidad = 10;
        }
        if (restar.isSelected()) {
            valor -= cantidad;
        } else {
            valor += cantidad;
        }
        actualizarResultado();
    }

    @FXML
    private void botonSumar(ActionEvent event) {
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(operacion.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (restar.isSelected()) {
            valor -= cantidad;
        } else {
            valor += cantidad;
        }
        actualizarResultado();
    }

    @FXML
    private void cambiarResta(ActionEvent event) {
        if (restar.isSelected()) {
            textoResta.setVisible(true);
        } else {
            textoResta.setVisible(false);
        }
    }

    private void actualizarResultado() {
        resultado.setText(Integer.toString(valor));
    }
}
