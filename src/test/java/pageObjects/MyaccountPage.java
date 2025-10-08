package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {

	public MyaccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkmyaccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgheading;
	
	public boolean isMyaccountpageexists() {
		try {
			return(msgheading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnLogout() {
		lnkLogout.click();
	}

}
