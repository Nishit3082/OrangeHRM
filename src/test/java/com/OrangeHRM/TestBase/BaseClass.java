package com.OrangeHRM.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//1.
	public WebDriver driver;
	public Properties prop;//Configs
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2. Launching browser
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException {
		
		/*****Config.property*****/
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(br.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Please pass Chrome / Firefox / IE as browser name");
		}
		
		driver.manage().window().maximize();
	}
		
		//4. Closing All Windows
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
		
		//Capturing ScreenShots
		public void capturescreen(WebDriver driver, String testName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
			FileUtils.copyFile(source, target);
			System.out.println("Captured Screenshot");
		}
		
		
}
