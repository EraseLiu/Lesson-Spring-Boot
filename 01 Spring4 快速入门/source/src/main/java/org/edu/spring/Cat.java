package org.edu.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(Cat.class + ".afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(Cat.class + ".destroy");
	}

}
