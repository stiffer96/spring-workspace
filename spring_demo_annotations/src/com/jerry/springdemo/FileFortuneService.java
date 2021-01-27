package com.jerry.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	//define scanner class and file class
	private Scanner reader ;
	private File myFile;
	
	//define array which store fortunes from file
	private List<String> fortunes = new ArrayList<String>();
	
	//define a random number generator
	private Random myRandom = new Random();
	
	@PostConstruct
	private void readFortunes() {
		//open file and read , also add this to list
				myFile = new File("/E:\\spring_workspace\\spring_demo_annotations\\src\\com\\jerry\\springdemo\\data.txt");
				
				try {
					reader = new Scanner(myFile);
					while(reader.hasNextLine()) {
						fortunes.add(reader.nextLine());
						
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	}
	
	@Override
	public String getFortune() {
		
		//get the random index
		int index = myRandom.nextInt(fortunes.size());
		
		return fortunes.get(index);
	}

}
