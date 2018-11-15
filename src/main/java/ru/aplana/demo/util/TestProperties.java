package ru.aplana.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Maria on 12.11.2018.
 */
public class TestProperties {
	private final Properties properties = new Properties();

	private static TestProperties INSTANCE = null;

	private TestProperties(){
		System.setProperty("environment", "application");
		try {
			properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static TestProperties getInstance() {
		if (INSTANCE == null){
			INSTANCE = new TestProperties();
		}
		return INSTANCE;
	}

	public Properties getProperties() {
		return properties;
	}
}
