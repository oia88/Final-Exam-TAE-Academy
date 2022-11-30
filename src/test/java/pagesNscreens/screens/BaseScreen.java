package pagesNscreens.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseScreen {

    protected final AndroidDriver driver;

    /**
     * The log.
     */
    public Logger log = Logger.getLogger(BaseScreen.class);

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(0)), this);
    }

    /**
     * Swipe vertical.
     *
     * @param percentage of swipe
     */
    @SuppressWarnings({"rawtypes", "unused"})
    public void swipeVertical(float percentage) {
        Dimension windowSize = driver.manage().window().getSize();
        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point(207, 582)).moveTo(PointOption.point(
                8,-360)).release().perform();
    }


    /**
     * Wrapper for click  event specifying custom wait.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void clickWait(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for sendKeys event.
     *
     * @param element   : AndroidElement
     * @param sequence: String
     * @author Hans.Marquez
     */
    public void sendKeys(WebElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @param timeout : int
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Initialize the scroll up/down function.
     * @param locator : Locator
     * @param swipes : Moves into screen
     * @autor Oscar.Araque
     */
    public void scroll(String locator, int swipes){
        int count = 0;
        while(count < swipes){
            try {
                driver.findElementByAndroidUIAutomator(locator);
                count++;
            } catch (Exception e){
                count++;
            }
        }
    }


    /**
     * Do the scroll down functionality.
     * @param swipes : Moves into screen
     * @autor Oscar.Araque
     */
    public void scrollDown(int swipes){
        String locator = "new UiScrollable(.scrollable(true)).scrollToEnd(1)";
        scroll(locator, swipes);
    }
}
