package com.insurance.repository.interfaces;

import java.util.List;

public interface BaseRepository<T> {
    T save(T entity);
    T findById(String id);
    List<T> findAll();
    void delete(String id);
}
