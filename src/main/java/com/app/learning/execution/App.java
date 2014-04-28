package com.app.learning.execution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.app.learning.config.AppConfig;
import com.app.learning.model.Customer;
import com.app.learning.model.Person;
import com.app.learning.service.CustomerService;
import com.app.learning.service.PersonService;

@Component
public class App {

	@Autowired
	private PersonService personService;

	@Autowired
	private CustomerService customerService;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);
		App app = ctx.getBean("app", App.class);

		app.populatePerson();
		app.showPersonDetails();
		// app.deletePerson();
		// app.populateCustomer();
		// app.showCustomerDetails();
		// app.deleteCustomer();

	}

	public void showCustomerDetails() {
		customerService.showDetails();

	}

	public void populateCustomer() {
		customerService.populate();

	}

	public void showPersonDetails() {
		personService.showDetails();

	}

	public void populatePerson() {
		personService.populate();

	}

	public void deletePerson() {

		Person person = personService.findById(1L);
		personService.delete(person);
	}

	public void deleteCustomer() {
		Customer customer = customerService.findById(1L);
		customerService.delete(customer);
	}

}
