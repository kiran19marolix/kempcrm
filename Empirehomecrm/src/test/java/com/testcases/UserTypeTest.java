package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.Loginfunctionality;
import com.pageobjects.UserTypePage;

public class UserTypeTest extends Basetest{
	Loginfunctionality lp;
	UserTypePage user;
	public UserTypeTest() {
	super();
	}
    
	@BeforeMethod
    public void setup() {
    initialization();
  	lp = new Loginfunctionality();
  	user = new UserTypePage();
	}
	
	@Test
	public void verifyusertypetestm() throws Exception {
	lp.verifylogin();
	user.verifyusertype();
	String urltest = driver.getCurrentUrl();
	Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/Master/Usertypes");
	}
	
	@AfterMethod
	public void teardown() {
	//driver.close();
	}
}
