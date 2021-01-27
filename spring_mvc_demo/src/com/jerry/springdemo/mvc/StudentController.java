package com.jerry.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//create method to show form
	@RequestMapping("showForm")
	public String showForm( Model theModel) {
		
		//create a student
		Student theStudent = new Student();
		
		//add student to the model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	//process form method to process the data
	@RequestMapping("processForm")
	public String processStudentForm(@ModelAttribute("student") Student theStudent ) {
		
		//log input data to console
		//System.out.println("Last Name : "+ theStudent.getFirstName());
		
		return "student-confirmation";
	}

}









