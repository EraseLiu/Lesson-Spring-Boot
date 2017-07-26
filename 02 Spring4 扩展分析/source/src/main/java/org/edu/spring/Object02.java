package org.edu.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Object02 implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public String toString() {
		return String.format("Object02 [applicationContext=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				applicationContext, getClass(), hashCode(), super.toString());
	}

}
