package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchresultPage extends basePage {

	public SearchresultPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//a[normalize-space()='Samsung SyncMaster 941BW']")
	WebElement productName;
	
	@FindBy(css = "div[id='content'] p")
	WebElement errMsg;
	
	
	public boolean isProductExists() {
		try {
		return(productName.isDisplayed());
		} catch (Exception e){
			return(false);
		}
	}
	
	

	public String ErrorMsgDisplayed() {
		try {return(errMsg.getText()); }
		catch (Exception e) {return(e.getMessage());}
}
	}

	
	

