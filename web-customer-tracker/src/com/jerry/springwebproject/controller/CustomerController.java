package com.jerry.springwebproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jerry.springwebproject.dao.CustomerDAO;
import com.jerry.springwebproject.dao.CustomerDAOImpl;
import com.jerry.springwebproject.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAOImpl customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customer from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//bind it to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}

}
