package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App04 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App04.class, args);
		System.out.println();

		context.getBean(DataSourceConifg.class).show();

		System.out.println();
		context.close();
	}

}
