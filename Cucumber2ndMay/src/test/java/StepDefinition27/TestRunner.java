package StepDefinition27;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

(
		features="src/test/java/FeatureFiles/",
		glue= {"StepDefinition27"},
		tags= "@sanity",
		dryRun=false,
		monochrome=false,
		
		plugin = {"pretty","html:target/HtmlReports/index.html"
				,
				
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
//		plugin = {"pretty","rerun:target/failed_scenarios.txt"
//				,
//				
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//		
		
		
		
		
		
		
		
		)













public class TestRunner {
	
	
	

}
