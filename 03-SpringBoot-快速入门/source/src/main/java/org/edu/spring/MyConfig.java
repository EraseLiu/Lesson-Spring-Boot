package org.edu.spring;

import org.springframework.context.annotation.Bean;

public class MyConfig {

	@Bean
	public Runnable run() {
		return () -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Runing!");
			System.out.println(this.toString());
		};
	}

}
