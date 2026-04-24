package com.insurance.repository.interfaces;

import java.util.List;

/*
    * Generic repository interface for CRUD operations.
 */
public interface BaseRepository<T> {
    T save(T entity);
    T findById(String id);
    List<T> findAll();
    void delete(String id);
}
