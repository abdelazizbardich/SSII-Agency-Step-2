package com.ssiiagency.services;


import com.ssiiagency.DAO.AddressDaoImpl;
import com.ssiiagency.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements ServiceInt<Address> {
    private AddressDaoImpl addressDao;

    @Autowired
    public AddressServiceImpl(AddressDaoImpl addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Address add(Address address) {
        return addressDao.add(address);
    }

    @Override
    public Address Find(long id) {
        return  addressDao.find(id);
    }

    @Override
    public List<Address> getAll() {
        return addressDao.getAll();
    }

    @Override
    public Address update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public boolean delete(long id) {
        return addressDao.delete(id);
    }
}
