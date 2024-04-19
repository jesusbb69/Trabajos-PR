package com.mycompany.mavenproject3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Circle cara = new Circle(125, 125, 80);
        cara.setFill(Color.YELLOW);
        cara.setStroke(Color.RED);
// Crear y configurar un círculo para el ojo derecho
        Circle ojoDerecho = new Circle(86, 100, 10);
        ojoDerecho.setFill(Color.YELLOW);
        ojoDerecho.setStroke(Color.BLUE);
// Crear y configurar un círculo para el ojo izquierdo
        Circle OjoIzquierdo = new Circle(162, 100, 10);
        OjoIzquierdo.setFill(Color.YELLOW);
        OjoIzquierdo.setStroke(Color.BLUE);
// Crear y configurar la boca sonriente
        Arc boca = new Arc(125, 150, 45, 35, 0, -180);
        boca.setFill(Color.YELLOW);
        boca.setStroke(Color.BLUE);
        boca.setType(ArcType.OPEN);
// Crear y configurar el texto
        Text texto = new Text(80, 240, "Cara Sonriente");
        texto.setFill(Color.BLUE);
        texto.setFont(Font.font("Verdana", 15));
// Crear un grupo para contener todos los elementos
        Group root = new Group(cara, ojoDerecho, OjoIzquierdo, boca, texto);
// Crear y configurar la scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);
// Añadir la escena a la ventana (stage)
        stage.setScene(scene);
// Configurar el título de la ventana
        stage.setTitle("Cara Sonriente");
// Mostrar la ventana
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
