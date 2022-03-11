package com.ssiiagency.services;

import com.ssiiagency.DAO.AdminDaoImpl;
import com.ssiiagency.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements ServiceInt<Admin> {
    private AdminDaoImpl adminDao;

    @Autowired
    public AdminServiceImpl(AdminDaoImpl adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin add(Admin admin) {
        return adminDao.add(admin);
    }

    @Override
    public Admin find(long id) {
        return adminDao.find(id);
    }

    @Override
    public List<Admin> getAll() {
        return adminDao.getAll();
    }

    @Override
    public Admin update(Admin admin) {
        return adminDao.update(admin);
    }

    @Override
    public boolean delete(long id) {
        return adminDao.delete(id);
    }


    public boolean login(String email, String password) {
        Admin admin = adminDao.findByEmail(email);
        if(admin == null){return false;}
        if(password.equals(admin.getPassword())){
            return true;
        }
        return false;
    }

    public boolean changePassword(String olPassword, String newPassword) {
        return false;
    }
}
