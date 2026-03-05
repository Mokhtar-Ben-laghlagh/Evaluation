package com.exemple.classes;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "tacheParEmploye" , query = "select e.tache , e.dateDebutReelle " +
        "from EmployeTache e " +
        "where e.employe.id  = :employeId")

@NamedQuery(name = "tacheRealisee" , query = "select et " +
        "from EmployeTache et " +
        "where et.tache.projet.id =:projetId")

@NamedQuery(name = "findBetweenDate" , query = "select et " +
        "from EmployeTache et " +
        "where et.dateDebutReelle >= :d1 and et.dateFinReelle <= :d2")

public class EmployeTache {


    @EmbeddedId
    private EmployeTachePK id;

    @Column
    private Date dateDebutReelle;

    @Column
    private Date dateFinReelle;

    @ManyToOne
    @MapsId("employeId")              // <= IMPORTANT
    @JoinColumn(name = "employeId" , updatable = false , insertable = false)
    private Employe employe;

    @ManyToOne
    @MapsId("tacheId")              // <= IMPORTANT
    @JoinColumn(name = "tacheId" , updatable = false , insertable = false)
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        this.id=new EmployeTachePK();
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTachePK getId() {
        return id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }
}
