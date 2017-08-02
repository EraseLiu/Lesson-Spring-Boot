package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@Conditional({ UTF8Condition.class })
@SpringBootConfiguration
public class EncodingConvertConfiguration {

	private static final Log logger = LogFactory.getLog(EncodingConvertConfiguration.class);

	@Bean
	@Conditional(GBKCondition.class)
	public GBKEncodingConvert createGBKEncodingConvert() {
		logger.info("Bean createGBKEncodingConvert");
		return new GBKEncodingConvert();
	}

	@Bean
	@Conditional(UTF8Condition.class)
	public UTF8EncodingConvert createUTF8EncodingConvert() {
		logger.info("Bean createUTF8EncodingConvert");
		return new UTF8EncodingConvert();
	}

	@Bean
	@ConditionalOnClass(value = { String.class }, name = { "java.lang.String" })
	@ConditionalOnProperty(name = "runnable.enadled", havingValue = "true")
	@ConditionalOnBean(name = "createUTF8EncodingConvert")
	@ConditionalOnMissingClass(value = "com.google.common.collect.Maps")
	public Runnable createRunnable() {
		logger.info("Run runnable Bean createRunnable");
		return () -> logger.info("Run runnable");
	}

}
