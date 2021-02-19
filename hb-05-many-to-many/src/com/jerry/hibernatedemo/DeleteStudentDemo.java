package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;
import com.jerry.hibernatedemo.entity.Review;
import com.jerry.hibernatedemo.entity.Student;



public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try {
			
				
			
			//begin transaction
			session.beginTransaction();
			
			//get student from session
			int theId =1;
			
			Student student = session.get(Student.class, theId);
			
			//Deleting student
			System.out.println("\n Deleting student : "+ student);
			
			
			session.delete(student);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Deleted  ");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}
	
}
