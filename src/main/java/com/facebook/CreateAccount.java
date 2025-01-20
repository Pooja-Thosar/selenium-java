package com.facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccount {

	WebDriver driver;

	@BeforeClass
	public void init() {
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of page is" +" "+ title);
		driver.getPageSource();

	}

	@Test
	public void createAccountFacebook() {
		driver.findElement(By.xpath("//a[contains(text(), 'Create new account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Test1");

//		Approach1
//		Select day = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
//		day.selectByVisibleText("29");
//		
//		Select month = new Select(driver.findElement(By.name("birthday_month")));
//		month.selectByVisibleText("Oct");
//		
//		Select year = new Select(driver.findElement(By.name("birthday_year")));
//		year.selectByVisibleText("1998");
		
//		Approach2
		//driver.findElement(By.xpath("//select[@name='birthday_month']")).click();

//		List <WebElement> month =driver.findElements(By.xpath("//select[@name='birthday_month']"));
//		//List <WebElement> month1 = sel.getOptions();
//		System.out.println(month.size());
//
//		for(WebElement option:month) {
//			if(option.getText().equals("Oct"));
//			{
//				option.click();
//				break;
//			}
//		}
		
		driver.findElement(By.xpath("//select[@id='day']")).click();
		List<WebElement> day= driver.findElements(By.xpath("//select[@id='day']//option"));
		
		for (WebElement option:day) {
			if (option.getText().equals("29")) {
				option.click();
				break;
			}
		}
		
		
		
		
		

		
		waitInSec(10);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void waitInSec(int a) {
		int b = a*1000;
		try {
			Thread.sleep(b);
		}
		catch(Exception c){
			c.printStackTrace();
		}
	}

}
