package com.automation.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePage 

{
public static WebDriver driver;
	
	@BeforeSuite
	
	// Setup method
	
	public void Launch_App()
	{
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
		String expected = "Challenging DOM";
		
	    String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		
		if(expected.equalsIgnoreCase(actual))
	    {
			System.out.println("The Application Launched Successfully");
		}
			
			else 
			{
				System.out.println("The Appliaction failed to Launch");
			}
			
		}
	
	@AfterSuite
	
	// Tear down method
	
	public void Close_App()
	{
		driver.close();
		
		System.out.println("Application closed successfully");
	}

}
