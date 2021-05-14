package com.jerry.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		//jackson data binding objec mapper used to 
		//convert json into POJO or vice versa
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			//getting student data from file in folder Data
			//reading from JSON file or MAP it to POJO using Jackson ObjectMapper
			Student theStudent = mapper.readValue(new File("Data/sample-lite.json"),Student.class);
			
			Address theAddress = theStudent.getAddress();
			
			System.out.println("First Name: "+ theStudent.getFirstName());
			System.out.println("Last Name: "+ theStudent.getLastName());
			
			System.out.println("City : "+ theAddress.getCity());
			System.out.println("Landmark: "+ theAddress.getLandmark());
			System.out.println("Zip Code: "+ theAddress.getZipCode());
			
			
			//to show languages
			for(String language : theStudent.getLanguages()) {
				System.out.println(language);
			}
			
			//converting POJO into JSON
			mapper.writeValue(new File("Data/json-output-from-POJO.json"), theStudent);
			System.out.println("JSON Created");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}

	}

}
