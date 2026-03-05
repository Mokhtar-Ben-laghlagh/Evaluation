package ma.projet.service;

import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class LigneCommandeProduitService implements IDao<LigneCommandeProduit> {
    @Override
    public boolean create(LigneCommandeProduit l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(l);
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
    public boolean update(LigneCommandeProduit l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(l);
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
    public boolean delete(LigneCommandeProduit l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(l);
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
    public LigneCommandeProduit findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LigneCommandeProduit p = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
        session.close();
        return p;
    }

    @Override
    public List<LigneCommandeProduit> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LigneCommandeProduit> list = session.createQuery("from LigneCommandeProduit").list();
        session.close();
        return list;
    }
}
