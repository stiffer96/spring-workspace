package com.jerry.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//this class is for practice activity # 4 in Annotation section 7

@Component
public class VolleyCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice upper hand serve for 20 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
