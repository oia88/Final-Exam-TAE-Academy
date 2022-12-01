package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/ui"
        ,glue = {"steps.ui.UiSteps"}
        ,plugin = {"pretty"
                    , "html:target/cucumber-Report.html"
                    , "json:target/report.json"
                    })

public class WebRunner extends AbstractTestNGCucumberTests {

}
