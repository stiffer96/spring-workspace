package com.jerry.crm.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc   // this is for rest controllers
@EnableTransactionManagement
@ComponentScan(basePackages="com.jerry.crm")
@PropertySource({"classpath:persistence-database.properties"})
public class MyConfigurationFile {
	
	@Autowired
	private Environment env; //environment hold fields value from properties file
	
	private Logger logger = Logger.getLogger(getClass().getName()); //for logging on console
	
	@Bean
	public DataSource myDataSource() {
		
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		
		//setting driver for jdbc connection
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		//check if properties file is working or not loggin db user and password
		logger.info(" >>> MySql url: "+env.getProperty("jdbc.url"));
		logger.info(" >>> MySql user: "+env.getProperty("jdbc.user"));
		
		//setting jdbc url,password and user
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		
		return myDataSource;
	}
	
	//helper method to converty properties into Integer
	private int getIntProperty(String prop) {
		String p = env.getProperty(prop);
		int x = Integer.parseInt(p);
		
		return x;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		//create session factory bean
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		//set data source
		sessionFactory.setDataSource(myDataSource());
		
		//set hibernate properties dialect and all
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		//set package to scan
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		
		return sessionFactory;
		
		
	}
	
	//helper method to get hibernate properties from properties file
	private Properties getHibernateProperties() {
		
		Properties props = new Properties();
		
		//set hibernate properties
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		//setup transaction manager based on the session factory
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory); 
		
		return transactionManager;
	}
	
}
