package org.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				UseBean.class, Object01.class, EchoBeanPostProcessor.class);

		// By Line103
		// org.springframework.context.support.ApplicationContextAwareProcessor.invokeAwareInterfaces
		System.out.println(context.getBean("useBean"));

		context.close();
	}

}
