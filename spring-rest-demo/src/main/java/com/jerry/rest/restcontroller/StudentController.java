package com.jerry.rest.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.rest.entity.Student;
import com.jerry.rest.entity.StudentErrorResponse;
import com.jerry.rest.exception.StudentNotFoundException;

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
		
		if(studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student with id - "+studentId+" not found!");
		}
		
		return theStudents.get(studentId);
	}
	
	/*
	 * Exception handlers moved to global exception handler defined by annotation
	 * @Controller advice , class name is StudentExceptionHandler.java
	 */
	
}
