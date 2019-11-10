package com.bit.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Express {
WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/fardin/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.express.com");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement men = driver.findElement(By.xpath("//a[@class='_399XX MegaMenuPrimaryNav_title__2EWGd'][contains(text(),'Men')]"));
		Actions action = new Actions(driver);
		action.contextClick(men).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		driver.close();
		 
	}

}
