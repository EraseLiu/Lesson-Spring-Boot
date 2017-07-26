package org.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				MyBeanDefinitionRegistryPostProcessor.class);
		System.out.println();

		// Get Cat
		System.out.println(context.getBean(Cat.class));

		System.out.println();
		context.close();
	}

}
