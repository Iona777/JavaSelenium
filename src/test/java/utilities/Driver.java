package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.sql.Time;

public class Driver {

    //Could I do away with the static clas and just call static methods form the instance class be giving
    //the class name? E.G. Driver.getDRiver()?
    //See the 'Explain the Driver class' lecture in Compendium. Reusing the driver rather than quitting and restarting
    //on every test may be a useful way to speed up the tests.

        public static WebDriver driver = null;

        public static void getDriver(String selectedBrowser)
        {
            switch (selectedBrowser.toUpperCase())
            {
                case "CHROME":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;

                case "EDGE":
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    System.out.println("Invalid driver selected");
            }
        }

        public static void navigateTo(String targetURL)
        {
            driver.navigate().to(targetURL);
        }

        //Only to be used for debugging and to slow down execution for demo purposes
        public static void pause(int timeInMilliseconds) throws InterruptedException {

                Thread.sleep(timeInMilliseconds);
        }

}
