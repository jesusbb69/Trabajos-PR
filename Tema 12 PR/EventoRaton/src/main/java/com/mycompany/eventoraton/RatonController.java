/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.eventoraton;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Jesús Ballesta
 */
public class RatonController implements Initializable {

    double x, y;
    @FXML
    private Text raton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setOnMouseDragged(MouseEvent event) {
        // Para obtener las nuevas cooordenadas
        double X = event.getSceneX() - x;
        double Y = event.getSceneY() - y;

        // Se establecen las coordenadas
        raton.setLayoutX(X);
        raton.setLayoutY(Y);
    }
    
    
        
}
