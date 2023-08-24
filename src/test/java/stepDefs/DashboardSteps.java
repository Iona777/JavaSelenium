package stepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;

public class DashboardSteps {

    private DashboardPage theDashboardPage;

    public DashboardSteps()
    {
        theDashboardPage = new DashboardPage();
    }

    @When("I select the the Admin menu item")
    public void iSelectTheTheAdminMenuItem() {
        theDashboardPage.ClickOnAdminMenuItem();
    }

    @And("I filter on username {string}")
    public void iFilterOnUsername(String userName) throws InterruptedException {
        theDashboardPage.EnterUserName(userName);
        theDashboardPage.ClickOnSearchButton();
        Driver.pause(2000);
    }

    @Then("the Username column in all the returned rows equal {string}")
    public void theUsernameColumnInAllTheReturnedRowsEqual(String expectedValue) {
        Assert.assertTrue("Value in username column not as expected",theDashboardPage.UserNameColumnContainsExpectedValue(expectedValue));

    }

    @And("I filter on user role {string}")
    public void iFilterOnUserRole(String role) throws InterruptedException {
        theDashboardPage.ClickOnUserRoleArrow();
        theDashboardPage.clickOnUserRoleOptionByText(role);
        //theDashboardPage.ClickOnNthUserRoleOption(2);
        theDashboardPage.ClickOnSearchButton();
        Driver.pause(2000);
    }

    @Then("the User Role column in all the returned rows equal {string}")
    public void theUserRoleColumnInAllTheReturnedRowsEqual(String expectedValue) {
        Assert.assertTrue("Value in user role column not as expected",theDashboardPage.UseRoleColumnContainsExpectedValue(expectedValue));
    }
}
