/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.movercirculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class CirculoController implements Initializable {


    @FXML
    private GridPane panel;
    @FXML
    private Circle bola;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void moverBola(KeyEvent event) {
        bola.setOnKeyPressed(tecla -> {
            int posicion = 0;
            if(tecla.getCode() == KeyCode.DOWN){
               posicion = panel.getRowIndex(bola);
               panel.setRowIndex(bola, posicion +1);
            }else if (tecla.getCode() == KeyCode.UP){
                posicion = panel.getRowIndex(bola);
                panel.setRowIndex(bola, posicion-1);
            }else if(tecla.getCode() == KeyCode.RIGHT){
                posicion = panel.getColumnIndex(bola);
                panel.setColumnIndex(bola, posicion -1);
            }else if(tecla.getCode() == KeyCode.LEFT){
                posicion = panel.getColumnIndex(bola);
                panel.setColumnIndex(bola, posicion +1);
            }
            
        });
    }

    @FXML
    private void salirPanel(KeyEvent event) {
        panel.setOnKeyPressed(tecla -> {
            if(tecla.getCode() == KeyCode.ESCAPE){
               
            }
        });
    }

}
