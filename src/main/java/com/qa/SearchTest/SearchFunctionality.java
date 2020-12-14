package com.qa.SearchTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SearchFunctionality {
	
	public static void main(String[] args) throws IOException {
		 WebDriver driver = new FirefoxDriver();
		driver.get("https://ui.freecrm.com/");
		
		driver.findElement(By.name("email")).sendKeys("riyazushaik710@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Testing@123");
		WebElement loginBtn=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		
		flash(loginBtn,driver);
		
		drawBorder(driver,loginBtn);
		
		generateAlert(driver,"There is an issue with login on login page");
		
		//click on any element using javascript Executor
		clickElementByJS(loginBtn,driver);
		//refresh the browser
		refreshBrowserByJS(driver);
		//get title
		System.out.println(getTitleByJS(driver));
		
		//getting the page innerText
		System.out.println(getPageInnerText(driver));
		
		scrollPageDown(driver);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("D:\\Automation\\AutomatingSearch\\Screenshots\\login.png"));
	}
	
	
	
	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
			
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		try {
			Thread.sleep(3000);
		} catch(Exception e) {
		
	}
	}

	public static void drawBorder(WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//generate Alert message:
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	public static void clickElementByJS(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String Title=js.executeScript("return document.title;").toString();
		return Title;
	}
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
	String Text=js.executeScript("return document.documentElement.innerText").toString();
		return Text;
	}
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
}
