package com.ssiiagency.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HSessionFactory {
    public SessionFactory getSession(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static HSessionFactory getInstance(){
        return new HSessionFactory();
    }
}
