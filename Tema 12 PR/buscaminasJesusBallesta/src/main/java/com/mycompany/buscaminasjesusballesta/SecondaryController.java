/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import com.mycompany.buscaminasjesusballesta.Persona;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class SecondaryController implements Initializable {

    @FXML
    private TableView<Persona> tabla;
    @FXML
    private TableColumn<Persona, String> nombre;
    @FXML
    private TableColumn<Persona, String> apellidos;
    @FXML
    private Button btVerDatos;
    @FXML
    private Button btAñadir;
    @FXML
    private Button btModificar;
    @FXML
    private Button btBorrar;

    ArrayList<Persona> misDatos = new ArrayList<>();
    ObservableList<Persona> datosObservableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        misDatos.add(new Persona("Lucia", "Garcia Vaquero"));
        misDatos.add(new Persona("Jesus", "Ballesta Bernabe"));
        misDatos.add(new Persona("Amelia", "Hernandez Gil"));
        misDatos.add(new Persona("Diego", "Campesino Ruiz"));
        misDatos.add(new Persona("Jorge", "Deltel Mellado"));
        misDatos.add(new Persona("Marcos", "Martinez Navarrete"));

        datosObservableList = FXCollections.observableList(misDatos);

        tabla.setItems(datosObservableList);
        nombre.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidos.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());

    }

    @FXML
    private void verDatos(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/datosPersona.fxml"));
        Parent root = miCargador.load();
        DatosPersonaController controladorPersona = miCargador.<DatosPersonaController>getController();

        Persona persona = tabla.getSelectionModel().getSelectedItem();
        if (persona == null) {
            return;
        }
        controladorPersona.initPersona(persona);
        controladorPersona.inicializarParaVerDatos(persona);
        controladorPersona.nombreTexto.setEditable(false);
        controladorPersona.apellidosTexto.setEditable(false);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver Datos Persona");
        //stage.show();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void añadir(ActionEvent event) throws IOException {
        Button clickButton = (Button) event.getSource();
        System.out.println(clickButton.getId());

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/datosPersona.fxml"));

        Parent root = miCargador.load();

        DatosPersonaController controladorPersona = miCargador.<DatosPersonaController>getController();
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        //System.out.println("primero");
        Persona persona = new Persona("", "");
        if (clickButton.getId().equals("añadir")) {
            stage.setTitle("Añadir persona");
            controladorPersona.inicializarParaAgregar();
        } else {
            persona = tabla.getSelectionModel().getSelectedItem();
            if (persona == null) {
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
                    int indice = datosObservableList.indexOf(persona);
                    Persona p = controladorPersona.getPersona();
                    datosObservableList.set(indice, p);
                }
                tabla.refresh();
            }
        }
    }

    @FXML
    private void borrar(ActionEvent event) {
        Persona persona = tabla.getSelectionModel().getSelectedItem();
        if (persona == null) {
            return;
        }
        datosObservableList.remove(persona);
    }

}
