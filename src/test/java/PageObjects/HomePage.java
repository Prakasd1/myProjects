package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends basePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "//span[normalize-space()='My Account']")
	WebElement btn_myAccount;
	
	@FindBy (xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement btn_register;
	
	@FindBy (xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement btn_login;
	
	@FindBy (xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy (xpath = "//button[@data-lang='en-gb']")
	WebElement searchBtn;
	
		
	public void MyAccount_btn() {
		btn_myAccount.click();
	}
	
	public void Register_btn() {
		btn_register.click();
		
	}
	
	public void Login_btn() {
		btn_login.click();
		
	}
	
	public void text_searchBox(String product) {
		searchBox.sendKeys(product); }
	
	public void btn_search() {
		
		searchBtn.click();
	}
	

}
