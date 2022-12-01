package steps.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.Matchers.is;

public class signUpSteps extends BaseUi {

    @Before()
    public void setup(){
        log.info("Initiating the browser and navigate into Homepage");
        testSetup("chrome");
    }

    @Given("the user is on sign up section")
    public void the_user_is_on_sign_up_section() {
        homePage.closeBanner();
        homePage.logInAndValidate();
        log.info("Validate a modal is present and contains:");
        checking(
                "Element: modal is present",
                homePage.modalIsDisplayed(),
                is(true));
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
    }

    @When("user enters the correct data credentials")
    public void user_enters_the_correct_data_credentials() {
        log.info("Accessing into the Sign Up modal..");
        log.info("Validating the presence of: ");
        homePage.clickSignUpButton();
        homePage.switchToIframeSignUpSection();
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

    @Then("the user should be create a new account and logged in" +
            "{string} {string} {string} {string}")
    public void the_user_should_be_create_a_new_account_and_logged_in(
            String firstName, String lastName, String email, String password) {
        log.info("Enter valid information in the form and click ‘Sign Up’");
        homePage.entryFirstNameInput(firstName);
        homePage.entryLastNameInput(lastName);
        homePage.entryEmailInput(email);
        homePage.entryPasswordInput(password);
        homePage.clickButtonSignUp();
    }





    @Given("the user logged goes to watch page")
    public void the_user_logged_goes_to_watch_page() {
        log.info("Entry into the Watch page");
        watchPage = homePage.clickLinkWatch();
    }
    @When("validate that at least one carousel is present")
    public void validate_that_at_least_one_carousel_is_present() {
        log.info("validating that at least one carousel is present");
        checking(
                "Element: 'Carousel' is present",
                watchPage.carouselIsDisplayed(),
                is(true));
    }
    @And("Click on the second card in the first carousel")
    public void click_on_the_second_card_in_the_first_carousel() {
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
    }
    @Then("Go back to the landing page")
    public void go_back_to_the_landing_page() {
        log.info("returning to the Homepage");
        watchPage.clickCloseButton();
        homePage = watchPage.goBackPage();
    }







    @Given("the user can verify if is logged")
    public void the_user_can_verify_if_is_logged() {
        log.info("verifying that user is currently logged");
        homePage.hoverUserIcon();
    }
    @When("Validate the sign up modal")
    public void validate_the_sign_up_modal() {
        log.info("Validating the element 'Nav text'");
        checking("Element: 'Nav Text: 'Welcome {{username}}!' ' is present",
                homePage.navTextIsDisplayed(),
                is(true));
    }
    @Then("Click log out and validate text without user name specified")
    public void click_log_out_and_validate_text_without_user_name_specified() {
        log.info("Clicking 'Log Out' element and validate");
        homePage.clickLogoutLink();
        checking("Element: 'Nav Text: 'Welcome' ' is present",
                homePage.navTextIsDisplayed(),
                is(true));
    }

    @After()
    public void closeBrowserEspn(){
        closeBrowser();
    }
}
