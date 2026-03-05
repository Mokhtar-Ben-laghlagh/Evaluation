package ma.projet.classes;

import ma.projet.classes.Produit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false , unique = true)
    private String code;
    @Column
    private String libelle;

    @OneToMany(mappedBy = "categorie" , fetch = FetchType.EAGER)
    private List<Produit> produits = new ArrayList<>();

    public Categorie() {
    }

    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}