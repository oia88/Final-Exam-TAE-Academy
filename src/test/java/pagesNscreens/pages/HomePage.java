package pagesNscreens.pages;

import configuration.WebOperations;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends WebOperations {

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement banner;
    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;
    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css = "li.user ul.account-management li:nth-child(7)")
    private WebElement loginLink;
    @FindBy(css = "#oneid-wrapper > #oneid-iframe")
    private WebElement modal;
    @FindBy(css = "#logo")
    private WebElement espnLogo;
    @FindBy(id = "BtnSubmit")
    private WebElement loginButton;
    @FindBy(css = "#BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(css = "#logo")
    private WebElement titleSignUp;
    @FindBy(css = "#InputFirstName")
    private WebElement firstNameSignUp;
    @FindBy(css = "#InputLastName")
    private WebElement lastNameSignUp;
    @FindBy(css = "#InputEmail")
    private WebElement emailSignUp;
    @FindBy(css = "#password-new")
    private WebElement passwordSignUp;
    @FindBy(css = "form #BtnSubmit")
    private WebElement buttonSignUp;
    @FindBy(css = "#oneid-wrapper")
    private WebElement wrapperIframe;
    @FindBy(css = "#close")
    private WebElement closeButtonSignUp;
    @FindBy(css = "#global-nav > ul > li.pillar.watch > a")
    private WebElement watchLink;
    @FindBy(className = "display-user")
    private WebElement navText;
    @FindBy(css = ".account-management a.small")
    List<WebElement> userIconList;
    @FindBy(className = "display-user")
    private WebElement navTextLogOut;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean verifyBanner() {
        boolean isBanner = true;
        try {
            waitForVisibility(banner);
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    public void closeBanner() {
        if (this.verifyBanner()) {
            switchToIframe(banner);
            clickElement(bannerCloseButton);
        }
    }

    public void clickOnUserIcon() {
        clickElement(userIcon);
    }

    public void clickOnLoginLink() {
        clickElement(loginLink);
    }

    public void switchToIframeSection() {
        this.switchToIframe(modal);
    }

    public boolean modalIsDisplayed() {
        return modal.isDisplayed();
    }

    public boolean espnLogoIsDisplayed() {
        return espnLogo.isDisplayed();
    }

    public boolean loginButtonIsDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean signUpButtonIsDisplayed() {
        return signUpButton.isDisplayed();
    }


    public void clickSignUpButton() {
        clickElement(signUpButton);
    }

    public boolean titleSignUpIsDisplayed() {
        return titleSignUp.isDisplayed();
    }

    public boolean firstNameIsDisplayed() {
        return firstNameSignUp.isDisplayed();
    }

    public boolean lastNameIsDisplayed() {
        return lastNameSignUp.isDisplayed();
    }

    public boolean emailIsDisplayed() {
        return emailSignUp.isDisplayed();
    }

    public boolean passwordIsDisplayed() {
        return passwordSignUp.isDisplayed();
    }

    public boolean buttonSignUpIsDisplayed() {
        return buttonSignUp.isDisplayed();
    }

    public boolean closeButtonSignUpIsDisplayed() {
        return closeButtonSignUp.isDisplayed();
    }


    public void entryFirstNameInput(String text) {
        typeOnInput(firstNameSignUp, text);
    }

    public void entryLastNameInput(String text) {
        typeOnInput(lastNameSignUp, text);
    }

    public void entryEmailInput(String text) {
        typeOnInput(emailSignUp, text);
    }

    public void entryPasswordInput(String text) {
        typeOnInput(passwordSignUp, text);
    }

    public void clickButtonSignUp() {
        waitForClickable(buttonSignUp);
        clickElement(buttonSignUp);
    }


    public WatchPage clickLinkWatch() {
        isElementAvailable(watchLink);
        scroll(watchLink);
        return new WatchPage(getDriver());
    }


    public boolean navTextIsDisplayed() {
        waitForVisibility(navText);
        return navText.isDisplayed();
    }


    public void clickLogoutLink() {
        clickElement(userIconList.get(0));
    }

    public boolean navTextLogOutIsDisplayed() {
        waitForVisibility(navTextLogOut);
        return navTextLogOut.isDisplayed();
    }
}
