package com.example.gestiondestock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class HomeController {
    public static Stage myroot;
    public static Stage aboutRoot;
    public static Stage ajoutRoot;
    public static Stage modifRoot;
    public static Stage supprRoot;
    public static Stage prodRoot;


    @FXML
    private Label welcomeText;
    @FXML
    private Button annulerButton;



    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();
    }

    public void onHelloButtonClickProduits() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("produit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();
        prodRoot=stage2;
    }

    public void onHelloButtonClickAjouter() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("ajouterProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();
        ajoutRoot=stage2;
    }

    public void onHelloButtonClickModifier() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("modifierProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();
        modifRoot=stage2;
    }

    public void onHelloButtonClickSupprimer() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("supprimerProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();
        supprRoot=stage2;
    }

    public void onHelloButtonClickAnnuler() throws IOException {
        HomeController.myroot.close();
    }

    public void onHelloButtonClickAbout() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("about.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Hello!");
        stage2.setScene(scene);
        stage2.show();
        aboutRoot = stage2;
    }


//    public void showName(ActionEvent actionEvent){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:81/javafx_database","root","root");
//            ResultSet resultSet = con.createStatement().executeQuery("Select * from name");
//            while (resultSet.next()){
//                welcomeText.setText(resultSet.getString(1));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
