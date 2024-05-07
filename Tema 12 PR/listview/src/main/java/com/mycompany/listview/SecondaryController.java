/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.listview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class SecondaryController implements Initializable {


    @FXML
    private TextField textoNombre;
    @FXML
    private TextField textoApellido;
    @FXML
    private Button salvar;
    @FXML
    private Button cancelar;
    @FXML
    private Button cerrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initPersona(Persona p){
        textoNombre.setText(p.getNombre());
        textoApellido.setText(p.getApellidos());
    }
    @FXML
    private void botonSalvar(ActionEvent event) {
        
        cerrarVentana();
    
    }

    @FXML
    private void botonCancelar(ActionEvent event) {
        cerrarVentana(); 
    }

    private void cerrarVentana() {
        Stage stage = (Stage) salvar.getScene().getWindow();
        stage.close();
    }
    
    
    
    
    private boolean esModificacion;
    
    public void inicializarParaAgregar() {
        esModificacion = false;
        textoNombre.clear();
        textoApellido.clear();
        salvar.setVisible(true);
        cancelar.setVisible(true);
    }
    
    public void inicializarParaModificar(String nombre, String apellido) {
        esModificacion = true;
        textoNombre.setText(nombre);
        textoApellido.setText(apellido);
        salvar.setVisible(true);
        cancelar.setVisible(true);
    }
    
    public void inicializarParaVerDatos(String nombre, String apellido) {
        textoNombre.setText(nombre);
        textoApellido.setText(apellido);
        salvar.setVisible(false);
        cancelar.setVisible(false);
    }

    @FXML
    private void botonCerrar(ActionEvent event) {
    }
}
