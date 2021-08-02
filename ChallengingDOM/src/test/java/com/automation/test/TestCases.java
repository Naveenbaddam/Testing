package com.automation.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.core.BasePage;
import com.automation.repo.Page1;


public class TestCases extends BasePage

{
    Page1 page;
	
	@Test(priority=1)
	
	// Verifying the application Page title
	
	public void verify_Pagetitle()
	{
		String pageTitle = driver.getTitle();
		
		System.out.println("The Title of the page is - " +pageTitle);
		
		Assert.assertEquals(pageTitle, "The Internet", "PageTitle doesn't matched");
	}
	
	@Test(priority=2)
	
	// Verifying 'Challenging DOM' presence
	
	public void verify_ChallengingDOM()
	{
		String expected = "Challenging DOM";
		
		String actual = driver.findElement(By.xpath("//*[text()='Challenging DOM']")).getText();
		
		Assert.assertEquals(actual, expected);
		
		System.out.println("Challenging DOM is presented on the page");
	}
	
	@Test(priority=3)
	
	// Verifying page description
	
	public void verify_pageDescription()
	{
		String expected = "The hardest part in automated web testing is finding the best locators";
		
		String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
		
		System.out.println(actual);
		
		Assert.assertTrue(actual.contains(expected),"Page description is not presented on the page");
		
		System.out.println("Page Description is presented in the page");
		
	}
	
	
	@Test(priority=4)
	
	// Verifying the 'button1' functionality
	
	public void verify_button1()
	{
		page = PageFactory.initElements(driver, Page1.class);
		
		page.click_on_table1();
		
		String expected = "Iuvaret0";
		
		String actual = driver.findElement(By.xpath("//*[text()='Iuvaret0']")).getText();
		
		if(expected.equalsIgnoreCase(actual))
		{
			System.out.println("Successfully clicked on table1 and got the respective table data");
		}
		else
		{
			System.out.println("Failed to click on table1");
			
		}
		
		
	}
	
	@Test(priority=5)
	
	// Verifying the 'button2' functionality
	
	public void verify_button2()
	{
		page = PageFactory.initElements(driver, Page1.class);
		
		page.click_on_table2();
		
		String expected = "Iuvaret1";
		
		String actual = driver.findElement(By.xpath("//*[text()='Iuvaret1']")).getText();
		
		if(expected.equalsIgnoreCase(actual))
		{
			System.out.println("Successfully clicked on table2 and got the respective table data");
		}
		else
		{
			System.out.println("Failed to click on table2");
			
		}
	}
	
	@Test(priority=6)
	
	// Verifying the 'button3' functionality
	
	public void verify_button3()
	{
		page = PageFactory.initElements(driver, Page1.class);
		
		page.click_on_table3();
		
		String expected = "Iuvaret2";
		
		String actual = driver.findElement(By.xpath("//*[text()='Iuvaret2']")).getText();
		
		if(expected.equalsIgnoreCase(actual))
		{
			System.out.println("Successfully clicked on table3 and got the respective table data");
		}
		else
		{
			System.out.println("Failed to click on table3");
			
		}
	}
	
	@Test(priority=7)
	
	// Verifying the 'edit' functionality
	
	public void verify_edit()
	{
		page = PageFactory.initElements(driver, Page1.class);
		
		page.click_on_edit();
		
		String expected_title = "The Internet";
		
		String actual_page_title = driver.getTitle();
		
		System.out.println(actual_page_title + " -Testcase on edit is executed successfully");
		
		Assert.assertEquals(actual_page_title,expected_title);
		
	}
	
	@Test(priority=8)
	
	// Verifying the 'delete' functionality
	public void verify_delete()
	{
		page = PageFactory.initElements(driver, Page1.class);
		
		page.click_on_delete();
		
		String actual = driver.getCurrentUrl();
		
		String expected = "delete";
		
		if(actual.contains(expected))
			
		{
			System.out.println("Record is deleted successfully");
		}
		
		else
		{
			System.out.println("Record is not deleted successfully");
		}
	}
		
	@Test(priority=9)
		
	// Verifying "Pork me on GitHub" link 
		
	public void verify_GitHubLink()
	{
		WebElement gitHubLink = driver.findElement(By.xpath("//img[contains(@style,'position')]"));
		
		gitHubLink.click();
		
		String actualUrl=driver.getCurrentUrl();
		
		String expectedUrl  = "https://github.com/saucelabs/the-internet";
		
		Assert.assertEquals(actualUrl, expectedUrl, "Pork me GitHub link is failed to click");
		
		driver.navigate().back();
		
		System.out.println("Pork me GitHub link is working as expected");
		
	}
	
	@Test(priority=10)
	
	// Verifying Canvas Presence
	
	public void verify_Canvas() throws IOException
	
	{
		WebElement canvs = driver.findElement(By.xpath("//canvas[@id='canvas']"));
		
		boolean b = canvs.isDisplayed();
		
		System.out.println(b +" - Canvas is presented on the page");
		
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C://Users//badda//ChallengingDOM//ScreensShots//Canvas.png"));
	}
	

}
