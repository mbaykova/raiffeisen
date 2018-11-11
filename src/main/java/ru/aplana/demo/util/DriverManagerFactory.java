package ru.aplana.demo.util;

/**
 * Created by Maria on 12.11.2018.
 */
public class DriverManagerFactory {

	public static DriverManager getManager(String type) {

		DriverManager driverManager;

		switch (type) {
			case "chrome":
				driverManager = new ChromeDriverManager();
				break;
			case "firefox":
				driverManager = new GeckoDriverManager();
				break;
			default:
				driverManager = new ChromeDriverManager();
				break;
		}
		return driverManager;

	}
}
