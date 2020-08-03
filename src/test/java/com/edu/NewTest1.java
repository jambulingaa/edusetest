package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
	
  WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--no-sandbox");
            options.addArguments("--headless"); //should be enabled for Jenkins
            options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
            options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
	    options.addArguments("--disable-gpu"); //should be enabled for Jenkins
	    driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://3.135.210.63:8081/");
  }
  
  @Test
  public void addContact() {
	  
	 	driver.findElement(By.xpath("//*[@id='About Us']")).click();
			
	}
  
  @Test
  public void verifytitle() {
	  
        String a = driver.getTitle();
        System.out.println(a);
        Assert.assertEquals(a, "Home | Simple PHP Website");
	    System.out.println("Test Successful."); 
  }
  
  @AfterMethod
  public void afterMethod() {  
	  driver.close();
  }

}
