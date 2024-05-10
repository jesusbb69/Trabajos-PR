/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tableview;

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
import javafx.scene.control.TableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import java.io.File;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class PrimaryController implements Initializable {


    @FXML
    private Button verDatos;
    @FXML
    private Button añadir;
    @FXML
    private Button modificar;
    @FXML
    private Button borrar;
    @FXML
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;
    @FXML
    private TableColumn<Persona, Residencia> residenciaColumna;
    @FXML
    private TableColumn<Persona, String> imagenColumna;
    
    private ObservableList<Persona> misPersonas;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     ArrayList<Persona> misDatos = new ArrayList<Persona>();
     misDatos.add(new Persona("Jesus", "Ballesta", new Residencia("Almoradi", "Alicante"),
     "./src/main/resources/com/mycompany/tableview/whatsapp.png"));
     misDatos.add(new Persona("Damian", "Sorribes", new Residencia("Ourense", "Galicia"),
     "./src/main/resources/com/mycompany/tableview/instagram.jpeg"));
     misDatos.add(new Persona("Pablo", "Ferrandez", new Residencia("Villaviciosa", "Madrid"),
     "./src/main/resources/com/mycompany/tableview/youtube.png"));
     
     misPersonas = FXCollections.observableArrayList(misDatos);
     vistaTabla.setItems(misPersonas);
     
     nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
     apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
     residenciaColumna.setCellValueFactory(cellData -> cellData.getValue().residenciaProperty());
     
     residenciaColumna.setCellFactory(v -> {
         return new TableCell<Persona, Residencia>() {
             @Override
             protected void updateItem(Residencia item, boolean empty){
                 super.updateItem(item, empty);
                 if (item == null || empty){
                     setText(null);
                 }else{
                     setText(item.getCiudad() + " --> " + item.getProvincia());
                 }
             }
         };
     });
     
     imagenColumna.setCellValueFactory(cellData -> cellData.getValue().pathImagenProperty());
     imagenColumna.setCellFactory(columna -> {
         return new TableCell<Persona, String>() {
             private ImageView view = new ImageView();
             @Override
             protected void updateItem(String item, boolean empty){
                 super.updateItem(item, empty);
                 if (item == null || empty){
                     setGraphic(null);
                 }else{
                     File imageFile = new File(item);
                     String fileLocation = imageFile.toURI().toString();
                     Image image = new Image(fileLocation, 40, 40, true, true);
                     view.setImage(image);
                     setGraphic(view);
                 }
             }
         };
     });
     
     
     
    } 
    
    @FXML
    private void verDatosBoton(ActionEvent event) {
    }

    @FXML
    private void añadirDatosBoton(ActionEvent event) {
    }

    @FXML
    private void borrarDatosBoton(ActionEvent event) {
        Persona persona = vistaTabla.getSelectionModel().getSelectedItem();
        if (persona == null){
            return;
        }
        misPersonas.remove(persona);
    }

}
