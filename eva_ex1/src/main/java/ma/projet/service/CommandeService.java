package ma.projet.service;

import ma.projet.classes.Commande;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CommandeService implements IDao<Commande> {
    @Override
    public boolean create(Commande c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(c);
            t.commit();
            return true;
        }catch(Exception e){
            t.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Commande c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(c);
            t.commit();
            return true;
        }catch(Exception e){
            t.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Commande c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(c);
            t.commit();
            return true;
        }catch(Exception e){
            t.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Commande findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Commande p = (Commande) session.get(Commande.class, id);
        session.close();
        return p;
    }

    @Override
    public List<Commande> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Commande> list = session.createQuery("from Commande").list();
        session.close();
        return list;
    }
}
