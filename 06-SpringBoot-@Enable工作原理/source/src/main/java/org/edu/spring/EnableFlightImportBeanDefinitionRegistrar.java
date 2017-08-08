package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class EnableFlightImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	private static final Log log = LogFactory.getLog(EnableFlightImportBeanDefinitionRegistrar.class);

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		log.info("org.edu.spring.EnableFlightImportBeanDefinitionRegistrar");
	}

}
