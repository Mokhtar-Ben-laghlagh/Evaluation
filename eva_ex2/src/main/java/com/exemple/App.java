package com.exemple;

import com.exemple.classes.Employe;
import com.exemple.classes.EmployeTache;
import com.exemple.classes.Projet;
import com.exemple.classes.Tache;
import com.exemple.service.EmployeService;
import com.exemple.service.EmployeTacheService;
import com.exemple.service.ProjetService;
import com.exemple.service.TacheService;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();

        // Insertions des employés
        Employe e1 = new Employe("Youssef", "Alami", "0612345678");
        Employe e2 = new Employe("Nadia", "Chakir", "0698765432");
        Employe e3 = new Employe("Karim", "Idrissi", "0655443322");

        es.create(e1);
        es.create(e2);
        es.create(e3);

        // Insertions des projets
        Projet p1 = new Projet("Application Mobile", new Date("2026/02/01"), new Date("2026/06/30"), e1);
        Projet p2 = new Projet("Système ERP", new Date("2026/03/01"), new Date("2026/09/30"), e2);

        ps.create(p1);
        ps.create(p2);

        // Insertions des tâches
        Tache t1 = new Tache("Conception BDD", new Date("2026/02/01"), new Date("2026/02/15"), 1500, p1);
        Tache t2 = new Tache("Développement API", new Date("2026/02/16"), new Date("2026/03/15"), 4000, p1);
        Tache t3 = new Tache("Interface Utilisateur", new Date("2026/03/16"), new Date("2026/04/30"), 3500, p1);
        Tache t4 = new Tache("Analyse des besoins", new Date("2026/03/01"), new Date("2026/03/20"), 2000, p2);
        Tache t5 = new Tache("Intégration modules", new Date("2026/03/21"), new Date("2026/05/30"), 5000, p2);

        ts.create(t1);
        ts.create(t2);
        ts.create(t3);
        ts.create(t4);
        ts.create(t5);

        // Insertions des EmployeTache
        EmployeTache et1 = new EmployeTache(new Date("2026/02/01"), new Date("2026/02/14"), e1, t1);
        EmployeTache et2 = new EmployeTache(new Date("2026/02/16"), new Date("2026/03/10"), e2, t2);
        EmployeTache et3 = new EmployeTache(new Date("2026/03/16"), new Date("2026/04/25"), e3, t3);
        EmployeTache et4 = new EmployeTache(new Date("2026/03/01"), new Date("2026/03/18"), e1, t4);

        ets.create(et1);
        ets.create(et2);
        ets.create(et3);
        ets.create(et4);

        System.out.println("insertion de donnees bien faite");

        // Tâches réalisées par employé 1
        List<Object[]> taches = es.tacheParEmploye(1);
        System.out.println("Les taches realisees par employee 1");
        for (Object[] row : taches) {
            Tache t = (Tache) row[0];
            Date debutReel = (Date) row[1];
            System.out.println(t.getId() + " - " + t.getNom() + " - " + t.getPrix() + " - " + debutReel);
        }

        // Projets gérés par employé 1
        List<Projet> projets = es.projetParEmploye(1);
        System.out.println("Les projets gérés par employee 1");
        for (Projet p : projets) {
            System.out.println(p.getId() + " - " + p.getNom());
        }

        // Tâches planifiées pour projet 1
        List<Tache> taches1 = ps.tachePlanifiee(1);
        System.out.println("La liste des tâches planifiées pour projet 1");
        for (Tache t : taches1) {
            System.out.println(t.getId() + " - " + t.getNom() + " - " + t.getPrix());
        }

        // Tâches réalisées pour projet 1
        List<EmployeTache> taches2 = ps.tacheRealisee(1);
        System.out.println("La liste des tâches réalisées pour projet 1");
        for (EmployeTache t : taches2) {
            System.out.println(t.getTache().getId() + " - " + t.getTache().getNom() + " - " + t.getTache().getPrix());
        }

        // Tâches dont le prix > 1000 DH
        List<Tache> taches3 = ts.sup1000dh();
        System.out.println("Les tâches dont le prix est supérieur à 1000 DH");
        for (Tache t : taches3) {
            System.out.println(t.getId() + " - " + t.getNom() + " - " + t.getPrix());
        }

        // Tâches réalisées entre deux dates
        List<EmployeTache> taches4 = ts.findBetweenDate(new Date("2026/01/01"), new Date("2026/12/31"));
        System.out.println("Les tâches réalisées entre 01/01/2026 et 31/12/2026");
        for (EmployeTache t : taches4) {
            System.out.println(t.getTache().getId() + " - " + t.getTache().getNom() + " - " + t.getTache().getPrix());
        }
    }
}