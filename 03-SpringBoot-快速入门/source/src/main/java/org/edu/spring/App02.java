package org.edu.spring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App02 {

	public static void main(String[] args) {
		// Create App
		SpringApplication springApplication = new SpringApplication();
		// Create sources
		Set<Object> sources = new HashSet<>();
		sources.add(MyConfig.class);
		springApplication.setSources(sources);
		ConfigurableApplicationContext context = springApplication.run(args);
		// run
		context.getBean(Runnable.class).run();
		context.close();
	}

}
