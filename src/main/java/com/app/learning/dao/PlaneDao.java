package com.app.learning.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.app.learning.model.Plane;


public class PlaneDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public void save(Plane plane) {
		entityManager.persist(plane);
	}
}
