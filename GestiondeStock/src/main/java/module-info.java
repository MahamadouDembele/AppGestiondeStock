module com.example.gestiondestock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.gestiondestock to javafx.fxml;
    exports com.example.gestiondestock;
}