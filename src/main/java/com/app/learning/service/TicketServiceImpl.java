package com.app.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.learning.model.Ticket;
import com.app.learning.repository.TicketRepository;

@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	@Transactional
	public Ticket save(Ticket entity) {
		return ticketRepository.save(entity);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(Ticket entity) {
		ticketRepository.delete(entity);
	}

	@Override
	public Ticket findById(Long id) {
		return ticketRepository.findOne(id);
	}

}
