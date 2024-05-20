module com.mycompany.buscaminasjesusballesta {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.buscaminasjesusballesta to javafx.fxml;
    exports com.mycompany.buscaminasjesusballesta;
}
