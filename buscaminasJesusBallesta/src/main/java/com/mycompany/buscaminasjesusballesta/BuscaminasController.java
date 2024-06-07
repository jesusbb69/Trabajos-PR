/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author jesbalber
 */
public class BuscaminasController implements Initializable {

    @FXML
    private MenuButton dificultad;
    @FXML
    private MenuItem facil;
    @FXML
    private MenuItem intermedio;
    @FXML
    private MenuItem experto;
    @FXML
    private MenuItem personalizado;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button pausa;
    @FXML
    private Button records;
    @FXML
    private Button ayuda;
    @FXML
    private Button salir;
    @FXML
    private Label numeroMinas;
    @FXML
    private Label tiempo;
    @FXML
    private MenuItem mSalir;
    @FXML
    private MenuItem mInformacion;
    @FXML
    private Button empezar;

    private int columnas = 30;
    private int filas = 30;
    private int numMinas = 99; // Número de minas en el tablero
    private Button[][] botones = new Button[filas][columnas];
    private boolean[][] minas = new boolean[filas][columnas];
    private int casillasSinRevelar;
    GridPane gridPane = new GridPane();

    private Timeline timeline;
    private int tiempoTranscurrido;
    private int minasEncontradas = 0;
    private int banderasColocadas = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    private void mostrarMinas() {

        // Crear un ImageView y establecer la imagen de la bandera
        // Establecer el tamaño del ImageView para que coincida con el botón
        // Establecer el ImageView como el contenido del botón
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (minas[fila][columna]) {
                    Image minaImage = new Image(getClass().getResourceAsStream("/mina.jpeg"));
                    ImageView imageView = new ImageView(minaImage);
                    imageView.setFitWidth(40);
                    imageView.setFitHeight(40);
                    botones[fila][columna].setGraphic(imageView);
                    //botones[fila][columna].setText("9");
                }
            }
        }
    }

    int minasGeneradas = 0;

    private void generarMinas() {
        Random rand = new Random();
        minasGeneradas = 0;
        while (minasGeneradas < numMinas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasGeneradas++;
            }
        }
    }

    private void mensajeVictoria() throws IOException {
        timeline.stop();
        gridPane.setDisable(true);
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/finPartida.fxml"));
        Parent root = miCargador.load();
        FinPartidaController fin = miCargador.<FinPartidaController>getController();

        Scene scene = new Scene(root, 540, 380);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Fin de Partida");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        Stage stageActual = (Stage) gridPane.getScene().getWindow();

        stage.showAndWait();
        stageActual.hide();

        //stageActual.show();
        cerrarVentana();

    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                    if (minas[nuevaFila][nuevaColumna]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void crearTablero() {
        minasGeneradas = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Button boton = new Button();
                boton.setMinSize(40, 40);
                boton.setMaxSize(40, 40);
                // Agrega el evento de clic aquí si lo necesitas
                final int f = fila;
                final int c = columna;
                boton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            clicIzquierdoEnCelda(f, c);
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            clicDerechoEnCelda(f, c);
                        }
                    }
                });
                gridPane.add(boton, columna, fila);
                botones[fila][columna] = boton;

            }
        }
        gridPane.setAlignment(Pos.CENTER);
        borderPane.setCenter(gridPane);
        gridPane.setDisable(true);

        generarMinas();
    }

    private void limpiarTablero() {
        // Eliminar botones del GridPane
        GridPane gridPane = (GridPane) borderPane.getCenter();
        gridPane.getChildren().clear();
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                minas[fila][columna] = false;
            }
        }

    }

    private void deshabilitarBotonesAdyacentesConCero(int fila, int columna) {
        /*for (int i = Math.max(0, fila - 1); i <= Math.min(fila + 1, filas - 1); i++) {
            for (int j = Math.max(0, columna - 1); j <= Math.min(columna + 1, columnas - 1); j++) {
                if (botones[i][j].getText().equals("0") && botones[i][j].isDisabled()) {
                    botones[i][j].setDisable(true);
                    deshabilitarBotonesAdyacentesConCero(i, j);
                }
            }
        }*/

        for (int i = (fila - 1); i <= (fila + 1); i++) {
            for (int j = (columna - 1); j <= (columna + 1); j++) {

                if (i >= 0 && i < filas && j >= 0 && j < columnas) {
                    if (!botones[i][j].isDisabled()) {
                        int minasAdyacentes = contarMinasAdyacentes(i, j);
                        botones[i][j].setText(Integer.toString(minasAdyacentes));
                        botones[i][j].setDisable(true);
                        if (minasAdyacentes == 0) {
                            deshabilitarBotonesAdyacentesConCero(i, j);
                        }
                    }
                }
            }
        }


        /*for (int i = Math.max(0, fila - 1); i <= Math.min(fila + 1, filas - 1); i++) {
            for (int j = Math.max(0, columna - 1); j <= Math.min(columna + 1, columnas - 1); j++) {
                if (botones[i][j].getText().equals("0")) {
                    botones[i][j].setDisable(true);
                    deshabilitarBotonesAdyacentesConCero(i, j);
                }
            }
        }*/
    }

    private void clicIzquierdoEnCelda(int fila, int columna) {
        /*String contenido = botones[fila][columna].getText();
        if (contenido.equals("0")) {           
            deshabilitarBotonesAdyacentesConCero(fila, columna);
            clicIzquierdoEnCelda(fila - 1, columna - 1);
        } else if (!contenido.equals("9")) {
            botones[fila][columna].setDisable(true);
            
        }*/

        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || botones[fila][columna].isDisabled()) {
            return;
        }

        int minasAdyacentes = contarMinasAdyacentes(fila, columna);

        if (minas[fila][columna]) {
            mostrarMensaje("GAME OVER", "¡Has encontrado una mina! ¡Juego terminado!");
            timeline.stop();
            mostrarMinas();
            gridPane.setDisable(true);
        } else {

            botones[fila][columna].setText(Integer.toString(minasAdyacentes));
            botones[fila][columna].setDisable(true);
        }

        if (minasAdyacentes == 0) {
            deshabilitarBotonesAdyacentesConCero(fila, columna);
        }

    }
    private int banderasAcertadas = 0;

    private void clicDerechoEnCelda(int fila, int columna) {

        System.out.println(fila + " " + columna);
        if (botones[fila][columna].getText().isEmpty()) {
            // Cargar la imagen de la bandera desde el archivo
            Image banderaImage = new Image(getClass().getResourceAsStream("/bandera.jpg"));
            // Crear un ImageView y establecer la imagen de la bandera
            ImageView imageView = new ImageView(banderaImage);
            // Establecer el tamaño del ImageView para que coincida con el botón
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);

            if (botones[fila][columna].getGraphic() != null) {
                // Si ya hay una bandera, la quitamos
                botones[fila][columna].setGraphic(null);
                banderasColocadas--;
            } else {
                // Colocar una bandera
                botones[fila][columna].setGraphic(imageView);
                banderasColocadas++;

            }
        }
        actualizarEtiquetaBanderasColocadas();

        if (minas[fila][columna] == true) {
            banderasAcertadas++;
        }
        if (banderasAcertadas == numMinas) {
            try {
                mensajeVictoria();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            banderasAcertadas = 0;
        }

    }

    @FXML
    public void dfFacil() {
        crearTablero();
        resetearJuego();
        limpiarTablero();
        columnas = 8;
        filas = 8;
        numMinas = 10;
        crearTablero();
        actualizarEtiquetaBanderasColocadas();

    }

    @FXML
    public void dfIntermedio() {
        crearTablero();
        resetearJuego();
        limpiarTablero();
        columnas = 16;
        filas = 16;
        numMinas = 40;
        crearTablero();
        actualizarEtiquetaBanderasColocadas();
    }

    @FXML
    public void dfExperto() {
        crearTablero();
        resetearJuego();
        limpiarTablero();
        columnas = 30;
        filas = 16;
        numMinas = 99;
        crearTablero();
        actualizarEtiquetaBanderasColocadas();
    }

    private void resetearJuego() {

        banderasColocadas = 0;
        actualizarEtiquetaBanderasColocadas();
        // Limpia el tablero si es necesario
        limpiarTablero();
        detenerTemporizador();
    }

    private void detenerTemporizador() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    private int columnasPersonalizado;
    private int filasPersonalizado;
    private int minasPersonalizado;

    @FXML
    public void dfPersonalizado() {

        crearTablero();
        resetearJuego();
        limpiarTablero();
        TextInputDialog dialog = new TextInputDialog("8x8-10"); // Valor predeterminado
        dialog.setTitle("Dificultad Personalizada");
        dialog.setHeaderText(null);
        dialog.setContentText("Introduce la configuración (filas x columnas - minas):");

        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()) {
            String[] configuracion = resultado.get().split("-");
            if (configuracion.length == 2) {
                String[] dimension = configuracion[0].split("x");
                if (dimension.length == 2) {
                    try {
                        columnasPersonalizado = Integer.parseInt(dimension[1]);
                        filasPersonalizado = Integer.parseInt(dimension[0]);
                        minasPersonalizado = Integer.parseInt(configuracion[1]);
                        crearTableroPersonalizado();
                    } catch (NumberFormatException e) {
                        mostrarMensaje("Error", "Formato de configuración incorrecto.");
                    }
                }
            }
        }
        actualizarEtiquetaBanderasColocadas();
    }

    private void crearTableroPersonalizado() {
        columnas = columnasPersonalizado;
        filas = filasPersonalizado;
        numMinas = minasPersonalizado;
        crearTablero();

    }

    private boolean juegoPausado = false;

    @FXML
    private void botonPausa(ActionEvent event) {
        if (juegoPausado) {
            timeline.play();
            borderPane.getCenter().setDisable(false);
            juegoPausado = false;
        } else {
            timeline.pause();
            borderPane.getCenter().setDisable(true);
            juegoPausado = true;
        }
    }

    @FXML
    private void botonRecords(ActionEvent event) {
    }

    @FXML
    private void botonAyuda(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Opcion de ayuda");
        alert.setHeaderText("AYUDA");
        alert.setContentText("- Click Izquierdo para destapar las casillas del tablero \n"
                + "- Click Derecho para colocar una bandera en un lugar donde pueda haber una mina");
        alert.showAndWait();

    }

    @FXML
    private void botonSalir(ActionEvent event) {
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void menuSalir(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/buscaminasjesusballesta/primary.fxml"));
        Parent root = miCargador.load();
        PrimaryController inicio = miCargador.<PrimaryController>getController();

        Stage stageActual = (Stage) gridPane.getScene().getWindow();
        stageActual.close();
        Scene scene = new Scene(root, 640, 400);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Buscaminas JBB");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    @FXML
    private void menuAyuda(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Opcion de ayuda");
        alert.setHeaderText("BIENVENIDO AL BUSCAMINAS");
        alert.setContentText("El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.\n"
                + "\n"
                + "Algunas casillas tienen un número, el cual indica la cantidad de minas que hay en las casillas circundantes. Así, si una casilla tiene el número 3, significa que de las ocho casillas que hay alrededor (si no es en una esquina o borde) hay 3 con minas y 5 sin minas. Si se descubre una casilla sin número indica que ninguna de las casillas vecinas tiene mina y éstas se descubren automáticamente.\n"
                + "\n"
                + "Si se descubre una casilla con una mina se pierde la partida.\n"
                + "\n"
                + "Se puede poner una marca en las casillas que el jugador piensa que hay minas para ayudar a descubrir las que están cerca.\n"
                + " Para mas ayuda pulsa el signo de interrogacion con los controles basicos");

        alert.showAndWait();
    }

    @FXML
    private void botonEmpezar(ActionEvent event) {
        // Establecer el tiempo y minas a 0
        tiempoTranscurrido = 0;
        minasEncontradas = 0;
        // Actualizar las etiquetas con los valores iniciales
        actualizarEtiquetas();

        // Iniciar temporizador para actualizar el tiempo cada segundo
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            // aumentar el tiempo
            tiempoTranscurrido++;
            // Volver a actualizar las etiquetas
            actualizarEtiquetas();
        }));
        // Configurar el temporizador para que se este ejecutando todo el rato
        timeline.setCycleCount(Animation.INDEFINITE);
        // iniciar temporizador
        timeline.play();
        gridPane.setDisable(false);

    }

    private void actualizarEtiquetas() {
        tiempo.setText("Tiempo: " + tiempoTranscurrido + " s");
        //numeroMinas.setText("Minas: " + minasEncontradas);

    }

    private void actualizarEtiquetaBanderasColocadas() {
        numeroMinas.setText("minas: " + banderasColocadas + " / " + numMinas);
    }

    private void cerrarVentana() {
        Stage stage = (Stage) gridPane.getScene().getWindow();
        stage.close();
    }

}
