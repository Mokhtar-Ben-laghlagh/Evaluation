package ma.projet.classes;

import javax.persistence.*;

@Entity
@Table(name = "lignes")
public class LigneCommandeProduit {

    @EmbeddedId
    private LigneCommandeProduitPK id;

    private int quantite;

    @ManyToOne
    @JoinColumn(name = "idproduit", insertable = false, updatable = false)
    Produit produit;

    @ManyToOne
    @JoinColumn(name = "idcommande", insertable = false, updatable = false)
    Commande commande;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(int quantite, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
        id = new LigneCommandeProduitPK(commande.getId(), produit.getId());
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}