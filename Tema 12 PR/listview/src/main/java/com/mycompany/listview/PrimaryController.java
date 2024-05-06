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
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

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
    
    public class Persona{
        private final StringProperty Nombre = new SimpleStringProperty();
        private final StringProperty Apellidos = new SimpleStringProperty();

        public Persona(String nombre, String apellidos) {
            Nombre.setValue(nombre);
            Apellidos.setValue(apellidos);
        }
        
        public final StringProperty NombreProperty(){
            return this.Nombre;
        }
        
        public final void setNombre(final java.lang.String Nombre){
            this.NombreProperty().set(Nombre);
        }
        
        public final java.lang.String getNombre() {
            return this.NombreProperty().get();
        }
        
        public final StringProperty ApellidosProperty(){
            return this.Apellidos;
        }
        
        public final java.lang.String getApellidos() {
            return this.ApellidosProperty().get();
        }
        
        public final void setApellidos(final java.lang.String Apellidos){
            this.ApellidosProperty().set(Apellidos);
        }
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



