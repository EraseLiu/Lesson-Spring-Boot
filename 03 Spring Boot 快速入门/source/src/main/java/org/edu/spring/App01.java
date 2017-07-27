package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class App01 {

	@Bean
	public Runnable run() {
		return () -> System.out.println("Hello Spring Boot ~~~");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App01.class, args);
		context.getBean(Runnable.class).run();
		context.close();
	}

}
