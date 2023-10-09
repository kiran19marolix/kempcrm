package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddDataPro {
	public static String[][] addPro(String sheetname ) throws Exception {
		File file = new File("C:\\Users\\kiran\\git\\EmpireHome_Crm\\Empirehomecrm\\src\\main\\java\\com\\testdata\\EMDATA.xlsx");
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows-1][cells] ;
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<cells;j++) {
				DataFormatter df = new DataFormatter();
				data [i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return data;
	  }		

}
