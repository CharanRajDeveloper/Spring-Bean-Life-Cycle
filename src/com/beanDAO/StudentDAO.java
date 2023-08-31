package com.beanDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {

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

	// this method will be invoked after creating the bean
	// @PostConstruct //commenting to configure it by xml file
	public void init() throws ClassNotFoundException, SQLException {
		System.out.println("Inside Custome init method");
		createConnection();
	}

	public void createConnection() throws ClassNotFoundException, SQLException {
		System.out.println("Creating connection");
		// Register the Driver Class
		Class.forName(driver);
		// create the connection
		con = DriverManager.getConnection(url, userName, password);

	}

	public void selectAllRows() throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM charan.developerdata");
		System.out.println("Retrieving the records..");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String designation = rs.getString(3);
			System.out.println(id + "::" + name + "::" + designation);
		}

	}

	public void deleteRecord(int StudentId) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = con.prepareStatement("delete from charan.developerdata where id='" + StudentId + "'");
		int count = pstmt.executeUpdate();
		System.out.println("Deleted Record Successfully");
		System.out.println("Count value" + count);
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	// This method will be called before destroying this class bean.ie.object.
	// @PreDestroy //commenting to configure it by xml file
	public void destroy() {
		System.out.println("Calling the destroy method");
	}
}
