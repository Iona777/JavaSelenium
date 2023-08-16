package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigHelper;
import utilities.Driver;

public class LoginSteps {

    @Given("I navigate to the Login page")
    public void i_navigate_to_the_login_page() throws InterruptedException {


        //The methods in the Driver class are static, so we do not need an instance of Driver to access them,
        //we can just use the class name.
        //The methods in in ConfigHelper are NOT static, so we do need to create an instance of the class to access
        ///them. Could have made them static, but doing it this way to show 2 different approaches for using
        //utility classes.

        ConfigHelper config = new ConfigHelper();

        String targetURL = config.getProperty("baseURL");
        //String targetURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Driver.getDriver("chrome");
        Driver.navigateTo(targetURL);
        Driver.pause(2000);

    }
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the Dashboard page is displayed")
    public void the_dashboard_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
