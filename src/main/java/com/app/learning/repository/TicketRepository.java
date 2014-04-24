package com.app.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.learning.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
