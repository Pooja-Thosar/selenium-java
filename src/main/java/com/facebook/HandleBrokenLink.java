package com.facebook;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleBrokenLink {
	WebDriver driver;
	String URL = "http://www.deadlinkcity.com/";

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		System.out.println(driver.manage().window().getSize());
	}
	@Test
	public void test03() {
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		for(WebElement element:links) {
			String url=element.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println("Url is Empty");
				continue;
			}
			
			
		}
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	}


