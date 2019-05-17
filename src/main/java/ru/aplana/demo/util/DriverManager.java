package ru.aplana.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Properties;

/**
 * Created by Maria on 12.11.2018.
 */
public class DriverManager {
	private static Properties properties = TestProperties.getInstance().getProperties();
	private static WebDriver driver = null;

	public static WebDriver getDriver(){
		if (driver == null){
			try {
				driver = createDriver();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

	public static void quitDriver(){
		if (driver != null){
			driver.quit();
			driver = null;
		}
	}

	private static WebDriver createDriver() throws MalformedURLException {

		switch (properties.getProperty("browser")) {
			case "chrome":
//				System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
//				ChromeOptions options = new ChromeOptions();
//				options.setExperimentalOption("useAutomationExtension", false);
//				driver = new ChromeDriver(options);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("chrome");
				capabilities.setVersion("73.0");
				capabilities.setCapability("enableVNC", true);
				capabilities.setCapability("enableVideo", false);
				capabilities.setCapability("enableLog", false);
				WebDriver driver = new RemoteWebDriver(
						URI.create("http://selenoid.aplana.com:4445/wd/hub/").toURL(),
						capabilities
				);
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
