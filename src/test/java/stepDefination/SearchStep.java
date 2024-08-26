package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@Then("Valdate the exact product named with {string}")
	public void valdate_the_exact_product_named_with(String productName) {
		
		sp = new SearchresultPage(baseclass.getDriver());
		List<String> productNames = sp.getProductNames();
        System.out.println("Product Names: " + productNames);
        boolean isPresent = sp.isProductPresent(productName);
        Assert.assertTrue("Product " + productName + " is not present in the list", isPresent);
    
	    
	}

	@Then("Add the product to cart page with product name {string}")
	public void add_the_product_to_cart_page_with_product_name(String productName) {
		
		sp = new SearchresultPage(baseclass.getDriver());
		sp.clickProductByName(productName);
		
	}

}
