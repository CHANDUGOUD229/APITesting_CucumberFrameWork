package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features",
        glue = "stepDefination",
        monochrome = true,

                plugin = {"json:target/jsonReports/cucumber-report.json",
                "rerun:target/failedRerun.txt" // it will create the file for failed scenarios
        }
)

public class TestRunner {
//    tags = "@deletePlace"
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

}
