package com.exemple;

import com.exemple.entites.Femme;
import com.exemple.entites.Homme;
import com.exemple.entites.Mariage;
import com.exemple.service.FemmeService;
import com.exemple.service.HommeService;
import com.exemple.service.MariageService;

import java.text.SimpleDateFormat;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        FemmeService   femmeService   = new FemmeService();
        HommeService   hommeService   = new HommeService();
        MariageService mariageService = new MariageService();

        System.out.println("========== Création des femmes ==========");

        Femme f1  = new Femme("Moussaoui",  "Lina",     "0601112233", "Casablanca",  sdf.parse("1985-03-10"));
        Femme f2  = new Femme("Tahiri",     "Dounia",   "0602223344", "Marrakech",   sdf.parse("1990-07-25"));
        Femme f3  = new Femme("Bennani",    "Zineb",    "0603334455", "Rabat",       sdf.parse("1978-11-14"));
        Femme f4  = new Femme("Hajji",      "Loubna",   "0604445566", "Fes",         sdf.parse("1983-06-02"));
        Femme f5  = new Femme("Seddiqi",    "Kawtar",   "0605556677", "Tanger",      sdf.parse("1975-09-19"));
        Femme f6  = new Femme("Amrani",     "Hajar",    "0606667788", "Agadir",      sdf.parse("1993-01-30"));
        Femme f7  = new Femme("Chraibi",    "Safae",    "0607778899", "Oujda",       sdf.parse("1988-04-07"));
        Femme f8  = new Femme("Filali",     "Ghita",    "0608889900", "Meknes",      sdf.parse("1981-12-21"));
        Femme f9  = new Femme("Naciri",     "Nadia",    "0609990011", "Kenitra",     sdf.parse("1995-08-13"));
        Femme f10 = new Femme("Berrada",    "Houda",    "0610001122", "Tetouan",     sdf.parse("1971-02-28"));

        femmeService.create(f1);  femmeService.create(f2);  femmeService.create(f3);
        femmeService.create(f4);  femmeService.create(f5);  femmeService.create(f6);
        femmeService.create(f7);  femmeService.create(f8);  femmeService.create(f9);
        femmeService.create(f10);

        System.out.println("10 femmes créées avec succès.");

        System.out.println("\n========== Création des hommes ==========");

        Homme h1 = new Homme("Karimi",     "Rachid",   "0621112233", "Casablanca",  sdf.parse("1972-05-18"));
        Homme h2 = new Homme("Ouali",      "Khalid",   "0632223344", "Rabat",       sdf.parse("1968-10-07"));
        Homme h3 = new Homme("Ziani",      "Amine",    "0643334455", "Marrakech",   sdf.parse("1979-03-25"));
        Homme h4 = new Homme("Belkadi",    "Nabil",    "0654445566", "Fes",         sdf.parse("1983-08-14"));
        Homme h5 = new Homme("Rhazali",    "Saad",     "0665556677", "Agadir",      sdf.parse("1990-12-01"));

        hommeService.create(h1); hommeService.create(h2); hommeService.create(h3);
        hommeService.create(h4); hommeService.create(h5);

        System.out.println("5 hommes créés avec succès.");

        System.out.println("\n========== Création des mariages ==========");

        // Rachid Karimi : 4 mariages
        Mariage m1  = new Mariage(sdf.parse("1998-04-10"), sdf.parse("2003-09-15"), 2, h1, f1);
        Mariage m2  = new Mariage(sdf.parse("2004-06-20"), sdf.parse("2009-11-30"), 1, h1, f2);
        Mariage m3  = new Mariage(sdf.parse("2010-01-05"), sdf.parse("2016-07-22"), 3, h1, f3);
        Mariage m4  = new Mariage(sdf.parse("2017-03-18"), null,                   2, h1, f4);

        // Khalid Ouali : 2 mariages
        Mariage m5  = new Mariage(sdf.parse("2001-08-12"), sdf.parse("2008-02-28"), 1, h2, f5);
        Mariage m6  = new Mariage(sdf.parse("2009-05-14"), null,                   2, h2, f6);

        // Amine Ziani : 2 mariages
        Mariage m7  = new Mariage(sdf.parse("2005-11-23"), sdf.parse("2013-04-10"), 0, h3, f7);
        Mariage m8  = new Mariage(sdf.parse("2014-07-01"), null,                   1, h3, f8);

        // Nabil Belkadi : 1 mariage
        Mariage m9  = new Mariage(sdf.parse("2012-09-09"), null,                   3, h4, f9);

        // Saad Rhazali : 1 mariage
        Mariage m10 = new Mariage(sdf.parse("2019-02-14"), null,                   0, h5, f10);

        // f5 mariée 2 fois (h2 et h3)
        Mariage m11 = new Mariage(sdf.parse("2015-06-30"), sdf.parse("2018-12-01"), 1, h3, f5);

        mariageService.create(m1);  mariageService.create(m2);
        mariageService.create(m3);  mariageService.create(m4);
        mariageService.create(m5);  mariageService.create(m6);
        mariageService.create(m7);  mariageService.create(m8);
        mariageService.create(m9);  mariageService.create(m10);
        mariageService.create(m11);

        System.out.println("11 mariages créés avec succès.\n");

        // ==================== REQUÊTES ====================

        System.out.println("========== Liste des femmes ==========");
        List<Femme> femmes = femmeService.findAll();
        for (Femme f : femmes) {
            System.out.println("- " + f.getPrenom() + " " + f.getNom()
                    + " | Née le : "   + f.getDateNaissance()
                    + " | Tél : "      + f.getTelephone()
                    + " | Adresse : "  + f.getAdresse());
        }

        System.out.println("\n========== Épouses de Rachid Karimi entre 1995 et 2020 ==========");
        List<Femme> epouses = hommeService.findEpouses(
                h1.getId(),
                sdf.parse("1995-01-01"),
                sdf.parse("2020-12-31")
        );
        for (Femme f : epouses) {
            System.out.println("- " + f.getPrenom() + " " + f.getNom());
        }

        System.out.println("\n========== Nombre d'enfants de Lina Moussaoui entre 1998 et 2010 ==========");
        int nbEnfants = femmeService.findEnfants(
                f1.getId(),
                sdf.parse("1998-01-01"),
                sdf.parse("2010-12-31")
        );
        System.out.println("Nombre d'enfants : " + nbEnfants);

        System.out.println("\n========== Femmes mariées 2 fois ou plus ==========");
        List<Femme> femmesDeuxFois = femmeService.findFemmesMarieesAuMoinsDeux();
        for (Femme f : femmesDeuxFois) {
            System.out.println("- " + f.getPrenom() + " " + f.getNom());
        }

        System.out.println("\n========== Hommes mariés à 4 femmes entre 1995 et 2020 ==========");
        long nbHommes = hommeService.getNbrHommesMariesQuatreFemmes(
                sdf.parse("1995-01-01"),
                sdf.parse("2020-12-31")
        );
        System.out.println("Nombre d'hommes mariés à 4 femmes : " + nbHommes);

        System.out.println("\n========== Mariages de Rachid Karimi avec détails ==========");
        System.out.println("\n========== Mariages de Rachid Karimi avec détails ==========");
        List<Mariage> mariages = hommeService.findMariagesByHomme(h1.getId());
        for (Mariage m : mariages) {
            System.out.println("- Épouse : " + m.getFemme().getPrenom() + " " + m.getFemme().getNom()
                    + " | Début : "   + m.getDateDebut()
                    + " | Fin : "     + (m.getDateFin() != null ? m.getDateFin() : "En cours")
                    + " | Enfants : " + m.getNbrEnfant());  // ✅ corrigé
        }    }
}