package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        monochrome = true,
        dryRun = false,
        glue = "stepdefinitions",
        plugin = {"html:target/cucumber-report/report.html,",
                "pretty:target/cucumber-report/cucumber-pretty.txt,",
                "junit:target/cucumber-report/cucumber-results.xml,",
                "json:target/cucumber-report/cucumber.json"},
        tags = "@Este")

public class TestRunner {

}