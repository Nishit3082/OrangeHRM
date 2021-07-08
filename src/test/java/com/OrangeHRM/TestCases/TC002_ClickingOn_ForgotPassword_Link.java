package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.TestBase.BaseClass;


public class TC002_ClickingOn_ForgotPassword_Link extends BaseClass {

	//1.
	@Test
	public void forgotpasswordlink() throws IOException {
	
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.clickforgotpwdLink();
		
		//String name = driver.findElement(By.id("btnSearchValues")).getText();
		String name = driver.findElement(By.xpath("//input[@id='btnSearchValues']")).getText();
		System.out.println(name);
		capturescreen(driver, "forgotpasswordlink");
		
	}
	
	
	
}
