package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Account_Registration_Page;
import pageObjects.Home_Page;

public class TC001_AccountRegistration extends BaseClass {
	
	
	@Test (groups= {"sanity","regression","reg"})
	public void verifyaccountregisteration()
	{
		logger.info("****** Click on My Account Page *******");
		Home_Page hp=new Home_Page(driver);
		hp.clickOnMyaccount();
		
		logger.info("****** Click on My Registration Page *******");
		hp.clickOnRegister();
		
		logger.info("****** Enter User details for account creation *******");
		Account_Registration_Page acr=new Account_Registration_Page(driver);
		acr.Efirstname(randomstring().toUpperCase());
		acr.Elasttname(randomstring().toUpperCase());
		acr.Eemail(randomstring()+"@gmail.com");
		acr.Etelepohone(randomnumber());
		
		String pwd=randomAlphaNumberic();
		acr.Epassword(pwd);
		acr.Econfirmpassword(pwd);
		acr.Cyes();
		acr.Cprivcaypolicy();
		
		logger.info("****** Submit the form with user details *******");
		acr.Ccontinue();
		
		
		String actual=acr.confirmation();
		if(actual.equals("Your Account Has Been Created!")) {
			logger.info("****** Account Successfully completed *******");
			Assert.assertTrue(true);
		}
		else {
			logger.error("****** Account registration failed *******");
			Assert.assertTrue(false);
		}
		
	}

	
	
}
