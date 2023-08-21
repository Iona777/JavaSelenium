package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectElements {

    public static void SelectDropDownByVisibleText(WebElement element, String visibleText)
    {
        Select selecDropDown = new Select(element);
        selecDropDown.selectByVisibleText(visibleText);
    }

}
