package org.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		System.out.println(context);
		context.close();
	}

}
