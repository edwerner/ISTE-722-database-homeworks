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
		
		for (Equipment e: equipmentList) {
			System.out.println(e);
		}

		// close database connection
		db.close();
	}
	
	public static String formatTable(List<ArrayList<String>> rows) {
		
	    int[] maxLengths = new int[rows.get(0).size()];
	    for (List<String> row : rows) {
	        for (int i = 0; i < row.size(); i++) {
	            maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
	        }
	    }

	    StringBuilder formatBuilder = new StringBuilder();
	    for (int maxLength : maxLengths) {
	        formatBuilder.append("%-").append(maxLength + 2).append("s");
	    }
	    String format = formatBuilder.toString();

	    StringBuilder result = new StringBuilder();
	    for (List<String> row : rows) {
	        result.append(String.format(format, row.toArray(new String[0]))).append("\n");
	    }
	    return result.toString();
	}
}