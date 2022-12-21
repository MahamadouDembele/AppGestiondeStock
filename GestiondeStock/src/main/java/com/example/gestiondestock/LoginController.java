package com.example.gestiondestock;

import database.ConnectionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    public PasswordField passwordField;
    public Button annulerButton;
    public TextField LoginField;
    public Button submit;
    public Label mdp;

    /**
     *
     */
    @FXML
    protected void  annulerButtonAction() throws IOException {
        Home.root.close();
    }
    @FXML
    public void setSubmit() throws IOException{
        Connection con = ConnectionDb.getConnection();
        PreparedStatement stat = null;

        ResultSet rs = null;

        String sql ="SELECT * FROM admin WHERE login= ? AND motdepasse= ?";

        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, LoginField.getText().toString());
            stat.setString(2,passwordField.getText().toString());
            rs = stat.executeQuery();
            if (rs.next()){
                Stage stage2 = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("home-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 650, 450);
                stage2.setTitle("Page d'accueil");
                stage2.setScene(scene);
                stage2.show();
                HomeController.myroot=stage2;
                Home.root.close();

            }else {
                mdp.setText("Veuillez corriger vos informations");
                Alert alert;
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur de connexion");
                alert.setHeaderText("Erreur");
                alert.setContentText("Login ou Mot de Passe Incorrect");
                alert.showAndWait();
            }
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }
}
