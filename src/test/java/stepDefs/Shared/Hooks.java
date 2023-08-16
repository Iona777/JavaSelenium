package stepDefs.Shared;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigHelper;
import utilities.Driver;

public class Hooks {

    //These run before and after each Scenario
    @Before
    public static void StartBrowser()
    {
        Driver.rootURL = ConfigHelper.getProperty("baseURL");
        Driver.getDriver(ConfigHelper.getProperty("browser"));
    }

    @After
    public static void Shutdown()
    {
        Driver.ShutDown();
    }
}
