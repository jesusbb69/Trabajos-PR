module com.sequeros.autoreslibros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.autoreslibros to javafx.fxml;
    exports com.sequeros.autoreslibros;
}
