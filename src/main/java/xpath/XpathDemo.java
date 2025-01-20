package xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XpathDemo {
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of page is" +" "+ title);
		driver.getPageSource();

	}

    @Test
    public void mouseAction() {
    	
	
	}
    
    @AfterClass
	public void tearDown() {
		driver.quit();
	}


}
