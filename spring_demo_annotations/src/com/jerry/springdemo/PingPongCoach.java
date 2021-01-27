package com.jerry.springdemo;

public class PingPongCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//Construnctor for CI
	public PingPongCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice back-hand smash for 20 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
