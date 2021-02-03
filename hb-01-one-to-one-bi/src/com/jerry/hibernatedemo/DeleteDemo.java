package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;



public class DeleteDemo {

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
			
			//get the instructor by primary key
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			System.out.println("\n FoundInstructor : "+ tempInstructor);
			
			//delete object
			System.out.println("\n Deleting Instructor : "+ tempInstructor);
			
			if(tempInstructor != null) {
				//note all object associate with it
				//also deleted due to cascade type all selected in one to one relation
				session.delete(tempInstructor);
			}
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Instructor deleted");
		}
		finally {
			factory.close();
		}
		
	}
	
}
