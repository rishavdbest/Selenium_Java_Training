package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/tagsDemo.feature",
        glue = {"stepdefinations"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/tagsDemo.html"
        },
        monochrome = true,
        dryRun = false,
        tags = "@wdw or @sanity"
)
public class TestRunner {
}
