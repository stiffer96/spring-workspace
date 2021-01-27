package com.jerry.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeActivityJavaConfig {
	
	@Bean
	public FortuneService crazyFortuneService() {
		CrazyFortuneService crazyFortuneService =
				new CrazyFortuneService();
		return crazyFortuneService;
	}
	
	@Bean
	public Coach pingPongCoach() {
		PingPongCoach ppCoach = 
				new PingPongCoach(crazyFortuneService());
		return ppCoach;
	}

}
