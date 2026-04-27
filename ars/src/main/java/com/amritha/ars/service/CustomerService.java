package com.amritha.ars.service;

import com.amritha.ars.entity.Customer;

public interface CustomerService {

	void registerCustomer(Customer customer);
	
	Customer findCustomerById(String username);

}
