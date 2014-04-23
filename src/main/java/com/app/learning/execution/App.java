package com.app.learning.execution;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.learning.model.Address;
import com.app.learning.model.Person;
import com.app.learning.service.AddressService;
import com.app.learning.service.PersonService;

@Configuration
@ComponentScan("com.app.learning")
@EnableJpaRepositories("com.app.learning.repository")
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}

class AppCommandLineRunner implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	@Autowired
	private AddressService addressService;

	@Override
	public void run(String... arg0) throws Exception {
		showDetails();
	}

	public void populatePerson() {

		Person person = new Person();
		person.setName("Jack");
		Address address1 = new Address();
		address1.setCountry("UK");
		// address1 = addressService.save(address1);
		Address address2 = new Address();
		address2.setCountry("US");
		// address2 = addressService.save(address2);
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		person.setAddresses(addresses);
		personService.save(person);
	}

	public void showDetails() {
		for (Address address : addressService.findAll()) {
			System.out.println(address.getPerson().getName());
		}

	}

	public void delete() {
		Person person = personService.findById(1L);
		// person.getAddresses().clear();
		// personService.save(person);
		personService.delete(person);
	}

}
