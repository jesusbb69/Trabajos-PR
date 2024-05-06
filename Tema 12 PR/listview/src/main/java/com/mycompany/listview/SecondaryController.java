/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.listview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class SecondaryController implements Initializable {


    @FXML
    private TextField textoNombre;
    @FXML
    private TextField textoApellido;
    @FXML
    private Button salvar;
    @FXML
    private Button cancelar;
    @FXML
    private Button cerrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void botonSalvar(ActionEvent event) {
    }

    @FXML
    private void botonCancelar(ActionEvent event) {
    }

    @FXML
    private void botonCerrar(ActionEvent event) {
    }

}
