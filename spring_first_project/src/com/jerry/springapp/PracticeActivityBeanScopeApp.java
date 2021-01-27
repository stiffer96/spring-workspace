package com.jerry.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivityBeanScopeApp {

	public static void main(String[] args) {
		
		//load the context file : applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from context
		BasketballCoach theCoach = context.getBean("basketballCoach", BasketballCoach.class);
		
		BasketballCoach alphaCoach = context.getBean("basketballCoach", BasketballCoach.class);
		
		//check if both objects shared same reference
		boolean results = (theCoach == alphaCoach);
		
		//print out the results
		System.out.println("\n Pointing to same object : "+ results);
		
		System.out.println("\n Location of thecoach object: "+ theCoach);
		
		System.out.println("\n Location of alphaCoach object : "+ alphaCoach);
		
		//close context
		context.close();
	}

}
