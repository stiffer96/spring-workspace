package com.jerry.rest.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jerry.rest.entity.StudentErrorResponse;
import com.jerry.rest.exception.StudentNotFoundException;


/*
 * To define global exception handler we need to use annotation @ControllerAdvice
 * It is a real time use of AOP , this class will run when any exception will raised
 * Also we need to include package of this class  in @ComponentScan in Config class.
 */

@ControllerAdvice
public class StudentExceptionHandler {
	
	//create Exception handler for id greater than the length of student list or less then 0
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatusCode(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		//exception handler if  studentId is not a number
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatusCode(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} 
}
