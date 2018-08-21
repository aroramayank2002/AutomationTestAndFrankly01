package com.andfrankly.android.app.pages;

import java.time.Duration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andfrankly.andriod.app.test.BaseTest;
import com.andfrankly.autotest.util.Elements;

public class Questions extends BaseTest {
	Logger logger = LoggerFactory.getLogger(OnBoarding.class);
	private AndroidDriver<MobileElement> driver;

	By firstQuestion = By.id(Elements.ID_FIRST_QUESTION);
	By smiley = By.xpath(Elements.XPATH_SMILEY);
	By scrollLine = By.id(Elements.ID_LINE);
	By nextQuestion = By.id(Elements.ID_NEXT_QUESTION);
	By comment = By.id(Elements.ID_COMMENT_BUTTON);
	By commentText = By.id(Elements.ID_COMMENT_BOX);
	By skipQuestion = By.id(Elements.ID_SKIP_QUESTION);
	By skipDialog = By.id(Elements.ID_SKIP_DIALOG);
	By thirdQuestionMessage = By.id(Elements.ID_THIRD_QUESTION_MESSAGE);

	public Questions(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void clickFirstQuestion() throws InterruptedException {
		logger.info("Click first question image");
		driver.findElement(firstQuestion).click();
		Thread.sleep(SLEEP_TIME_3_SEC);
	}

	public void swipeSmileyToMax() throws InterruptedException {
		logger.info("Swipe to max upwards");
		TouchAction<AndroidTouchAction> action = new TouchAction<AndroidTouchAction>(
				driver);
		action.press(PointOption.point(522, 1055));
		action.moveTo(PointOption.point(533, 384));
		action.release();
		action.perform();
		Thread.sleep(1000);
	}

	public int getSmileyYTopLocation() {
		MobileElement smileyImage = driver.findElement(smiley);
		int smileyY = (smileyImage.getRect().getY() * 2 + smileyImage.getRect()
				.getHeight()) / 2;
		return smileyY;
	}

	public int getLineYTopLocation() {
		MobileElement lineImage = driver.findElement(scrollLine);
		int lineY = lineImage.getRect().getY();
		return lineY;
	}

	public void clickNextQuestion() {
		logger.info("Click next question button");
		driver.findElement(nextQuestion).click();
	}
	
	public void clickComment(){
		logger.info("Click comment button");
		driver.findElement(comment).click();
	}

	public void typeComment(String comment) {
		logger.info("Enter comment: \"" + comment + "\"");
		driver.findElement(commentText).sendKeys(comment);
	}

	public void getBackContext() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.runAppInBackground(Duration.ofSeconds(5));
		driver.currentActivity();
	}

	public void clickSkipQuestion() {
		logger.info("Click skip question button");
		driver.findElement(skipQuestion).click();
	}

	public void clickSkipDialog() {
		logger.info("Click skip question dialog");
		driver.findElement(skipDialog).click();
	}

	public String getThirdQuestionMessage() {
		logger.info("Verify page is 3rd question and message");
		return driver.findElement(thirdQuestionMessage).getText();
	}
}
