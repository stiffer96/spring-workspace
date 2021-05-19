package com.jerry.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.crm.entity.Customer;
import com.jerry.crm.exception.CustomerNotFoundException;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Customer");
		
		List<Customer> theCustomers = theQuery.getResultList();
		
		return theCustomers;
	}

	public Customer getCustomer(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, id);
		
		System.out.println(">> Customer "+theCustomer);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Student with id - "+id+" not found");
		}
		
		return theCustomer;
	}

}
