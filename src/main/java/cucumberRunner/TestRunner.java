package cucumberRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/",
        glue = "steps",
        plugin = {"pretty", "html:out"})
public class TestRunner {

}