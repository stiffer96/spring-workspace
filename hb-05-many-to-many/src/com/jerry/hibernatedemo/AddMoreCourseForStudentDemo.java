package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;
import com.jerry.hibernatedemo.entity.Review;
import com.jerry.hibernatedemo.entity.Student;



public class AddMoreCourseForStudentDemo {

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
			
			System.out.println("\n Adding course to student: "+ student);
			
			//create courses
			Course tempCourse1 = new Course("Java");
			Course tempCourse2 = new Course("Angular 8");
			
			//save above course
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// add above courses to student
			student.addCourse(tempCourse1);
			student.addCourse(tempCourse2);
			
			//save the course which will ultimately save the student too due to cascade type persist
			session.save(student);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Course added for the student ");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}
	
}
