package com.beanDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

public class ConnectionDetails {
	private String driver;
	private String url;
	private String userName;
	private String password;
	Connection con;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@PostConstruct
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		// Register the Driver Class
		Class.forName(driver);
		// create the connection
		con = DriverManager.getConnection(url, userName, password);
		return con;

	}
}
