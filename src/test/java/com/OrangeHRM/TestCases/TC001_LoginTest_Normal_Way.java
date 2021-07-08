package com.OrangeHRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_LoginTest_Normal_Way {
	
	//1
	public WebDriver driver;
	public String expTtile = "OrangeHRM";
	
	//2. Launching Browser
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//3. 
	@Test
	public void test() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickLoginButton();
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if (actTitle.equalsIgnoreCase(expTtile)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//4. Closing Window
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
