module com.mycompany.listview {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.listview to javafx.fxml;
    exports com.mycompany.listview;
}
