module com.mycompany.convertidor {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.convertidor to javafx.fxml;
    exports com.mycompany.convertidor;
}
