package ru.aplana.demo.steps;

/**
 * Created by Maria on 12.11.2018.
 */



import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import ru.aplana.demo.util.DriverManager;
import ru.aplana.demo.util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 06.05.2017.
 */
public class BaseSteps {
	public static Properties properties = TestProperties.getInstance().getProperties();


	@Before
	public void startScenario() {
		WebDriver driver = DriverManager.getDriver();
		driver.get(properties.getProperty("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@After
	public void afterMethod() {
	//	DriverManager.quitDriver();
	}


}

