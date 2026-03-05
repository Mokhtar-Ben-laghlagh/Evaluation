package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findByCategorie", query = "from Produit where categorie = :categorie"),
        @NamedQuery(name = "findBetweenDate", query = "from Produit where dateAchat between :d1 and :d2"),
        @NamedQuery(name = "produitSup100", query = "from Produit where prix > 100")
})
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String reference;

    @Column(nullable = false)
    private float prix;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String reference, float prix, Date dateAchat, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.dateAchat = dateAchat;
        this.categorie = categorie;
    }

    public int getId() { return id; }
    public String getReference() { return reference; }
    public float getPrix() { return prix; }
    public Categorie getCategorie() { return categorie; }
    public Date getDateAchat() { return dateAchat; }

    public void setReference(String reference) { this.reference = reference; }
    public void setPrix(float prix) { this.prix = prix; }
    public void setDateAchat(Date dateAchat) { this.dateAchat = dateAchat; }
}