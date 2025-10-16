package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.Search_Page;

public class TC004_SearchProduct extends BaseClass {

	
	@Test (priority=1)
	public void verifysearchpage() {
		logger.info("******Search Test Starts.... *******");
		Home_Page hp=new Home_Page(driver);
		hp.Searchproduct("iphone");
		hp.ClickonSearchicon();
		Search_Page sp=new Search_Page(driver);
		String act=sp.issearchpageisexist();
		Assert.assertEquals(act, "Search - iphone");
		logger.info("******Search Test Ends.... *******");
		
	}
	
	@Test (priority=2)
	public void Verifyaddproduttocart() {
		Search_Page sp=new Search_Page(driver);
		sp.ClickSearchinproductdescriptions();
		sp.ClickonSearch();
		sp.SelectSortByDrp("Price (Low > High)");
		sp.selectshowdrp("25");
		sp.Clickonaddtocart();
		String actualaddtocartmsg=sp.addtocartmessage();
			System.out.print(actualaddtocartmsg);	
		Assert.assertEquals(actualaddtocartmsg, "Success: You have added iPod Nano to your shopping cart! ×");
	}
}
