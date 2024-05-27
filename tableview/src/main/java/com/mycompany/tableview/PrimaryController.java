/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileWriter;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button verDatos;
    @FXML
    private Button añadir;
    @FXML
    private Button modificar;
    @FXML
    private Button borrar;
    @FXML
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;
    @FXML
    private TableColumn<Persona, Residencia> residenciaColumna;
    @FXML
    private TableColumn<Persona, String> imagenColumna;

    private ObservableList<Persona> misPersonas;
    ArrayList<Persona> misDatos = new ArrayList<>();
    @FXML
    private Button guardarTodo;
    @FXML
    private Button guardarSel;
    @FXML
    private ImageView imagenView;
    @FXML
    private Label letraDNI;
    @FXML
    private Button botonDNI;
    @FXML
    private TextField dniTexto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        misDatos.add(new Persona("Jesus", "Ballesta", new Residencia("Almoradi", "Alicante"),
                "./src/main/resources/com/mycompany/tableview/whatsapp.png"));
        misDatos.add(new Persona("Damian", "Sorribes", new Residencia("Ourense", "Galicia"),
                "./src/main/resources/com/mycompany/tableview/instagram.jpeg"));
        misDatos.add(new Persona("Pablo", "Ferrandez", new Residencia("Villaviciosa", "Madrid"),
                "./src/main/resources/com/mycompany/tableview/youtube.png"));

        misPersonas = FXCollections.observableArrayList(misDatos);
        vistaTabla.setItems(misPersonas);

        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        residenciaColumna.setCellValueFactory(cellData -> cellData.getValue().residenciaProperty());

        residenciaColumna.setCellFactory(v -> {
            return new TableCell<Persona, Residencia>() {
                @Override
                protected void updateItem(Residencia item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getCiudad() + " --> " + item.getProvincia());
                    }
                }
            };
        });

        vistaTabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Se ha seleccionado una nueva fila en la tabla
                // Configura la imagen correspondiente en el ImageView
                Persona personaSeleccionada = newSelection;
                configurarImagen(personaSeleccionada.getPathImagen());
            }
        });

        //imagenColumna.setCellFactory(columna -> new ImagenTableCell<>(imagenView));
        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().pathImagenProperty());
        imagenColumna.setCellFactory(columna -> {
            return new TableCell<Persona, String>() {
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

        borrar.disableProperty().bind(Bindings.isEmpty(vistaTabla.getSelectionModel().getSelectedItems()));

        vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observable, Persona oldValue, Persona newValue) {
                modificar.setDisable(newValue == null); // Habilita el botón Modificar si se selecciona un elemento, de lo contrario lo deshabilita
            }
        });
        
        
        int numeroNIF = 48784136;
        char letraNIF = calcularLetraNIF(numeroNIF);
        System.out.println("El NIF es: " + numeroNIF + letraNIF);

    }

    private void configurarImagen(String rutaImagen) {
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            Image image = new Image(new File(rutaImagen).toURI().toString());
            imagenView.setImage(image);
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("La imagen no está disponible para esta persona.");
            alert.showAndWait();
            // Si la ruta de la imagen es nula o vacía, puedes establecer una imagen predeterminada o dejarla en blanco según tu preferencia.
            imagenView.setImage(null); // Esto deja la imagen en blanco
        }
    }

    @FXML
    private void verDatosBoton(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/tableview/secondary.fxml"));
        Parent root = miCargador.load();
        SecondaryController controladorPersona = miCargador.<SecondaryController>getController();

        Persona persona = vistaTabla.getSelectionModel().getSelectedItem();

        if (persona == null) {
            return;
        }

        controladorPersona.initPersona(persona);
        controladorPersona.inicializarParaVerDatos(persona);
        controladorPersona.nombreTexto.setEditable(false);
        controladorPersona.apellidosTexto.setEditable(false);
        controladorPersona.ciudadTexto.setEditable(false);
        controladorPersona.provinciaTexto.setEditable(false);
        controladorPersona.imagenTexto.setEditable(false);

        controladorPersona.configurarImagen(persona.getPathImagen());

        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver Datos Persona");
        //stage.show();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void añadirDatosBoton(ActionEvent event) throws IOException {
        Button clickButton = (Button) event.getSource();
        System.out.println(clickButton.getId());

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/tableview/secondary.fxml"));

        Parent root = miCargador.load();

        SecondaryController controladorPersona = miCargador.<SecondaryController>getController();
        Scene scene = new Scene(root, 600, 500);
        Stage stage = new Stage();
        //System.out.println("primero");
        Persona persona = new Persona("", "", new Residencia("", ""), "");
        if (clickButton.getId().equals("añadir")) {
            stage.setTitle("Añadir persona");
            controladorPersona.inicializarParaAgregar();
        } else {
            persona = vistaTabla.getSelectionModel().getSelectedItem();
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
                    misPersonas.add(controladorPersona.getPersona());

                } else {
                    int indice = misPersonas.indexOf(persona);
                    Persona p = controladorPersona.getPersona();
                    misPersonas.set(indice, p);
                }
                vistaTabla.refresh();
            }
        }
    }

    @FXML
    private void borrarDatosBoton(ActionEvent event) {

        Persona persona = vistaTabla.getSelectionModel().getSelectedItem();
        if (persona == null) {
            return;
        }
        misPersonas.remove(persona);
    }

    @FXML
    private void guardarTodo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo CSV", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if (selectedFile != null) {
            try {
                FileWriter writer = new FileWriter(selectedFile);

                // Escribir encabezados
                writer.append("Nombre,Apellidos,Ciudad,Provincia,Imagen\n");

                // Escribir datos de cada persona
                for (Persona persona : misPersonas) {
                    writer.append(persona.getNombre() + ",");
                    writer.append(persona.getApellidos() + ",");
                    writer.append(persona.getResidencia().get().ciudad + ",");
                    writer.append(persona.getResidencia().get().provincia + ",");
                    writer.append(persona.getPathImagen() + "\n");
                }

                writer.flush();
                writer.close();

                System.out.println("Datos guardados en: " + selectedFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar los datos en el archivo CSV: " + e.getMessage());
            }
        }
    }

    @FXML
    private void guardarDatosSel(ActionEvent event) {
        if (vistaTabla.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione al menos una persona para guardar en el archivo CSV.");
            alert.showAndWait();
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo CSV", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if (selectedFile != null) {
            try {
                FileWriter writer = new FileWriter(selectedFile);

                // Escribir encabezados
                writer.append("Nombre,Apellidos,Ciudad,Provincia,Imagen\n");

                // Escribir datos de las personas seleccionadas
                for (Persona persona : vistaTabla.getSelectionModel().getSelectedItems()) {
                    writer.append(persona.getNombre() + ",");
                    writer.append(persona.getApellidos() + ",");
                    writer.append(persona.getResidencia().get().ciudad + ",");
                    writer.append(persona.getResidencia().get().provincia + ",");
                    writer.append(persona.getPathImagen() + "\n");
                }

                writer.flush();
                writer.close();

                System.out.println("Datos de personas seleccionadas guardados en: " + selectedFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar los datos de personas seleccionadas en el archivo CSV: " + e.getMessage());
            }
        }
    }
    
    
     public static char calcularLetraNIF(int numero) {
        // Array con las letras del NIF en orden
        char[] letrasNIF = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        // Calcula el índice de la letra en el array
        int indiceLetra = numero % 23;
        
        // Devuelve la letra correspondiente
        return letrasNIF[indiceLetra];
    }

    @FXML
    private void calcularDNI(ActionEvent event) {
        String numeroDNI = dniTexto.getText();
        if (!numeroDNI.isEmpty()) {
            try {
                int numero = Integer.parseInt(numeroDNI);
                char letra = calcularLetraNIF(numero);
                letraDNI.setText("Letra NIF: " + letra);
            } catch (NumberFormatException e) {
                letraDNI.setText("Introduce un número válido");
            }
        } else {
            letraDNI.setText("Introduce un número de DNI");
        }
    }
    
    
    

}
