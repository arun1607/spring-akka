package com.app.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.learning.model.Person;
import com.app.learning.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public void save(Person person) {
		personRepository.save(person);
	}

}
