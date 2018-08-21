package com.andfrankly.andriod.app.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.andfrankly.android.app.pages.Login;
import com.andfrankly.android.app.pages.OnBoarding;
import com.andfrankly.android.app.pages.Questions;
import com.andfrankly.autotest.util.Messages;

public class TestAndroidAppWithPageObject extends BaseTest {
	private AndroidDriver<MobileElement> driver;
	private Login login;
	private OnBoarding onBoarding;
	private Questions questions;

	Logger logger = LoggerFactory.getLogger(TestAndroidAppWithPageObject.class);

	private void initializePages() {
		login = new Login(driver);
		onBoarding = new OnBoarding(driver);
		questions = new Questions(driver);
	}

	@BeforeClass
	public void setUp() throws IOException {
		logger.info("Verifying &Frankly on Android");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		Enumeration<?> e = getCapabilities().propertyNames();
		logger.debug("Property count " + getCapabilities().size());
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = getCapabilities().getProperty(key);
			logger.debug("Key : '" + key + "', Value : '" + value + "'");
			if (value.trim().equalsIgnoreCase("false")
					|| value.trim().equalsIgnoreCase("true")) {
				capabilities.setCapability(key, Boolean.parseBoolean(value));
			} else {
				capabilities.setCapability(key, value);
			}
		}

		driver = new AndroidDriver<MobileElement>(getServiceUrl(), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initializePages();
	}

	@AfterClass
	public void tearDown() {
		logger.info("Close the &frankly app");
		driver.quit();
	}

	@Test
	public void login() {
		logger.info("Verify Login");

		login.typeEmail(getTestProperties().getProperty("username"));
		login.clickNextOnEmail();
		login.typePassword(getTestProperties().getProperty("password"));
		login.clickNextOnPassword();
		String message = login.getWelcomeMessage();

		Assert.assertEquals(Messages.WELCOME_MESSAGE, message);
	}

	@Test(dependsOnMethods = { "login" })
	public void verifyOnboarding() throws InterruptedException {
		onBoarding.swipeRightToLeft();
		Assert.assertEquals(Messages.PAGE2_TITLE, onBoarding.getPageTwoTitle());

		onBoarding.swipeRightToLeft();
		Assert.assertEquals(Messages.PAGE3_TITLE,
				onBoarding.getPageThreeTitle());

		onBoarding.swipeRightToLeft();
		Assert.assertEquals(Messages.PAGE4_MESSAGE,
				onBoarding.getPageFourTitle());

		onBoarding.clickIUnderstand();
		onBoarding.clickStart();
		onBoarding.clickBegin1();
		onBoarding.clickBegin2();
		onBoarding.getBackContext();

		Assert.assertTrue(onBoarding.isLogoDiaplayed());
	}

	@Test(dependsOnMethods = { "verifyOnboarding" })
	public void verifyFirstQuestion() throws InterruptedException {
		logger.info("Answer first question: (I like my work at this very point in time)");
		questions.clickFirstQuestion();
		questions.swipeSmileyToMax();
		int smileyY = questions.getSmileyYTopLocation();
		int lineY = questions.getLineYTopLocation();
		logger.info("Smilye y: " + smileyY + ", Line y: " + lineY);
		Assert.assertEquals(smileyY, lineY);
	}

	@Test(dependsOnMethods = { "verifyFirstQuestion" })
	public void verifySecondQuestionAndAddComment() throws InterruptedException {
		logger.info("Add comment to second question and skip (If you had the chance today, would you re-apply for your current job?)");

		questions.clickNextQuestion();
		questions.clickComment();
		questions.typeComment("I think I would re-apply");
		questions.getBackContext();
		questions.clickSkipQuestion();
		questions.clickSkipDialog();
		String message = questions.getThirdQuestionMessage();

		Assert.assertEquals(Messages.THIRD_QUESTION_MESSAGE, message);
	}

}
