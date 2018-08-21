package com.andfrankly.andriod.app.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.time.Duration;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.andfrankly.autotest.util.Elements;
import com.andfrankly.autotest.util.Messages;

public class TestAndroidApp extends BaseTest {

	private AndroidDriver<WebElement> driver;

	Logger logger = LoggerFactory.getLogger(TestAndroidApp.class);

//	@BeforeClass
//	public void setUp() throws IOException {
//		logger.info("Verifying &Frankly on Android");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//
//		Enumeration<?> e = getCapabilities().propertyNames();
//		logger.debug("Property count " + getCapabilities().size());
//		while (e.hasMoreElements()) {
//			String key = (String) e.nextElement();
//			String value = getCapabilities().getProperty(key);
//			logger.debug("Key : '" + key + "', Value : '" + value + "'");
//			if (value.trim().equalsIgnoreCase("false")
//					|| value.trim().equalsIgnoreCase("true")) {
//				capabilities.setCapability(key, Boolean.parseBoolean(value));
//			} else {
//				capabilities.setCapability(key, value);
//			}
//		}
//
//		driver = new AndroidDriver<WebElement>(getServiceUrl(), capabilities);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//	}
//
//	@AfterClass
//	public void tearDown() {
//		logger.info("Close the &frankly app");
//		driver.quit();
//	}
//
//	@Test
//	public void login() {
//		logger.info("Verify Login");
//
//		MobileElement emailField = (MobileElement) driver.findElement(By
//				.xpath(Elements.XPATH_EMAIL));
//		logger.info("Enter email: " + getTestProperties().getProperty("username"));
//		emailField.sendKeys(getTestProperties().getProperty("username"));
//
//		MobileElement nextButton = (MobileElement) driver
//				.findElementById(Elements.ID_EMAIL_NEXT);
//		logger.info("Click next button");
//		nextButton.click();
//
//		MobileElement passwordField = (MobileElement) driver.findElement(By
//				.xpath(Elements.XPATH_PASSWORD));
//		logger.info("Enter password :" + getTestProperties().getProperty("password"));
//		passwordField.sendKeys(getTestProperties().getProperty("password"));
//
//		MobileElement passNextButton = (MobileElement) driver
//				.findElementById(Elements.ID_PASSWORD_NEXT);
//		logger.info("Click password next button");
//		passNextButton.click();
//
//		MobileElement welcomeLabel = (MobileElement) driver
//				.findElementById(Elements.ID_WELCOME_MESSAGE);
//		logger.info("Assert welcome message: " + welcomeLabel.getText());
//		Assert.assertEquals(Messages.WELCOME_MESSAGE,
//				welcomeLabel.getText());
//	}
//
//	@Test(dependsOnMethods = { "login" })
//	public void verifyOnboarding() throws InterruptedException {
//		PointOption<ElementOption> swipeStart = PointOption.point(850, 789);
//		PointOption<ElementOption> swipeEnd = PointOption.point(150, 733);
//
//		logger.info("Swipe 1 onboarding");
//		TouchAction<AndroidTouchAction> action = new TouchAction<AndroidTouchAction>(driver);
//		action.press(swipeStart);
//		action.moveTo(swipeEnd);
//		action.release();
//		action.perform();
//
//		MobileElement pageLabel = (MobileElement) driver
//				.findElementById(Elements.ID_PAGE_2_TITLE);
//		logger.info("Verify page title: " + pageLabel.getText());
//		Assert.assertEquals(Messages.PAGE2_TITLE, pageLabel.getText());
//
//		logger.info("Swipe 2 onboarding");
//		action.press(swipeStart);
//		action.moveTo(swipeEnd);
//		action.release();
//		action.perform();
//
//		pageLabel = (MobileElement) driver
//				.findElementById(Elements.ID_PAGE_3_TITLE);
//		logger.info("Verify page title: " + pageLabel.getText());
//		Assert.assertEquals(Messages.PAGE3_TITLE, pageLabel.getText());
//
//		logger.info("Swipe 3 onboarding");
//		action.press(swipeStart);
//		action.moveTo(swipeEnd);
//		action.release();
//		action.perform();
//
//		pageLabel = (MobileElement) driver
//				.findElementById(Elements.ID_PAGE_4_TITLE);
//		logger.info("Verify page title: " + pageLabel.getText());
//		Assert.assertEquals(Messages.PAGE4_MESSAGE, pageLabel.getText());
//
//		MobileElement iUnderstandButton = (MobileElement) driver
//				.findElementById(Elements.ID_UNDERSTAND);
//		logger.info("Click i-understand button");
//		iUnderstandButton.click();
//
//		MobileElement tutorialButton = (MobileElement) driver
//				.findElementById(Elements.ID_START);
//		logger.info("Click start button");
//		tutorialButton.click();
//
//		MobileElement questionsButton = (MobileElement) driver
//				.findElementById(Elements.ID_QUESTIONS_BEGIN1);
//		logger.info("Click questions button");
//		questionsButton.click();
//
//		MobileElement introQuestionsButton = (MobileElement) driver
//				.findElementById(Elements.ID_QUESTIONS_BEGIN2);
//		logger.info("Click intro questions image");
//		introQuestionsButton.click();
//
//		driver.runAppInBackground(Duration.ofSeconds(5));
//		driver.currentActivity();
//		Thread.sleep(5000);
//
//		MobileElement companyLogo = (MobileElement) driver
//				.findElementById(Elements.ID_COMPANY_LOGO);
//		logger.info("Verify company logo displays.");
//		Assert.assertTrue(companyLogo.isDisplayed());
//	}
//
//	@Test(dependsOnMethods = { "verifyOnboarding" })
//	public void verifyFirstQuestion() throws InterruptedException {
//		logger.info("Answer first question: (I like my work at this very point in time)");
//		MobileElement firstQuestionsButton = (MobileElement) driver
//				.findElementById(Elements.ID_FIRST_QUESTION);
//		logger.info("Click first question image");
//		firstQuestionsButton.click();
//		Thread.sleep(SLEEP_TIME_3_SEC);
//
//		logger.info("Swipe to max upwards");
//		TouchAction<AndroidTouchAction> action = new TouchAction<AndroidTouchAction>(driver);
//		action.press(PointOption.point(522, 1055));
//		action.moveTo(PointOption.point(533, 384));
//		action.release();
//		action.perform();
//		Thread.sleep(1000);
//
//		// Verify value is 100%
//		MobileElement smileyImage = (MobileElement) driver.findElement(By
//				.xpath(Elements.XPATH_SMILEY));
//		int smileyY = (smileyImage.getRect().getY() * 2 + smileyImage.getRect()
//				.getHeight()) / 2;
//
//		MobileElement lineImage = (MobileElement) driver
//				.findElementById(Elements.ID_LINE);
//		int lineY = lineImage.getRect().getY();
//		logger.info("Smilye y: " + smileyY + ", Line y: " + lineY);
//		Assert.assertEquals(smileyY, lineY);
//	}
//
//	@Test(dependsOnMethods = { "verifyFirstQuestion" })
//	public void verifySecondQuestionAndAddComment() throws InterruptedException {
//		logger.info("Add comment to second question and skip (If you had the chance today, would you re-apply for your current job?)");
//
//		MobileElement nextQuestionButton = (MobileElement) driver
//				.findElementById(Elements.ID_NEXT_QUESTION);
//		logger.info("Click next question button");
//		nextQuestionButton.click();
//		Thread.sleep(SLEEP_TIME_3_SEC);
//
//		MobileElement commentButton = (MobileElement) driver
//				.findElementById(Elements.ID_COMMENT_BUTTON);
//		logger.info("Click comment button");
//		commentButton.click();
//		//
//		MobileElement commentTextBox = (MobileElement) driver
//				.findElementById(Elements.ID_COMMENT_BOX);
//		logger.info("Enter comment: \"I think I would re-apply\"");
//		commentTextBox.sendKeys("I think I would re-apply");
//
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		
//		driver.runAppInBackground(Duration.ofSeconds(5));
//		driver.currentActivity();
//
//		MobileElement skipButton = (MobileElement) driver
//				.findElementById(Elements.ID_SKIP_QUESTION);
//		logger.info("Click skip question button");
//		skipButton.click();
//
//		MobileElement skipButtonDialog = (MobileElement) driver
//				.findElementById(Elements.ID_SKIP_DIALOG);
//		logger.info("Click skip question dialog");
//		skipButtonDialog.click();
//
//		MobileElement thirdQuestionMessage = (MobileElement) driver
//				.findElementById("com.andfrankly.app:id/question_title");
//		logger.info("Verify page is 3rd question and message: " + thirdQuestionMessage.getText());
//		Assert.assertEquals(Messages.THIRD_QUESTION_MESSAGE,
//				thirdQuestionMessage.getText());
//	}
}