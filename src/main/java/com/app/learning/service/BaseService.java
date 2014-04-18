package com.app.learning.service;

public interface BaseService<T> {
	T save(T entity);
}
