package com.jerry.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("controller")
public class HelloWorldController {
	
	//need a controller method to redirect to initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//create a controller method to read form data
	// add data to spring model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request , Model model) {
		
		//read data from the the request
		String theName = request.getParameter("studentName");
		
		//convert name to upper case
		theName = theName.toUpperCase();
		
		//create message
		String msg = "Yo! "+ theName;
		
		//add data to attribute
		model.addAttribute("message" , msg);
		
		return "helloworld";
	}
	
	//reading form data with @RequestParam annotation instead of HttpServletRequest
	
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(
			@RequestParam("studentName") String theName , 
			Model model) {
		
		//convert name to upper case
		theName = theName.toUpperCase();
		
		//create message
		String msg = "You did it Yo! "+ theName;
		
		//add data to attribute
		model.addAttribute("message" , msg);
		
		return "helloworld";
	}
	
}
