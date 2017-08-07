package org.edu.spring;

public class Dog {

	private String name = "WangCai";

	public Dog() {
		super();
	}

	@Override
	public String toString() {
		return String.format("Dog [name=%s]", name);
	}

}
