module com.mycompany.menusydialogos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.menusydialogos to javafx.fxml;
    exports com.mycompany.menusydialogos;
}
