package com.jerry.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create a array of strings
	private String data[] = {
		"Just do it",
		"Nothing is impossible",
		"Every day is a new opportunity"
	};
	
	//create a random generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from data
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune;
	}

}
