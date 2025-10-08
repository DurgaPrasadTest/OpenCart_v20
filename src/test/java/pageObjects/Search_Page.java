package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_Page extends BasePage {

	public Search_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='Search - iphone']")
	WebElement txtmessage;
	
	public String issearchpageisexist() {
		
		return (txtmessage.getText());
			
		}

}
