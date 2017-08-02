package org.edu.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
class EchoBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Object01 object01;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof SpringContextAware) {
			System.out.print(2);
			System.out.print("	org.edu.spring.EchoBeanPostProcessor.postProcessBeforeInitialization:	");
			System.out.println(beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof SpringContextAware) {
			System.out.print(4);
			System.out.print("	org.edu.spring.EchoBeanPostProcessor.postProcessAfterInitialization:	");
			System.out.println(beanName);

			SpringContextAware sca = (SpringContextAware) bean;
			sca.setContext(applicationContext, object01);
		}
		return bean;
	}

}
