package com.edu.spring;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02 {

	public static void main(String[] args) {
		// By package
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.edu.spring");
		System.out.println();

		// Get bean
		System.out.println("Get bean");
		// @Component
		System.out.println(context.getBean(User.class));
		System.out.println(context.getBean("user"));
		// @Service
		System.out.println(context.getBean(UserService.class));
		System.out.println(context.getBean("userService"));
		// @Controller
		System.out.println(context.getBean(UserController.class));
		System.out.println(context.getBean("userController"));
		// @Repository
		System.out.println(context.getBean(UserDoc.class));
		System.out.println(context.getBean("userDoc"));

		// Get bean of type
		System.out.println();
		System.out.println("Get bean of type");
		Map<String, User> map = context.getBeansOfType(User.class);
		if (!map.isEmpty())
			for (Entry<String, User> entry : map.entrySet()) {
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
			}

		System.out.println();
		context.close();
	}

}
