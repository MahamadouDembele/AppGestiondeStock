package com.example.gestiondestock;

import database.Commandes;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Produits;

import java.io.IOException;
import java.text.ParseException;

public class ModifierProduitController {


    public TextField id;
    public TextField nom;
    public TextField prix;
    public TextField description;
    public TextField quantite;

    public void AnnulerModif() {
        HomeController.modifRoot.close();
    }

    public void chercherId(ActionEvent actionEvent) throws IOException, ParseException {
        String pid = id.getText();
        int id = Integer.parseInt(pid);
        Produits produits= Commandes.getProduits(id);
        nom.setText(produits.getNom());
        prix.setText(produits.getPrix());
        description.setText(produits.getDescription());
        quantite.setText(produits.getQuantite());
    }

    public void modifierProduit(ActionEvent actionEvent) {
        String pid = id.getText();
        int id = Integer.parseInt(pid);
        String pnom = nom.getText();
        String pprix = prix.getText();
        String pdesc = description.getText();
        String pquant = quantite.getText();
        Produits produits = new Produits();
        produits.setId(id);
        produits.setNom(pnom);
        produits.setPrix(Integer.parseInt(pprix));
        produits.setDescription(pdesc);
        produits.setQuantite(pquant);
        int status = Commandes.ModifierProduits(produits);
        Alert alert;
        if(status>0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modif d'un produit");
            alert.setHeaderText("Information");
            alert.setContentText("Produit modifié avec succès");
        }else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur survenue");
            alert.setHeaderText("Erreur");
            alert.setContentText("Produit non modifié");
        }
        alert.showAndWait();
    }
    }

