package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;

/* Here in eager vs lazy demo , eager means all dependent data at a time
 * Lazy means load dependencies only on  demand.
 * check courses field in Instructor.java ,i have set fetch type 
 * */



public class EagerLazyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try {
						
			
			//begin transaction
			session.beginTransaction();
			
			// get instructor from database
			int theId = 1;
			Instructor theInstructor =
					session.get(Instructor.class, theId);
			
			//printing results
			System.out.println("The instructor : "+ theInstructor);
			
			System.out.println("\n Courses of instructor " + theInstructor.getCourses());
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Instructor saved");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}
	
}
