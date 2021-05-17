package com.jerry.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.jerry.rest.restcontroller","com.jerry.rest.exception_handler"})
public class DemoConfig {

}