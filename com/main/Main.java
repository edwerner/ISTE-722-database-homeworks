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
	
	public static void formatTable(ArrayList<Equipment> rows) {
		
//	    int[] maxLengths = new int[rows.size()];
//	    int counter = 0;
//	    
//	    for (Equipment row : rows) {
//	    	maxLengths[counter] = Math.max(maxLengths[counter], rows.size());
//	    	counter++;
//	    }
//
//	    StringBuilder formatBuilder = new StringBuilder();
//	    
//	    for (int maxLength : maxLengths) {
//	        formatBuilder.append("%-").append(maxLength + 2).append("s");
//	    }
//	    
//	    String format = formatBuilder.toString();
//	    StringBuilder result = new StringBuilder();
	     
	    for (Equipment e : rows) {
		    System.out.format("%n%-2s%20s%-16s", String.valueOf(e.getId()), 
		    		e.getName(), e.getDescription(), String.valueOf(e.getCapacity()));
	    }
	    
	    
//	    return result.toString();
	}
}