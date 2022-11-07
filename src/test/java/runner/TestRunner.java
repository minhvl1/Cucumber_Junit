package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test or @Test4",
        plugin = {"pretty",
                "junit:target/JUnitReports/report.xml",
                "json:target/cucumber.json",
                "html:target/HtmlReports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/Features/"},
        glue = {"Steps"}
)

public class TestRunner {


}
