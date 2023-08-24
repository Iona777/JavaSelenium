package pages;

import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.GetElements;
import utilities.ManipulateElements;
import utilities.Tables;

import java.util.List;

@NoArgsConstructor
public class DashboardPage {

    String DashboardTitle = "OrangeHRM";

    //WebElement locators
    private static final By LIST_ITEMS_LOCATOR = By.cssSelector("li[class='oxd-main-menu-item-wrapper']");
    private static final String ADMIN_HREF = "/web/index.php/admin/viewAdminModule";
    private static final String PIN_HREF = "/web/index.php/pim/viewPimModule";
    //Looks like the element locators are badly written (perhaps on purpose), so have to use generated Xpath
    private static final By USERNAME_LOCATOR = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");

    private static final By ADMIN_TABLE_LOCATOR = By.cssSelector("[role='table']");
    private static final By ROW_LOCATOR = By.cssSelector("[role='row']");
    private static final By COLUMN_LOCATOR = By.cssSelector("[role='cell']");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");


    private static final By ARROW_LOCATORS = By.cssSelector("[class = 'oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private static final By OPTION_LOCATORS = By.cssSelector("[role='option']");

    //Methods
    public void CheckTitle()
    {
        Assert.assertEquals(DashboardTitle, Driver.driver.getTitle());


    }

    public void ClickOnUserRoleArrow() throws InterruptedException {

         List<WebElement> arrows = GetElements.GetListOfElements(ARROW_LOCATORS);
         WebElement userRoleArrow = arrows.get(0);
         userRoleArrow.click();
         Driver.pause(500);
    }


    public void  clickOnUserRoleOptionByText(String visibleText) throws InterruptedException {
        WebElement option = GetElements.GetElementByVisibleText(visibleText);
        option.click();
        Driver.pause(2000);
    }

    public void ClickOnNthUserRoleOption(int index) throws InterruptedException {
        List<WebElement> options = GetElements.GetListOfElements(OPTION_LOCATORS);
        //Zero index will be --Select-- so can just pass index as it is
        WebElement nthOption = options.get(index);
        nthOption.click();
        Driver.pause(2000);
    }

    public void ClickOnNthListElement(int index)
    {
        WebElement element = GetElements.GetListItemByIndex(LIST_ITEMS_LOCATOR, index);
    }

    public void ClickOnAdminMenuItem()
    {
        WebElement admin = GetElements.GetElementByHref(ADMIN_HREF);
        admin.click();
    }

    public void ClickOnPinMenuItem()
    {
        WebElement pin = GetElements.GetElementByHref(PIN_HREF);
        pin.click();
    }

    public void EnterUserName(String userName)
    {
        ManipulateElements.EnterText(USERNAME_LOCATOR, userName);
    }

    public void ClickOnSearchButton()
    {
        ManipulateElements.ClickOnElement(SEARCH_BUTTON_LOCATOR);
    }

    public boolean UserNameColumnContainsExpectedValue(String expectedValue)
    {
        int userNameColIndex = 1;
        return Tables.AllNthColumnsEqualSpecifiedText(ADMIN_TABLE_LOCATOR, ROW_LOCATOR ,COLUMN_LOCATOR, userNameColIndex, expectedValue);
    }

    public boolean UseRoleColumnContainsExpectedValue(String expectedValue)
    {
        int userNameColIndex = 2;
        return Tables.AllNthColumnsEqualSpecifiedText(ADMIN_TABLE_LOCATOR, ROW_LOCATOR ,COLUMN_LOCATOR, userNameColIndex, expectedValue);
    }

}
