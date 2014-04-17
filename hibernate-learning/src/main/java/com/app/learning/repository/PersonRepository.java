package com.app.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.learning.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
