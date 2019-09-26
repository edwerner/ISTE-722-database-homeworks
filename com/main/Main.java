package com.main;

public class Main {
	
	public static void main(String[] args) {
		MySQLDatabase db = new MySQLDatabase();
		db.connect();
		Equipment equipment = Equipment.fetch(568);
		db.close();
	}
}