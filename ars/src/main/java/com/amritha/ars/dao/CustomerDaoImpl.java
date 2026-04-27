package com.amritha.ars.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amritha.ars.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	EntityManager em;

	@Override
	public Customer registerCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer findCustomerById(String username) {
		Query query = em.createQuery("from Customer where username = :username");
		query.setParameter("username", username);
		
		List<Customer> list = query.getResultList();
		
		return list.get(0);
	}
	
	
}
