package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		// create sql database instance
		// and connect to database
		MySQLDatabase db = new MySQLDatabase();
		db.connect();
		
		// create and fetch new equipment collection
		Equipment equipment = new Equipment();
		ArrayList<Equipment> equipmentList = equipment.fetch(0);
		
		formatTable(equipmentList);
		
//		System.out.println(equipmentTable);

		// close database connection
		db.close();
	}
	
	public static void formatTable(ArrayList<Equipment> equipmentList) {
		for (int i = 0; i < equipmentList.size(); i++) {
		    System.out.format("%n%-10s%-30s%-30s%-10s", 
		    		String.valueOf(equipmentList.get(i).getId()), 
		    		equipmentList.get(i).getName(),
		    		equipmentList.get(i).getDescription(), 
		    		String.valueOf(equipmentList.get(i).getCapacity()));
		}
	}
}