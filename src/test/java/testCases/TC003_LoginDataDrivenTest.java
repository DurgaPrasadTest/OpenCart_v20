package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_LoginDataDriven(String email, String pwd, String exp) {
		
		logger.info("******Login DataDrivern Test Starts.... *******");
		try {
			Home_Page hm=new Home_Page(driver);
			hm.clickOnMyaccount();
			hm.clickOnLogin();
			
			LoginPage login=new LoginPage(driver);
			login.Eemail(email);
			login.Epassword(pwd);
			login.clickonlogin();
			
			MyaccountPage mac=new MyaccountPage(driver);
			boolean target=mac.isMyaccountpageexists();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(target==true) {
					mac.clickOnLogout();
					Assert.assertTrue(true);
					
				}
				else {
					Assert.assertTrue(false);
				}
				
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(target=true) {
					mac.clickOnLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}
		logger.info("******Login DataDrivern Test ends.... *******");
	}
}
