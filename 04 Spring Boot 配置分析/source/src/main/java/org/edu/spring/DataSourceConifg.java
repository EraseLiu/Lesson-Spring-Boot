package org.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
public class DataSourceConifg {

	@Autowired
	private Environment environment;

	private String userName;

	private String password;

	private String driverName;

	private String url;

	public void show() {
		System.out.println("db.userName: " + this.environment.getProperty("db.userName"));
		System.out.println(this.toString());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format("DataSourceConifg [userName=%s, password=%s, driverName=%s, url=%s]", userName, password,
				driverName, url);
	}

}
