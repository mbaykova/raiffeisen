import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mbaykova on 15.11.2018
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/deposit1.feature"}, glue = {"ru.aplana.demo"},
        plugin = {"json:target/cucumber-report.json",
                  "pretty",
                "ru.aplana.demo.reporter.AllureReporter"})
public class CucumberRunner2 {
}
