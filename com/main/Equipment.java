package com.main;

import java.util.ArrayList;

public class Equipment {
	
	private int id;
	private String name;
	private String description;
	private int capacity;
	
	public Equipment(int id, String name, String description, int capacity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public static Object fetch(int id) {
		String query = "SELECT * FROM equipment WHERE EquipID = " + id;
		ArrayList<ArrayList<Object>> objectList = MySQLDatabase.getData(query, 4);
		return objectList.get(0).get(0);
	}
	
	public void put(int id) {
		
	}
	
	public void post(Equipment equipment) {
		
	}
	
	public void delete(int id) {
		
	}
}
