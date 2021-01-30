package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a new student object
			Student tempStudent = new Student("John" , "Doe" , "johndoe@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save student in db
			session.save(tempStudent);
			
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
