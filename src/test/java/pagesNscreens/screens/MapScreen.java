package pagesNscreens.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

// TODO: Auto-generated Javadoc

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    @AndroidFindBy(xpath =
            "//android.widget.LinearLayout" +
                    "[@content-desc=\"Attractions, Category, Collapsed, 1of11, button\"]" +
                    "/android.widget.ImageView")
    private AndroidElement categoryButton;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/facilityTypeList")
    private AndroidElement categoryList;


    @AndroidFindBy(xpath = "//android.widget.LinearLayout" +
            "[@content-desc=\"Hotels, Category, 10of11, button\"]")
    private AndroidElement hotelOption;



    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }


    /**
     * @author Hans.Marquez
     * return true if Hotel option element is displayed in screen, otherwise false.
     */
    public boolean hotelIsDisplayed() {
        return isElementAvailable(hotelOption);
    }


    /**
     * @autor Oscar.Araque
     * Access into Category list section.
     */
    public void clickCategoryList() { click(categoryButton); }

}
