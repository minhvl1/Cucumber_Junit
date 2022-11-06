package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber","summary"}
        ,features = {"src/test/resources"}
        ,glue = {"Steps"}
//        ,tags= "@scenario1"
        ,snippets = CAMELCASE
)

public class TestRunner {
}
