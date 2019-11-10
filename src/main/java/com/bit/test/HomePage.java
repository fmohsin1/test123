package com.bit.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	
	WebDriver dr;
	
	@Test
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/fardin/Downloads/chromedriver");
		ChromeDriver d= new ChromeDriver();
		d.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	public void CloseBrowser() {
		dr.quit();
	}
	
	

}
