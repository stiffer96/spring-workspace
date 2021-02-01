package com.jerry.hibernate_practice_acitvity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernate_practice_acitvity.Entity.Employee;

public class CreateEmployeeApp {

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
			
			// create new employees to save in db
			Employee theEmployees1 = new Employee("Sutosh", "cruise", "Wipro");
			Employee theEmployees2 = new Employee("Jerry", "Pitt", "TCS");
			Employee theEmployees3 = new Employee("Scooby", "Dooby", "Apple");
						
			//save employees in database
			session.save(theEmployees1);
			session.save(theEmployees2);
			session.save(theEmployees3);
			
			//commit the changes to db
			session.getTransaction().commit();
			
			//Acknowledgement
			System.out.println("Employees Saved");
		}
		finally {
			factory.close();
		}
		
	}

}
