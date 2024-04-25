module com.mycompany.controlcirculo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.controlcirculo to javafx.fxml;
    exports com.mycompany.controlcirculo;
}
