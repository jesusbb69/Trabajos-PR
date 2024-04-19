package com.mycompany.mavenproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new Button("En el Stage Primary"), 200, 250);
        primaryStage.setTitle("MiJavaFX"); // Definimos el título del stage
        primaryStage.setScene(scene); // colocamos la scene en el stage
        primaryStage.show(); // Display el stage
        
        Stage stage = new Stage(); // Crea un nuevo stage
        stage.setTitle("Segundo Stage"); // Definimos el título del stage
        // Actualiza una scene con un botón (button) en el stage (ventana)
        stage.setScene(new Scene(new Button("Segundo Stage"), 100, 100));
        stage.show(); // Display el stage
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