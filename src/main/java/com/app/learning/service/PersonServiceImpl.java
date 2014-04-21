package com.app.learning.service;

import com.app.learning.model.Person;
import com.app.learning.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

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
}
