/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tableview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.lang.Object;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author jesbalber
 */
public class Persona {

    private final StringProperty Nombre = new SimpleStringProperty();
    private final StringProperty Apellidos = new SimpleStringProperty();
    private ObjectProperty<Residencia> residencia = new SimpleObjectProperty<>();
    private final StringProperty pathImagen = new SimpleStringProperty();

    public Persona(String nombre, String apellidos, Residencia residencia, String imagen) {
        this.Nombre.setValue(nombre);
        this.Apellidos.setValue(apellidos);
        this.residencia.setValue(residencia);
        this.pathImagen.setValue(imagen);
    }

    public final StringProperty NombreProperty() {
        return this.Nombre;
    }

    public final String getNombre() {
        return this.NombreProperty().get();
    }

    public final void setNombre(String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.Apellidos;
    }

    public final String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }

    public final ObjectProperty residenciaProperty() {
        return this.residencia;
    }

    public ObjectProperty<Residencia> getResidencia() {
        return residencia;
    }

    public void setResidencia(ObjectProperty<Residencia> residencia) {
        this.residencia = residencia;
    }

    public final StringProperty pathImagenProperty() {
        return this.pathImagen;
    }

    public String getPathImagen() {
        return this.pathImagen.get();
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagenProperty().set(pathImagen);
    }

}
