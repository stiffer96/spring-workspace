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

	public void saveOrUpdateCustomer(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		/*
		 * Below method is to save or update the customer by same method
		 * if id= null or 0 , then it will insert new customer( for this id is set to 0 explicitly
		 * if id != null then it will update the customer
		 */
		session.saveOrUpdate(theCustomer);
		
		
	}

	public String deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer theCustomer = session.get(Customer.class, id);
		
		//if session returns null ,the exception is handled below otherwise delete
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer with id : "+id+" not found !");
		}
		
		session.delete(theCustomer);
		
		return "Customer with id:-  "+id+" is deleted.";
	}

}
