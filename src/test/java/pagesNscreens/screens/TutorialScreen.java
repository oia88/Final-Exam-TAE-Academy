package pagesNscreens.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TutorialScreen extends BaseScreen{

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public TutorialScreen(AndroidDriver driver) {
        super(driver);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Don’t allow\")")
    private WebElement dismissNotifications;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Get Started\")")
    private WebElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Share Location\")")
    private WebElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    private WebElement allowLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"While using the app\")")
    private WebElement allowButton;


    /**
     * @author Hans.Marquez
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        click(dismissNotifications);
        click(getStartedButton);
    }

    /**
     * @author Hans.Marquez
     * Share Location permissions process.
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }
}
