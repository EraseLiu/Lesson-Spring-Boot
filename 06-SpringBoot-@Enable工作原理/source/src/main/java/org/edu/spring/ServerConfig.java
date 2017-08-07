package org.edu.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

	private String port;

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return String.format("ServerConfig [port=%s]", port);
	}

}
