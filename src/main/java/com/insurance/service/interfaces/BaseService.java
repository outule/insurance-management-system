package com.insurance.service.interfaces;

import java.util.List;

public interface BaseService<T> {
    T create(T entity);
    T findById(String id);
    List<T> findAll();
    void delete(String id);
}
