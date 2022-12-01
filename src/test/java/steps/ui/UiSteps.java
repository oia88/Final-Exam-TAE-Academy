package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UiSteps {


    @Given("the user is on sign up section")
    public void the_user_is_on_sign_up_section() {
        System.out.println("user must be able to get into the website ");
        System.out.println("and go to the sign up section");
    }

    @When("user enters the correct data credentials")
    public void user_enters_the_correct_data_credentials() {
        System.out.println("user should fill all the inputs with his own data");
    }

    @And("hits sign up button")
    public void hits_sign_up_button() {
        System.out.println("do click on the button");
    }

    @Then("the user should be create a new account and logged in")
    public void the_user_should_be_create_a_new_account_and_logged_in() {
        System.out.println("after put in his data, user must click the sign up button" +
                "and should be redirect into the homepage and be login");
    }
}
