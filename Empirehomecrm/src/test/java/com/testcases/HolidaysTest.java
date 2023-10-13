package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.CustomerAddPage;
import com.pageobjects.HolidaysPage;
import com.pageobjects.Loginfunctionality;

public class HolidaysTest extends Basetest{
	Loginfunctionality lp;
	HolidaysPage hp;
    public HolidaysTest() {
    super();
    }
	@BeforeMethod
    public void setup() {
    initialization();
  	lp = new Loginfunctionality();
  	hp = new HolidaysPage();
	}
	@Test
	public void verifyholiday() throws Exception {
	lp.verifylogin();
	hp.verifyholiday();
	String urltest = driver.getCurrentUrl();
	Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/Master/Holidays");
	}
	
	@AfterMethod
	public void teardown() {
	//driver.close();
	}

}
