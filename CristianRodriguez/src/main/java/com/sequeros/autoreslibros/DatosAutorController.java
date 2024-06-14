/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.autoreslibros;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IEUser
 */
public class DatosAutorController implements Initializable {

    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField nacimiento;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;
    private boolean salvar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        salvar = false;
        ObservableBooleanValue dniIsNotEmpty = dni.textProperty().isEmpty();
        ObservableBooleanValue nombreIsNotEmpty = nombre.textProperty().isEmpty();
        ObservableBooleanValue apellidosIsNotEmpty = apellidos.textProperty().isEmpty();
        ObservableBooleanValue nacimientoIsNotEmpty = nacimiento.textProperty().isEmpty();
        ObservableBooleanValue rutaImagenIsNotEmpty = rutaImagen.textProperty().isEmpty();
        BooleanBinding todosCamposLlenos = Bindings.or(Bindings.or(dniIsNotEmpty, nombreIsNotEmpty), Bindings.or(apellidosIsNotEmpty, Bindings.or(nacimientoIsNotEmpty, rutaImagenIsNotEmpty)));
        botonSalvar.disableProperty().bind(todosCamposLlenos);
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        if (datosCorrectos()) {
            salvar = true;
            Node n = (Node) event.getSource();
            n.getScene().getWindow().hide();
        }

    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();
        
    }

    public Autor getAutor() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(nacimiento.getText(), formatter);
        Autor a = new Autor(dni.getText(), nombre.getText(), apellidos.getText(), fecha, rutaImagen.getText());
        return a;
    }

    public boolean isSalvar() {
        return salvar;
    }

    public boolean datosCorrectos() {
        int fallos = 0;

        if (!dniCorrecto()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error al analizar el DNI");
            alert.setContentText("La letra del DNI o el DNI están mal, introduce uno válido");
            alert.showAndWait();
            fallos++;
        }

        if (!fechaCorrecta()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en la fecha");
            alert.setContentText("Porfavor ingrese una fecha válida en el formato DD/MM/YYYY.");
            alert.showAndWait();
            fallos++;
        }
        if (fallos > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean dniCorrecto() {
        String dniTexto = dni.getText();
        if (dniTexto.trim().length() == 9) {
            char letra = letraDni(dniTexto);
            int numeroDni = Integer.parseInt(dniTexto.substring(0, 8));
            char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
            return letra == letras[numeroDni % 23];
        } else {
            return false;
        }

    }

    private boolean fechaCorrecta() {
        String fecha = nacimiento.getText();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaBien = LocalDate.parse(fecha, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private char letraDni(String dniTexto) {

        int numDni = Integer.parseInt(dniTexto.substring(0, 8));
        System.out.println(numDni);
        char[] letrasDni = dniTexto.toCharArray();

        return letrasDni[letrasDni.length - 1];

    }
}
