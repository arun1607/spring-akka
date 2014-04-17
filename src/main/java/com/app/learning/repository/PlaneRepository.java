package com.app.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.learning.model.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long>{

}
