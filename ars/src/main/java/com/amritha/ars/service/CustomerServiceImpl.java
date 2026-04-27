package com.amritha.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amritha.ars.dao.CustomerDao;
import com.amritha.ars.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void registerCustomer(Customer customer) {
		customerDao.registerCustomer(customer);
	}

	@Override
	public Customer findCustomerById(String username) {
		return customerDao.findCustomerById(username);
	}
	
}
