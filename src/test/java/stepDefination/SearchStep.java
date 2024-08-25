package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.baseclass;
import PageObjects.HomePage;
import PageObjects.SearchresultPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {
	
	public WebDriver driver;
	public HomePage hp;
	public SearchresultPage sp;
	

	
	@When("I search for a product {string}")
	public void i_search_for_a_product(String product) {
		hp = new HomePage(baseclass.getDriver());
		hp.text_searchBox(product);
	    hp.btn_search();
			
	}

	@Then("I should see the product in the search results address")
	public void i_should_see_the_product_in_the_search_results_address() {
	   
		sp = new SearchresultPage(baseclass.getDriver());
		 try {
				boolean productName = sp.isProductExists();
				Assert.assertEquals(productName, true);}
				catch(Exception e)
				{
					Assert.fail();
				}
		
	}
	
	@Then("I should see the page displaying the message")
	public void i_should_see_the_page_displaying_the_message() {
	    
		sp = new SearchresultPage(baseclass.getDriver());
		String errorMessage = sp.ErrorMsgDisplayed();
		Assert.assertEquals(errorMessage, "There is no product that matches the search criteria.");
	}

}
