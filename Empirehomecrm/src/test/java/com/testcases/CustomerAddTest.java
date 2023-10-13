package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.CustomerAddPage;
import com.pageobjects.Loginfunctionality;
import com.pageobjects.UserTypePage;


public class CustomerAddTest extends Basetest{
	Loginfunctionality lp;
	CustomerAddPage cap;
    public CustomerAddTest() {
    super();
    	
	
    
    }
    
	@BeforeMethod
    public void setup() {
    initialization();
  	lp = new Loginfunctionality();
  	cap = new CustomerAddPage ();
	}
	
	@Test
	public void verifycustomeradd() throws Exception {
	lp.verifylogin();
	cap.verifycustomeradd();
	String urltest = driver.getCurrentUrl();
	Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/User/CustomerList");
	}
	
	@AfterMethod
	public void teardown() {
	//driver.close();
	}
}
