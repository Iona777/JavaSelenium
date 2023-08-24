package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigHelper;
import utilities.Driver;

public class LoginSteps {

    private LoginPage theLoginPage;
    private DashboardPage theDashboardPage;

    public LoginSteps()
    {
        theLoginPage = new LoginPage();
        theDashboardPage = new DashboardPage();
    }

    @Given("I navigate to the Login page")
    public void i_navigate_to_the_login_page() throws InterruptedException {
        //The methods in the Driver class are static, so we do not need an instance of Driver to access them,
        //we can just use the class name.

        theLoginPage.GotoLoginPage();
        Driver.pause(2000);


    }
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String userName, String password) {
        theLoginPage.EnterUserName(userName);
        theLoginPage.EnterPassword(password);
        theLoginPage.ClickOnLoginButton();
    }
    @Then("the Dashboard page is displayed")
    public void the_dashboard_page_is_displayed() throws InterruptedException {
        theDashboardPage.CheckTitle();
        //Pause so we can see the page
        Driver.pause(2000);
    }


}
