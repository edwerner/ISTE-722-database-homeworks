package com.main;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		// create sql database instance
		// and connect to database
		MySQLDatabase db = new MySQLDatabase();
		db.connect();
		
		// create and fetch new equipment
		// instance by id
		Equipment equipment = new Equipment();
		ArrayList<Equipment> equipmentList = equipment.fetch(-1);
		
		System.out.println(equipmentList.get(0).getName());
		
		
		
		// close database connection
		db.close();
	}
}