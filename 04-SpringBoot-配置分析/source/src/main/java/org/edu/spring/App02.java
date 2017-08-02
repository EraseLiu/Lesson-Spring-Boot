package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App02 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyProperty03.class, args);
		System.out.println();
		System.out.println(context.getBean(MyProperty03.class));
		context.getBean(MyProperty03.class).show();
		System.out.println();
		context.close();
	}

}
