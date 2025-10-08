package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage {

	public Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText="My Account") 
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtsearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement lnksearchicon;
	
	public void clickOnMyaccount() {
		lnkMyaccount.click();
	}
	
	public void clickOnRegister() {
		lnkRegister.click();
	}
	
	public void clickOnLogin() {
		lnklogin.click();
	}
	
	public void Searchproduct(String productname) {
		txtsearch.sendKeys(productname);;
	}
	
	public void ClickonSearchicon() {
		lnksearchicon.click();
	}

}
