package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App01 {

	private static final Log log = LogFactory.getLog(App01.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App01.class);
		app.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context = app.run(args);
		log.info(": S===================================S :");
		context.publishEvent(new MyApplicationEvent(new Object()));
		log.info(": E===================================E :");
		context.close();
	}

}
