package com.jerry.springapp;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your day ! Just do it.";
	}

}
