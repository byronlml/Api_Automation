package co.com.apitesting.project.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.apitesting.project.stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //if you want to run all scenarios you can include tag or comment tag line @PostId
        //tags = "@PostId",
        plugin = {"pretty","html:target/cucumber-reports.html"}
)
public class RunnerTest {
}
