package com.ssiiagency.DAO;
import com.ssiiagency.entities.Admin;
import com.ssiiagency.hibernate.HSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AdminDaoImpl implements DAOInt<Admin> {

    @Autowired
    private SessionFactory sessionFactory;

    private Admin admin;


    @Autowired
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    @Override
    public Admin add(Admin admin) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        admin.setIdUser((long)session.save(admin));
        session.getTransaction().commit();
        session.close();
        return admin;
    }

    @Override
    public Admin find(long id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        Admin admin = session.find(Admin.class,id);
        session.close();
        return admin;
    }

    public Admin findByEmail(String email){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        List results = session.createQuery("FROM user e where email = :email")
                .setParameter("email", email)
                .setMaxResults(1).list();
        session.close();
        if(results.size()>0)
        return (Admin) results.get(0);
        return null;
    }

    @Override
    public List<Admin> getAll() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        List<Admin> admins = session.createCriteria(Admin.class).list();
        session.close();
        return admins;
    }

    @Override
    public Admin update(Admin admin) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        session.merge(admin);
        session.getTransaction().commit();
        session.close();
        return admin;
    }

    @Override
    public boolean delete(long id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        Admin admin = session.find(Admin.class,id);
        session.delete(admin);
        session.getTransaction().commit();
        return true;
    }
}
