package com.edu.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Animal {

	public Animal() {
		super();
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println(Animal.class + ".postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println(Animal.class + ".preDestroy");
	}

}
