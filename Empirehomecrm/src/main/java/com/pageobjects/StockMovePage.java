package com.pageobjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Basetest;
import com.utils.Utils;

public class StockMovePage  extends Basetest{
	@FindBy(xpath="//span[@class='pe-7s-keypad']")
	WebElement element;
	
	@FindBy(xpath="//span[normalize-space()='Inventory']")
	WebElement inventory;
	
	@FindBy(xpath="//a[normalize-space()='Move Stock']")
	WebElement movstock;
	
	@FindBy(xpath="//select[@id='movedFromD']")
	WebElement movfrm;
	
	@FindBy(xpath="//select[@id='movedToD']")
	WebElement movto;
	
	@FindBy(xpath="//input[@id='MoStNot']")
	WebElement notes;
	
	@FindBy(xpath="//button[@id='btnSave']")
	WebElement savebtn;
	
	@FindBy(xpath="//span[@id='select2-invId-container']")
	WebElement selectmnumber;
	
	@FindBy(xpath="//input[@role='textbox']")
	WebElement textbox;
	
	@FindBy(xpath="//input[@id='qtymoving']")
	WebElement movingqty;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement addbtn;
	
	public StockMovePage() {
		PageFactory.initElements(driver, this);
	}
    public void verifyStockMovePage() throws Exception {
    	Thread.sleep(2000);
    	element.click();
    	inventory.click();
    	movstock.click();
    	
    	Thread.sleep(2000);
    	Utils.selectDropdown(movfrm, "Warehouse");
    	Utils.selectDropdown(movto, "Showroom");
    	notes.sendKeys(prop.getProperty("table"));
    
    	
//    	Select s1 = new Select(movfrm);
//    	s1.selectByVisibleText("Warehouse");
//    	
//    	Select s2 = new Select(movto);
//    	s2.selectByVisibleText("Showroom");
//    	
//    	notes.sendKeys("table");
    	Thread.sleep(2000);
    	Utils.mouseHoverandClickOnElement(driver, selectmnumber);
    	
    	
//    	Actions ac = new Actions(driver);
//    	ac.moveToElement(selectmnumber).click().perform();
    	textbox.sendKeys("8888420421");
    	textbox.sendKeys(Keys.ENTER);
    	
    	Robot rb = new Robot();
    	movingqty.sendKeys("1");
    	
    	rb.keyPress(KeyEvent.VK_ENTER);
    	rb.keyRelease(KeyEvent.VK_ENTER);
    	
    	addbtn.click();
    	savebtn.click();
    	
    	driver.navigate().to("http://empirehome.myprojectsonline.co.in/Inventory/MoveStock");
    	Thread.sleep(2000);
    	Utils.selectDropdown(movto, "Showroom");
    	Utils.selectDropdown(movfrm, "Warehouse");
//    	s1.selectByVisibleText("Showroom");
//    	s2.selectByVisibleText("Warehouse");
    	
    	notes.sendKeys(prop.getProperty("table"));
    	Thread.sleep(2000);
    	Utils.mouseHoverandClickOnElement(driver, selectmnumber);
    	//ac.moveToElement(selectmnumber).click().perform();
    	textbox.sendKeys("8888420421");
    	textbox.sendKeys(Keys.ENTER);
    	
    	
    	movingqty.sendKeys("1");
    	
    	rb.keyPress(KeyEvent.VK_ENTER);
    	rb.keyRelease(KeyEvent.VK_ENTER);
    	
    	addbtn.click();
    	savebtn.click();
    	
    	
    }
}