module com.mycompany.tableview {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tableview to javafx.fxml;
    exports com.mycompany.tableview;
}
