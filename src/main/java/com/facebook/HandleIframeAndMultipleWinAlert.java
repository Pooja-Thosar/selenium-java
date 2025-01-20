package com.facebook;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleIframeAndMultipleWinAlert {
	String URL = "https://demoqa.com/alertsWindows";
	WebDriver driver;

	@BeforeClass
	public void beforeFn() {
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		System.out.println(driver.manage().window().getSize());



	}
	@Test
	public void test02() {
		driver.findElement(By.xpath(getSpanTextXpath("Browser Windows"))).click();
		driver.findElement(By.xpath(getFirstButtonXpath("New Tab"))).click();
		Set<String> id = driver.getWindowHandles();
		ArrayList<String> ids = new ArrayList(id);
		String fis = ids.get(0);
		String sec = ids.get(1);
		driver.switchTo().window(sec);
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath(getXpathById("Sample Page"))).getText());
	}


	public String getSpanTextXpath(String replaceText) {
		return "//span[text()='"+replaceText+"']";
	}
	public String getFirstButtonXpath(String replaceText) {
		return "//button[text()='"+replaceText+"']";
	}
	public String getXpathById(String replaceText) {
		return "//*[@id='"+replaceText+"']";
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}


