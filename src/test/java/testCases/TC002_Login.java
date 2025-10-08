package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.LoginPage;

public class TC002_Login extends BaseClass {
	
	@Test (groups= {"smoke","sanity","regression"})
	public void verifyLogin() {
		
		logger.info("******Login Page Test Starts.... *******");
		logger.info("****** Click on My Account Page *******");
		Home_Page hp=new Home_Page(driver);
		hp.clickOnMyaccount();
		
		logger.info("****** Click on Login Page *******");
		hp.clickOnLogin();
		
		logger.info("****** Enter user details for login *******");
		LoginPage login=new LoginPage(driver);
		login.Eemail(P.getProperty("username"));
		login.Epassword(P.getProperty("password1"));
		logger.info("****** Click on login buttom *******");
		login.clickonlogin();
		logger.info("****** Login Successful *******");
		String act=login.getheadertxt();
		Assert.assertEquals(act, "My Account");
		logger.info("****** Login Page Test Ends *******");
	}

	
}
