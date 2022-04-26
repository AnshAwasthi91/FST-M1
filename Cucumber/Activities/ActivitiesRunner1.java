package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinitions"},
        tags = "@activity1",
        plugin = { "pretty","html:target/cucumber/report.html" },
        monochrome = true
)

public class ActivitiesRunner1 {
    //empty
}
