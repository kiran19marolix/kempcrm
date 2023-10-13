package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Basetest;
import com.pageobjects.AddProductPage;
import com.pageobjects.Loginfunctionality;
import com.pageobjects.StockMovePage;

public class StockMoveTest extends Basetest {
	Loginfunctionality lp;
    StockMovePage move; 
	public StockMoveTest() {
	super();
	}
    
	@BeforeMethod
    public void setup() {
    initialization();
  	lp = new Loginfunctionality();
  	lp.verifylogin();
  	move = new StockMovePage();
	}
	
	@Test
	public void verifystockmovetest() throws Exception {
	move.verifyStockMovePage();
	String urltest = driver.getCurrentUrl();
	Assert.assertEquals(urltest, "http://empirehome.myprojectsonline.co.in/Inventory/StockMovement");
	}
	
	@AfterMethod
	public void teardown() {
	//driver.close();	
	}
}
