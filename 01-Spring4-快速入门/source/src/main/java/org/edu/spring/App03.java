package org.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.edu.spring");
		System.out.println();
		System.out.println(context.getBean(UserController.class).toString());
		System.out.println(context.getBean(UserService.class).toString());
		System.out.println(context.getBean(UserDoc.class).toString());

		// @Primary(createUser) AliasRegistry = [ createUser, user ]
		System.out.println(context.getBean(User.class).toStrings());
		// By name 根据优先装载的顺序
		System.out.println(context.getBean("createUser", "user"));
		System.out.println(context.getBean("user", "createUser"));
		System.out.println();
		context.close();
	}

}
