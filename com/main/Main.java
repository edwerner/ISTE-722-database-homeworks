package com.main;

public class Main {
	
	public static void main(String[] args) {
		
		// create sql database instance
		// and connect
		MySQLDatabase db = new MySQLDatabase();
		db.connect();
		
		// create and fetch new equipment
		// instance by id
		Equipment equipment = new Equipment();
		equipment = equipment.fetch(568);
		
		// close database connection
		// and log equipment attributes
		db.close();
		logEquipmentFetch(equipment);

		
		db.connect();
//		int result = equipment.put(568, "EquipmentName", "Continental");
//		System.out.println("Result count: " + result);
		
		int result = equipment.post(9500, "Airbus Civilian A220", "Passenger and Cargo", 130);
		System.out.println("Result count: " + result);
		db.close();
	}

	private static void logEquipmentFetch(Equipment equipment) {
		System.out.println("EquipID: " + equipment.getId());
		System.out.println("EquipmentName: " + equipment.getName());
		System.out.println("EquipmentDescription: " + equipment.getDescription());
		System.out.println("EquipmentCapacity: " + equipment.getCapacity());
	}
}