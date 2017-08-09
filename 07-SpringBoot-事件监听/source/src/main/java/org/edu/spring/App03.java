package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App03 {

	private static final Log log = LogFactory.getLog(App03.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App03.class, args);
		log.info(": S===================================S :");
		// By application.properties
		context.publishEvent(new MyApplicationEvent("Hello event"));
		log.info(": E===================================E :");
		context.close();
	}

}
