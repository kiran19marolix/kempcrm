package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Driver;

import javax.swing.event.DocumentEvent.ElementChange;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Utils {
	//private static WebElement element;
	//For ExcelData
	
	public static String[][] setData(String sheetname) throws Exception {
		File file = new File("C:\\Users\\kiran\\git\\EmpireHome_Crm\\Empirehomecrm\\src\\main\\java\\com\\testdata\\EMDATA1.xlsx");
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
	//For SendKeys Action
//	public static void sendKeys(WebElement element, String text) {
//		element.clear();
//		element.click();
//		element.sendKeys(text);
//		
//	}
	//For Dropdowns
	public static void selectDropdown(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}
	//For MouseHover and Click Actions
	public static void mouseHoverandClickOnElement(WebDriver driver, WebElement locator) {
		Actions ac = new Actions(driver);
		ac.moveToElement(locator).click().perform();
	}
	//For Alerts
	public static void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
	}
}