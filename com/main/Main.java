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
		
		
		String equipmentTable = formatTable(equipmentList);
		
		System.out.println(equipmentTable);

		// close database connection
		db.close();
	}
	
	public static String formatTable(ArrayList<Equipment> rows) {
		
	    int[] maxLengths = new int[rows.size()];
	    int counter = 0;
	    
	    for (Equipment row : rows) {
	    	maxLengths[counter] = Math.max(maxLengths[counter], rows.size());
	    	counter++;
	    }

	    StringBuilder formatBuilder = new StringBuilder();
	    
	    for (int maxLength : maxLengths) {
	        formatBuilder.append("%-").append(maxLength + 2).append("s");
	    }
	    
	    String format = formatBuilder.toString();
	    StringBuilder result = new StringBuilder();
	    
	    for (Equipment e : rows) {
		    result.append(e.getId()).append("\n");
		    result.append(e.getName()).append(" ");
		    result.append(e.getDescription()).append(" ");
		    result.append(e.getCapacity()).append(" ");
	    }
	    
	    return result.toString();
	}
}