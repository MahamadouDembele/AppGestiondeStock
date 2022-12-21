package com.example.gestiondestock;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
        stage2.setTitle("Page de Connexion");
        stage2.setScene(scene);
        stage2.show();
    }

    public void onHelloButtonClickProduits() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("produit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Liste des Produits");
        stage2.setScene(scene);
        stage2.show();
        prodRoot=stage2;
    }

    public void onHelloButtonClickAjouter() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("ajouterProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Ajout d'un Produit");
        stage2.setScene(scene);
        stage2.show();
        ajoutRoot=stage2;
    }

    public void onHelloButtonClickModifier() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("modifierProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Modification d'un Produit");
        stage2.setScene(scene);
        stage2.show();
        modifRoot=stage2;
    }

    public void onHelloButtonClickSupprimer() throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("supprimerProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage2.setTitle("Suppression d'un Produit");
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
        stage2.setTitle("A propos de Nous");
        stage2.setScene(scene);
        stage2.show();
        aboutRoot = stage2;
    }

    }
