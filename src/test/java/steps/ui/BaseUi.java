package steps.ui;

import configuration.Driver;
import configuration.Reporter;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pagesNscreens.pages.HomePage;
import pagesNscreens.pages.WatchPage;

import static java.lang.String.format;

public class BaseUi {

    protected Driver driver;
    protected HomePage homePage;
    protected WatchPage watchPage;
    protected String url = "https://www.espnqa.com/?src=com&amp;_adblock=true&amp;espn=cloud";
    public Logger log = Logger.getLogger(BaseUi.class);

    //@Parameters({"browser", "url"})

    public void testSetup(String browser){
        driver = new Driver(browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
    }


    public void closeBrowser(){ driver.getDriver().quit(); }

    public <T> void checking(
            String description, T actualValue, Matcher<? super T> expectedValue){
        Reporter.info(
                format("Checking... " + description.toLowerCase() + "[Expectation: %s]", expectedValue));
        try{
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError error){
            Reporter.error(format("Assertion error: [%s]", error.getMessage()
                    .replaceAll("\n", "")));
        }
    }
}
