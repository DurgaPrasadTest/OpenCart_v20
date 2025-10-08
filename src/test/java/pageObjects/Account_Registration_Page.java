package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Registration_Page extends BasePage {

	public Account_Registration_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirmpassword;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement rdyes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rdno;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement ckbprivacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirm;
	
	public void Efirstname(String fname) {
		
		txtfirstname.sendKeys(fname);
		
	}
	
    public void Elasttname(String lname) {
		
		txtlastname.sendKeys(lname);
		
	}
    
   public void Eemail(String email) {
		
		txtemail.sendKeys(email);
		
	}
   
   public void Etelepohone(String telephone) {
		
 		txttelephone.sendKeys(telephone);
 		
 	}
   
   public void Epassword(String pwd) {
		
 		txtpassword.sendKeys(pwd);
 		
 	}
   
   public void Econfirmpassword(String cpwd) {
		
 		txtconfirmpassword.sendKeys(cpwd);
 		
 	}
	
   public void Cyes() {
		
 		rdyes.click();
 		
 	}
   
   public void Cno() {
		
		rdno.click();
		
	}
   
   public void Cprivcaypolicy() {
		
	   ckbprivacypolicy.click();
		
	}
   
   public void Ccontinue() {
		
	   btncontinue.click();
		
	}
   
   public String confirmation() {
	   try {
		return (msgconfirm.getText());
	} catch (Exception e) {
		return (e.getMessage());
	}
   }
   
   
   
}
