package com.jerry.hibernate_practice_acitvity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernate_practice_acitvity.Entity.Employee;

public class DeleteEmployeeApp {

	public static void main(String[] args) {
		
		// configure our hibernate app with session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		try {
			// configure session
			Session session  = factory.getCurrentSession();
			
			//start transaction
			session.beginTransaction();
			
			// code to delete an object by primary key.
			int employeeId = 2;
			
			//query 
			Employee theEmployee = session.get(Employee.class , employeeId);
			
			//deleting object
			session.delete(theEmployee);
			
			//commit the changes to db
			session.getTransaction().commit();
			
			//Acknowledgement
			System.out.println("Employee deleted");
		}
		finally {
			factory.close();
		}
		
	}

}
