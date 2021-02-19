package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Course;
import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;
import com.jerry.hibernatedemo.entity.Review;
import com.jerry.hibernatedemo.entity.Student;



public class CreateCourseAndStudentDemo {

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
			
			//create course
			Course tempCourse = new Course("How to Solve rubiks Cube");
			
			// create students
			Student student1 = new Student("Pradeep","tomar","pt@gmail.com");
			Student student2 = new Student("Sutosh","prasad","sp@gmail.com");
			
			//add students for same course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			//save student
			session.save(student1);
			session.save(student2);
			
			//save the course which will ultimately save the student too due to cascade type persist
			session.save(tempCourse);
			
			//commit the changes
			session.getTransaction().commit();
			
			//print out acknowledgement
			System.out.println("Course and student saved");
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}
	
}
