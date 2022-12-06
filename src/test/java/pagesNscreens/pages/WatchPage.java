package pagesNscreens.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WatchPage extends HomePage{

    public WatchPage(WebDriver driver) { super(driver); }

    @FindBy(css = ".BucketsContainer > div:nth-child(1) .CarouselSlide--active")
    private WebElement carouselSingle;
    @FindBy(css = ".WatchTile__Content span")
    private WebElement carouselTitle;
    @FindBy(css = ".WatchTile__Meta")
    private WebElement carouselDescription;
    @FindBy(css = ".BucketsContainer > div:nth-child(1) .CarouselSlide--inView:nth-child(2)")
    private WebElement carouselSecondItem;
    @FindBy(css = "[aria-label='Close dialog']")
    private WebElement carouselCloseButton;


    public boolean carouselIsDisplayed(){
        isElementAvailable(carouselSingle);
        return carouselSingle.isDisplayed();
    }

    public boolean carouselTitleIsDisplayed(){ return carouselTitle.isDisplayed(); }

    public boolean carouselDescriptionIsDisplayed(){ return carouselDescription.isDisplayed(); }

    public void clickSecondCarousel(){ clickElement(carouselSecondItem); }

    public boolean closeButtonIsDisplayed(){
        //isElementAvailable(carouselCloseButton);
        waitForClickable(carouselCloseButton);
        //waitForVisibility(carouselCloseButton);
        return carouselCloseButton.isDisplayed();
    }

    public void clickCloseButton(){
        //isElementAvailable(carouselCloseButton);
        //waitForClickable(carouselCloseButton);
        clickElement(carouselCloseButton);
    }

    public HomePage goBackPage(){
        getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
