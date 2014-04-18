package com.app.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.learning.model.Person;
import com.app.learning.repository.PersonRepository;

@Service
public class PersonService implements BaseService<Person> {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}

}
