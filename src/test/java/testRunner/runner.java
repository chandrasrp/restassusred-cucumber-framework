package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/tests/features",
        glue = {"stepdefs"},
        plugin = {"pretty", "json:build/cucumber.json"}
)

public class runner {

}
