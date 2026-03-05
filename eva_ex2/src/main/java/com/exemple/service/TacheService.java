package com.exemple.service;

import com.exemple.classes.EmployeTache;
import com.exemple.classes.Tache;
import com.exemple.service.AbstractFacade;
import com.exemple.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class TacheService extends AbstractFacade<Tache> {

    public TacheService() {
        super(Tache.class);
    }


    public List<Tache> sup1000dh(){
        Session session= null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            taches = session.getNamedQuery("sup1000dh").list();
            tx.commit();
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return taches;
    }
    public List<EmployeTache> findBetweenDate(Date d1 , Date d2){
        Session session= null;
        Transaction tx = null;
        List<EmployeTache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            taches = session.getNamedQuery("findBetweenDate")
                    .setParameter("d1",d1).setParameter("d2",d2).list();
            tx.commit();
        }catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return taches;
    }
}
