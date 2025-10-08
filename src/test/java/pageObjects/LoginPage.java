package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement headertxt;
	
	public void Eemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void Epassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void clickonlogin() {
		lnkLogin.click();
	}
	
	public String getheadertxt() {
		return (headertxt.getText());
	}
}
