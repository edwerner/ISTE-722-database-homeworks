package com.main;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		// create sql database instance
		// and connect to database
		MySQLDatabase db = new MySQLDatabase();
		db.connect();
		
		// create and fetch new equipment collection
		Equipment equipment = new Equipment();
		ArrayList<Equipment> equipmentList = equipment.fetch(0);

		// close database connection
		db.close();
	}
}