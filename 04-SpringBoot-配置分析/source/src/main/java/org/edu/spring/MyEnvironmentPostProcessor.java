package org.edu.spring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	private static final Log logger = LogFactory.getLog(MyEnvironmentPostProcessor.class);

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		// 可以是文件
		Properties properties = new Properties();
		try (InputStream input = new FileInputStream("target/classes/db.properties")) {
			properties.load(input);
		} catch (IOException e) {
			logger.error(e);
		}
		PropertiesPropertySource source = new PropertiesPropertySource("my", properties);
		environment.getPropertySources().addLast(source);
	}

}
