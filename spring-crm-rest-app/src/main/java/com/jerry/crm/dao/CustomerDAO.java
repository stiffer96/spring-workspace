package com.jerry.crm.dao;

import java.util.List;

import com.jerry.crm.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	
	
}
