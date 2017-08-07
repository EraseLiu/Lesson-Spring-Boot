package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import({ Cat.class })
public class App02 {

	private static final Log logger = LogFactory.getLog(App02.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App02.class, args);
		logger.info("S ============================================ S");
		logger.info(context.getBean(Cat.class).toString());
		logger.info("E ============================================ E");
		context.close();
	}

}
