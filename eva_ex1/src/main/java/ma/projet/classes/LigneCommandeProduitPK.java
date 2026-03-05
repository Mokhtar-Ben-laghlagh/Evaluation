package ma.projet.classes;

import java.io.Serializable;
import java.util.Objects;


public class LigneCommandeProduitPK implements Serializable {
    private int idproduit;
    private int idcommande;

    public LigneCommandeProduitPK() {
    }

    public LigneCommandeProduitPK(int produit, int commande) {
        this.idproduit = produit;
        this.idcommande = commande;
    }

    // Equals : obligatoire pour comparer les clés
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeProduitPK that = (LigneCommandeProduitPK) o;
        return idproduit == that.idproduit && idcommande == that.idcommande;
    }

    // HashCode : obligatoire pour les collections et caching Hibernate
    @Override
    public int hashCode() {
        return Objects.hash(idproduit, idcommande);
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }
}