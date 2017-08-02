package org.edu.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:property/propertySource01.ini")
public class MyProperty02 {

	@Value("${PropertySource}")
	private String propertySource;

	public void show() {
		System.out.println("==================================================================================");
		System.out.println("this.propertySource: " + this.propertySource);
		System.out.println("==================================================================================");
	}

}
