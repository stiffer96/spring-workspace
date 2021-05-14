package com.jerry.springwebproject.dao;

import java.util.List;
import com.jerry.springwebproject.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
}
