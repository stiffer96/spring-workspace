package com.jerry.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivityApp {

	public static void main(String[] args) {
		
		//read the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean
		Coach theCoach = context.getBean("volleyCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
