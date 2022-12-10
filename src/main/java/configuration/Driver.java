package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private WebDriver driver;

    /**
     * defines which browser will execute the tests
     * @author Oscar.Araque
     * @param browser
     */
    public Driver(String browser) {
        switch (browser.toLowerCase()){
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox":  {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}