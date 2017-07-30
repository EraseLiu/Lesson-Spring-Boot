package org.edu.spring;

import java.util.List;

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

	private List<String> languages;

	public void show() {
		System.out.println("db.user-name: " + this.environment.getProperty("db.user-name"));
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

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return String.format(
				"DataSourceConifg [userName=%s, password=%s, driverName=%s, url=%s, languages=%s]",
				userName, password, driverName, url, languages);
	}

}
