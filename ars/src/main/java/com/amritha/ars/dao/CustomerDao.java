package com.amritha.ars.dao;

import com.amritha.ars.entity.Customer;

public interface CustomerDao {

	public Customer registerCustomer(Customer customer);

	public Customer findCustomerById(String username);
	
}
