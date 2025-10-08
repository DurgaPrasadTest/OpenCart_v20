package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.Search_Page;

public class TC004_SearchProduct extends BaseClass {

	
	@Test
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
}
