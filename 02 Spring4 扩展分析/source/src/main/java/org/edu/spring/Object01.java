package org.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Object01 {

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public String toString() {
		return String.format("Object01 [applicationContext=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				applicationContext, getClass(), hashCode(), super.toString());
	}

}
