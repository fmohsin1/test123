package com.bit.test;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.List;
	import java.util.Properties;
	import java.util.Set;

	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import com.google.common.io.Files;

	public class Shared {
		WebDriver driver;
		//public Shared(WebDriver dr) {
			//driver=dr;
			
		//}
		static Actions action;
		static FileInputStream file;
		static XSSFWorkbook excelbook;
		static FileReader textfile;
		
		

		public static void type(WebElement element, String text) {
			
			element.clear();
			element.sendKeys(text);

		}
		
		public static void click(WebElement element) {
			element.click();
		}
		public static void verify(WebElement element) {
			element.isDisplayed();
			
		}
		public static void sleep(long millis) throws InterruptedException {
			Thread.sleep(millis);

		}
		
		

		public void verifyifDisplayed(WebElement element) {
			element.isDisplayed();
		}

		public void search(WebElement element, String b) {
			element.clear();
			element.sendKeys(b);

		}

		public void enter(WebElement element, Keys keys) {
			element.sendKeys(keys);

		}

		public void clickonitem(WebElement element) {
			element.click();

		}
		public void getSize(List<WebElement> elements) {
			elements.size();
			
		}
		public Select select(By a, String b) {
			Select s=new Select(driver.findElement(a));
			//s.selectByVisibleText(b);
			return s;
		}
		public static void performRightclick(WebDriver driver, WebElement target) {
			action = new Actions(driver);
			action.contextClick(target).build().perform();
		}

		public static Properties readpropertyFile(String filepath) {

			try {
				file = new FileInputStream(new File(filepath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}

		public static void screenShoot(WebDriver driver) {
			int num = (int) Math.random();
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(file,new File("C:\\Users\\Urmi\\eclipse-workspace\\TestNgPractice\\shoot"+num+".png") );
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}

		public static XSSFWorkbook readxlfile(String excelpath) {
			try {
				file = new FileInputStream(new File(excelpath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				excelbook = new XSSFWorkbook(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return excelbook;
		}

		public static void readtextfile(String textfilepath) throws IOException {

			try {
				textfile = new FileReader(new File(textfilepath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader reader = new BufferedReader(textfile);

			String line = reader.readLine();
			while (line != null) {
				line = reader.readLine();

			}

		}

		public static void multipleWindowhandle(WebDriver driver, WebElement target) {
			action = new Actions(driver);
			String pwind = driver.getWindowHandle();
			action.contextClick(target).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			Set<String> childWin = driver.getWindowHandles();
			for (String wind : childWin) {
				if (!wind.equals(pwind))
					;
				driver.switchTo().window(wind);
				// driver.switchTo().window(pwind);/to move to main window.
				driver.switchTo().defaultContent();
			}

		}

		public static void hoverover(WebDriver driver, WebElement target) {
			action = new Actions(driver);
			action.moveToElement(target).build().perform();
		}

		public static void alertHandle(WebDriver driver, WebElement target) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			alert.dismiss();
			alert.sendKeys("");
			alert.getText();

		}

		public static void iframehandle(WebDriver driver, WebElement target, String framename) {
			driver.switchTo().frame(2);
			driver.switchTo().frame("efwet");
			driver.switchTo().frame(driver.findElement(By.id("")));
			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			List<WebElement> allframes = driver.findElements(By.tagName("iframe"));
			for (WebElement frame : allframes) {
				if (frame.getAttribute("name").equals(framename)) {
					driver.switchTo().frame(framename);
				}

			
		
		

	}
	}
