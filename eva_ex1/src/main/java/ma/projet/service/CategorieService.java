package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie c) {
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
    public boolean update(Categorie c) {
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
    public boolean delete(Categorie c) {
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
    public Categorie findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Categorie p = (Categorie) session.get(Categorie.class, id);
        session.close();
        return p;
    }

    @Override
    public List<Categorie> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Categorie> list = session.createQuery("from Categorie").list();
        session.close();
        return list;
    }
}
