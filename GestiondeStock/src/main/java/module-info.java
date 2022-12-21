module com.example.gestiondestock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.gestiondestock to javafx.fxml;
    opens models to javafx.base;
    exports com.example.gestiondestock;
}