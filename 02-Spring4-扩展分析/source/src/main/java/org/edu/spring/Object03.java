package org.edu.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Object03 {

	private ApplicationContext applicationContext;

	public Object03(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public String toString() {
		return String.format("Object03 [applicationContext=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				applicationContext, getClass(), hashCode(), super.toString());
	}

}
