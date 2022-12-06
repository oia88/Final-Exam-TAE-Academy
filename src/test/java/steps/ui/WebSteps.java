package steps.ui;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.Matchers.is;

public class WebSteps extends BaseUi {

    @Before()
    public void setup(){
        log.info("Initiating the browser and navigate into Homepage");
        testSetup("chrome");
    }

    @Given("the user should be able to go to the log in section and get inside sign up")
    public void the_user_should_be_able_to_go_to_the_log_in_section_and_get_inside_sign_up() {
        homePage.closeBanner();
        homePage.clickOnUserIcon();
        homePage.clickOnLoginLink();
        log.info("Validate a modal is present and contains:");
        checking(
                "Element: modal is present",
                homePage.modalIsDisplayed(),
                is(true));
        homePage.switchToIframeSection();
        checking(
                "Element: 'ESPN Logo' is present",
                homePage.espnLogoIsDisplayed(),
                is(true));
        checking(
                "Element: 'Log in' is present",
                homePage.loginButtonIsDisplayed(),
                is(true));
        checking(
                "Element: 'Sign Up' is present",
                homePage.signUpButtonIsDisplayed(),
                is(true));
        homePage.clickSignUpButton();
        log.info("Accessing into the Sign Up modal..");
        log.info("Validating the presence of: ");
        checking(
                "Element: 'Sign Up title' is present",
                homePage.titleSignUpIsDisplayed(),
                is(true));
        checking(
                "Element: 'First Name' is present",
                homePage.firstNameIsDisplayed(),
                is(true));
        checking(
                "Element: 'Last Name' is present",
                homePage.lastNameIsDisplayed(),
                is(true));
        checking(
                "Element: 'Email' is present",
                homePage.emailIsDisplayed(),
                is(true));
        checking(
                "Element: 'Password' is present",
                homePage.passwordIsDisplayed(),
                is(true));
        checking(
                "Element: 'Sign Up Button' is present",
                homePage.buttonSignUpIsDisplayed(),
                is(true));
        checking(
                "Element: 'X Close Button' is present",
                homePage.closeButtonSignUpIsDisplayed(),
                is(true));
    }
    @And("the user should be created with firstname: {string}, lastname: {string}, email: {string} and password: {string}")
    public void the_user_should_be_created_with_firstname_lastname_email_and_password(
            String firstName, String lastName, String email, String password) {
        log.info("Enter valid information in the form and click ‘Sign Up’");
        homePage.entryFirstNameInput(firstName);
        homePage.entryLastNameInput(lastName);
        homePage.entryEmailInput(email);
        homePage.entryPasswordInput(password);
        homePage.clickButtonSignUp();
    }
    @When("Once logged in, go to watch and validate that at least one carousel is present")
    public void once_logged_in_go_to_watch_and_validate_that_at_least_one_carousel_is_present() {
        log.info("Entry into the Watch page");
        watchPage = homePage.clickLinkWatch();
        log.info("validating that at least one carousel is present");
        checking(
                "Element: 'Carousel' is present",
                watchPage.carouselIsDisplayed(),
                is(true));
    }
    @And("Click on the second card in the first carousel and validate")
    public void click_on_the_second_card_in_the_first_carousel_and_validate() {
        log.info("validating that each card in the carousel has a title and a small description");
        checking("Element: 'Carousel Title' is present",
                watchPage.carouselTitleIsDisplayed(),
                is(true));
        checking("Element: 'Carousel Description' is present",
                watchPage.carouselDescriptionIsDisplayed(),
                is(true));
        log.info("Click on the second card in the first carousel and validating");
        watchPage.clickSecondCarousel();
        checking("Element: 'Close 'X' Button' is present",
                watchPage.closeButtonIsDisplayed(),
                is(true));
        watchPage.clickCloseButton();
    }
    @Then("Go back to the landing page and log out")
    public void go_back_to_the_landing_page_and_log_out() {
        log.info("returning to the Homepage");
        homePage = watchPage.goBackPage();
        homePage.clickOnUserIcon();
        checking("Element: Nav text is present",
                homePage.navTextIsDisplayed(),
                is(true));
        homePage.clickLogoutLink();
        checking("Element: Nav text logout is present",
                homePage.navTextLogOutIsDisplayed(),
                is(true));
    }
    @After()
    public void closeBrowserEspn(){
        closeBrowser();
    }
}
