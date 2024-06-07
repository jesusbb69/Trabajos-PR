/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import com.mycompany.buscaminasjesusballesta.SeleccionarDificultadController;
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
public class FinPartidaController implements Initializable {

    @FXML
    private Button salir;
    @FXML
    private Button volverJugar;
    @FXML
    private Button guardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btSalir(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/primary.fxml"));
        Parent root = miCargador.load();
        PrimaryController inicio = miCargador.<PrimaryController>getController();

        Scene scene = new Scene(root, 640, 400);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Buscaminas JBB");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        Stage stageActual = (Stage) salir.getScene().getWindow();
        stageActual.close();
        stageActual.show();
    }

    @FXML
    private void btVolverJugar(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/seleccionarDificultad.fxml"));
        Parent root = miCargador.load();
        SeleccionarDificultadController buscaminas = miCargador.<SeleccionarDificultadController>getController();

        Scene scene = new Scene(root, 620, 400);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Seleccionar Dificultad");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        Stage stageActual = (Stage) volverJugar.getScene().getWindow();
        stageActual.hide();
        stageActual.show();
    }

    @FXML
    private void btGuardar(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/secondary.fxml"));
        Parent root = miCargador.load();
        SecondaryController elegirJugador = miCargador.<SecondaryController>getController();
        
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Jugadores Buscaminas");
        stage.initModality(Modality.APPLICATION_MODAL);       
        stage.showAndWait();
        
        elegirJugador.btAñadir.setText("Elegir Persona");
    }

}
