package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Search_Page extends BasePage {

	public Search_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='Search - iphone']")
	WebElement txtmessage;
	
	@FindBy(xpath="//input[@id=\"description\"]")
	WebElement ChbxSearchinproductdescriptions;
	
	@FindBy(xpath="//input[@id=\"button-search\"]")
	WebElement BtnSearch;
	
	@FindBy(xpath="//select[@id=\"input-sort\"]")
	WebElement DrpSortBy;
	
	@FindBy(xpath="//select[@id=\"input-limit\"]")
	WebElement Drpshow;
	
	@FindBy(xpath="//div[@class=\"product-thumb\"][contains(.,'iPod Nano')]//span[@class=\"hidden-xs hidden-sm hidden-md\"]")
	WebElement Btnaddtocart;
	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement textmsg;
	
	public String issearchpageisexist() {
		
		return (txtmessage.getText());
			
		}
	
	public void ClickSearchinproductdescriptions() {
		ChbxSearchinproductdescriptions.click();
	}
	
	public void ClickonSearch() {
		BtnSearch.click();
	}
	
	public void SelectSortByDrp(String sortvalue) {
		
		Select sortbyvalue=new Select(DrpSortBy);
		sortbyvalue.selectByVisibleText(sortvalue);
		
	}
	
	public void selectshowdrp(String shvalue) {
		Select showvalue=new Select(Drpshow);
		showvalue.selectByVisibleText(shvalue);
	}
	
	public void Clickonaddtocart() {
		Btnaddtocart.click();
	}
	
	public String addtocartmessage() {
		return (textmsg.getText());
		
	}

}
