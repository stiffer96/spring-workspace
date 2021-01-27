package com.jerry.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivityApp1 {

	public static void main(String[] args) {
		
		//load the context file : applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from context
		BasketballCoach theCoach = context.getBean("basketballCoach", BasketballCoach.class);
		
		//call fortune method to get random bean and also daily workout method
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();
	}

}
