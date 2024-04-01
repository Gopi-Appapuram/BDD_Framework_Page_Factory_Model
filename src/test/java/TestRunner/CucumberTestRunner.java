package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "", 
		features = { "src/test/resources/Feature" }, 
		glue = { "StepDefinations" }, 
		plugin = {
					"pretty", 
					"html:test-output/CucumberReports/htmlreport.html" 
					}
		)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}