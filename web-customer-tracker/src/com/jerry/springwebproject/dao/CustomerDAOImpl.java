package com.jerry.springwebproject.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.springwebproject.entity.Customer;

@Repository	
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//getting current session
		Session sess = sessionFactory.getCurrentSession();	
		
		//creating query from package org.hibernate.query.Query
		Query<Customer> theQuery = sess.createQuery("from Customer", Customer.class);
		
		//execute the query and get list of customer
		List<Customer> customers = theQuery.getResultList();
	
		//return result
		return customers;
	}

}
