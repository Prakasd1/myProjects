package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.baseclass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.myAccountPage;
import io.cucumber.java.en.*;


public class LoginSteps {
	
	public WebDriver driver;
	HomePage hp;
	LoginPage lp;
	myAccountPage mAcc;
	
	
	
	@Given("User navigate to myAccount button")
	public void user_navigate_to_my_account_button() {
	   hp = new HomePage(baseclass.getDriver());
	   hp.MyAccount_btn();
	   hp.Login_btn();
	}
	
	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
	   lp = new LoginPage(baseclass.getDriver());
	   lp.set_Email(email);
	   lp.set_password(pwd);
	}
	
	@When("Click on Login button")
	public void click_on_login_button() {
	    lp.click_Login();
	}
	
	@Then("Validate user on myAccount page")
	public void validate_user_on_my_account_page() {
		mAcc = new myAccountPage(baseclass.getDriver());
		try {
		boolean tagetPage = mAcc.myAccountbtnExist();
		Assert.assertEquals(tagetPage, true);
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Then("I should see an error message informing the User about invalid credentials")
	public void i_should_see_an_error_message_informing_the_user_about_invalid_credentials() throws InterruptedException {
	    
		Thread.sleep(2000);
		String textMsg = lp.alertMsg();
		System.out.println(textMsg);
		Assert.assertEquals(textMsg, "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@When("User leave the field as blank")
	public void user_leave_the_field_as_blank() throws InterruptedException {
	    
		
		Thread.sleep(1000);
		lp = new LoginPage(baseclass.getDriver());
		lp.click_Login();
	}

}
