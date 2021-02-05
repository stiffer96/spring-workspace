package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;



public class CreateCoursesDemo {

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
			
			//create Course
			Course tempCourse1 = new Course("Spring Framework");
			Course tempCourse2 = new Course("Cyber Security");
			
			// add courses to instructor
			theInstructor.add(tempCourse1);
			theInstructor.add(tempCourse2);
			
			//save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
