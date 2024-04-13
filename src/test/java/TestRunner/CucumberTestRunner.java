package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Gopi Appapuram
 * 
 * Runner class to run as Cucumber Test-NG File.
 */


// Configurations for Cucumber Test Runner
@CucumberOptions(
		tags = "", // Define the tags to be executed (if any)
		features = { "src/test/resources/Feature" }, // Path to feature files
		glue = { "StepDefinations" }, // Package where step definitions are located
		plugin = {
					"pretty", // Prints the output in a readable format
					"html:test-output/CucumberReports/htmlreport.html" // Generates HTML report
					}
		)

// Extends AbstractTestNGCucumberTests to run Cucumber tests with TestNG
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
