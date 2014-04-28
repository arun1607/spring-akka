package com.app.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.learning.model.Person;
import com.app.learning.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/person/all")
	public List<Person> getAllPerson() {
		return personService.findAll();
	}

}
