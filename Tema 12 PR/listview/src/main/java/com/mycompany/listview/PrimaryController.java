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

    ArrayList<Persona> datos = new ArrayList<>();
    ObservableList<Persona> datosObservableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        datos.add(new Persona("Lucia", "Garcia"));
        datos.add(new Persona("Lucas", "Soprano"));
        datos.add(new Persona("Alvaro", "Vazquez"));
        datos.add(new Persona("Aitor", "tilla"));
        datos.add(new Persona("Margarita", "Gomez"));
        datos.add(new Persona("Andrea", "Ballesta"));
        datos.add(new Persona("Jesus", "Moreno"));

        datosObservableList = FXCollections.observableList(datos);

        lista.setItems(datosObservableList);
        lista.setCellFactory(c -> new PersonListCell());

    }

    @FXML
    private void verDatoBoton(ActionEvent event) throws IOException {

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/listview/secondary.fxml"));
        Parent root = miCargador.load();
        SecondaryController controladorPersona = miCargador.<SecondaryController>getController();

        Persona persona = lista.getSelectionModel().getSelectedItem();
        if (persona == null) {
            return;
        }
        controladorPersona.initPersona(persona);        
        controladorPersona.inicializarParaVerDatos(persona);
        controladorPersona.textoNombre.setEditable(false);
        controladorPersona.textoApellido.setEditable(false);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver Datos Persona");
        //stage.show();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void añadirBoton(ActionEvent event) throws IOException {
        Button clickButton = (Button) event.getSource();
        System.out.println(clickButton.getId());

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/listview/secondary.fxml"));

        Parent root = miCargador.load();

        SecondaryController controladorPersona = miCargador.<SecondaryController>getController();
                        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        //System.out.println("primero");
        Persona persona = new Persona("", "");
        if(clickButton.getId().equals("añadir")){
            stage.setTitle("Añadir persona");
            controladorPersona.inicializarParaAgregar();
        }else{
            persona = lista.getSelectionModel().getSelectedItem();
            if (persona == null){
                return;
            }
            stage.setTitle("Modificar persona");
            controladorPersona.inicializarParaModificar(persona);
        }
        //controladorPersona.initPersona(persona);
        
        

        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        if (!controladorPersona.getCancelar()) {
            if ((!controladorPersona.getPersona().getNombre().isEmpty())
                    && (controladorPersona.getPersona().getNombre().trim().length() != 0)
                    && (!controladorPersona.getPersona().getNombre().isEmpty())
                    && (controladorPersona.getPersona().getApellidos().trim().length() != 0)) {
                if (clickButton.getId().equals("añadir")) {
                    datosObservableList.add(controladorPersona.getPersona());

                } else {
                    int indice = datos.indexOf(persona);
                    Persona p = controladorPersona.getPersona();
                    datos.set(indice, p);
                }
                lista.refresh();
            }
        }
    }

    @FXML
    private void borrarBoton(ActionEvent event) {
        Persona persona = lista.getSelectionModel().getSelectedItem();
        if (persona == null){
            return;
        }
        datosObservableList.remove(persona);
    }

    class PersonListCell extends ListCell<Persona> {

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
            } else {
                setText(item.getApellidos() + ", " + item.getNombre());
            }
        }
    }

}
