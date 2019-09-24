package com.main;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDatabase {
	
	private Connection conn;
	private String url;
	private String username;
	private String password;
	
	public MySQLDatabase() {
		url = "jdbc:mysql://localhost:3306/travel?useSSL=false";
		username = "root";
		password = "password";
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
	
	public ArrayList<Equipment> getData(String sqlString, int numFields) {
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("There was an error creating a SQL statement");
		}
		try {
			rs = stmnt.executeQuery(sqlString);
		} catch (SQLException e) {
			System.out.println("There was an error executing SQL query");
		}
		
		System.out.println("RESULST SET: " + rs);
		
		return null;
	}
}