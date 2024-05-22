package stepDefination;

import io.cucumber.java.en.*;

public class StepDefination {

    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        System.out.println("landing page");
    }

    @When("user login in to application with username and password")
    public void user_login_in_to_application_with_username_and_password() {
        System.out.println("home page");
    }

    @Then("user should navigate to Homepage")
    public void user_should_navigate_to_homepage() {
        System.out.println("logout page");
    }

}
