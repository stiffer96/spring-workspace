package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Student;

public class DeleteStudentDemo {

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
			
	/*		// id of the object
			int studentId = 1;
			
			Student theStudent = session.get(Student.class, studentId);
			
			//Deleting the student using specific id
			System.out.println("\n Deleting the student whose id is : "+ studentId);
			
			//Deleting the student
			session.delete(theStudent);
	*/
			//Deleting the student using specific id
			System.out.println("\n Deleting the student");
			
			session.createQuery("delete from Student where id=2 ").executeUpdate();
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Deleted");
		}
		finally {
			factory.close();
		}
	}

}
