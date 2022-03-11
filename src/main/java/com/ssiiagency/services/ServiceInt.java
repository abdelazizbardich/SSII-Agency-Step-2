package com.ssiiagency.services;

import java.util.List;

public interface ServiceInt<T> {

    T add(T role);
    T find(long id);
    List<T> getAll();
    T update(T role);
    boolean delete(long id);
}
