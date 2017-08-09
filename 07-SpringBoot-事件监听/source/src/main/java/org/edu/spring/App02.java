package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App02 {

	private static final Log log = LogFactory.getLog(App02.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App02.class);
		ConfigurableApplicationContext context = app.run(args);
		log.info(": S===================================S :");
		context.stop();
		context.start();
		context.publishEvent(new MyApplicationEvent(new Object()));
		log.info(": E===================================E :");
		context.close();
	}

}
