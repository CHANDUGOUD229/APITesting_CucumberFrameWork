package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features",
glue = "stepDefination",
monochrome = true,
plugin = "rerun:target/failedRerun.txt")
public class TestRunner {
//    tags = "@deletePlace"
}
