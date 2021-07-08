package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.TestBase.BaseClass;

public class TC001_LoginTest_CallingFrom_BaseClass extends BaseClass {

	//1. 
	//2. Launching Browser --> No Need to apply step 1 and 2
	
	public String expTitle = "OrangeHRM";
	
	//3. Test
	@Test
	public void test() throws IOException {
		
		logger.info("*****Starting Test Cases - TC001 Login_Test******");
		
		driver.get(prop.getProperty("url"));
		
		logger.info("*****Application is Opened******");
		
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("*****Entering Login Details********");
		lp.setUserName(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		String actTitle = driver.getTitle();
		System.out.println("Application Title After Login is - " + actTitle);
		if (actTitle.equalsIgnoreCase(expTitle)) {
			logger.info("******Login Successful*********");
			Assert.assertTrue(true);		
			capturescreen(driver, "Main Method Test");
		} else {
			logger.info("******Login is not Successful*********");
			Assert.assertTrue(false);
		}
		logger.info("*****Ending Test Cases - TC001 Login_Test******");
	}
	
}
