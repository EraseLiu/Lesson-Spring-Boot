package org.edu.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("org.edu.spring.MyBeanFactoryPostProcessor.postProcessBeanFactory");
		System.out.println(beanFactory);
		System.out.println("BeanDefinitionCount:" + beanFactory.getBeanDefinitionCount());
	}

}
