import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mbaykova on 15.11.2018
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = "@rerun.txt",
                    //Cucumber picks the failed scenarios from this file ,
         glue = {"ru.aplana.demo"},
         plugin = {"json:target/cucumber-report.json",
                  "pretty",
                  "html:target/cucumber-reports"})
public class CucumberReRunner {
}
