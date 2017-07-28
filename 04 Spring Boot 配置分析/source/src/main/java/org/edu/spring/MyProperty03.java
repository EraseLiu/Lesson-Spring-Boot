package org.edu.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/*
 * By java 1.8
 */
@PropertySource("classpath:property/propertySource01.ini")
@PropertySource(value = "classpath:property/propertySource02.ini", ignoreResourceNotFound = true)
public class MyProperty03 {

	@Value("${PropertySource}")
	private String propertySource;

	public void show() {
		System.out.println("=============================================================");
		System.out.println("this.propertySource: " + this.propertySource);
		System.out.println("=============================================================");
	}

}
