package com.jerry.crm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public MyDispatcherServletInitializer() {
		
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		//setup configuratio file for dispatcher servlet
		return new Class[] { MyConfigurationFile.class };
	}

	@Override
	protected String[] getServletMappings() {
		
		//setup mapping url
		return new String[] {"/"};
	}

}
