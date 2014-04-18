package com.app.learning.execution;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.learning.config.AppConfig;
import com.app.learning.model.Address;
import com.app.learning.model.Person;
import com.app.learning.service.AddressService;
import com.app.learning.service.PersonService;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);

		PersonService personService = (PersonService) ctx
				.getBean("personService");
		AddressService addressService = (AddressService) ctx
				.getBean("addressService");
		Person person = new Person();
		person.setName("Jack");
		Address address1 = new Address();
		address1.setCountry("UK");
		address1 = addressService.save(address1);
		Address address2 = new Address();
		address2.setCountry("US");
		address2 = addressService.save(address2);
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		person.setAddresses(addresses);
		person = personService.save(person);

	}
}
