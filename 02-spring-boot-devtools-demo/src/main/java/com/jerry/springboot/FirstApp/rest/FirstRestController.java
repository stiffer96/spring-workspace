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
	
	/*
	 * Devtools is basically used for automatically sync the modification in the app
	 * So there is no need to restart application everytime.
	 */
	@GetMapping("/devtools")
	public String getMessage() {
		return "Devtools demo, now app is running without restarting app after modification";
	}

}
