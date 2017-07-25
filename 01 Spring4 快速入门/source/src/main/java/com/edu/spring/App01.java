package com.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		System.out.println();
		// Get bean
		System.out.println("Get bean");
		// 1
		System.out.println(context.getBean(MyBean.class));
		System.out.println(context.getBean("myBeanByName"));
		// 2
		System.out.println(context.getBean(JeepFactoryBean.class));
		System.out.println(context.getBean(Jeep.class));
		System.out.println(context.getBean("createJeepFactoryBean"));
		System.out.println(context.getBean("&createJeepFactoryBean"));
		// 3
		System.out.println(context.getBean(Car.class));
		System.out.println(context.getBean("createCar"));
		System.out.println();

		// Lifecycle
		System.out.println("Lifecycle");

		// 1 Interface InitializingBean, DisposableBean
		System.out.println(context.getBean(Cat.class));

		// 2 Method init and destroy
		System.out.println(context.getBean(Dog.class));

		// 3 JSR-250
		System.out.println(context.getBean(Animal.class));

		System.out.println();
		context.close();
	}

}
