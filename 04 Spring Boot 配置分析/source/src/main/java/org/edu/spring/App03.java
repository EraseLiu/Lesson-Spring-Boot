package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App03 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyProperty02.class, args);
		System.out.println();
		System.out.println(context.getBean(MyProperty02.class));
		context.getBean(MyProperty02.class).show();
		System.out.println();
		context.close();
	}

}
