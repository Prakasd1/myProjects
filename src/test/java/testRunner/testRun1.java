package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				//features = {".//FeatureFiles/"},
				//features = {".//FeatureFiles/Login.feature"},
				features = {".//FeatureFiles/Search.feature"},
				glue = "stepDefination",
				plugin= {"pretty", "html:reports/myreport.html", 
								  "rerun:target/rerun.txt",
								  //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},		  
				dryRun=false,
				tags = "@Three"
				)
	

public class testRun1 {

}
