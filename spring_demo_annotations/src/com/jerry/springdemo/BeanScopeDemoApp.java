package com.jerry.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		//load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if pointing to same object
		boolean result = ( theCoach == alphaCoach );
		
		//print out  the results
		System.out.println("\n Pointing to same object : "+ result);
		
		System.out.println("\n Location of theCoach : "+ theCoach);
		
		System.out.println("\n Location of alphaCoach : "+ alphaCoach);
		
		//close context
		context.close();
	}

}
