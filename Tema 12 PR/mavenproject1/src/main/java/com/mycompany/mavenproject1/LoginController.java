/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class LoginController implements Initializable {


    @FXML
    private TextField texto_usuario;
    @FXML
    private Text mensaje_usuario;
    @FXML
    private PasswordField contrasenya_usuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void pulsadoIniciar(ActionEvent event) {
        mensaje_usuario.setText("Bienvenido " + texto_usuario.getText() + "\n" + "Contraseña: " + contrasenya_usuario.getText());
        
    }

}
