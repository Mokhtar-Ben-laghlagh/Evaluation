package com.exemple.classes;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "tachePlanifiee" , query = "from Tache t where t.projet.id = :projetId")
@NamedQuery(name = "sup1000dh" , query = "from Tache t where t.prix > 1000")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column
    private Date dateDebut;

    @Column
    private Date dateFin;

    @Column(nullable = false)
    private double prix;

    @ManyToOne
    @JoinColumn(name = "projetId" , nullable = false)
    private Projet projet;

    public Tache() {
    }

    public Tache(String nom, Date dateDebut, Date dateFin, double prix , Projet projet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.projet=projet;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public double getPrix() {
        return prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


}
