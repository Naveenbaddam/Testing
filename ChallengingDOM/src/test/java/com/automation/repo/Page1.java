package com.automation.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page1

{
	
@FindBy(xpath="//a[@class='button']")
WebElement t1;

@FindBy(xpath="//a[@class='button alert']")
WebElement t2;

@FindBy(xpath="//a[@class='button success']")
WebElement t3;

@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]")
WebElement edit;

@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]")
WebElement delete;


public void click_on_table1()
{
	t1.click();
}
public void click_on_table2()
{
	t2.click();
}

public void click_on_table3()
{
	t3.click();
}

public void click_on_edit()
{
	edit.click();
}

public void click_on_delete()
{
	delete.click();
}


}
