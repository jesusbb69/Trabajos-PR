module com.mycompany.cuadradosrecursivos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.cuadradosrecursivos to javafx.fxml;
    exports com.mycompany.cuadradosrecursivos;
}
