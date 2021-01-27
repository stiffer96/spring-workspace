package com.jerry.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add initbinder method ..
	//to remove trailing and leading white space
	//resolve validating issue
	
	@InitBinder
	public void initBinder(WebDataBinder theWebDataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		theWebDataBinder.registerCustomEditor(String.class , stringTrimmerEditor);
		
	}
	
	//create controller method to show customer form
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute(theCustomer);
		
		return "customer-form";
	}
	
	//create controller method to process the customer form
	
	@RequestMapping("/processForm")
	public String proceessForm(@Valid @ModelAttribute("customer") Customer theCustomer , 
			BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) 
			return "customer-form";
		else
			return "customer-confirmation";
	}

}
