/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class PrimaryController implements Initializable {


    @FXML
    private Button btJugar;
    @FXML
    private Button btRanking;
    @FXML
    private Button btJugadores;
    @FXML
    private Button btSalir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void accederJugar(ActionEvent event) {
        
    }

    @FXML
    private void accederRanking(ActionEvent event)  {
        
        
    }

    @FXML
    private void accederJugadores(ActionEvent event) throws IOException{
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/secondary.fxml"));
        Parent root = miCargador.load();
        SecondaryController tablaPersonas = miCargador.<SecondaryController>getController();
        
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Jugadores Buscaminas");
        //stage.show();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void salirJuego(ActionEvent event) {
        Stage stage = (Stage) btSalir.getScene().getWindow();
        stage.close();
    }

}
