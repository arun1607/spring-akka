package com.app.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.learning.model.Plane;
import com.app.learning.repository.PlaneRepository;

@Component
public class PlaneService {

	@Autowired
	private PlaneRepository planeRepository;

	@Transactional
	public void save(Plane plane) {
		planeRepository.save(plane);
	}

}
