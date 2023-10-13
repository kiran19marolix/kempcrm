package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.Loginfunctionality;
import com.utils.Utils;

public class Logintest extends Basetest {

	Loginfunctionality lf;
	private final String sheetname = "Sheet3";

	public Logintest() {
		super();   //invokes the parent class constructor
	}

	@DataProvider
	public String[][] loadData() throws Throwable{
		return Utils.setData(sheetname);
		
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		lf = new Loginfunctionality();
		//lf.verifylogin();
	}

//	@Test
//	public void loginvalidation() {
//	//lf.verifylogin();	
//	String urltest = driver.getCurrentUrl();
//	Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard");
//		
//	}
	
	@Test(dataProvider = "loadData", dataProviderClass = Logintest.class)
    public void logindatatest(String username, String password) {
		lf.verifylogindata(username, password);
		String str = driver.getCurrentUrl();
		Assert.assertEquals(str,"http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard");
    }
    
	/*@AfterMethod
	public void teardown() {
		  extentreports.flush();
		//driver.close();

	}*/
}
