package com.jerry.springboot.FirstApp.rest;

import java.time.LocalDateTime;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
	@GetMapping("/")
	public String test() {
		return "Hello World ! Time on server is "+ LocalDateTime.now();
	}

}
