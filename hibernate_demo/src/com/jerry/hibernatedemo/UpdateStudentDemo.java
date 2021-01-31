package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		try {
			
			//create session
			Session session = factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			// id of the object
			int id = 1;
			
			Student theStudent = session.get(Student.class, id);
			
			//update the field of student of specific id
			System.out.println("\n Updating first name of the student whose id is : "+ id);
			theStudent.setFirstName("Scooby");
			
			//commit the changes
			session.getTransaction().commit();
			
			//create a  session for update query
			session = factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//update email for all students
			System.out.println("updating emails for all student");
			
			session.createQuery("update Student s set s.email='foo@gmail.com'")
					.executeUpdate();
			
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Updated");
		}
		finally {
			factory.close();
		}
	}

}
