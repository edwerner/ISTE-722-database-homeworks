package com.main;

public class Main {
	
	public static void main(String[] args) {
		
		// create sql database instance
		// and connect to database
		MySQLDatabase db = new MySQLDatabase();
		db.connect();
		
		// create and fetch new equipment
		// instance by id
		Equipment equipment = new Equipment(568);
		equipment = equipment.fetch(equipment.getId());
		
		// close database connection
		db.close();
		
		// log equipment attributes
		logEquipmentFetch(equipment);
		
		System.out.println("\n");

		// connect to database
		db.connect();
		
		// post new equipment instance
		int result = equipment.post(9500, "Airbus Civilian A220", "Passenger and Cargo", 130);

		// close database connection
		db.close();
		
		System.out.println(result + " records inserted");
	}

	private static void logEquipmentFetch(Equipment equipment) {
		System.out.println("EquipID: " + equipment.getId());
		System.out.println("EquipmentName: " + equipment.getName());
		System.out.println("EquipmentDescription: " + equipment.getDescription());
		System.out.println("EquipmentCapacity: " + equipment.getCapacity());
	}
}