module com.mycompany.sumaryrestar {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.sumaryrestar to javafx.fxml;
    exports com.mycompany.sumaryrestar;
}
