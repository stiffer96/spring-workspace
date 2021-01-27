package com.jerry.springapp;

public class RandomFortuneService implements FortuneService {
	
	private String fortunes[] = {"Today is your day" ,"Just do it!" , "Nothing can stop you"};
	
	@Override
	public String getFortune() {
		return fortunes[(int) Math.round(Math.random() * 2)];
	}

}
