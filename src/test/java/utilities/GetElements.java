package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

public class GetElements {

    /**
     * Waits for, then returns a clickable web element
     * @param elementLocator Used to locate the element, e.g. By.Id("xyz")
     * @return WebElement
     */
    public static WebElement GetClickableElement(By elementLocator)
    {
        WebDriverWait wait  = new WebDriverWait(Driver.driver, Driver.DEFAULT_TIMEOUT);

        return  wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    /**
     * Waits for, then returns a visible web element
     * @param elementLocator Used to locate the element, e.g. By.Id("xyz")
     * @return WebElement
     */
    public  static WebElement GetVisibleElement(By elementLocator)
    {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Driver.DEFAULT_TIMEOUT);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    /**
     * Waits for, then returns all visible elements by given locator
     * @param elementLocator Used to locate the elements, e.g. By.Id("xyz")
     * @param minCount Minimum number of elements required to be returned
     * @return List<WebElement>
     */
    public static List<WebElement>  GetAllVisibleElements(By elementLocator, int minCount) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Driver.DEFAULT_TIMEOUT);

        List<WebElement> elementList;

        try
        {
            elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));

            if (elementList.size() < minCount)
            {
                //Sometimes it will just not get all the elements in time, so  give it another chance.
                Driver.pause(500);
                elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));
            }

            return elementList;
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
            throw new InterruptedException();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
            throw new NoSuchElementException("Cannot find element via "+elementLocator);
        }

    }

    /**
     * Will return the element of the list of items by given locator and index
     * @param elementLocator Used to locate the elements, e.g. By.Id("xyz")
     * @param index index of required element in list
     * @return WebElement
     */
    public static WebElement GetListItemByIndex(By elementLocator, int index)
    {
        //This is probably better than using Driver.FindElements()
        WebDriverWait wait = new WebDriverWait(Driver.driver, Driver.DEFAULT_TIMEOUT);
        List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));

        //Just use this in debugging to check the text is as expected
        String checkText = listItems.get(index).getText();

        return listItems.get(index);
    }

    public static WebElement GetElementByHref(String href)
    {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Driver.DEFAULT_TIMEOUT);

        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href*='" + href + "']")));
    }

    public static WebElement GetElementByVisiableText(String  searchText)
    {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Driver.DEFAULT_TIMEOUT);

        //Not sure which syntax will work in Java
        String xpath1 = ".//*[contains(text(),'" + searchText + "')]";
        String xpath2 = ".//*[contains(.,'" + searchText + "')]";
        String xpath2A = "//*[contains(., 'Admin')]";
        String xpathAdmin = "//*[contains(., 'Admin')]";

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
    }

}
