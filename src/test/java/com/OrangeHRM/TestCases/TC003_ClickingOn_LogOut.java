package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.TestBase.BaseClass;

public class TC003_ClickingOn_LogOut extends BaseClass {

	@Test
	public void logout() throws InterruptedException, IOException {
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickLoginButton();
		lp.clickLogoutArrow();
		Thread.sleep(3000);
		lp.clickLogoutBtn();
		capturescreen(driver, "logOut");
		
		
		
		
	}
}
