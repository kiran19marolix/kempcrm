package com.pageobjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Basetest;
import com.utils.Utils;

public class AddProductPage extends Basetest {
	@FindBy(xpath="//span[@class='pe-7s-keypad']")
	WebElement element;
	
	@FindBy(xpath="//span[normalize-space()='Inventory']")
	WebElement inventory;
	
	@FindBy(xpath="//a[normalize-space()='Add Inventory']")
	WebElement addinven;
	
	@FindBy(xpath="//input[@placeholder='Enter Model Number']")
    WebElement mnumber;
    
    @FindBy(xpath="//textarea[@name='Title']")
    WebElement ititle;
    
    @FindBy(xpath="//textarea[@name='ItemDescription']")
    WebElement idescription;
    
    @FindBy(xpath="//input[@placeholder='Enter Height']")
    WebElement hght;
    
    @FindBy(xpath="//input[@placeholder='Enter Width']")
    WebElement wdth;
    
    @FindBy(xpath="//input[@placeholder='Enter Breadth']")
    WebElement brdh;
    
    @FindBy(xpath="//input[@placeholder='Enter Color Name']")
    WebElement color;
    
    @FindBy(xpath="//input[@id='actual']")
    WebElement aprice;
    
    @FindBy(xpath="//*[@id=\"lobicard-custom-control1\"]/div[2]/form/div[1]/div[17]/div/span/span[1]/span")
    WebElement mrp;
    
    @FindBy(xpath="//li[contains(text(),'1.00')]")
    WebElement mrpp;
    
    @FindBy(xpath="//input[@placeholder='Enter Qty ']")
    WebElement qty;
    
    @FindBy(xpath="//input[@name='ProductMainImageUploaded']")
    WebElement img;
    
    @FindBy(xpath="//button[normalize-space()='Save']")
    WebElement save;
    
    public AddProductPage() {
    	PageFactory.initElements(driver, this);;
    }
            		
    public void verifyaddproduct(String modelnumber, String itemtitle, String itemdescription, String height, String width, String breadth, String colour, String actualprice, String quantity ) throws Exception {
    	Thread.sleep(3000);
    	element.click();
    	inventory.click();
    	addinven.click();
    	mnumber.sendKeys(modelnumber);
    	ititle.sendKeys(itemtitle);
    	idescription.sendKeys(itemdescription);
    	hght.sendKeys(height);
    	wdth.sendKeys(width);
    	brdh.sendKeys(breadth);
    	color.sendKeys(colour);
    	aprice.sendKeys(actualprice);
    	mrp.click();
    	mrpp.click();
    	Thread.sleep(2000);
    	
    	qty.sendKeys(quantity);

    	Thread.sleep(3000);
    	Utils.mouseHoverandClickOnElement(driver, img);
//    	Actions ac = new Actions(driver);
//    	ac.moveToElement(img).click().perform();
    	
     	Robot rb = new Robot();
    	rb.delay(2000);
    	
    	StringSelection path = new StringSelection("C:\\Users\\kiran\\OneDrive\\Desktop\\chair.jpg");
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
    	rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		save.click();
    	
    	}
    	
    	}

