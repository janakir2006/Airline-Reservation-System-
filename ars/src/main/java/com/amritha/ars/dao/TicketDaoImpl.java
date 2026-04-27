package com.amritha.ars.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amritha.ars.entity.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class TicketDaoImpl implements TicketDao {

	@Autowired
	EntityManager em;

	@Override
	public Ticket createTicket(Ticket ticket) {
		em.persist(ticket);
		
		return ticket;
	}	
}
