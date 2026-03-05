package com.exemple.service;

import com.exemple.classes.EmployeTache;
import com.exemple.classes.Projet;
import com.exemple.classes.Tache;
import com.exemple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProjetService extends AbstractFacade<Projet> {

    public ProjetService() {
        super(Projet.class);
    }

    public List<Tache> tachePlanifiee (int projetId){
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            taches = session.getNamedQuery("tachePlanifiee")
                    .setParameter("projetId" , projetId).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return taches;
    }
    public List<EmployeTache> tacheRealisee (int projetId){
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            taches = session.getNamedQuery("tacheRealisee")
                    .setParameter("projetId" , projetId).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return taches;
    }

}