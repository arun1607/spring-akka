package com.app.learning.execution;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.app.learning.config.AppConfig;
import com.app.learning.model.Address;
import com.app.learning.model.Customer;
import com.app.learning.model.Person;
import com.app.learning.model.Ticket;
import com.app.learning.service.AddressService;
import com.app.learning.service.CustomerService;
import com.app.learning.service.PersonService;

@Component
public class App implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);
		App app = ctx.getBean("app", App.class);

		// app.populatePerson();
		// app.delete();
		// app.showDetails();
		// app.populateCustomer();
		// app.showCustomerDetails();
		app.deleteCustomer();

	}

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.applicationContext = ctx;
	}

	public void populatePerson() {
		PersonService personService = applicationContext
				.getBean(PersonService.class);
		AddressService addressService = applicationContext
				.getBean(AddressService.class);
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
		AddressService addressService = applicationContext
				.getBean(AddressService.class);
		for (Address address : addressService.findAll()) {
			System.out.println(address.getPerson().getName());
		}

	}

	public void delete() {
		PersonService personService = applicationContext
				.getBean(PersonService.class);
		Person person = personService.findById(1L);
		// person.getAddresses().clear();
		// personService.save(person);
		personService.delete(person);
	}

	public void populateCustomer() {
		CustomerService customerService = applicationContext
				.getBean(CustomerService.class);
		Customer customer = new Customer();
		customer.setName("Jack");

		Ticket ticket1 = new Ticket();
		ticket1.setSource("UK");
		ticket1.setDestination("AUS");
		ticket1.setCustomer(customer);

		Ticket ticket2 = new Ticket();
		ticket2.setSource("NZ");
		ticket2.setDestination("US");
		ticket2.setCustomer(customer);
		Set<Ticket> tickets = new HashSet<Ticket>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		customer.setTickets(tickets);

		customerService.save(customer);
	}

	public void showCustomerDetails() {
		CustomerService customerService = applicationContext
				.getBean(CustomerService.class);
		Customer customer = customerService.findById(1L);

		for (Ticket ticket : customer.getTickets()) {
			System.out.println(ticket.getSource());
			System.out.println(ticket.getDestination());
		}
	}

	public void deleteCustomer() {
		CustomerService customerService = applicationContext
				.getBean(CustomerService.class);
		Customer customer = customerService.findById(1L);
		customerService.delete(customer);
	}

}
