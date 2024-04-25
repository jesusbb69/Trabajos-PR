module com.mycompany.eventoraton {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.eventoraton to javafx.fxml;
    exports com.mycompany.eventoraton;
}
