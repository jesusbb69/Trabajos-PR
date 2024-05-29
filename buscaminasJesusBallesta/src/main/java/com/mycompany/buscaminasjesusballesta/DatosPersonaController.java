/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import com.mycompany.buscaminasjesusballesta.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class DatosPersonaController implements Initializable {

    @FXML
    public TextField nombreTexto;
    @FXML
    public TextField apellidosTexto;
    @FXML
    private Button salvar;
    @FXML
    private Button cerrar;
    @FXML
    private Button cancelar;
    
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
        nombreTexto.setText(p.getNombre());
        apellidosTexto.setText(p.getApellidos());
    }

    @FXML
    private void botonSalvar(ActionEvent event) {
        personaM = new Persona(nombreTexto.getText(), apellidosTexto.getText());
        cancela = false;
        cerrarVentana();
    }

    @FXML
    private void botonCerrar(ActionEvent event) {
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
        nombreTexto.clear();
        apellidosTexto.clear();
        salvar.setVisible(true);
        cancelar.setVisible(true);
        cerrar.setVisible(false);
    }
    
    public void inicializarParaModificar(Persona p) {
        esModificacion = true;
        nombreTexto.setText(p.getNombre());
        apellidosTexto.setText(p.getApellidos());
        salvar.setVisible(true);
        cancelar.setVisible(true);   
        cerrar.setVisible(false);
    }
    
    public void inicializarParaVerDatos(Persona p) {
        nombreTexto.setText(p.getNombre());
        apellidosTexto.setText(p.getApellidos());
        salvar.setVisible(false);
        cancelar.setVisible(false);
    }


    
    public boolean getCancelar(){
        return cancela;
    }
    
    public Persona getPersona(){
        return personaM;
    }
}
    

