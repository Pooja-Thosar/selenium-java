package com.facebook;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleBrowserWindow {

	WebDriver driver;
	String URL = "https://opensource-demo.orangehrmlive.com/";

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
	public void test01() {
		//		String windowId= driver.getWindowHandle();
		//		System.out.println(windowId);
		driver.findElement(By.xpath(linkXpath("OrangeHRM, Inc"))).click();

		//getWindowHandles()
		Set<String>WindowIDs=driver.getWindowHandles();

		// First Method- iterator()
		/*Iterator <String> it = WindowIDs.iterator();
		String parentId= it.next();
		String childId= it.next();
		System.out.println("Parent Window Id: "+ parentId);
		System.out.println("Child Window Id: " + childId);*/
		
		// Second Method- List
		ArrayList<String> windowIdList= new ArrayList(WindowIDs);
		
		/*String parentWindowId= windowIdList.get(0);
		String childWindowId= windowIdList.get(1);
		
		System.out.println("Parent Window Id: "+ parentWindowId);
		System.out.println("Child Window Id: " + childWindowId);
		
		//How to switch for another window
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window Title: " +driver.getTitle());
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child Window Title: " +driver.getTitle());*/
		
		//For each loop
		for(String winId:windowIdList)
		{
			//System.out.println(winId);
//			String title=driver.switchTo().window(winId).getTitle();
//			System.out.println(title);
			driver.switchTo().window(winId);
			if(driver.getTitle().equals("Human Resources Management Software | OrangeHRM"));
			break;
		}
		
		
		
		
		
		

	}

	public String linkXpath(String replaceText) {
		return "//a[text()='"+replaceText+"']";
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
