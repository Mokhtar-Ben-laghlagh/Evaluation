package ma.projet;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeProduitService;
import ma.projet.service.ProduitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService cms = new CommandeService();
        LigneCommandeProduitService lcs = new LigneCommandeProduitService();

        Categorie cat1 = new Categorie("INFO", "INFORMATIQUE");
        cs.create(cat1);
        Categorie cat2 = new Categorie("FASHION", "FASHION");
        cs.create(cat2);

        ps.create(new Produit("ES12", 100, new Date(), cs.findById(1)));
        ps.create(new Produit("ED15", 120, new Date(), cs.findById(1)));
        ps.create(new Produit("ES13", 300, new Date(), cs.findById(2)));
        ps.create(new Produit("ED14", 600, new Date(), cs.findById(2)));

        cms.create(new Commande(new Date()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Commande c1 = new Commande(sdf.parse("08/05/2026"));
        Commande c2 = new Commande(sdf.parse("11/04/2026"));
        cms.create(c1);
        cms.create(c2);

        lcs.create(new LigneCommandeProduit(7, ps.findById(1), cms.findById(1)));
        System.out.println("insertion bien");

        // find by categorie
        System.out.println("=== Produits par catégorie " + cs.findById(1).getLibelle() + " ===");
        for (Produit p : ps.findByCategorie(cs.findById(1))) {
            System.out.println(" " + p.getReference() + " - " + p.getPrix() + " DH");
        }

        System.out.println("=== Produits par catégorie " + cs.findById(2).getLibelle() + " ===");
        for (Produit p : ps.findByCategorie(cs.findById(2))) {
            System.out.println(" " + p.getReference() + " - " + p.getPrix() + " DH");
        }

        // find between dates
        System.out.println("=== Produits entre 01/01/2026 et 10/05/2026 ===");
        for (Produit p : ps.findBetwenDates(sdf.parse("01/01/2026"), sdf.parse("10/05/2026"))) {
            System.out.println(" " + p.getReference() + " - " + p.getPrix() + " DH");
        }

        // find by commande
        System.out.println("=== Produits par commande ===");
        for (Produit p : ps.findByCommande(cms.findById(1))) {
            System.out.println(" " + p.getReference() + " - " + p.getPrix() + " DH");
        }

        // find by price
        System.out.println("\n=== Produits dont le prix > 100 DH ===");
        for (Produit p : ps.findByPrice()) {
            System.out.println("  " + p.getReference() + " - " + p.getPrix() + " DH");
        }
    }
}