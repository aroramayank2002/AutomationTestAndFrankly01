package com.andfrankly.android.app.pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andfrankly.autotest.util.Elements;

public class LoginPageFactory {
	Logger logger = LoggerFactory.getLogger(LoginPageFactory.class);
	AndroidDriver<MobileElement> driver;

	@FindBy(id = Elements.ID_EMAIL_NEXT)
	WebElement emailText;

	@FindBy(how = How.XPATH, using = Elements.XPATH_EMAIL)
	WebElement email;

	@FindBy(how = How.XPATH, using = Elements.XPATH_PASSWORD)
	WebElement passwordText;
	
	@FindBy(how = How.ID, using = Elements.ID_EMAIL_NEXT)
	WebElement nextOnEmail;
	
	@FindBy(how = How.ID, using = Elements.ID_PASSWORD_NEXT)
	WebElement nextOnPassword;
	
	@FindBy(how = How.ID, using = Elements.ID_WELCOME_MESSAGE)
	WebElement welcomeMessage;

	public LoginPageFactory(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void typeEmail(String userName) {
		logger.info("Enter email: " + userName);
		email.sendKeys(userName);
	}

	public void clickNextOnEmail() {
		logger.info("Click next button");
		nextOnEmail.click();
	}

	public void typePassword(String password) {
		logger.info("Enter password :" + password);
		passwordText.sendKeys(password);
	}

	public void clickNextOnPassword() {
		logger.info("Click password next button");
		nextOnPassword.click();
	}

	public String getWelcomeMessage() {
		logger.info("Get welcome message");
		return welcomeMessage.getText();
	}
}
