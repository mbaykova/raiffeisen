package ru.aplana.demo.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Maria on 12.11.2018.
 */
public class ChromeDriverManager extends DriverManager{


	@Override
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
	}
}
