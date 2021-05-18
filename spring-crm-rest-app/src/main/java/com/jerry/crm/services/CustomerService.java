package com.jerry.crm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.crm.dao.CustomerDaoImpl;
import com.jerry.crm.entity.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDaoImpl customerDao;
	
	@Transactional
	public List<Customer> getCustomers(){
		return customerDao.getCustomers();
	}
}
