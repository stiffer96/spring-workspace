package com.jerry.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeActivity7App {

	public static void main(String[] args) {
		
		// load java configuration class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(PracticeActivityJavaConfig.class);
		
		//retrieve bean from container
		Coach theCoach = context.getBean("pingPongCoach", Coach.class);
		
		//print out the results
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context
		context.close();

	}

}
