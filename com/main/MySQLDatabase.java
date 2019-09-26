package com.main;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDatabase {

	private static Connection conn;
	private String url;
	private String username;
	private String password;

	public MySQLDatabase() {
		url = "jdbc:mysql://localhost:3306/travel?useSSL=false";
		username = "root";
		password = "Gv3rn1ca";
	}

	public void connect() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
			System.out.println("Closed database connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ArrayList<Object>> getData(String sqlString, int numFields) {

		Statement stmnt = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> objectList = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tempList = new ArrayList<Object>();

		try {
			stmnt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("There was an error creating SQL statement: " + e);
		}

		try {
			rs = stmnt.executeQuery(sqlString);
			while (rs.next()) {
				for (int i = 1; i <= numFields; i++) {
					tempList.add(rs.getString(i));
				}
			}
			objectList.add(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("There was an error executing SQL query: " + e);
		}
		
		return objectList;
	}

	public static int setData(String sqlString, int numFields) {

		int status = -1;

		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sqlString);
			preparedStmt.executeUpdate();
			status = preparedStmt.getUpdateCount();
		} catch (SQLException e) {
			e.printStackTrace();
			status = -1;
			System.out.println("There was an error executing SQL query: " + e);
		}
		
		return status;
	}

	public static int getObjectList(ResultSet rs, int numFields) {

		int result = -1;
		ArrayList<ArrayList<Object>> objectList = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tempList = new ArrayList<Object>();

		try {
			while (rs.next()) {
				for (int i = 1; i <= numFields; i++) {
					tempList.add(rs.getString(i));
				}
			}
			objectList.add(tempList);
			result = objectList.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}