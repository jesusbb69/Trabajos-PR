package com.sequeros.autoreslibros;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Autor {

    private final StringProperty dni = new SimpleStringProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();
    private ObjectProperty<LocalDate> nacimiento = new SimpleObjectProperty<>();
    private final StringProperty pathImagen = new SimpleStringProperty();

    public Autor(String dni, String nombre, String apellidos, LocalDate nacimiento, String pathImagen) {
        this.dni.setValue(dni);
        this.nombre.setValue(nombre);
        this.apellidos.setValue(apellidos);
        this.nacimiento.setValue(nacimiento);
        this.pathImagen.setValue(pathImagen);
    }

    public final StringProperty DniProperty() {
        return this.dni;
    }

    public final String getDni() {
        return this.DniProperty().get();
    }

    public final void setDni(final java.lang.String dni) {
        this.DniProperty().set(dni);
    }

    public final StringProperty NombreProperty() {
        return this.nombre;
    }

    public final String getNombre() {
        return this.NombreProperty().get();
    }

    public final void setNombre(final java.lang.String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.apellidos;
    }

    public final String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(final java.lang.String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }

    public final ObjectProperty nacimientoProperty() {
        return this.nacimiento;
    }

    public ObjectProperty<LocalDate> getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(ObjectProperty<LocalDate> residencia) {
        this.nacimiento = residencia;
    }

    public final StringProperty pathImagenProperty() {
        return this.pathImagen;
    }

    public String getPathImagen() {
        return this.pathImagenProperty().get();
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagenProperty().set(pathImagen);
    }

    @Override
    public String toString() {
        return "Autor{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nacimiento=" + nacimiento + ", pathImagen=" + pathImagen + '}';
    }

}
