package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//1.
	public WebDriver driver;
	
	//2.Create Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver; // Assigning the Driver passed from Test Case to Local WebDriver driver
		PageFactory.initElements(driver, this);//We are initializing this driver.. elements
											   // this--> Passing your Local one to Global one	
	}
	
//Below are called PAGE OBJECTS--> Our job is to defined first Page Objects.
	//3. Locator for UserName
		@FindBy(id="txtUsername")
		@CacheLookup
		WebElement txtUsername;
	
	//4. Locator for password
		@FindBy(id="txtPassword")
		@CacheLookup
		WebElement txtPassword;
	
	//5. Locator for loginButton
		@FindBy(id="btnLogin")
		@CacheLookup
		WebElement btnLogin;
	
	//6. Arrow next to the username to Logout 
		@FindBy(id="welcome")
		@CacheLookup
		WebElement lnkLogoutArrow;
	
	//7. Text after clicking on Arrow to Logout
		@FindBy(xpath="//a[contains(text(),'Logout')]")
		@CacheLookup
		WebElement lnkLogoutText;
	
	//8. Forgot Password Link
		@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
		@CacheLookup
		WebElement lnkForgotPasswordText;
	
	//9. OrangeHRM Link
		@FindBy(xpath="//a[contains(text(),'OrangeHRM, Inc')]")
		@CacheLookup
		WebElement lnkOrangeHRMIncText;
	
//Create Method for Entering All Values into Elements
	//1. Entering UserName
		public void setUserName(String uname) {
			txtUsername.clear();//Always clear the entered Value
			txtUsername.sendKeys(uname);
		}
	
	//2. Entering Password
		public void setPassword(String pwd) {
			txtPassword.clear();
			txtPassword.sendKeys(pwd);
		}
	
	//3. Clicking on Login Button
		public void clickLoginButton() {
			btnLogin.click();
				
		}
	
	//4. Clicking on Logout Arrow 
		public void clickLogoutArrow() {
			lnkLogoutArrow.click();
		}
		
	//5. Clicking on Logout Button
		public void clickLogoutBtn() {
			lnkLogoutText.click();
		}
	
	//6. Clicking on Forgot Password Link
		public void clickforgotpwdLink() {
			lnkForgotPasswordText.click();
		}
		
	//7. Clicking on OrangeHRM Link
		public void clickOrangeHRMLink() {
			lnkOrangeHRMIncText.click();
		}
		
}