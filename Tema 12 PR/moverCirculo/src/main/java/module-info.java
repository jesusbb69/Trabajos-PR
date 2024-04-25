module com.mycompany.movercirculo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.movercirculo to javafx.fxml;
    exports com.mycompany.movercirculo;
}
