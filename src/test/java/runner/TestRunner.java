package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:target/JUnitReports/report.xml",
                "json:target/JSONReports/report.json",
                "html:target/HtmlReports"},
        monochrome = true,
        features = {"src/test/resources/"},
        glue = {"Steps"}
//        ,tags= "@scenario1"

)

public class TestRunner {
}
