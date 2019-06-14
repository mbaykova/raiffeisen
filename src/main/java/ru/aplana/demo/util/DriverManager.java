package ru.aplana.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

/**
 * Created by Maria on 12.11.2018.
 */
public class DriverManager {
	private static Properties properties = TestProperties.getInstance().getProperties();
	private static WebDriver driver = null;

	public static WebDriver getDriver(){
		if (driver == null){
			driver = createDriver();
		}
		return driver;
	}

	public static void quitDriver(){
		if (driver != null){
			driver.quit();
			driver = null;
		}
	}

	private static WebDriver createDriver() {

		switch (properties.getProperty("browser")) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
//				options.addArguments("disable-infobars"); // disabling infobars
//				options.addArguments("--disable-extensions"); // disabling extensions
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless");
				options.addArguments("window-size=1024,768");
				options.setExperimentalOption("useAutomationExtension", false);
				driver = new ChromeDriver(options);
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
				driver = new FirefoxDriver();
				break;
			default:
				driver = new ChromeDriver();
				break;
		}
		return driver;
	}
}
