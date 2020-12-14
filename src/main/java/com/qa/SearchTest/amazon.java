package com.qa.SearchTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class amazon {
WebDriver driver;
Select select;
 WebDriverWait wait;

@Test
public void amazonTest() throws InterruptedException {
	driver = new FirefoxDriver();
	driver.get("https://www.amazon.in/");
	Thread.sleep(5000);

	WebElement ele =driver.findElement(By.tagName("select"));
	select = new Select(ele);
	List<WebElement> list=select.getOptions();
	System.out.println(list.size());
	
	for(int i=0;i<list.size();i++) {
		String listText=list.get(i).getText();
		System.out.println(listText);
		if(listText.equals("Deals")) {
			list.get(i).click();
			break;
		}
	
	
	
	
	//select = new Select();
	

	/*List<WebElement>list=driver.findElements(By.xpath("//select[contains(@class,'nav-search-dropdown searchSelect')]//option\r\n" + 
			"\r\n" + 
			""));
	System.out.println(list.size());
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().contains("Books")) {
			list.get(i).click();
			break;
		}
	}*/
	


	
}
}
}

