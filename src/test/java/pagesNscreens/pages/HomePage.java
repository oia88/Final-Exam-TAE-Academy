package pagesNscreens.pages;

import configuration.WebOperations;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebOperations {

    public HomePage(WebDriver driver) { super(driver); }

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement banner;
    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;
    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css = "li.user ul.account-management li:nth-child(7)")
    private WebElement loginLink;
    @FindBy(css = "#oneid-iframe")
    private WebElement modal;
    @FindBy(css = "[data-testid='login-logo']")
    private WebElement espnLogo;
    @FindBy(id = "BtnSubmit")
    private WebElement loginButton;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;


    @FindBy(css = "#root.loading-container")
    private WebElement modalSignUp;
    @FindBy(css = "#root.loading-container.title > span")
    private WebElement titleSignUp;
    @FindBy(css = "#root.loading-container.input-InputFirstName")
    private WebElement firstNameSignUp;
    @FindBy(css = "#root.loading-container.input-InputLastName")
    private WebElement lastNameSignUp;
    @FindBy(css = "#root.loading-container.input-InputEmail")
    private WebElement emailSignUp;
    @FindBy(css = "#root.loading-container.input-password-new")
    private WebElement passwordSignUp;
    @FindBy(css = "#root.loading-container #BtnSubmit")
    private WebElement buttonSignUp;
    @FindBy(css = "#root.loading-container #close")
    private WebElement closeButtonSignUp;


    @FindBy(css = ".pillar.watch > a")
    private WebElement watchLink;
    @FindBy(className = "display-user")
    private WebElement navText;


    @FindBy(css = "li.user ul.account-management li:nth-child(8)")
    private WebElement logoutLink;
    @FindBy(className = "display-user")
    private WebElement navTextLogOut;



    public boolean verifyBanner(){
        boolean isBanner = true;
        try{
            waitForVisibility(banner);
        } catch (TimeoutException e){
            isBanner = false;
        }
        return isBanner;
    }

    public void closeBanner(){
        if(this.verifyBanner()){
            switchToIframe(banner);
            clickElement(bannerCloseButton);
        }
    }

    public void clickOnUserIcon(){
        clickElement(userIcon);
    }
    public void clickOnLoginLink(){
        clickElement(loginLink);
    }
    public void switchToIframeSection(){
        this.switchToIframe(modal);
    }
    public boolean modalIsDisplayed(){ return modal.isDisplayed(); }
    public boolean espnLogoIsDisplayed(){
        return espnLogo.isDisplayed();
    }
    public boolean loginButtonIsDisplayed(){
        return loginButton.isDisplayed();
    }
    public boolean signUpButtonIsDisplayed(){ return signUpButton.isDisplayed(); }

    public void clickSignUpButton(){ clickElement(signUpButton); }



    public void switchToIframeSignUpSection(){
        this.switchToIframe(modalSignUp);
    }
    public boolean titleSignUpIsDisplayed(){ return titleSignUp.isDisplayed(); }
    public boolean firstNameIsDisplayed(){ return firstNameSignUp.isDisplayed(); }
    public boolean lastNameIsDisplayed(){ return lastNameSignUp.isDisplayed(); }
    public boolean emailIsDisplayed(){ return emailSignUp.isDisplayed(); }
    public boolean passwordIsDisplayed(){ return passwordSignUp.isDisplayed(); }
    public boolean buttonSignUpIsDisplayed(){ return buttonSignUp.isDisplayed();}

    public boolean closeButtonSignUpIsDisplayed(){ return closeButtonSignUp.isDisplayed(); }




    public WatchPage clickLinkWatch(){
        clickElement(watchLink);
        return new WatchPage(getDriver());
    }



    public void hoverUserIcon(){
        Actions action = new Actions(getDriver());
        action.moveToElement(userIcon).perform();
    }
    public boolean navTextIsDisplayed(){ return navText.isDisplayed(); }



    public void clickLogoutLink(){ clickElement(logoutLink); }
    public boolean navTextLogOutIsDisplayed(){ return navTextLogOut.isDisplayed(); }
    public void logout(){
        clickOnUserIcon();
        clickLogoutLink();
    }
}
