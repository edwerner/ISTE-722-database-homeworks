package com.main;

import java.sql.*;

public class MySQLDatabase {
	
	private Connection conn;
	private String url;
	private String username;
	private String password;
	
	public MySQLDatabase() {
		url = "jdbc:mysql://simon.ist.rit.edu/networx_ser";
		username = "330User";
		password = "330Password";
	}
	
	public void connect() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Connected to database");
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Closed database connection");
		}
	}
}