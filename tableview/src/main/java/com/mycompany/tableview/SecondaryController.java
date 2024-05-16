/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.binding.ObjectExpression;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class SecondaryController implements Initializable {


    @FXML
    public TextField nombreTexto;
    @FXML
    public TextField apellidosTexto;   
    @FXML
    public TextField imagenTexto;
    @FXML
    private TextField ciudadTexto;
    @FXML
    private TextField provinciaTexto;
    @FXML
    private Button salvar;
    @FXML
    private Button cerrar;
    @FXML
    private Button cancelar;
    
    Persona personaM;
    boolean cancela = true;
    @FXML
    private Text Ciudad;
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initPersona(Persona p){
        
        ObjectProperty<Residencia> residencia;
        nombreTexto.setText(p.getNombre());
        apellidosTexto.setText(p.getApellidos());
        ciudadTexto.setText(p.getResidencia().get().getCiudad());
        provinciaTexto.setText(p.getResidencia().get().getProvincia());
        imagenTexto.setText(p.getPathImagen());
    }
    
    @FXML
    private void botonSalvar(ActionEvent event) {      
        
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
     
     public boolean getCancelar(){
        return cancela;
    }
    
    public Persona getPersona(){
        return personaM;
    }
     private boolean esModificacion;
    
    public void inicializarParaAgregar() {
        esModificacion = false;
        
        salvar.setVisible(true);
        cancelar.setVisible(true);
        cerrar.setVisible(false);
    }
    
    public void inicializarParaModificar(Persona p) {
        esModificacion = true;
        
        salvar.setVisible(true);
        cancelar.setVisible(true);   
        cerrar.setVisible(false);
    }
    
    public void inicializarParaVerDatos(Persona p) {
        nombreTexto.setText(p.getNombre());
        apellidosTexto.setText(p.getApellidos());
        //residenciaTexto.setText(p.getResidencia());
        //imagenTexto.setText(p.getPathImagen());
        salvar.setVisible(false);
        cancelar.setVisible(false);
    }
    

}