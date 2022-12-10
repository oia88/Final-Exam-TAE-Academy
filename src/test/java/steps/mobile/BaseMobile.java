package steps.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import pagesNscreens.screens.DashBoardScreen;
import pagesNscreens.screens.MapScreen;
import pagesNscreens.screens.TutorialScreen;


public class BaseMobile {

    public static AndroidDriver<AndroidElement> driver;
    public Logger log = Logger.getLogger(BaseMobile.class);

    public DashBoardScreen dashBoard;
    public MapScreen map;



    public void environmentSetUp() {
          dashBoard = new DashBoardScreen();
          map = new MapScreen();
      }


    public void mobileApplicationEnd() { driver.resetApp(); }


    protected DashBoardScreen loadDashBoardScreen() {
        TutorialScreen tutorialScreen = new TutorialScreen();
        tutorialScreen.startPermissionsProcess();
        return tutorialScreen.shareLocationPermissions();
    }
}
