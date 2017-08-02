package org.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyProperty01 {

	@Value("${local.ipv4}")
	private String localIP;

	@Value("${server.timeout:20000}")
	private Long serverTimeout;

	@Value("${local.server}")
	private String localServer;

	@Autowired
	private Environment environment;

	public void show() {
		System.out.println("==================================================================================");
		System.out.println("local.ipv4: " + environment.getProperty("local.ipv4"));
		System.out.println("local.conncount: " + environment.getProperty("local.conncount", Long.class));
		System.out.println("server.ipv4: " + environment.getProperty("server.ipv4", "192.168.1.10"));
		System.out.println("server.timeout: " + environment.getProperty("server.timeout", Long.class, 20000l));
		System.out.println("this.localIP: " + this.localIP);
		System.out.println("this.serverTimeout: " + this.serverTimeout);
		System.out.println("this.localServer: " + this.localServer);
		System.out.println("==================================================================================");
	}

	@Override
	public String toString() {
		return "MyProperty01 [localIP=" + localIP + ", environment=" + environment + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
