package com.main;

import java.util.ArrayList;

public class Equipment {
	
	private int id;
	private String name;
	private String description;
	private int capacity;
	
	public Equipment() {
		
	}
	
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
	
	public Equipment fetch(int equipId) {
		
		// query database for equipment by id
		String query = "SELECT * FROM equipment WHERE EquipID = " + equipId;
		ArrayList<ArrayList<Object>> objectList = MySQLDatabase.getData(query, 4);
		
		// set equipment entity attributes
		int id = Integer.parseInt((String) objectList.get(0).get(0));
		String name = (String) objectList.get(0).get(1);
		String description = (String) objectList.get(0).get(2);
		int capacity= Integer.parseInt((String) objectList.get(0).get(3));
		
		// return equipment pojo
		return new Equipment(id, name, description, capacity);
	}
	
	public int put(int equipId, String column, String value) {
		
		// create update query
		String updateQuery = "Update `equipment` SET `" + column + "` = '" + value + "'  where `EquipID` = '" + equipId +"'";
		
		// set data
		return MySQLDatabase.setData(updateQuery, 4);
	}
	
	public void post(Equipment equipment) {
		
	}
	
	public void delete(int id) {
		
	}
}
