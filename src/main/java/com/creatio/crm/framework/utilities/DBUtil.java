package com.creatio.crm.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtil {
	
	public static Properties prop = PropUtil.readData("Config.properties");
	
	// Common method to connect with database and get the raw data from the database tables.
	public static ResultSet executeQuery(String query)  {
		ResultSet dataSet = null;
		String dbUrl = prop.getProperty("db.url");
		String dbUserName = prop.getProperty("db.username");
		String dbPassword = prop.getProperty("db.password");	
		try {
			Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);// connect to database
			dataSet = connection.createStatement().executeQuery(query);// execute query and get raw data
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSet;
	}
	
	// Common method to convert the raw data into a list of maps.
	public static List<Map<String,String>> getData(String query) throws SQLException{	
		
		//Create a empty list of maps to hold the data
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
		// get the raw data from database
		ResultSet dataSet = executeQuery(query);
		
		// Convert the raw data into a list of maps.
		while(dataSet.next()) { //check if there is a next row
			
			// Create an empty map for each and every row.
			Map<String,String> rowData = new HashMap<String,String>();
			
			// Convert the ResultSet into a map.
			for(int c= 1; c<=dataSet.getMetaData().getColumnCount(); c++) {
				String columnName = dataSet.getMetaData().getColumnName(c);// get the column name
				String columnValue = dataSet.getString(c);// get the column value
				rowData.put(columnName, columnValue);// put the column name and value into the map
			}
			
			// Add the map into the list.
			data.add(rowData);
		}	
		
		return data;		
	}
	

}
