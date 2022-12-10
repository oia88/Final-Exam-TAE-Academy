package pagesNscreens.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.String.format;

/**
 * Base class for all screens Objects.
 *
 * @author Arley.Bolivar
 */
public abstract class BaseScreen {

    /**
     * The driver.
     */
    protected static AndroidDriver<AndroidElement> driver;

    /**
     * The log.
     */
    public Logger log = Logger.getLogger(BaseScreen.class);

    static{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Capabilities.deviceSetUp(capabilities);
        Capabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Constructor method for standard screens object.
     *
     *
     * @author Arley.Bolivar, Hans.Marquez
     */
    public BaseScreen() {
        //this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(2)), this);
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
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
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
    public void sendKeys(AndroidElement element, String sequence) {
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
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
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
    public boolean isElementAvailable(AndroidElement element ,int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
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
