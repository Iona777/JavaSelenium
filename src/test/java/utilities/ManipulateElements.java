package utilities;

import org.openqa.selenium.By;

public class ManipulateElements {

    /**
     * Waits for a given element to be clickable and then sends the given input text
     * @param elementLocator Used to locate the element, e.g. By.Id("xyz")
     * @param inputText Text to enter
     */
    public static void EnterText(By elementLocator, String inputText)
    {
        GetElements.GetClickableElement(elementLocator).sendKeys(inputText);
    }

    /**
     * Waits for a given element to be clickable then clicks on it
     * @param elementLocator Used to locate the element, e.g. By.Id("xyz")
     */
    public static void ClickOnElement(By elementLocator)
    {
        GetElements.GetClickableElement(elementLocator).click();
    }
}
