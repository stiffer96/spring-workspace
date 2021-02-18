package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;
import com.jerry.hibernatedemo.entity.Review;



public class CreateCourseAndReviewDemo {

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
			
			//create course
			Course tempCourse = new Course("Data Structure");
			
			//add some reviews
			tempCourse.addReview(new Review("This course is cool"));
			tempCourse.addReview(new Review("Its very nice"));
			
			//print some things 
			System.out.println("Course is : "+tempCourse);
			System.out.println("Reviews : " + tempCourse.getReviews());
			System.out.println("Saving the course and reviews");
			
			//save the course which will ultimately save the reviews too due to cascade tyoe
			session.save(tempCourse);
			
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
