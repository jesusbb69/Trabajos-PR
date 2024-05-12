/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
/**
 * FXML Controller class
 *
 * @author Jesús Ballesta
 */
public class CalculadoraController implements Initializable {


    @FXML
    private Button limpiar;
    @FXML
    private Button dividir;
    @FXML
    private Button multiplicar;
    @FXML
    private Button restar;
    @FXML
    private Button siete;
    @FXML
    private Button ocho;
    @FXML
    private Button nueve;
    @FXML
    private Button sumar;
    
    
    @FXML
    private TextField resultado;
    
    private double operando1 = 0;
    private String operador = "";
    private boolean inicioNuevoNumero = true;
    private boolean decimal = false;
 
    
    @FXML
    private Button cuatro;
    @FXML
    private Button cinco;
    @FXML
    private Button seis;
    @FXML
    private Button uno;
    @FXML
    private Button dos;
    @FXML
    private Button tres;
    @FXML
    private Button igual;
    @FXML
    private Button cero;
    @FXML
    private Button coma;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void limpiarBoton(ActionEvent event) {
        limpiar();
    }

    @FXML
    private void operarBoton(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String op = boton.getText();
        operador(op);
    }

    @FXML
    private void numeroBoton(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String textoBoton = boton.getText();
        agregarNumero(textoBoton);
    }
    
    @FXML
    public void igualBoton(ActionEvent event) {
        calcular();
    }
    
    private void limpiar() {
        resultado.setText("");
        operando1 = 0;
        operador = "";
        inicioNuevoNumero = true;
    }

    private void operador(String op) {
        operando1 = Double.parseDouble(resultado.getText());
        operador = op;
        inicioNuevoNumero = true;
        
    }

    private void agregarNumero(String numero) {
        if (inicioNuevoNumero) {
            resultado.setText(numero);
            inicioNuevoNumero = false;
        } else {
            resultado.setText(resultado.getText() + numero);
        }
    }

    private void calcular() {
        double operando2 = Double.parseDouble(resultado.getText());
        double resultados = 0;
        switch (operador) {
            case "/":
                if (operando2 == 0){
                    resultado.setText("ERR");
                }
                resultados = operando1 / operando2;
                break;
            case "X":
                resultados = operando1 * operando2;
                break;
            case "-":
                resultados = operando1 - operando2;
                break;
            case "+":
                resultados = operando1 + operando2;
                break;
        }        
        resultado.setText(String.valueOf(resultados));
        inicioNuevoNumero = true;
    }

    @FXML
    private void decimalBoton(ActionEvent event) {
        if (!decimal) {
            resultado.setText(resultado.getText() + ".");
            decimal = true;
            inicioNuevoNumero = false;
        }
    }   
    
}
