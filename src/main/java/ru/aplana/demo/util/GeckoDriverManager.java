package ru.aplana.demo.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Maria on 12.11.2018.
 */
public class GeckoDriverManager extends DriverManager {


	@Override
	public void createDriver() {
		System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
		driver = new FirefoxDriver();
	}
}
