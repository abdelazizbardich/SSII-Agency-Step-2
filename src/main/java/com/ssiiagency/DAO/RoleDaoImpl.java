package com.ssiiagency.DAO;


import com.ssiiagency.entities.Role;
import com.ssiiagency.hibernate.HSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class RoleDaoImpl implements DAOInt<Role> {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role add(Role role) {

        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
        session.close();
        return role;
    }

    @Override
    public Role find(long id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        Role role = session.get(Role.class,id);
        session.close();
        return role;
    }

    @Override
    public ArrayList<Role> getAll() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        ArrayList<Role> roles = (ArrayList<Role>) session.createCriteria(Role.class).list();
        session.close();
        return roles;
    }

    @Override
    public Role update(Role role) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        session.find(Role.class,role.getId_role());
        session.merge(role);
        session.getTransaction().commit();
        session.close();
        return role;
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
        Role roleEntity = session.load(Role.class,id);
        session.delete(roleEntity);
        session.getTransaction().commit();
        return true;
    }
}
