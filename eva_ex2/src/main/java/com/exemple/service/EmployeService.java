package com.exemple.service;

import com.exemple.classes.Employe;
import com.exemple.classes.Projet;
import com.exemple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeService extends AbstractFacade<Employe> {

    public EmployeService() {
        super(Employe.class);
    }

    public List<Object[]> tacheParEmploye(int employeId){
        Session session = null;
        Transaction tx = null;
        List<Object[]> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            taches = session.getNamedQuery("tacheParEmploye")
                    .setParameter("employeId",employeId).list();

            tx.commit();
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return taches;
    }

    public List<Projet> projetParEmploye(int employeId){
        Session session=null;
        Transaction tx = null;
        List<Projet> projets = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            projets = session.getNamedQuery("projetParEmploye")
                    .setParameter("employeId" , employeId).list();

            tx.commit();
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return projets;
    }

}


