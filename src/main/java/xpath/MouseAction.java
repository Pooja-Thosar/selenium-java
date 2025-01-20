package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseAction {
	
	WebDriver driver;

	@BeforeClass
	public void init() {
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title of page is" +" "+ title);
		driver.getPageSource();

	}

    @Test
    public void mouseAction() {
    	
    	WebElement rightBt = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
    	
    	Actions act = new Actions(driver);
    	act.contextClick(rightBt).build().perform();
    	act.dragAndDrop(rightBt, rightBt);
    	act.doubleClick();
    	act.moveToElement(rightBt);
    	
    	
	
	}
    
    @AfterClass
	public void tearDown() {
		driver.quit();
	}


}



