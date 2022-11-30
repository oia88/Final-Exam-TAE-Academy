package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void typeOnInput(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clickElement(WebElement element){
        waitForVisibility(element);
        element.click();
    }

    public void switchToIframe(WebElement frameToChange){
        waitForVisibility(frameToChange);
        getDriver().switchTo().frame(frameToChange);
    }
}
