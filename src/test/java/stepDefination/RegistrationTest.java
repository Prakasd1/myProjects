package stepDefination;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Factory.baseclass;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.myAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationTest {
	
	WebDriver driver;
	HomePage hp;
	RegistrationPage regPage;
	myAccountPage mp;
	
	
	@Given("User navigate to My Account button")
	public void user_navigate_to_my_account_button() {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		hp = new HomePage(baseclass.getDriver());
		hp.MyAccount_btn();
	  
	}
	
	@Given("click on register option")
	public void click_on_register_option() {
		
		hp.Register_btn();
		regPage = new RegistrationPage(baseclass.getDriver());
	 }
	
	@When("Enter the valid details")
	public void enter_the_valid_details(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		regPage.firstName_txt(dataMap.get("First Name"));
		regPage.lastName_txt(dataMap.get("Last Name"));
		regPage.email_txt(baseclass.randomAlphaNumeric()+"@gmail.com");
		regPage.password_txt(dataMap.get("Password"));
				
	}
	
	@When("Click on subscribe button")
	public void click_on_subscribe_button() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)baseclass.getDriver();
		js.executeScript("window.scrollBy(0, 400)");
		regPage.newsletter_btn();
	}
	
	@When("Click on Privacy Policy button")
	public void click_on_privacy_policy_button() throws InterruptedException {
		Thread.sleep(4000);
		regPage.privacyPolicy_btn();
	}
	
	@When("Click on Continue button")
	public void Click_on_continue_button() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)baseclass.getDriver();
		js.executeScript("window.scrollBy(0, 300)");
		Thread.sleep(4000);
		regPage.btn_continue();
	}
	
	@Then("Validate account successfully Created")
	public void validate_account_successfully_created() throws InterruptedException {
	   mp = new myAccountPage(baseclass.getDriver());
	   String cnfrmsg = mp.getsuccess_msg();
	   System.out.println(cnfrmsg);
	   Assert.assertEquals(cnfrmsg, "Your Account Has Been Created!");
	   
	   Thread.sleep(5000);
	   mp.clickonContinuebtn();
	}
	
	@Then("Validate My Account Category exists")
	public void validate_my_account_category_exists() {
	    try {
		boolean targetpage = mp.myAccountbtnExist();
		Assert.assertEquals(targetpage, true);
	    }
	    catch(Exception e)
		{
			Assert.fail();
		}

	}
	
	
	@Then("User Account should not created")
	public void user_account_should_not_created() {
	    try {
		boolean btn_register = regPage.register_success();
		Assert.assertEquals(btn_register, true);}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
	
	@Then("User should see the error messages")
	public void user_should_see_the_error_messages() {
		
		String PrivacyPolicy = regPage.warn_PrivacyPolicymsg();
		Assert.assertEquals(PrivacyPolicy, "Warning: You must agree to the Privacy Policy!");
		
		String First_name = regPage.warn_firstNamemsg();
		Assert.assertEquals(First_name, "First Name must be between 1 and 32 characters!");
		
		String Last_name = regPage.warn_lastNamemsg();
		Assert.assertEquals(Last_name, "Last Name must be between 1 and 32 characters!");
			
		String Password = regPage.warn_passwordmsg();
		Assert.assertEquals(Password, "Password must be between 4 and 20 characters!");
		
		String Email = regPage.warn_emailmsg();
		Assert.assertEquals(Email, "E-Mail Address does not appear to be valid!");
		
		
		
	}
	
	
}
