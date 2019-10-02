package com.main;

import java.sql.*;
import java.util.ArrayList;

/**
 * The Class MySQLDatabase
 */
public class MySQLDatabase {

	private static Connection conn;
	private String url;
	private String username;
	private String password;

	/**
	 * Instantiates a new my SQL database
	 * and sets database connection attributes
	 */
	public MySQLDatabase() {
		url = "jdbc:mysql://localhost:3306/travel?useSSL=false";
		username = "root";
		password = "Gv3rn1ca";
	}

	/**
	 * Connect to mysql driver
	 */
	public void connect() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close mysql database connection
	 */
	public void close() {
		try {
			conn.close();
			System.out.println("Closed database connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fetch data from mysql database
	 * called from model class
	 *
	 * @param sqlString
	 * @param numFields
	 * @return objectlist
	 */
	public static ArrayList<ArrayList<Object>> getData(String sqlString, int numFields) {

		Statement stmnt = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> objectList = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tempList = new ArrayList<Object>();

		try {
			stmnt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
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
		}
		
		return objectList;
	}
	
	/**
	 * Fetch data from mysql database
	 * called from model class
	 *
	 * @param sqlString
	 * @param length
	 * @return objectlist
	 */
	public static ArrayList<ArrayList<Object>> getData(String sqlString, boolean columns) {

		Statement stmnt = null;
		ResultSet rs = null;
		ArrayList<Object> tempList = new ArrayList<Object>();
		ArrayList<ArrayList<Object>> objectList = new ArrayList<ArrayList<Object>>();

		if (columns == true) {
			try {
				stmnt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				rs = stmnt.executeQuery(sqlString);
				while (rs.next()) {
					for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
						if (rs.getMetaData().getColumnTypeName(i) == "INT") {
							tempList.add(rs.getInt(i));
							System.out.println("INT");
						} else {
							tempList.add(rs.getString(i));
							System.out.println("VARCHAR");	
						}
//						System.out.println("METADATA: " + rs.getMetaData().getColumnLabel(i));
//						tempList.add(rs.getMetaData().getColumnLabel(i));
//						System.out.println("VALUE: " + (int) Integer.parseInt(rs.getString(i)));
						
//						System.out.println("RS CLASS: " + rs.getString(i).getClass());
					}
					objectList.add(tempList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return objectList;
	}

	/**
	 * Sets the data for put, post
	 * and delete model methods
	 *
	 * @param sqlString
	 * @param numFields
	 * @return int
	 */
	public static int setData(String sqlString, int numFields) {

		int status = -1;

		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sqlString);
			preparedStmt.executeUpdate();
			status = preparedStmt.getUpdateCount();
		} catch (SQLException e) {
			e.printStackTrace();
			status = -1;
		}
		
		return status;
	}
}