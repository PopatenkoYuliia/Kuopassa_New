package runner;

import configurations.CucumberHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenarios/kuopassa.feature",
        glue = "stepdefinitions")

public class RunnerTests {
}
