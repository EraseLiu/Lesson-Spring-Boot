package org.edu.spring;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		// 可以是文件
		Properties properties = new Properties();
		PropertiesPropertySource source = new PropertiesPropertySource("my", properties);
		environment.getPropertySources().addLast(source);
	}

}
