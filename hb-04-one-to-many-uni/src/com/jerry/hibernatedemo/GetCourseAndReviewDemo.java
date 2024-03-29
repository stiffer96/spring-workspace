package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;
import com.jerry.hibernatedemo.entity.Review;



public class GetCourseAndReviewDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try {
			
				
			
			//begin transaction
			session.beginTransaction();
			
			//get  course with id
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
					
			//print our results 
			System.out.println("Course is : "+tempCourse);
			System.out.println("Reviews : " + tempCourse.getReviews());
	
						
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Course and reviews saved");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}
	
}
