package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "input-email")
	WebElement txt_email;
	
	@FindBy(id = "input-password")
	WebElement txt_pwd;
	
	@FindBy (xpath = "//button[normalize-space()='Login']")
	WebElement btn_login;
	
	public void set_Email(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void set_password(String pwd) {
		txt_pwd.sendKeys(pwd);
	}
	
	public void click_Login() {
		btn_login.click();
	}
	
	
	
	

}
