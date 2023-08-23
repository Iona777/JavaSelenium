package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tables {

    /**
     * Waits for the table webElement using the given By
     * Return the row at index nRow
     * NOTE: This is zero referenced
     * @param by Used to locate the element, e.g. By.Id("xyz")
     * @param tagname Tag name to identify the table rows. Usually "tr" but could vary
     * @param nRow Index of the row to return
     * @return WebElement
     * @throws InterruptedException
     */
    public static WebElement GetTableNthRow(By by, String tagname, int nRow) throws InterruptedException {
        WebElement tableElement = GetElements.GetVisibleElement(by);
        Assert.assertNotNull("did not find table given by: "+by, tableElement);
        //NOTE: it is possible that tag name varies (bad programming?) so this assertion many not always be suitable
        Assert.assertEquals("table", tableElement.getTagName(), "Element given by: "+by+" is not a table!");

        //Alternative approach where we give the tagname for the row and just get all the rows that way. Does not work
        //if more than 1 table present.
        //List<WebElement> webElements = GetElements.GetAllVisibleElements(By.tagName(tagname), 2);

        //Tag name could vary, so use a parameter rather than assuming it is just 'table'
        List<WebElement> webElements = tableElement.findElements(By.tagName(tagname));


        try {
            Assert.assertNotNull("Did not find any data at row index"+nRow, webElements.get(nRow));

        }
        catch (IndexOutOfBoundsException e)
        {
            throw e;
        }

        return webElements.get(nRow);
    }

    /**
     * Waits for the table webElement using the given By.
     * Returns the column at index nCol
     * NOTE: This is zero referenced
     * @param by Used to locate the element, e.g. By.Id("xyz")
     * @param tagName Tag name to idenfify the table column. Usually "td" but could vary
     * @param nCol Index of the column to return
     * @return
     */
    public static WebElement GetTableNthColumn(By by, String tagName, int nCol)
    {
        WebElement tableElement = GetElements.GetVisibleElement(by);
        Assert.assertNotNull("did not find table given by: "+by, tableElement);
        //NOTE: it is possible that tag name varies (bad programming?) so this assertion many not always be suitable
        Assert.assertEquals("table", tableElement.getTagName(), "Element given by: "+by+" is not a table!");

        //Tag name may vary so use paramenter
        List<WebElement> webElements = tableElement.findElements(By.tagName(tagName));

        try {
            Assert.assertNotNull("Did not find any data at column index"+nCol, webElements.get(nCol));
        }
        catch (IndexOutOfBoundsException e)
        {
            throw e;
        }

        return webElements.get(nCol);
    }

    /**
     *  Waits for the table webElement using the given By.
     *  Returns the element at row and column indices nRow and nCol
     * @param by by Used to locate the element, e.g. By.Id("xyz")
     * @param rowTagName Tag name to idenfify the table row. Usually "tr" but could vary
     * @param colTagName Tag name to idenfify the table column. Usually "td" but could vary
     * @param nRow Index of the row to return
     * @param nCol Index of the column to return
     * @return WebElement
     */


    public static WebElement GetTableNthRowAndColumn(By by, String rowTagName, String colTagName, int nRow, int nCol)
    {
        WebElement tableElement =  GetElements.GetVisibleElement(by);
        Assert.assertNotNull("did not find table given by: "+by, tableElement);
        //NOTE: it is possible that tag name varies (bad programming?) so this assertion many not always be suitable
        Assert.assertEquals("table", tableElement.getTagName(), "Element given by: "+by+" is not a table!");

        //Tag names may vary, so use parameters
        List<WebElement> rows = tableElement.findElements(By.tagName(rowTagName));
        WebElement nthRow = rows.get(nRow);

        List<WebElement> columns = nthRow.findElements(By.tagName(colTagName));
        WebElement nthRowCol = columns.get(nCol);

        return nthRowCol;
    }

    /**
     * Checks to see if all the displayed columns in the nthRow contain the expected text
     * @param tableBy Used to locate the element, e.g. By.Id("xyz")
     * @param rowBy Used to locate the element, e.g. By.Id("xyz")
     * @param colBy Tag name to idenfify the table column. Usually "td" but could vary
     * @param nRow Index of the row to return
     * @param expectedText  text each column should equal
     * @return boolean
     */
    public static boolean AllColumnsInNthRowEqualSpecifiedText(By tableBy, By rowBy, By colBy,  int nRow, String expectedText)
    {
        boolean allColumnsEqualText = true;
        WebElement tableElement = GetElements.GetVisibleElement(tableBy);

        //Tag names may vary, so use parameters
        List<WebElement> rows = tableElement.findElements(rowBy);
        WebElement nthRow = rows.get(nRow);

        List<WebElement> columns = nthRow.findElements(colBy);

        for (WebElement column: columns)
        {
            if (column.isDisplayed())
            {
                if (!column.getText().equals(expectedText))
                {
                    allColumnsEqualText = false;
                    break;
                }
            }
        }
        return allColumnsEqualText;
    }


    /**
     *
     * @param tableBy Used to locate the element, e.g. By.Id("xyz")
     * @param rowBy Used to locate the element, e.g. By.Id("xyz")
     * @param colBy Used to locate the element, e.g. By.Id("xyz")
     * @param columnIndex index of column
     * @param expectedText text to check for
     * @return boolean
     */
    public static boolean AllNthColumnsEqualSpecifiedText(By tableBy, By rowBy, By colBy,  int columnIndex, String expectedText)
    {
        boolean allColumnsEqualText = true;
        WebElement tableElement = GetElements.GetVisibleElement(tableBy);

        //Tag names may vary, so use parameters
        List<WebElement> rows = tableElement.findElements(rowBy);

        for (WebElement row: rows)
        {
            List<WebElement> columns = row.findElements(colBy);
            WebElement nthColumn = columns.get(columnIndex);

            if (nthColumn.isDisplayed())
            {
                if (!nthColumn.getText().equals(expectedText))
                {
                    allColumnsEqualText = false;
                    break;
                }
            }

        }

        return allColumnsEqualText;
    }

}
