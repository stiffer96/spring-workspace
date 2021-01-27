package com.jerry.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.jerry.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService() {
		SadFortuneService sadFortuneService = 
				new SadFortuneService();
		return sadFortuneService;
	}
	
	@Bean
	public Coach swimCoach() {
		SwimCoach swimCoach = 
				new SwimCoach(sadFortuneService());
		return swimCoach;
	}
}
