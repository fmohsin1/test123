package com.bit.test;


	import java.io.IOException;
	import java.util.Properties;

	import org.apache.log4j.xml.DOMConfigurator;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterGroups;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeGroups;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

	public class Logger {

		WebDriver driver;

		Properties prop;
		String browser;	
		org.apache.log4j.Logger log;
		
		@BeforeSuite
		public void beforeSuit() throws IOException {
			DOMConfigurator.configure("log4j.xml");
			//log=Logger.getLogger(Logger.class);
			log=org.apache.log4j.Logger.getLogger(org.apache.log4j.Logger.class);
			log.info("File initialized");

			

		}

		@AfterSuite
		public void afterSuite() {

			System.out.println("afterSuite");

		}

		@BeforeTest
		public void beforeTest() throws IOException {
			prop = ReadFile.readFile("C:\\Users\\Urmi\\eclipse-" + "workspace\\TestNgPractice\\config.properties");
			browser = prop.getProperty("browser");

			System.out.println("beforeTest");
		}

		@AfterTest
		public void afterTest() throws InterruptedException {

			Shared.sleep(5000);
			System.out.println("afterTest");
		}

		@BeforeGroups
		public void beforeGroups() {
			System.out.println("beforeGroups");
		}

		@AfterGroups
		public void afterGroups() {
			System.out.println("afterGroups");

		}

		@BeforeClass
		public void beforeClass() {

			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Urmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Urmi\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\Urmi\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}

			System.out.println("beforeClass");

		}

		@AfterClass
		public void afterClass() {
			driver.quit();
			System.out.println("afterClass");

		}

		@BeforeMethod
		public void beforeMethod() {

			driver.get("https://www.target.com");
			System.out.println("beforeMethod");
			log.info("File initialized");

		}

		@AfterMethod
		public void afterMethod(ITestResult r) {
			switch(r.getStatus()) {
			case ITestResult.FAILURE:{
				Shared.screenShoot(driver);
				log.info(r.getName()+"failed");
			}
			
			
			
			}
			System.out.println("afterMethod");
		}

	}


