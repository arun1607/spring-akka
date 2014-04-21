package com.app.learning.service;

import java.util.List;

public interface BaseService<T> {
    T save(T entity);

    List<T> findAll();

    void delete(T entity);


    T findById(Long id);
}
