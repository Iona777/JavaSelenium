package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/jave/resources/features",
        glue = ("stepDefs"),
        plugin = {"pretty", "html:target/cucumber"}
)

public class RunAllCucumberTests {
}
