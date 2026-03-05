package com.exemple.classes;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "projetParEmploye" , query = "from Projet p where p.employe.id = :employeId")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private Date dateDebut;

    @Column
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "employeId" ,nullable = false )
    private Employe employe;

    @OneToMany(mappedBy = "projet")
    private List<Tache> taches = new ArrayList<>();

    public Projet() {
    }

    public Projet(String nom, Date dateDebut, Date dateFin ,Employe employe ) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.employe=employe;
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

    public Employe getEmploye() {
        return employe;
    }

    public List<Tache> getTaches() {
        return taches;
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
}
