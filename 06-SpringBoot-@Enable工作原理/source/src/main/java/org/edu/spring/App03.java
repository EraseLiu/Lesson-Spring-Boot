package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnablePet(Dog.class)
@SpringBootApplication
public class App03 {

	private static final Log logger = LogFactory.getLog(App03.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App03.class, args);
		logger.info("S ============================================ S");
		logger.info(context.getBean(Dog.class).toString());
		logger.info("E ============================================ E");
		context.close();
	}

}
