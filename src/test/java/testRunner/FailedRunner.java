package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failedRerun.txt",
        glue = "stepDefination",
        monochrome = true,
        plugin = "rerun:target/failedRerun.txt")
public class FailedRunner {
}
