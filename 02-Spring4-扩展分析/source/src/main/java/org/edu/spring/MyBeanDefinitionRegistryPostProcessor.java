package org.edu.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("org.edu.spring.MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
		System.out.println(beanFactory);
		System.out.println("BeanDefinitionCount:" + beanFactory.getBeanDefinitionCount());
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("org.edu.spring.MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
		System.out.println(registry);
		System.out.println("BeanDefinitionCount:" + registry.getBeanDefinitionCount());

		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Cat.class);
		beanDefinitionBuilder.addPropertyValue("name", "Tiger");
		registry.registerBeanDefinition("cat", beanDefinitionBuilder.getBeanDefinition());
	}

}
