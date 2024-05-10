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
    public TextField textoNombre;
    @FXML
    public TextField textoApellido;
    @FXML
    private Button salvar;
    @FXML
    private Button cancelar;
    @FXML
    private Button cerrar;
    
    boolean cancela = true;
    
    Persona personaM;
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
        
        personaM = new Persona(textoNombre.getText(), textoApellido.getText());
        cancela = false;
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
        cerrar.setVisible(false);
    }
    
    public void inicializarParaModificar(Persona p) {
        esModificacion = true;
        textoNombre.setText(p.getNombre());
        textoApellido.setText(p.getApellidos());
        salvar.setVisible(true);
        cancelar.setVisible(true);   
        cerrar.setVisible(false);
    }
    
    public void inicializarParaVerDatos(Persona p) {
        textoNombre.setText(p.getNombre());
        textoApellido.setText(p.getApellidos());
        salvar.setVisible(false);
        cancelar.setVisible(false);
    }

    @FXML
    private void botonCerrar(ActionEvent event) {
        cerrarVentana();
    }
    
    public boolean getCancelar(){
        return cancela;
    }
    
    public Persona getPersona(){
        return personaM;
    }
}
