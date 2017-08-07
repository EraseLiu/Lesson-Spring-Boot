package org.edu.spring;

public class Cat {

	private String name = "Tiger";

	public Cat() {
		super();
	}

	@Override
	public String toString() {
		return String.format("Cat [name=%s]", name);
	}

}
