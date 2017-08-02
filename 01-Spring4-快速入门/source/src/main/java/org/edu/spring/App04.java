package org.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App04 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationScan.class);
		System.out.println();
		try {
			// Filters
			System.out.println(context.getBean(UserController.class));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println();
			context.close();
		}
	}

}
