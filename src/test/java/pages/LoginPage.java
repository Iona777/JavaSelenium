package pages;

import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import utilities.Driver;

@NoArgsConstructor
public class LoginPage {

    //WebElement locators
    private static final By USERNAME_LOCATOR = By.cssSelector("[name='username']");
    private static final By PASSWORD_LOCATOR = By.cssSelector("[name='password']");
    private static final By LOGINBUTTON_LOCATOR = By.cssSelector("button[type='submit']");

    //Methods
    public void GotoLoginPage()
    {
        Driver.navigateTo(Driver.rootURL);
    }


}
