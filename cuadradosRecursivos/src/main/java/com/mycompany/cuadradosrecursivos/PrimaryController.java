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

   private void dibujarCuadrado(Rectangle rect, double size, int nivel) {
    if (nivel <= 0) return;

    Color color = invertir.isSelected() ? Color.GREEN : Color.BLACK;
    double newSize = size / 2;

    
    Rectangle r1 = new Rectangle(rect.getX(), rect.getY(), newSize, newSize);
    r1.setFill(color);
    rect.getParent().getChildrenUnmodifiable().add(r1);

    Rectangle r2 = new Rectangle(rect.getX() + newSize, rect.getY(), newSize, newSize);
    r2.setFill(color);
    rect.getParent().getChildrenUnmodifiable().add(r2);

    Rectangle r3 = new Rectangle(rect.getX(), rect.getY() + newSize, newSize, newSize);
    r3.setFill(color);
    rect.getParent().getChildrenUnmodifiable().add(r3);

    Rectangle r4 = new Rectangle(rect.getX() + newSize, rect.getY() + newSize, newSize, newSize);
    r4.setFill(color);
    rect.getParent().getChildrenUnmodifiable().add(r4);

    
    dibujarCuadrado(r1, newSize, nivel - 1);
    dibujarCuadrado(r2, newSize, nivel - 1);
    dibujarCuadrado(r3, newSize, nivel - 1);
    dibujarCuadrado(r4, newSize, nivel - 1);
}





}
