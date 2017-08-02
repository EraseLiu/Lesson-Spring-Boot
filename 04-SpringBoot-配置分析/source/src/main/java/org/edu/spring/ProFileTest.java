package org.edu.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("devpro")
public class ProFileTest {

	@Bean
	public Runnable createRunnable() {
		System.out.println("Dev create runnable");
		return () -> {
		};
	}

}
