package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class InterrogateElements {

    /**
     * Checks if an element is visible on the page. Visibility means tha the element is not only displayed but also
     * has a height and width thta is greater than zero.
     * @param elementlocator Used to locate the lement, e.g. By.Id("xyz)
     * @return boolean
     */
    public static boolean IsElementDisplayed(By elementlocator)
    {
        try {
            WebElement element = GetElements.GetVisibleElement(elementlocator);
            return  element.isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            //If this element is not present on the DOM at all (instead of being present but not displayed)
            //the will get an error. so, return false as the element is not displayed.
            return false;
        }
    }
}
