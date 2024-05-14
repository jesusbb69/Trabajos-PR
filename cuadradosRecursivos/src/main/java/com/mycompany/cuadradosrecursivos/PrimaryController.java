/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.cuadradosrecursivos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Jesús Ballesta
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button aplicar;
    @FXML
    private TextField texto;
    @FXML
    private CheckBox invertir;
    @FXML
    private Slider slider;
    @FXML
    private Rectangle rectangulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double tickValue = Math.round(newValue.doubleValue() / slider.getMajorTickUnit()) * slider.getMajorTickUnit();
            slider.setValue(tickValue);
            texto.setText(String.valueOf((int) tickValue));
        });

        aplicar.setOnAction(event -> dibujarFigura());

    }

    private void dibujarFigura() {
        int nivel = Integer.parseInt(texto.getText());
        boolean yes = invertir.isSelected();
        double lado = Math.min(rectangulo.getWidth(), rectangulo.getHeight()) / 2;
        dibujarCuadrado(rectangulo, lado, nivel);
    }

    private void nCuadrado(int n, double centroX, double centroY, double lado) {

        Rectangle square = new Rectangle(centroX, centroY, lado, lado);
        //square.setFill();
        //square.setStroke(color)
        pane.getChildren().add(square)
        if (n > 1) {
            nCuadrado(n - 1, centroX - lado / 4, centroY - lado / 4, lado / 2);
            nCuadrado(n - 1, centroX - lado / 4, (centroY + lado) - lado / 4, lado / 2);
            nCuadrado(n - 1, (centroX + lado) - lado / 4, centroY - lado / 4, lado / 2);
            nCuadrado(n - 1, (centroX + lado) - lado / 4, (centroY + lado) - lado / 4, lado / 2);
        }
    }

    private void rCuadradoInverso(int n, double centroX, double centroY, double lado) {
        if (n > 1) {
            rCuadradoInverso(n - 1, centroX - lado / 4, centroY - lado / 4, lado / 2);
            rCuadradoInverso(n - 1, centroX - lado / 4, (centroY + lado) - lado / 4, lado / 2);
            rCuadradoInverso(n - 1, (centroX + lado) - lado / 4, centroY - lado / 4, lado / 2);
            rCuadradoInverso(n - 1, (centroX + lado) - lado / 4, (centroY + lado) - lado / 4, lado / 2);
        }
        Rectangle square = new Rectangle(centroX, centroY, lado, lado
        square.setFill(color)
        square.setStroke(color)
        pane.getChildren().add(square)
    }

}
