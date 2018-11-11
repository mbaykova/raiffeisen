package ru.aplana.demo.steps;

/**
 * Created by Maria on 12.11.2018.
 */


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.demo.util.DriverManager;
import ru.aplana.demo.util.DriverManagerFactory;
import ru.aplana.demo.util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 06.05.2017.
 */
public class BaseSteps {
	public static Properties properties = TestProperties.getInstance().getProperties();
	private static DriverManager driverManager;

	public static WebDriver getWebDriver(){
		return driverManager.getDriver();
	}


	@Before
	public void startScenario() {
		driverManager = DriverManagerFactory.getManager(properties.getProperty("browser"));
		WebDriver driver = driverManager.getDriver();
		driver.get(properties.getProperty("app.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@After
	public void afterMethod() {
		driverManager.quitDriver();
	}


}

