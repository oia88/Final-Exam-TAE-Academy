package pagesNscreens.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/skip_text")
    private AndroidElement skipButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Close\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(accessibility = "Map, Tab, 2of5")
    private AndroidElement mapButton;

    @AndroidFindBy(accessibility = "More Options, Tab, 5of5")
    private AndroidElement burgerMenuButton;

    @AndroidFindBy(accessibility = "Privacy & Legal button")
    private AndroidElement privacyLegalButton;

    @AndroidFindBy(uiAutomator = "new UiSelector()" +
            ".resourceId(\"com.disney.wdpro.dlr:id/privacy_and_legal_elements\")")
    private AndroidElement privacyLegalList;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/tab_animated_icon")
    private AndroidElement addPlansButton;

    @AndroidFindBy(accessibility = "Check Dining Availability, 1 of 7, button")
    private AndroidElement reserveDiningOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    private AndroidElement welcomeBanner;

    /**
     * @author Hans.Marquez
     * Navigate to Map Screen from DashBoard Screen.
     */
    public void goToDashboardScreen() {
        if (this.isElementAvailable(skipButton, 25)){
            click(skipButton);
        }

        isElementAvailable(mapButton);

        log.info(this.isElementAvailable(dismissWelcome, 45));
            click(dismissWelcome);

        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }

     public void waitForInvisibility(AndroidElement element){
         WebDriverWait wait = new WebDriverWait(driver, 25);
         wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * @autor Oscar.Araque
     * Continues the navigation into the Dashboard Screen
     * @return Access to Map Screen
     */
    public MapScreen goToMapScreen() {
        goToDashboardScreen();
        click(mapButton);
        return new MapScreen();
    }


    /**
     * @autor Oscar.Araque
     * Return true if Burger Menu Tab element is displayed in screen, otherwise false.
     */
    public void navigatePrivacyLegalOption(){
        if (this.isElementAvailable(burgerMenuButton, 25)){
            click(burgerMenuButton);
        }
    }

    /**
     * @autor Oscar.Araque
     * Scroll down the screen until the edge and clicks the Privacy & Legal element.
     */
    public void scrollAndClickPrivacyLegalButton(){
        scrollDown(3);
        click(privacyLegalButton);
    }

    /**
     * @autor Oscar.Araque
     * @return true if Privacy & Legal list is displayed in screen, otherwise false.
     */
    public boolean privacyLegalOptionsListIsDisplayed() {
        return isElementAvailable(privacyLegalList);
    }

    /**
     * @autor Oscar.Araque
     * Navigate into the Add Plans' list.
     */
    public void navigateIntoAddPlans(){
        if (this.isElementAvailable(addPlansButton,25)){
            click(addPlansButton);
        }
    }

    /**
     * @autor Oscar.Araque
     * @return true if Reserve Dining Available element is displayed in screen, otherwise false.
     */
    public boolean reserveDiningOptionIsDisplayed(){
        return isElementAvailable(reserveDiningOption);
    }
}
