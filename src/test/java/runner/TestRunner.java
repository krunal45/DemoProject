package runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;



    @CucumberOptions(
    tags = {"@APITest"},
    features = {"src/test/resources/features/UserRegistration.feature"},
    glue = {"src/test/java/steps/APISteps.java"},
    strict = true,
    dryRun = false)

public class TestRunner {
}
