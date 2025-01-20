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

public class HandleLinks {
	WebDriver driver;
	String URL = "https://www.flipkart.com/";

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		System.out.println(driver.manage().window().getSize());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test03() {
//		driver.findElement(By.linkText("TVs & Appliances")).click();
//		driver.findElement(By.partialLinkText("Appliances")).click();
		
		// hpw to capture all the links
		List<WebElement> links= driver.findElements(By.tagName("a"));
		//System.out.println("No of links present "+ links.size());
		
		//Normal for loop
		
		/*for(int i=0;i<=links.size();i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			}*/
		
		//for each loop
		
		for(WebElement link:links) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
