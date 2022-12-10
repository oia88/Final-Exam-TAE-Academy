package steps.mobile;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class MobileSteps extends BaseMobile{

    @Given("the user should start the app and navigate until the dashboard")
    public void the_user_should_start_the_app_and_navigate_until_the_dashboard() {
        log.info("Initiating the app and navigate until dashboard..");
        environmentSetUp();
        loadDashBoardScreen();
    }

    @When("Look for the map button then tap it")
    public void look_for_the_map_button_then_tap_it() {
        log.info("Tapping Map Button available in Dashboard Page..");
        dashBoard.goToMapScreen();
    }

    @And("find the category list")
    public void find_the_category_list() {
        log.info("Tapping Category List..");
        map.clickCategoryList();
        Assert.assertTrue(map.categoryIsDisplayed());
    }

    @Then("validate if the hotels option is available in the list")
    public void validate_if_the_hotels_option_is_available_in_the_list() {
        log.info("Checking if the Hotels Option is available in the list..");
        Assert.assertTrue(map.hotelIsDisplayed());
    }




    @When("tap on menu button scrolling down until bottom of the screen")
    public void tap_on_menu_button_scrolling_down_until_bottom_of_the_screen() {
        log.info("Tapping on Menu Button and scrolling down until bottom of the screen..");
        dashBoard.goToDashboardScreen();
        dashBoard.navigatePrivacyLegalOption();
    }
    @Then("tap on Privacy & Legal")
    public void tap_on_privacy_legal() {
        log.info("Clicking the Privacy & Legal button..");
        dashBoard.scrollAndClickPrivacyLegalButton();
    }
    @And("validate if a list of options is visible")
    public void validate_if_a_list_of_options_is_visible() {
        log.info("Validate Privacy & Legal list..");
        Assert.assertTrue(dashBoard.privacyLegalOptionsListIsDisplayed(),
                "Privacy & Legal list not displayed");
    }



    @When("tap on add plans button")
    public void tap_on_add_plans_button() {
        log.info("Accessing into the add plans tab menu");
        dashBoard.goToDashboardScreen();
        dashBoard.navigateIntoAddPlans();
    }
    @Then("check if the reserve dining option is in the list")
    public void check_if_the_reserve_dining_option_is_in_the_list() {
        log.info("Validate Check Dining Availability option");
        Assert.assertTrue(dashBoard.reserveDiningOptionIsDisplayed(),
                "Reserve Dining Option not displayed");
    }
}
