package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;



public class MainAppBidirectional {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			
				
			
			//begin transaction
			session.beginTransaction();
			
			//get instructor through the instructor detail 
			// to check bidirectional one to one mapping
			int theId =2;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			System.out.println("\n Instructor details : " + tempInstructorDetail);
			
			//getting instructor associated with it
			Instructor tempInstructor = tempInstructorDetail.getTheInstructor();
			
			System.out.println("\n Instructor details : " + tempInstructor);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("yaayyy ! we did it bidirectional mapping");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//handle leak issue
			session.close();
			
			factory.close();
		}
		
	}
	
}
