package com.insurance.service.interfaces;

import java.util.List;

/*
 * Generic repository interface for CRUD operations.
 */
public interface BaseService<T> {
    T create(T entity);
    T findById(String id);
    List<T> findAll();
    void delete(String id);
}
