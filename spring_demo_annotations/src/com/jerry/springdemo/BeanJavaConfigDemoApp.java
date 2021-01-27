package com.jerry.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read the spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//retrieve the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call methods on the bean email and team are injected from properties file
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
