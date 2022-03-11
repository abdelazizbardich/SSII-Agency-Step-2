package com.ssiiagency.services;

import com.ssiiagency.DAO.RoleDaoImpl;
import com.ssiiagency.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements ServiceInt<Role> {

    private RoleDaoImpl roleDao;

    @Autowired
    public RoleServiceImpl(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role find(long id) {
        return roleDao.find(id);
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public boolean delete(long id) {
        return roleDao.delete(id);
    }
}
