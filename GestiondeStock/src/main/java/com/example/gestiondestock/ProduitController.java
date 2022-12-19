package com.example.gestiondestock;

import database.ConnectionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Produits;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitController {

    @FXML
    private TableView<Produits> mesProduits;
    @FXML
    private TableColumn<Produits, Integer> id;
    @FXML
    private TableColumn<Produits,String> nom;
    @FXML
    private TableColumn<Produits,Integer> prix;
    @FXML
    private TableColumn<Produits, Integer> decription;
    @FXML
    private TableColumn<Produits,Integer> quantite;

    public ObservableList<Produits> produitsData = FXCollections.observableArrayList();
    @FXML
    public void viewProduits() {
        try {
            Connection con = ConnectionDb.getConnection();
            String sql = "SELECT * FROM produits";
            PreparedStatement stat = con.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                produitsData.add(
                        new Produits(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5))
                        );
            }
            con.close();
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

        id.setCellValueFactory(new PropertyValueFactory<Produits,Integer>("id"));

        nom.setCellValueFactory(new PropertyValueFactory<Produits,String>("nom"));

        prix.setCellValueFactory(new PropertyValueFactory<Produits,Integer>("prix"));

        decription.setCellValueFactory(new PropertyValueFactory<Produits,Integer>("description"));

        quantite.setCellValueFactory(new PropertyValueFactory<Produits,Integer>("quantite"));

        mesProduits.setItems(produitsData);
    }

    public void AnnulerProduit() {
        HomeController.prodRoot.close();
    }

}
