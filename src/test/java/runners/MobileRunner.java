package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/mobile/disneylandMobile.feature"
        ,glue = {"steps.mobile#Mobilesteps"}
        ,plugin = {"pretty"
                , "html:target/cucumber-Report.html"
                , "json:target/report.json"
        })

public class MobileRunner extends AbstractTestNGCucumberTests {}

