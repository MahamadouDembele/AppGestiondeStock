package com.example.gestiondestock;

import database.Commandes;
import database.ConnectionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Produits;

import java.net.URL;
import java.util.ResourceBundle;

public class AjouterProduitController {

    @FXML 
    public TextField nom;
    @FXML
    public TextField prix;
    @FXML
    public TextField description;
    @FXML
    public TextField quantite;
    @FXML


    private ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4");


    public void AnnulerAjouter()  {
        HomeController.ajoutRoot.close();
    }

    public void AjouterProduits(ActionEvent actionEvent) {
        String nomR = nom.getText();
        String prixR = prix.getText();
        String descR = description.getText();
        String quantR = quantite.getText();

        Produits prods = new Produits();
        prods.setNom(nomR);
        prods.setPrix(Integer.parseInt(prixR));
        prods.setDescription(descR);
        prods.setQuantite(quantR);

        int status = Commandes.AjouterProduits(prods);
        Alert alert;
        if(status>0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout d'un produit");
            alert.setHeaderText("Information");
            alert.setContentText("Produit ajouté avec succès");
        }else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur survenue");
            alert.setHeaderText("Erreur");
            alert.setContentText("Produit non ajouté");
        }
        alert.showAndWait();
    }
}
