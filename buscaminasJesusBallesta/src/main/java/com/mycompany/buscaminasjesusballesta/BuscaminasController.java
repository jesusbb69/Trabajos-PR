/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class BuscaminasController implements Initializable {


    @FXML
    private MenuButton dificultad;
    @FXML
    private MenuItem facil;
    @FXML
    private MenuItem intermedio;
    @FXML
    private MenuItem experto;
    @FXML
    private MenuItem personalizado;
    @FXML
    private BorderPane borderPane;
    
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         int columnas = 30;
         int filas = 16;
         
        
         
        
        GridPane gridPane = new GridPane();
       
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Button boton = new Button();
                boton.setMinSize(40, 40); 
                boton.setMaxSize(40, 40); 
                boton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event){
                        System.out.println(GridPane.getRowIndex(boton) + "  " + GridPane.getColumnIndex(boton));
                    }
                });
                gridPane.add(boton, columna, fila);
            }
        }
        
        gridPane.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(gridPane);
        
    
    }    
    
    
   
    
    
    @FXML
    private void dfFacil(ActionEvent event) {
    }

    @FXML
    private void dfIntermedio(ActionEvent event) {
    }

    @FXML
    private void dfExperto(ActionEvent event) {
    }

    @FXML
    private void dfPersonalizado(ActionEvent event) {
    }

}
