package com.jerry.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.jerry.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1 , message="is required")
	private String lastName;
	
	// integer type is set to required only when using wrapper class Integer in place of integer
	
	@NotNull(message="is required")
	@Min(value=0 , message="must be equal to or greater than zero")
	@Max(value=10 , message ="must be less than or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-z0-9]{6}" , message="only 6 chars/digits")
	private String postalCode;
	
	@CourseCode(value="COU" , message="must starts with COU")
	private String courseCode;

	//no arg constructor
	public Customer() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
