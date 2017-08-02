package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App01 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyProperty01.class, args);
		System.out.println();
		System.out.println(context.getBean(MyProperty01.class));
		context.getBean(MyProperty01.class).show();
		System.out.println();
		context.close();
	}

}
