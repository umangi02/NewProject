package com.manta.framework.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {

	static String testDataPath = "resources" + File.separator + "testdata";

	public static String getColumn(String excelName, String sheetName, String columnName, String whereClause) {
		Fillo fillo = new Fillo();
		String strResult = null;

		try {
			Connection connection = fillo
					.getConnection(Path.getProjectDir() + File.separator + testDataPath + File.separator + excelName);
			String query = "Select * from " + sheetName + " where " + whereClause;
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				strResult = recordset.getField(columnName);
			}
			recordset.close();
			connection.close();
		} catch (FilloException fe) {
			System.err.println("Error while connecting to the sheet.");
			fe.printStackTrace();
		}

		return strResult;
	}

	/**
	 * Performs "SELECT * From <sheetName> Where <whereClause>". Returns data that
	 * meet the condition(s) given in where clause, from an excel sheet.
	 *
	 * @param excelName   - Excel file name
	 * @param sheetName   - Sheet name in an excel file
	 * @param whereClause - Mention single or multiple conditions. With or without
	 *                    LIKE Operator ex. "Select * from Sheet1 where userName
	 *                    like 'Cod%'"
	 * @return HashMap string with column name and value pairing.
	 */
	public static HashMap<String, String> getRow(String excelName, String sheetName, String whereClause) {
		Fillo fillo = new Fillo();
		HashMap<String, String> row = new HashMap<>();

		try {
			Connection connection = fillo
					.getConnection(Path.getProjectDir() + File.separator + testDataPath + File.separator + excelName);
			String query = "Select * from " + sheetName + " where " + whereClause;
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				ArrayList<String> collection = recordset.getFieldNames();
				int size = collection.size();
				Map<String, String> values = new HashMap<>();
				for (int i = 0; i <= (size - 1); i++) {
					String columnName = collection.get(i);
					String columnValue = recordset.getField(columnName);
					row.put(columnName, columnValue);
				}
			}
			recordset.close();
			connection.close();
		} catch (FilloException fe) {
			System.err.println("Error while connecting to the sheet.");
			fe.printStackTrace();
		}

		return row;
	}

	/**
	 * Performs "UPDATE SET <ColumnName> = <Value> Where <whereClause>". Updates data that
	 * meet the condition(s) given in where clause, to an excel sheet.
	 *
	 * @param excelName   - Excel file name
	 * @param sheetName   - Sheet name in an excel file
	 * @param columnName  - Column Name where you want to set value
	 * @param columnValue  - Value that you want to set for Column
	 * @param whereClause - Mention single or multiple conditions. With or without
	 *                    LIKE Operator ex. "Select * from Sheet1 where userName
	 *                    like 'Cod%'"
	 */
	public static void updateColumn(String excelName, String sheetName, String columnName, String columnValue,
			String whereClause) {
		Fillo fillo = new Fillo();

		try {
			Connection connection = fillo
					.getConnection(Path.getProjectDir() + File.separator + testDataPath + File.separator + excelName);
			String query = "Update " + sheetName + " Set " + columnName + "='" + columnValue + "' where "
					+ whereClause;
			connection.executeUpdate(query);
			connection.close();
		} catch (FilloException fe) {
			System.err.println("Error while connecting to the sheet.");
			fe.printStackTrace();
		}
	}

	/**
	 * Performs "SELECT * FROM <SheetName>". fetch data that
	 * meet the condition(s), from an excel sheet.
	 *
	 * @param excelName   - Excel file name
	 * @param sheetName   - Sheet name in an excel file
	 * @return List<HashMap<String, String>> Array of list with key value pair of each row.
	 */
	public static List<HashMap<String, String>> getAllRows(String excelName, String sheetName) {
		Fillo fillo = new Fillo();
		List<HashMap<String,String>> rows = new ArrayList<HashMap<String, String>>();;

		try {
			Connection connection = fillo
					.getConnection(Path.getProjectDir() + File.separator + testDataPath + File.separator + excelName);
			String query = "Select * from " + sheetName;
			Recordset recordset = connection.executeQuery(query);

				while (recordset.next()) {
					HashMap<String, String> row = new HashMap<>();
					ArrayList<String> collection = recordset.getFieldNames();
					int size = collection.size();
					Map<String, String> values = new HashMap<>();
					for (int i = 0; i <= (size - 1); i++) {
						String columnName = collection.get(i);
						String columnValue = recordset.getField(columnName);
						row.put(columnName, columnValue);
					}
					rows.add(row);
				}
			recordset.close();
			connection.close();
		} catch (FilloException fe) {
			System.err.println("Error while connecting to the sheet.");
			fe.printStackTrace();
		}

		return rows;
	}
}
