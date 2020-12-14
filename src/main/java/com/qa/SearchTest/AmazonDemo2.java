package com.qa.SearchTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonDemo2 {
	WebDriver driver;
	

	@Test
	public void amazonTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(10000);

		WebElement all=driver.findElement(By.cssSelector("div#nav-search-dropdown-card"));
		all.click();
		
		List<WebElement>options=driver.findElements(By.xpath("//select[@name='url']//option"));
		System.out.println(options.size());
		
		for(int i=0;i<options.size();i++) {
			String listText=options.get(i).getText();
			System.out.println(listText);
			if(listText.equals("Appliances")) {
				options.get(i).click();
				break;
			}
		}
}
}