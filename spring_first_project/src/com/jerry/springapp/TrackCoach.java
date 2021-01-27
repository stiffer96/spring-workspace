package com.jerry.springapp;

public class TrackCoach implements Coach {

	// create filed for parameter to be used in constructor for DI
	private FortuneService fortuneService;
		
	// create constructor for Dependency injection
	public TrackCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Track Coach : " + fortuneService.getFortune() ;
	}
	
	//Below methods are for lifcycle of bean app
	
	// add init-method 
	public void doMyStartupStuff() {
		System.out.println("\n TrackCoach : inside init method doMyStartupStuff");
	}
	
	//add destroy method
	public void doMyCleanupStuff() {
		System.out.println("\n TrackCoach : inside destroy method doMyCleanupStuff");
	}

}










