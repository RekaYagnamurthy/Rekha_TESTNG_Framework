package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	// Common method to read the data from Excel and convert it into a 2D array.
	public static String [][] readData(String fileName, String sheetName) {
		
		// Placeholder for 2D array to hold the data reading from Excel. 
		String[][] data = null;
		
		
		try {
			// Read the Excel file by using FileInputStream.
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);
			
			// Using XSSFWorkbook class, analyze the excel file.
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			// Get the specific sheet from the workbook.
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			// Get the total number of rows and columns.
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			// Initialize the 2D array with totalRows-1 and totalCols.
			data = new String[totalRows - 1][totalCols]; // Exclude header row.
			
			// Loop through the rows and columns to read the data.
			for(int r=1; r<totalRows; r++) { // Start from 1 to skip header row.
				for(int c=0; c<totalCols; c++) {					
					data[r-1][c] = sheet.getRow(r).getCell(c).getStringCellValue();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return data;
	}

	
	// Common method to read the data from Excel and convert it into List<Map<String,String>>.
		public static List<Map<String,String>> readExcel(String fileName, String sheetName) {
			
			// Placeholder for List<Map<String,String>> to hold the data reading from Excel.
			List<Map<String,String>> data = new ArrayList<Map<String,String>>();
						
			try {
				// Read the Excel file by using FileInputStream.
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);
				
				// Using XSSFWorkbook class, analyze the excel file.
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				
				// Get the specific sheet from the workbook.
				XSSFSheet sheet = workbook.getSheet(sheetName);
				
				// Get the total number of rows and columns.
				int totalRows = sheet.getPhysicalNumberOfRows();
				int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
				
				// Iterate over each and every row and column, and store the data into a list of maps.
				for(int r=1; r<totalRows; r++) { // Start from 1 to skip header row.
					
					//Create a new map for each and every row. 
					Map<String,String> rowData = new HashMap<String,String>();
					
					// Iterate over each column.
					for(int c=0; c<totalCols; c++) {		
						
						// Get the key from the header row (0th row).
						String key = sheet.getRow(0).getCell(c).getStringCellValue();
						
						// Get the value from the current row.
						String value = sheet.getRow(r).getCell(c).getStringCellValue();
						
						// Put the key-value pair into the map.
						rowData.put(key, value);
					}
					
					// Add the map to the list.
					data.add(rowData);
					
				
				}				
				

			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			return data;
		}
}
