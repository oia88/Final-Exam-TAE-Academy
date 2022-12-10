package configuration;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * @param driver initiate the driver in the constructor
     */
    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 4);
        initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void typeOnInput(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    /**
     * switch into de iframe context and interact with it
     * @param frameToChange
     * @author Oscar.Araque
     */
    public void switchToIframe(WebElement frameToChange){
        waitForVisibility(frameToChange);
        getDriver().switchTo().frame(frameToChange);
    }

    /**
     * Make a scroll and find the element
     * @param element
     * @ Oscar.Araque
     */
    public void scroll(WebElement element){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Check if an element is available
     * @param element
     * @return a boolean
     * @author Oscar.Araque
     */
    public boolean isElementAvailable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
