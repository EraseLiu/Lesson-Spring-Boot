package org.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.edu.spring");
		System.out.println();

		// Get ApplicationContext
		System.out.println("Get ApplicationContext");
		// @Autowired
		System.out.println(context.getBean(Object01.class));
		// implements ApplicationContextAware
		// Analysis -> App02.java
		System.out.println(context.getBean(Object02.class));
		// Spring 4.3
		// public Object03(ApplicationContext applicationContext) or
		// public Object03(Bean... bean)
		System.out.println(context.getBean(Object03.class));

		System.out.println();
		context.close();
	}

}
