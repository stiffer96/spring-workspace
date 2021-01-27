package com.jerry.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retrieve bean 
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//call bean method
		System.out.println(theCoach.getDailyWorkout());
		
		//close context
		context.close();
	}

}
