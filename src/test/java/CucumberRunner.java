import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mbaykova on 15.11.2018
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.aplana.demo"},
        plugin = {"json:target/cucumber-report.json",
                  "pretty",
                  "html:target/cucumber-reports",
                "ru.aplana.demo.reporter.AllureReporter"},
        tags = {"@web"})
public class CucumberRunner {
}
