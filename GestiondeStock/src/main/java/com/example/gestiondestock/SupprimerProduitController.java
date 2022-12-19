package com.example.gestiondestock;

import database.Commandes;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SupprimerProduitController {
    public TextField id;

    public void AnnulerSuppr() {
        HomeController.supprRoot.close();
    }

    public void supprimerProduits() {
        String pid = id.getText();
        int id =Integer.parseInt(pid);

        int status = Commandes.SupprimerProduits(Integer.parseInt(pid));
        Alert alert;
        if(status>0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppression d'un produit");
            alert.setHeaderText("Information");
            alert.setContentText("Produit Supprimer avec succès");
        }else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur survenue");
            alert.setHeaderText("Erreur");
            alert.setContentText("Produit non Supprimer");
        }
        alert.showAndWait();
    }
}

