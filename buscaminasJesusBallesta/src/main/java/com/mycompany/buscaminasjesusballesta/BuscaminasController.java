/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminasjesusballesta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
    
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         int columnas = 8;
         int filas = 8;
         
        
         
        
        GridPane gridPane = new GridPane();
       
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Button boton = new Button();
                boton.setMinSize(40, 40); 
                boton.setMaxSize(40, 40); 
                boton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event){
                        System.out.println(GridPane.getRowIndex(boton) + "  " + GridPane.getColumnIndex(boton));
                    }
                });
                gridPane.add(boton, columna, fila);
            }
        }
        
        gridPane.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(gridPane);
        
    
    }    
    
    
   
    
    
    @FXML
    private void dfFacil(ActionEvent event) {
        int columnas = 8;
         int filas = 8;
         
        
         
        
        GridPane gridPane = new GridPane();
       
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Button boton = new Button();
                boton.setMinSize(40, 40); 
                boton.setMaxSize(40, 40); 
                boton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event){
                        System.out.println(GridPane.getRowIndex(boton) + "  " + GridPane.getColumnIndex(boton));
                    }
                });
                gridPane.add(boton, columna, fila);
            }
        }
        
        gridPane.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(gridPane);
    }

    @FXML
    private void dfIntermedio(ActionEvent event) {
        int columnas = 16;
         int filas = 16;
         
        
         
        
        GridPane gridPane = new GridPane();
       
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Button boton = new Button();
                boton.setMinSize(40, 40); 
                boton.setMaxSize(40, 40); 
                boton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event){
                        System.out.println(GridPane.getRowIndex(boton) + "  " + GridPane.getColumnIndex(boton));
                    }
                });
                gridPane.add(boton, columna, fila);
            }
        }
        
        gridPane.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(gridPane);
    }

    @FXML
    private void dfExperto(ActionEvent event) {
        int columnas = 30;
         int filas = 16;
         
        
         
        
        GridPane gridPane = new GridPane();
       
        
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Button boton = new Button();
                boton.setMinSize(40, 40); 
                boton.setMaxSize(40, 40); 
                boton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event){
                        System.out.println(GridPane.getRowIndex(boton) + "  " + GridPane.getColumnIndex(boton));
                    }
                });
                gridPane.add(boton, columna, fila);
            }
        }
        
        gridPane.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(gridPane);
    }

    @FXML
    private void dfPersonalizado(ActionEvent event) {
        
    }

    @FXML
    private void botonPausa(ActionEvent event) {
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
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();      
                
    }

    @FXML
    private void menuAyuda(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Opcion de ayuda");
        alert.setHeaderText("BIENVENIDO AL BUSCAMINAS");          
        alert.setContentText("El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.\n" +
"\n" +
"Algunas casillas tienen un número, el cual indica la cantidad de minas que hay en las casillas circundantes. Así, si una casilla tiene el número 3, significa que de las ocho casillas que hay alrededor (si no es en una esquina o borde) hay 3 con minas y 5 sin minas. Si se descubre una casilla sin número indica que ninguna de las casillas vecinas tiene mina y éstas se descubren automáticamente.\n" +
"\n" +
"Si se descubre una casilla con una mina se pierde la partida.\n" +
"\n" +
"Se puede poner una marca en las casillas que el jugador piensa que hay minas para ayudar a descubrir las que están cerca.\n"
                + " Para mas ayuda pulsa el signo de interrogacion con los controles basicos");
                         
        alert.showAndWait();
    }

}
