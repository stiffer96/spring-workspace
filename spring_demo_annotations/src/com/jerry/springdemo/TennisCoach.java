package com.jerry.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

// if you do not set any component name 
// the default one is same as class name with its first letter in lower case
//@Component("tCoach")

@Component
public class TennisCoach implements Coach {
	
	// field injection 
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		
	}
	
	//define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("\n TennisCoach : inside method doMyStartupStuff");
	}
	
	
	//define destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("\n TennisCoach : inside method doMyCleanupStuff");
	}
	
	/*
	//setter injection with autowired injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	/*//constructor injection with autowired annotation
	
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast serve daily 20 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
