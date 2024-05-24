/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.menusydialogos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import java.lang.Object;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;
import javafx.scene.control.ChoiceDialog;
import java.util.Optional;
import javafx.scene.control.Menu;
import javafx.scene.control.TextInputDialog;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class PrimaryController implements Initializable {


    @FXML
    private BorderPane panel;
    @FXML
    private MenuItem cerrar;
    @FXML
    private MenuItem mAmazon;
    @FXML
    private MenuItem mBlogguer;
    @FXML
    private MenuItem mEbay;
    @FXML
    private MenuItem mFacebook;
    @FXML
    private MenuItem mGoogle;
    @FXML
    private Button btAmazon;
    @FXML
    private Button btBlogguer;
    @FXML
    private Button btEbay;
    @FXML
    private Button btFacebook;
    @FXML
    private Button btGoogle;
    @FXML
    private Label estado;
    @FXML
    private RadioMenuItem rdAmazon;
    @FXML
    private RadioMenuItem rdEbay;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rdAmazon.setSelected(true);
    }    
    
    @FXML
    private void cerrar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // ó AlertType.WARNINGó AlertType.ERRORó AlertType.CONFIRMATION
        alert.setTitle("Confirmacion");
        alert.setHeaderText("Vas a salir del programa");
        // ó nullsi no queremos cabecera
        alert.setContentText("¿Seguro que quieres salir?");
        alert.showAndWait();
        //Optional<ButtonType> result= alert.showAndWait();
        System.exit(0);
    }

    @FXML
    private void comprarAmazon(ActionEvent event) {    
        if (rdAmazon.isSelected()){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Confirmacion");
           alert.setHeaderText("Compra realizada correctamente");          
           alert.setContentText("Has comprado en Amazon");         
           alert.showAndWait();
           estado.setVisible(true);
           estado.setText("Compra en Amazon");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Confirmacion");
            alert.setHeaderText("No puede comprar en Amazon");
            alert.setContentText("Por favor, cambie la seleccion actual en el menú de opciones.");
            alert.showAndWait();
            estado.setVisible(true);
            estado.setText("Compra fallida");
        }
    }

    @FXML
    private void visitarBlogguer(ActionEvent event) {
        ArrayList<String> ejemplo= new ArrayList<>();
        ejemplo.add("El blog de Jesus");
        ejemplo.add("El blog de Nathan");
        ejemplo.add("El blog de Ramon");
        ejemplo.add("El blog de Alejandra");
        
        ChoiceDialog<String> dialogo = new ChoiceDialog<>("El blog de Jesus", ejemplo);
        dialogo.setTitle("Selecciona un blog");
        dialogo.setHeaderText("¿Que blog quieres elegir?");
        dialogo.setContentText("Elige:");
        Optional<String> result= dialogo.showAndWait();
        if (result.isPresent()){
            estado.setVisible(true);
            estado.setText(result.get());
        }
        
        
    }

    @FXML
    private void comprarEbay(ActionEvent event) {
       if (rdEbay.isSelected()){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Confirmacion");
           alert.setHeaderText("Compra realizada correctamente");          
           alert.setContentText("Has comprado en Ebay");         
           alert.showAndWait();
           estado.setVisible(true);
           estado.setText("Compra en Ebay");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Confirmacion");
            alert.setHeaderText("No puede comprar en Ebay");
            alert.setContentText("Por favor, cambie la seleccion actual en el menú de opciones.");
            alert.showAndWait(); 
            estado.setVisible(true);
            estado.setText("Compra fallida");
       }
    }

    @FXML
    private void visitarFacebook(ActionEvent event) {
        TextInputDialog dialogo= new TextInputDialog("Jesus");
        dialogo.setTitle("Introduce tu nombre");
        dialogo.setHeaderText("¿Con qué usuario quieres escribir en Facebook?");
        dialogo.setContentText("Introduce tu nombre:");
        Optional<String> result= dialogo.showAndWait();
        if (result.isPresent()){
            estado.setVisible(true);
            estado.setText("Enviando mensaje como " + result.get());
        }
        
    }

    @FXML
    private void visitarGoogle(ActionEvent event) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Google+");
           alert.setHeaderText("Página temporalmente fuera de servicio");          
           alert.setContentText("Por favor vuelva al inicio y seleccione otra opción");         
           alert.showAndWait();
           estado.setVisible(true);
           estado.setText("Visitando Google+ (Fuera de servicio)");
    }


}
