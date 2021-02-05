package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;



public class DeleteCourseDemo {

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
			

			// get the course from database
			int theId = 10;
			
			Course tempCourse = session.get(Course.class, theId);
			
			// delete the course
			System.out.println("\n Deleting course : "+ tempCourse);
			
			session.delete(tempCourse);
			
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
