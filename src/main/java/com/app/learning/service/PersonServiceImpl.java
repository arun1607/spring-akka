package com.app.learning.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.learning.model.Address;
import com.app.learning.model.Person;
import com.app.learning.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void showDetails() {
		Person person = personRepository.findOne(1L);
		for (Address address : person.getAddresses()) {
			System.out.println(address.getCountry());
		}

	}

	@Override
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Person person) {
		personRepository.delete(person);
	}

	@Override
	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public void populate() {
		Person person = new Person();
		person.setName("Jack");
		Address address1 = new Address();
		address1.setCountry("UK");
		Address address2 = new Address();
		address2.setCountry("US");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		person.setAddresses(addresses);
		personRepository.save(person);
	}
}
