package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends basePage {

	public myAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement welcome_msg;
	
	@FindBy (xpath = "//a[normalize-space()='Continue']")
	WebElement btn_continue;
	
	@FindBy (xpath = "//h2[normalize-space()='My Account']")
	WebElement mAcc_cat;
	
	public String getsuccess_msg() {
		
		try {
			return (welcome_msg.getText());
		} catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickonContinuebtn() {
		btn_continue.click();
	}

	public boolean myAccountbtnExist() {
		try {
		return (mAcc_cat.isDisplayed());
		}
		catch (Exception e) {
			return(false);
		}
		
	}
}
