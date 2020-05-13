package com.spring.basics.springineasysteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.basics.componentscan.ComponentDAO;

@SpringBootApplication
@ComponentScan("com.spring.basics.componentscan") // we have to do it because by default component scan is done only in
													// only in package (and subpackages) which has class annotated with
													// SpringBootApplication, if component is in some other package then
													// we have to specify that package in @ComponentScan annotation.
public class SpringInEasyStepsComponentScanApplication {

	private static Logger _logger = LoggerFactory.getLogger(SpringInEasyStepsComponentScanApplication.class);

	public static void main(String[] args) {

		// Get the bean using Application Context because "Application Context"
		// maintains all the beans.
		ApplicationContext applicationContext = SpringApplication.run(SpringInEasyStepsComponentScanApplication.class,
				args);

		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

		_logger.info("{}", componentDAO);

	}
}
