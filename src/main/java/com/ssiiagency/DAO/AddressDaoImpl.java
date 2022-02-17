package com.ssiiagency.DAO;

import com.ssiiagency.entities.Address;
import com.ssiiagency.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl implements DAOInt<Address> {
    @Override
    public Address add(Address address) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    @Override
    public Address find(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Address address = session.get(Address.class,id);
        session.close();
        return address;

    }

    @Override
    public List<Address> getAll() {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        List<Address> addresss = session.createCriteria(Address.class).list();
        session.close();
        return addresss;
    }

    @Override
    public Address update(Address address) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.find(Address.class,address.getIdAddress());
        session.merge(address);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    @Override
    public boolean delete(long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Address address = session.load(Address.class,id);
        session.delete(address);
        session.getTransaction().commit();
        return true;
    }
}
