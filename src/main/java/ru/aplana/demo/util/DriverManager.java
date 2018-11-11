package ru.aplana.demo.util;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by Maria on 12.11.2018.
 */
public abstract class DriverManager {

	static Properties properties = TestProperties.getInstance().getProperties();
	WebDriver driver;

	protected abstract void createDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		if (null == driver) {
			createDriver();
		}
		return driver;
	}
}
