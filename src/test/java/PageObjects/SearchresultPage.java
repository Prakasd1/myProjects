package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchresultPage extends basePage {

	public SearchresultPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//a[normalize-space()='Samsung SyncMaster 941BW']")
	WebElement productName;
	
	@FindBy(css = "div[id='content'] p")
	WebElement errMsg;
	
	@FindBy(css = ".description h4 a")
	List<WebElement> allProducts;
	
	@FindBy(css = ".product-thumb")
	List<WebElement> products;
	
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
	
	 public List<String> getProductNames() {
	        // Using Java Streams to collect the text of each product link
	        return allProducts.stream()
	                          .map(WebElement::getText) // Extract text from each WebElement
	                          .collect(Collectors.toList()); // Collect as a List
	    }
		
		 public void clickProductByName(String productName) { 
			
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        for (WebElement product : products) {
		            String productTitle = product.findElement(By.cssSelector(".description h4 a")).getText();
		            System.out.println("Product Title: " + productTitle);
		            
		            if (productTitle.equalsIgnoreCase(productName)) {
		                // Use a CSS selector to locate the Add to Cart button
		                WebElement addToCart = product.findElement(By.cssSelector("button[title='Add to Cart']"));
		                
		                // Scroll into view and wait for the button to be clickable
		                js.executeScript("arguments[0].scrollIntoView(true);", addToCart);
		                wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		                
		                // Click using JavaScript executor for reliability
		                js.executeScript("arguments[0].click();", addToCart);
		                break;
		            }
		        }
			 
						 
		 }
		
	 
	 public boolean isProductPresent(String productName) {
	        return allProducts.stream()
	                .anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	    }
	
}

	
	

