package ma.projet.util;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static{
        try{
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Categorie.class);
        configuration.addAnnotatedClass(Commande.class);
        configuration.addAnnotatedClass(LigneCommandeProduit.class);
        configuration.addAnnotatedClass(Produit.class);

        sessionFactory = configuration.buildSessionFactory();
        }catch(Exception e){
            System.err.println( "Erreur d'initialisation de SessionFactory !!"+ e.getMessage());
            throw new  ExceptionInInitializerError( e );
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutdown(){
        sessionFactory.close();
    }
    }

