package com.jerry.hibernate_practice_acitvity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernate_practice_acitvity.Entity.Employee;

public class ReadEmployeeApp {

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
			
		// code to retrieve object with primary key
			//primary key
			int employeeId = 1;
			
			//query to retrieve employees with primary key
			Employee theEmployee = session.get(Employee.class,employeeId);
			
			//printing results
			System.out.println("\n Employee retrieved by primary key : "+ employeeId);
			
			System.out.println(theEmployee);
			
		// code to query objects to find employees for a given company.
			
			List<Employee> theEmployees = 
					session.createQuery("from Employee e where e.company = 'Wipro' ").list();
			
			//printing results
			System.out.println("\n Employee whose company name is Wipro");
			
			displayEmployees(theEmployees);
			
			//commit the changes to db
			session.getTransaction().commit();
			
			//Acknowledgement
			System.out.println("Employees Saved");
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
