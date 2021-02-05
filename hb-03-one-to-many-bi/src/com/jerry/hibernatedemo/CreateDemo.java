package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;



public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		try {
			
			//create session
			Session session = factory.getCurrentSession();
			
			
			//begin transaction
			session.beginTransaction();
			
			Instructor theInstructor =
					new Instructor("Sutosh", "prasad","sutosh@innovativeprogrammers.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://youtube.com/sutossh","coding");
			
			//associate the objects
			theInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//save the object
			//
			//note this will also save the object associated with it
			//due to cascade type all
			session.save(theInstructor);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Instructor saved");
		}
		finally {
			factory.close();
		}
		
	}
	
}
