package com.andfrankly.andriod.app.test;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
	Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static AppiumDriverLocalService service;
	private Properties prop = null;
	private Properties capabilities = null;
	public static final int SLEEP_TIME_3_SEC = 3000;

	private Properties loadProperties(String name) {
		logger.debug("Loading properties: " + name);
		Properties p = new Properties();
		
		try (InputStream input = new FileInputStream(name))  {
			p.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
		return p;
	}

	@BeforeSuite
	public void globalSetup() throws IOException {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		prop = loadProperties("test.properties");
		capabilities = loadProperties("capabilities.properties");
	}

	@AfterSuite
	public void globalTearDown() {
		service.stop();
	}

	public URL getServiceUrl() {
		return service.getUrl();
	}

	public Properties getTestProperties() {
		if (null == prop) {
			prop = loadProperties("test.properties");
		}
		return prop;
	}

	public Properties getCapabilities() {
		if (null == capabilities) {
			capabilities = loadProperties("capabilities.properties");
		}
		return capabilities;
	}

}