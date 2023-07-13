package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources",
    glue = {"StepDefinition", "Hooks"},
    tags = "@uploadfile or @scrollelement", // Specify the desired tag(s) here
    plugin = {"pretty", "html:target/cucumber-reports/reports_html.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
