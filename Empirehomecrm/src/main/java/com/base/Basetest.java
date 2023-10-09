package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Basetest {

	public static Properties prop;
	FileInputStream file;
	public static WebDriver driver;
	protected ExtentReports extentreports;

	public Basetest() {

		try {
			file = new FileInputStream("./src/main/java/com/configprop/credentialsprop");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		prop = new Properties();

		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		extentreports = new ExtentReports();
//		ExtentSparkReporter spark= new ExtentSparkReporter(".\\target\\report.html");
//	    extentreports.attachReporter(spark);
//	    
	  

	}

	public void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equals("firefox")) {

			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		//extentreports.flush();

	}

}
