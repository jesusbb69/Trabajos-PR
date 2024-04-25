package com.mycompany.controlcirculo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btAumentar = new Button("Aumentar");
        Button btDisminuir = new Button("Disminuir");
        hBox.getChildren().add(btAumentar);
        hBox.getChildren().add(btDisminuir);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        // Creamos una scene y la situamos en el stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Control de Círculo"); // Establecemos el título de la ventana
        primaryStage.setScene(scene); // Situamos la escena (scene) en la ventana (stage)
        primaryStage.show(); // Mostramos stage
        
        
        btAumentar.setOnAction(event -> aumentar(circle));
        btDisminuir.setOnAction(event -> disminuir(circle));

        
        circle.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                aumentar(circle);
            } else if (event.getButton() == MouseButton.SECONDARY) {
                disminuir(circle);
            }
        });
    }

    private void aumentar(Circle circulo){
        circulo.setRadius(circulo.getRadius()+ 5);
    }
    
    private void disminuir(Circle circulo){
        if (circulo.getRadius() > 5){
            circulo.setRadius(circulo.getRadius() - 5);
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class
                .getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
