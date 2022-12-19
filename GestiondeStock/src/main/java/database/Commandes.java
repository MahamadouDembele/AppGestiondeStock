package database;

import models.Produits;

import java.sql.*;

public class Commandes {
    private static final String db = "gestock";
    private static final String user = "root";
    private static final String pass = "root";
    private static Connection con ;

    public static Connection getConnection() {
        if (con != null) return con;
        return getConnection(db, user, pass);
    }

    private static Connection getConnection(String db, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, pass);
            System.out.println("Connectée avec Succes");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: " + e.getMessage());
        }

        return con;
    }
    public static int AjouterProduits(Produits produits){
        int prd=0;
        try {
            String sql ="INSERT INTO produits(nom,prix,description,quantite) VALUES (?,?,?,?)";
            Connection con = ConnectionDb.getConnection();
            PreparedStatement stat;
            stat= con.prepareStatement(sql);
            stat.setString(1,produits.getNom());
            stat.setString(2,produits.getPrix());
            stat.setString(3,produits.getDescription());
            stat.setString(4,produits.getQuantite());
            prd=stat.executeUpdate();
            con.close();
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
        return prd;
    }
    public static int ModifierProduits(Produits produits){
        int prdd=0;
        try {
            String sql="UPDATE produits SET nom=?,prix=?,description=?,quantite=? WHERE id=?";
            Connection con = ConnectionDb.getConnection();
            PreparedStatement stat;
            stat= con.prepareStatement(sql);
            stat.setString(1,produits.getNom());
            stat.setInt(2, Integer.parseInt(produits.getPrix()));
            stat.setString(3,produits.getDescription());
            stat.setInt(4, Integer.parseInt(produits.getQuantite()));
            stat.setInt(5,produits.getId());
            prdd= stat.executeUpdate();
            con.close();

        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
        return prdd;
    }
    public static int SupprimerProduits(int id){
        int prrdd=0;
        try {
            String sql ="DELETE FROM produits WHERE id=?";
            Connection con = ConnectionDb.getConnection();
            PreparedStatement stat;
            stat= con.prepareStatement(sql);
            stat.setInt(1,id);
            prrdd=stat.executeUpdate();
            con.close();
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
        return prrdd;
    }
    public static Produits getProduits(int id){
        Produits produits = new Produits();
        try {
            String sql ="SELECT * FROM produits WHERE id=?";
            Connection con = ConnectionDb.getConnection();
            PreparedStatement stat;
            stat= con.prepareStatement(sql);
            stat = con.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rst = stat.executeQuery();
            if (rst.next()){
                produits.setId(rst.getInt(1));
                produits.setNom(rst.getString(2));
               produits.setPrix(rst.getInt(3));
                produits.setDescription(rst.getString(4));
                produits.setQuantite(String.valueOf(rst.getInt(5)));
            }

        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
        return produits;
    }
}
