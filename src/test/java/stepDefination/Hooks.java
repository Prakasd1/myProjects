package stepDefination;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.baseclass;
import io.cucumber.java.*;

public class Hooks {
	
	WebDriver driver;
	Properties p;
	
	@Before
	public void setUp() throws IOException {
		
		driver =  baseclass.initilizeBrowser();
		
		p = baseclass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	 @AfterStep
	    public void addScreenshot(Scenario scenario) {
	        
	    	// this is for cucumber junit report
	        if(scenario.isFailed()) {
	        	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        	            
	        }
	      
	    }

}
