package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.Loginfunctionality;
import com.utils.Utils;

public class Logintest extends Basetest {

	Loginfunctionality lf;

	public Logintest() {
		super();   //invokes the parent class constructor
	}

	@BeforeMethod
	public void setup() {

		initialization();

		lf = new Loginfunctionality();

	}

	@Test

	public void loginvalidation() {
		lf.verifylogin();
		String urltest = driver.getCurrentUrl();
		Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/EmpireHome/Dashboard");
		
	}
	
	@Test(dataProvider = "addData", dataProviderClass = Utils.class)
    public void logindatatest(String user, String pwd) {
		lf.verifylogindata(user, pwd);
    	
    }
    
	/*@AfterMethod
	public void teardown() {
		  extentreports.flush();
		//driver.close();

	}*/
}
