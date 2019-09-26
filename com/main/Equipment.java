package com.main;

import java.util.ArrayList;

/**
 * The Class Equipment
 */
public class Equipment {
	
	private int id;
	private String name;
	private String description;
	private int capacity;
	
	/**
	 * Empty constructor
	 */
	public Equipment() {
		
	}

	/**
	 * Instantiates a new equipment
	 * instance with id parameter
	 *
	 * @param id the id
	 */
	public Equipment(int id) {
		this.id = id;
	}
	
	/**
	 * Instantiates a new equipment
	 * instance with parameters
	 *
	 * @param id the id
	 * @param name the name
	 * @param description the description
	 * @param capacity the capacity
	 */
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
	
	/**
	 * Fetch equipment instance
	 *
	 * @param equipId
	 * @return equipment
	 */
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
	
	/**
	 * Update existing database record
	 *
	 * @param equipId
	 * @param column
	 * @param value
	 * @return int
	 */
	public int put(int equipId, String column, String value) {
		
		// create put query
		String putQuery = "Update `equipment` SET `" + column + "` = '" + value + "'  where `EquipID` = '" + equipId +"'";
		
		// set data
		return MySQLDatabase.setData(putQuery, 4);
	}
	
	/**
	 * Post new record in database
	 *
	 * @param id
	 * @param name
	 * @param description
	 * @param capacity
	 * @return int
	 */
	public int post(int id, String name, String description, int capacity) {
		
		// create post query
		String postQuery = "INSERT into `equipment` (EquipID, EquipmentName, EquipmentDescription, EquipmentCapacity)" + 
		"VALUES ('" + id + "','" + name + "','" + description + "','" + capacity + "')";

		// post data
		return MySQLDatabase.setData(postQuery, 4);
	}
	
	/**
	 * Delete database record
	 *
	 * @param id
	 * @return int
	 */
	public int delete(int id) {
		
		// create delete query
		String deleteQuery = "DELETE from equipment WHERE EquipID = " + id;
		
		// delete record
		return MySQLDatabase.setData(deleteQuery, 4);
	}
}
