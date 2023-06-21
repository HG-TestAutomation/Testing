package testrunners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.qa.util.SendEmailAttachment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = {"src/test/resources/AppFeatures/Login.feature"},
	        glue = {"stepdefinitions", "AppHooks"},
	        		// dryRun = true,
	        plugin = {"pretty",
	                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	                "rerun:target/rerun.txt"  // Save Failed test scenarios in rerun.txt file
	        }, 
	        monochrome = true,
	        publish = false
	)

public class TestRunnerIT {
	@AfterClass
	public static void sendEmail() {
	//	SendEmailAttachment.main(null);
	}

}
