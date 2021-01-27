package com.jerry.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean 
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are pointing to same bean
		boolean result = (theCoach == alphaCoach);
		
		//print the results
		System.out.println("\n Pointing to the same object: "+ result);
		
		System.out.println("\n Memory location of theCoach: "+ theCoach);
		
		System.out.println("\n Memory location of alphaCoach: "+ alphaCoach);
		//close context
		
	}

}
