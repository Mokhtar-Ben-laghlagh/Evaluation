package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    public boolean create(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(p);
            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(Produit o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(o);
            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean delete(Produit o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(o);
            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Produit findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Produit p = session.get(Produit.class, id);
        session.close();
        return p;
    }

    public List<Produit> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = session.createQuery("from Produit", Produit.class).list();
        session.close();
        return list;
    }

    public List<Produit> findByCategorie(Categorie categorie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Produit> query = session.createQuery(
                "from Produit p where p.categorie.id = :catId", Produit.class
        );
        query.setParameter("catId", categorie.getId());
        List<Produit> list = query.list();
        session.close();
        return list;
    }

    public List<Produit> findBetwenDates(Date date1, Date date2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Produit> query = session.createQuery(
                "select lcp.produit from LigneCommandeProduit lcp where lcp.commande.date between :d1 and :d2",
                Produit.class
        );
        query.setParameter("d1", date1);
        query.setParameter("d2", date2);
        List<Produit> list = query.list();
        session.close();
        return list;
    }

    public List<Produit> findByCommande(Commande cmd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Produit> query = session.createQuery(
                "select lcp.produit from LigneCommandeProduit lcp where lcp.commande.id = :cmdId",
                Produit.class
        );
        query.setParameter("cmdId", cmd.getId());
        List<Produit> list = query.list();
        session.close();
        return list;
    }

    public List<Produit> findByPrice() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = session.createNamedQuery("produitSup100", Produit.class).list();
        session.close();
        return list;
    }
}