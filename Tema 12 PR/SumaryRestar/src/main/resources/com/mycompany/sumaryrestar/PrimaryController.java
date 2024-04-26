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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void pulsarBoton(ActionEvent event) {
        if(!restar.isSelected()){
            if(event.getSource().equals("1")){
                
            }
        }
    }

    @FXML
    private void botonSumar(ActionEvent event) {
        if(){
            
        }
    }

    @FXML
    private void cambiarResta(ActionEvent event) {
        
    }

}
