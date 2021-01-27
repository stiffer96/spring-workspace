package com.jerry.springapp;


//Class for pratice activity to get random fortunes from RandomFortuneSerivce class and app name PracticeAcitivityApp1
public class BasketballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BasketballCoach() {
		// TODO Auto-generated constructor stub
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Go dribble for 30 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
