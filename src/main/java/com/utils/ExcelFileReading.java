package com.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReading {
//xlsx = XSSF
//xls = HSSF
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public ExcelFileReading(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getRowCount() throws IOException {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}

	public static Object getCellData(int row, int col) throws IOException { 
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(row).getCell(col));
		// double value = sheet.getRow(1).getCell(2).getNumericCellValue();
		System.out.println(value);
		return value;
	}
}
