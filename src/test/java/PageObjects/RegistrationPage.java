package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends basePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id = "input-firstname")
	WebElement txt_firstName;
	
	@FindBy (id = "input-lastname")
	WebElement txt_lastName;
	
	@FindBy (id = "input-email")
	WebElement txt_email;
	
	@FindBy (id = "input-password")
	WebElement txt_password;
	
	@FindBy (id = "input-newsletter")
	WebElement btn_newsletter;
	
	@FindBy (xpath = "//input[@name='agree']")
	WebElement btn_PrivacyPolicy;
	
	@FindBy (xpath = "//button[normalize-space()='Continue']")
	WebElement btn_continue;
	
	@FindBy (xpath = "(//a[contains(text(),'Register')])[2]")
	WebElement text_register;
	//=====
	@FindBy (css =".alert.alert-danger.alert-dismissible")
	WebElement warn_privecy;
	
	@FindBy (xpath = "//div[@id='error-firstname']")
	WebElement warn_firstname;
	
	@FindBy(xpath = "//div[@id='error-lastname']")
	WebElement warn_lastName;
	
	@FindBy (xpath = "//div[@id='error-email']")
	WebElement warn_email;
	
	@FindBy (xpath = "//div[@id='error-password']")
	WebElement warn_password;
	
	
	public void firstName_txt(String fname) {
		txt_firstName.sendKeys(fname);
	}
	
	public void lastName_txt(String lname) {
		txt_lastName.sendKeys(lname);
	}
	
	public void email_txt(String email) {
		txt_email.sendKeys(email);
	}
	
	public void password_txt(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void newsletter_btn() {
		btn_newsletter.click();
	}
	
	public void privacyPolicy_btn() {
		btn_PrivacyPolicy.click();
	}
	
	public void btn_continue() {
		btn_continue.click();
	}
	
	public boolean register_success() {
		try {
		return(text_register.isDisplayed());
		} catch (Exception e){
			return(false);
		}
	}
	
	public String warn_PrivacyPolicymsg() {
		
		try { return(warn_privecy.getText());}
		catch(Exception e) { return(e.getMessage()); }
	}
	
	public String warn_firstNamemsg() {
		
		try { return(warn_firstname.getText());}
		catch(Exception e) { return(e.getMessage()); }
	}
	
	public String warn_lastNamemsg() {
		
		try { return(warn_lastName.getText());}
		catch(Exception e) { return(e.getMessage()); }
	}
	
	public String warn_emailmsg() {
		
		try { return(warn_email.getText());}
		catch(Exception e) { return(e.getMessage()); }
	}
	
	public String warn_passwordmsg() {
		
		try { return(warn_password.getText());}
		catch(Exception e) { return(e.getMessage()); }
	}

	
	
	
	
	
	
	
	
	
	

}
