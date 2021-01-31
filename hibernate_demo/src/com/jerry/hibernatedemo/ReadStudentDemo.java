package com.jerry.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//Query students
			List<Student> theStudents = session
										.createQuery("from Student")
										.list();
			
			//list students
			System.out.println("\n\n Below is the list of total students");
			
			displayStudents(theStudents);
			
			//Query students whose last name is doe
			 theStudents = session.createQuery("from Student s where s.lastName='Doe' ").list();
			
			//printing student whose last name is doe
			System.out.println("\n\n Below are the list of students whose last name is doe ");
			
			displayStudents(theStudents);
			
			//query student whose last name is doe and first name is shubham
			theStudents = session
					.createQuery("from Student s where s.lastName='Doe' or s.firstName='shubham' ").list();
			
			System.out.println("\n\n Below are the list of students whose last name is doe and firstname is shubham ");
						
			displayStudents(theStudents);
			
			// query students whose email ends with gmail.com	
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com' ").list();
			
			System.out.println("\n\n Below are the students whose email ends with gmail.com.");
			
			displayStudents(theStudents);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
