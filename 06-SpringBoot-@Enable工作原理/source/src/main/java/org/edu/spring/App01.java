package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@EnableConfigurationProperties
@EnableAsync
// @SpringBootApplication
public class App01 {

	private static final Log logger = LogFactory.getLog(App01.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App01.class, args);
		logger.info("S ============================================ S");
		logger.info(context.getBean(ServerConfig.class).toString());
		context.getBean(Runnable.class).run();
		logger.info("E ============================================ E");
		context.close();
	}

}
