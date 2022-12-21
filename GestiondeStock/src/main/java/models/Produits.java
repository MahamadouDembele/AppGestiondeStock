package models;

public class Produits {
    private int id;
    private  String nom;
    private int prix;
    private String description;
    private int quantite;

    public Produits(){
        super();
    }

    public Produits(int id, String nom, int prix, String description, int quantite) {
        super();
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public Produits setId(int id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Produits setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public int getPrix() {
        return prix;
    }

    public Produits setPrix(int prix) {
        this.prix = prix;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Produits setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getQuantite() {
        return String.valueOf(quantite);
    }

    public Produits setQuantite(int quantite) {
        this.quantite = quantite;
        return this;
    }
}
