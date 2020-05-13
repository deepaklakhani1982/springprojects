package com.spring.basics.springineasysteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.basics.springineasysteps.scope.PersonDAO;

@SpringBootApplication
public class SpringInEasyStepsScopeApplication {
	
	private static Logger _logger = LoggerFactory.getLogger(SpringInEasyStepsScopeApplication.class);

	public static void main(String[] args) {

		// Get the bean using Application Context because "Application Context"
		// maintains all the beans.
		ApplicationContext applicationContext = SpringApplication.run(SpringInEasyStepsScopeApplication.class, args);

		/*
		 * Bean Scope 
		 * singleton - one bean per spring context 
		 * prototype - new bean whenever requested 
		 * request - new bean per HTTP request 
		 * session - one bean per user session
		 * 
		 * Difference between Spring Singleton and GOF Singleton -
		 * In Spring Singleton - one object gets created per Application Context.
		 * In GOF Singleton - one object gets created per JVM.
		 */
		
		PersonDAO personDao1 = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
		
		_logger.info("{}", personDao1);
		_logger.info("{}", personDao2);

	}
}
