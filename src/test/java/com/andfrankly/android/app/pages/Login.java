package com.andfrankly.android.app.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andfrankly.autotest.util.Elements;

public class Login {
	Logger logger = LoggerFactory.getLogger(Login.class);
	private AndroidDriver<MobileElement> driver;

	By email = By.xpath(Elements.XPATH_EMAIL);
	By emailText = By.id(Elements.ID_EMAIL_NEXT);
	By passwordText = By.xpath(Elements.XPATH_PASSWORD);
	By nextOnEmail = By.id(Elements.ID_EMAIL_NEXT);
	By nextOnPassword = By.id(Elements.ID_PASSWORD_NEXT);
	By welcomeMessage = By.id(Elements.ID_WELCOME_MESSAGE);

	public Login(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void typeEmail(String userName) {
		logger.info("Enter email: " + userName);
		driver.findElement(email).sendKeys(userName);;
	}

	public void clickNextOnEmail() {
		logger.info("Click next button");
		driver.findElement(nextOnEmail).click();
	}

	public void typePassword(String password) {
		logger.info("Enter password :" + password);
		driver.findElement(passwordText).sendKeys(password);
	}
	
	public void clickNextOnPassword(){
		logger.info("Click password next button");
		driver.findElement(nextOnPassword).click();
	}
	
	public String getWelcomeMessage(){
		logger.info("Get welcome message");
		return driver.findElement(welcomeMessage).getText();
	}
}
