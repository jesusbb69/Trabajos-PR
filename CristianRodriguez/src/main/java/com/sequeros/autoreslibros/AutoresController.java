/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.autoreslibros;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class AutoresController implements Initializable {
    
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
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
    private TableView<Autor> vistaTabla;
    @FXML
    private TableColumn<Autor, String> dniColumna;
    @FXML
    private TableColumn<Autor, String> nombreColumna;
    @FXML
    private TableColumn<Autor, String> apellidosColumna;
    @FXML
    private TableColumn<Autor, LocalDate> nacimientoColumna;
    @FXML
    private TableColumn<Autor, String> imagenColumna;
    @FXML
    private Button botonSalirGrabando;
    @FXML
    private Button botonAplicar;
    @FXML
    private Button botonModificarAutor;
    @FXML
    private Button botonCancelar;
    
    private ObservableList<Autor> misAutores;
    private ArrayList<Autor> misDatos = new ArrayList<>();
    
    private String originalDni;
    private String originalNombre;
    private String originalApellidos;
    private String originalNacimiento;
    private String originalRutaImagen;
    
    
        
    public Button getBotonAplicar() {
        return botonAplicar;
    }
        
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dni.setEditable(false);
        nombre.setEditable(false);
        apellidos.setEditable(false);
        nacimiento.setEditable(false);
        rutaImagen.setEditable(false);
        botonAplicar.setDisable(true);
        botonCancelar.setDisable(true);
        misDatos = Auxiliar.leerAutores("autores.txt");
        for (Autor misDato : misDatos) {
            System.out.println(misDato);
        }
        misAutores = FXCollections.observableArrayList(misDatos);
        vistaTabla.setItems(misAutores);
        dniColumna.setCellValueFactory(new PropertyValueFactory<Autor, String>("Dni"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<Autor, String>("Nombre"));
        apellidosColumna.setCellValueFactory(new PropertyValueFactory<Autor, String>("Apellidos"));
        nacimientoColumna.setCellValueFactory(cellData -> cellData.getValue().nacimientoProperty());
        nacimientoColumna.setCellFactory(v -> {
            return new TableCell<Autor, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        setText(item.format(formatter));
                    }
                }
            };
        });
        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().pathImagenProperty());
        imagenColumna.setCellFactory(columna -> {
            return new TableCell<Autor, String>() {
                private ImageView view = new ImageView();
                
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        File imageFile = new File(item);
                        String fileLocation = imageFile.toURI().toString();
                        Image image = new Image(fileLocation, 40, 40, true, true);
                        view.setImage(image);
                        setGraphic(view);
                    }
                }
            };
        });
        //botonBorrar.disableProperty().bind(Bindings.equal(-1, vistaTabla.getSelectionModel().selectedIndexProperty()));
        //botonModificarAutor.disableProperty().bind(Bindings.equal(-1, vistaTabla.getSelectionModel().selectedIndexProperty()));
        botonBorrar.disableProperty().bind(Bindings.isEmpty(vistaTabla.getSelectionModel().getSelectedItems()));
        botonModificarAutor.disableProperty().bind(Bindings.isEmpty(vistaTabla.getSelectionModel().getSelectedItems()));
        
        vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Autor>() {
            
            @Override
            public void changed(ObservableValue<? extends Autor> ov, Autor t, Autor t1) {
                
                if (t1 != null) {
                    dni.setText(t1.getDni());
                    nombre.setText(t1.getNombre());
                    apellidos.setText(t1.getApellidos());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    nacimiento.setText(t1.getNacimiento().get().format(formatter));
                    rutaImagen.setText(t1.getPathImagen());
                    File imageFile = new File(t1.getPathImagen());
                    String fileLocation = imageFile.toURI().toString();
                    Image image;
                    image = new Image(fileLocation);
                    imagen.setImage(image);
                }
            }
            
        });
    }
    
    @FXML
    private void borrarAccion(ActionEvent event) {
        misAutores.remove(vistaTabla.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void salirGrabando(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Saliendo");
        alert.setHeaderText("Saliendo del programa");
        alert.setContentText("¿Seguro que quieres continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Auxiliar.grabarAutores("autores.txt", new ArrayList<Autor>(misAutores));
            Platform.exit();
        }
        
    }
    
    @FXML
    private void aplicar(ActionEvent event) {
        if (datosCorrectos()) {
            dni.setEditable(false);
            nombre.setEditable(false);
            apellidos.setEditable(false);
            nacimiento.setEditable(false);
            rutaImagen.setEditable(false);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(nacimiento.getText(), formatter);
            Autor autor = vistaTabla.getSelectionModel().getSelectedItem();
            int indice = misAutores.indexOf(autor);
            Autor autorNuevo = new Autor(dni.getText(), nombre.getText(), apellidos.getText(), fecha, rutaImagen.getText());
            misAutores.set(indice, autorNuevo);
            vistaTabla.refresh();
            botonAplicar.setDisable(true);
            botonCancelar.setDisable(true);
            botonModificarAutor.setVisible(true);
        }
        
    }
    
    @FXML
    private void modificarAutor(ActionEvent event) {
        botonAplicar.setDisable(false);
        botonCancelar.setDisable(false);
        dni.setEditable(true);
        nombre.setEditable(true);
        apellidos.setEditable(true);
        nacimiento.setEditable(true);
        rutaImagen.setEditable(true);
        botonModificarAutor.setVisible(false);
        originalDni = dni.getText();
        originalNombre = nombre.getText();
        originalApellidos = apellidos.getText();
        originalNacimiento = nacimiento.getText();
        originalRutaImagen = rutaImagen.getText();
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        botonAplicar.setDisable(true);
        botonCancelar.setDisable(true);
        dni.setEditable(false);
        nombre.setEditable(false);
        apellidos.setEditable(false);
        nacimiento.setEditable(false);
        rutaImagen.setEditable(false);
        botonModificarAutor.setVisible(true);
        dni.setText(originalDni);
        nombre.setText(originalNombre);
        apellidos.setText(originalApellidos);
        nacimiento.setText(originalNacimiento);
        rutaImagen.setText(originalRutaImagen);
        
    }
    
    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        System.out.println(clickedButton.getId());
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource("com/sequeros/autoreslibros/DatosAutor.fxml")
        );
        Parent root = miCargador.load();
        DatosAutorController controladorAutor = miCargador.<DatosAutorController>getController();
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir autor");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if (controladorAutor.isSalvar()) {
            if ((!controladorAutor.getAutor().getNombre().isEmpty())
                    && (controladorAutor.getAutor().getNombre().trim().length() != 0)
                    && (!controladorAutor.getAutor().getApellidos().isEmpty())
                    && (controladorAutor.getAutor().getApellidos().trim().length() != 0)) {
                boolean dniRepe = false;
                for (Autor misAutore : misAutores) {
                    if (misAutore.getDni().equals(controladorAutor.getAutor().getDni())) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error con el DNI");
                        alert.setHeaderText(null);
                        alert.setContentText("No puede haber dos personas con el mismo DNI");
                        alert.showAndWait();
                        dniRepe = true;
                    }
                }
                if (!dniRepe) {
                    misAutores.add(controladorAutor.getAutor());
                    vistaTabla.refresh();
                }
                
            }
        }
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
