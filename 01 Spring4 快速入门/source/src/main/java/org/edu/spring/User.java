package org.edu.spring;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

	/*
	 * Spring
	 */
	@Autowired
	private Dog dog;

	/*
	 * JSR-250
	 */
	@Resource
	private Jeep jeep;

	/*
	 * JSR-330 'javax.inject.Inject' annotation found and supported for
	 * autowiring
	 */
	@Inject
	private Cat cat;

	public String toStrings() {
		return String.format("User [dog=%s, jeep=%s, cat=%s, getClass()=%s, hashCode()=%s, toString()=%s]", dog, jeep,
				cat, getClass(), hashCode(), super.toString());
	}

}
