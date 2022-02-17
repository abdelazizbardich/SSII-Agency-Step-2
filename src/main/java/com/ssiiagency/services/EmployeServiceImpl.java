package com.ssiiagency.services;

import com.ssiiagency.DAO.EmployeDaoImpl;
import com.ssiiagency.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements ServiceInt<Employe> {

    private EmployeDaoImpl employeDao;

    @Autowired
    public EmployeServiceImpl(EmployeDaoImpl employeDao) {
        this.employeDao = employeDao;
    }

    @Override
    public Employe add(Employe employe) {
        return employeDao.add(employe);
    }

    @Override
    public Employe Find(long id) {
        return employeDao.find(id);
    }

    @Override
    public List<Employe> getAll() {
        return employeDao.getAll();
    }

    @Override
    public Employe update(Employe employe) {
        return employeDao.update(employe);
    }

    @Override
    public boolean delete(long id) {
        return employeDao.delete(id);
    }
}
