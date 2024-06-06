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
 * @author Jesús Ballesta
 */
public class SeleccionarDificultadController implements Initializable {

    @FXML
    private Button facil;
    @FXML
    private Button intermedio;
    @FXML
    private Button experto;
    @FXML
    private Button personalizado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dfFacil(ActionEvent event) throws IOException {        
        cargarBuscaminas(event);
        
    }

    @FXML
    private void dfIntermedio(ActionEvent event) throws IOException {
        cargarBuscaminas(event);
    }

    @FXML
    private void dfExperto(ActionEvent event) throws IOException {
        cargarBuscaminas(event);
    }

    @FXML
    private void dfPersonalizado(ActionEvent event) throws IOException {
        cargarBuscaminas(event);
    }
    
    private void cargarBuscaminas(ActionEvent event) throws IOException{
        Button clickButton = (Button) event.getSource();
        System.out.println(clickButton.getId());
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/buscaminas.fxml"));
        Parent root = miCargador.load();
        BuscaminasController buscaminas = miCargador.<BuscaminasController>getController();
        
        if(clickButton.getId().equals("facil")){
            buscaminas.dfFacil();
        }else if(clickButton.getId().equals("intermedio")){
            buscaminas.dfIntermedio();
        }else if(clickButton.getId().equals("experto")){
            buscaminas.dfExperto();
        }else{
            buscaminas.dfPersonalizado();
        }
        
        
        
        Scene scene = new Scene(root, 1200, 900);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Buscaminas");
        //stage.show();
        stage.initModality(Modality.APPLICATION_MODAL);
        //tablaPersonas.btVolver1.setVisible(false);
        //tablaPersonas.btSiguiente1.setVisible(false);
        stage.showAndWait();
        
        
            
        
        
        
    }
    
}
