package com.ssiiagency.DAO;

import java.util.List;

public interface DAOInt<T> {

    T add(T object);
    T find(long id);
    List<T> getAll();
    T update(T object);
    boolean delete(long id);
}
