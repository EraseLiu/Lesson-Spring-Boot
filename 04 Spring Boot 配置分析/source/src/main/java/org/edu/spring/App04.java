package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class App04 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataSourceConifg.class, args);
		System.out.println();
		// 没有成功, 值为 null 查找资料中...
		context.getBean(DataSourceConifg.class).show();

		System.out.println();
		context.close();
	}

}
