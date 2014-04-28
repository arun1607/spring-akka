package com.app.learning.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.learning.model.Customer;
import com.app.learning.model.Ticket;
import com.app.learning.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public Customer save(Customer entity) {
		return customerRepository.save(entity);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Customer entity) {
		customerRepository.delete(entity);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findOne(id);
	}

	public void populate() {

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

		customerRepository.save(customer);
	}

	public void showDetails() {
		Customer customer = customerRepository.findOne(1L);

		for (Ticket ticket : customer.getTickets()) {
			System.out.println(ticket.getSource());
			System.out.println(ticket.getDestination());
		}
	}

}
