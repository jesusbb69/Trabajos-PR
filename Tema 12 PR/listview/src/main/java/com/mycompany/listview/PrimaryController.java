/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.listview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class PrimaryController implements Initializable {


    @FXML
    private Button verDatos;
    @FXML
    private ListView<Persona> lista;
    @FXML
    private Button añadir;
    @FXML
    private Button borrar;
    @FXML
    private Button modificar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ArrayList<Persona> datos = new ArrayList<>();
        datos.add(new Persona("Garcia", "Lucia"));
        datos.add(new Persona("Soprano", "Lucas"));
        datos.add(new Persona("Vazquez", "Alvaro"));
        datos.add(new Persona("tilla", "Aitor"));
        datos.add(new Persona("Gomez", "Margarita"));
        datos.add(new Persona("Ballesta", "Andrea"));
        datos.add(new Persona("Moreno", "Jesus"));
        
        ObservableList<Persona> datosObservableList;
        datosObservableList = FXCollections.observableList(datos);
        
        lista.setItems(datosObservableList);
        lista.setCellFactory(c-> new PersonListCell());
        
    }    

    @FXML
    private void verDatoBoton(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader (getClass().getClassLoader().getResource("com/mycompany/listview/secondary.fxml"));
        Parent root = miCargador.load();
        SecondaryController controladorPersona = miCargador.<SecondaryController>getController();
        
        Persona persona = lista.getSelectionModel().getSelectedItem();
        if (persona == null){
            return;
        }
        controladorPersona.initPersona(persona);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver Datos Persona");
        //stage.show();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void añadirBoton(ActionEvent event) {
       
    }

    @FXML
    private void borrarBoton(ActionEvent event) {
        
    }

    @FXML
    private void modificarBoton(ActionEvent event) {
        
    }
    
    

    class PersonListCell extends ListCell<Persona> {
        @Override
        protected void updateItem(Persona item, boolean empty){
            super.updateItem(item, empty);
            if (item == null || empty){
                setText(null);
            }else{
                setText(item.getApellidos() + ", " + item.getNombre());
            }
        }
    }
    
    
    
    
} 



