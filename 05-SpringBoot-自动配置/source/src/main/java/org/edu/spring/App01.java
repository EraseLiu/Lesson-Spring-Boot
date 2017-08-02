package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App01 {

	public static final Log logger = LogFactory.getLog(App01.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App01.class, args);
		logger.warn(context.getBeansOfType(EncodingConvert.class));
		logger.warn(context.getBeansOfType(Runnable.class));
		context.close();
	}

}
