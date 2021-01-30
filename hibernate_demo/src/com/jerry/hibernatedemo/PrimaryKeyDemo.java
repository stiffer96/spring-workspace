package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a multiple students object to check primary key auto generation
			Student tempStudent = new Student("shubham" , "Choudhary" , "jerryChoudhary@gmail.com");
			Student tempStudent1 = new Student("sutosh" , "walker" , "paulwalker@gmail.com");
			Student tempStudent2 = new Student("harry" , "Smith" , "willsmith@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save students in db
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Student saved");
		}
		finally {
			factory.close();
		}
	}

}
