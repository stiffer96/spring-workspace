package com.jerry.springapp;

public class VolleyCoach implements Coach {
	
	// create filed for parameter to be used in constructor for DI
	private FortuneService fortuneService;
	
	// create constructor for dependency injection
	public VolleyCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do stretching and tapping practice";
	}

	@Override
	public String getDailyFortune() {
		return "Volleyball Coach : " + fortuneService.getFortune();
	}

}
