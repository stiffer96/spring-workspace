package com.jerry.rest.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	/*
	 * Jackson api will automatically convert POJOs into JSON
	 * and list of students into array of student data into JSON
	 */
	
	private List<Student> theStudents;
	
	//below method is to store students in the array list temp DB
	//below annotation is used to run method once when bean get created
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Sourav","Choudhary"));
		theStudents.add(new Student("Albert","Einstein"));
		theStudents.add(new Student("Nikola","Tesla"));
		theStudents.add(new Student("Elon","Musk"));
	}
	
	//get list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	//get stuent with path variable
	// annotation @PathVariable is used to get param from path and pass it as method arg
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return theStudents.get(studentId);
	}
}