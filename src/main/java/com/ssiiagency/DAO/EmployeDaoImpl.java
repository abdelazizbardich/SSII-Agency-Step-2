package com.ssiiagency.DAO;

import com.ssiiagency.entities.Employe;
import com.ssiiagency.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeDaoImpl implements DAOInt<Employe> {

    public boolean setAsGone(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Employe employe = session.find(Employe.class,id);
        employe.setGoneOut(true);
        session.merge(employe);
        session.getTransaction().commit();
        session.close();
        return true;
    }


    @Override
    public Employe add(Employe employe) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(employe);
        session.getTransaction().commit();
        session.close();
        return employe;
    }

    @Override
    public Employe find(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Employe employe = session.find(Employe.class,id);
        session.close();
        return employe;
    }

    @Override
    public  List<Employe> getAll() {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        List<Employe> employes = session.createCriteria(Employe.class).list();
        return employes;
    }

    @Override
    public Employe update(Employe employe) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.load(Employe.class,employe.getIdUser());
        session.merge(employe);
        session.getTransaction().commit();
        session.close();
        return  employe;
    }

    @Override
    public boolean delete(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Employe employe = session.find(Employe.class,id);
        session.delete(employe);
        session.getTransaction().commit();
        session.close();
        return true;
    }



    public  boolean setAsWokring(long id){
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Employe employe = session.find(Employe.class,id);
        employe.setGoneOut(false);
        session.merge(employe);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
