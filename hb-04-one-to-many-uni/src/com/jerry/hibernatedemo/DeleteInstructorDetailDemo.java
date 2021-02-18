package com.jerry.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jerry.hibernatedemo.entity.Instructor;
import com.jerry.hibernatedemo.entity.InstructorDetail;



public class DeleteInstructorDetailDemo {

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
			int theId =3;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			System.out.println("\n Instructor details : " + tempInstructorDetail);
			
			//getting instructor associated with it
			Instructor tempInstructor = tempInstructorDetail.getTheInstructor();
			
			System.out.println("\n Instructor details : " + tempInstructor);
			
			//Deleting only tempInstructordetail without its associated object
			//remove bidirection link between instructor and instructor detail
			
			tempInstructorDetail.getTheInstructor().setInstructorDetail(null);
			
			if(tempInstructorDetail != null) {
				//now it will delte only the tempInstructor detail as we removed the link between them above
				session.delete(tempInstructorDetail);
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
