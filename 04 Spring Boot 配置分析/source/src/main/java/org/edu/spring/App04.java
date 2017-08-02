package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App04 {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App04.class);
		// --spring.profiles.active=test or
		app.setAdditionalProfiles("devpro");
		ConfigurableApplicationContext context = app.run(args);
		System.out.println();

		context.getBean(DataSourceConifg.class).show();
		System.out.println(context.getEnvironment().getProperty("user.name"));
		System.out.println(context.getEnvironment().getProperty("user.age"));

		System.out.println(context.getEnvironment().getProperty("db.url"));

		System.out.println(context.getBean(Runnable.class));

		System.out.println();
		context.close();
	}

}
