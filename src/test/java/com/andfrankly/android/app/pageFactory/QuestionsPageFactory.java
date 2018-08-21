package com.andfrankly.android.app.pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andfrankly.andriod.app.test.BaseTest;
import com.andfrankly.autotest.util.Elements;

public class QuestionsPageFactory extends BaseTest {
	Logger logger = LoggerFactory.getLogger(QuestionsPageFactory.class);
	private AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
	@FindBy(how = How.XPATH, using = Elements.XPATH_SMILEY)
	WebElement smiley;
	
	@FindBy(how = How.ID, using = Elements.ID_FIRST_QUESTION)
	WebElement firstQuestion;
	
	@FindBy(how = How.ID, using = Elements.ID_LINE)
	WebElement scrollLine;
	
	@FindBy(how = How.ID, using = Elements.ID_NEXT_QUESTION)
	WebElement nextQuestion;
	
	@FindBy(how = How.ID, using = Elements.ID_COMMENT_BUTTON)
	WebElement comment;
	
	@FindBy(how = How.ID, using = Elements.ID_COMMENT_BOX)
	WebElement commentText;
	
	@FindBy(how = How.ID, using = Elements.ID_SKIP_QUESTION)
	WebElement skipQuestion;
	
	@FindBy(how = How.ID, using = Elements.ID_SKIP_DIALOG)
	WebElement skipDialog;
	
	@FindBy(how = How.ID, using = Elements.ID_THIRD_QUESTION_MESSAGE)
	WebElement thirdQuestionMessage;
	
	public QuestionsPageFactory(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, 10);
		PageFactory.initElements(factory, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void clickFirstQuestion()  {
		logger.info("Click first question image");
		firstQuestion.click();
	}

	public void swipeSmileyToMax()  {
		logger.info("Swipe to max upwards");
		wait.until(ExpectedConditions.visibilityOf(smiley));
		TouchAction<AndroidTouchAction> action = new TouchAction<AndroidTouchAction>(
				driver);
		action.press(PointOption.point(522, 1055));
		action.moveTo(PointOption.point(533, 384));
		action.release();
		action.perform();
	}

	public int getSmileyYTopLocation() {
		int smileyY = (smiley.getRect().getY() * 2 + smiley.getRect()
				.getHeight()) / 2;
		return smileyY;
	}

	public int getLineYTopLocation() {
		int lineY = scrollLine.getRect().getY();
		return lineY;
	}

	public void clickNextQuestion() {
		logger.info("Click next question button");
		nextQuestion.click();
	}
	
	public void clickComment(){
		logger.info("Click comment button");
		comment.click();
	}

	public void typeComment(String comment) {
		logger.info("Enter comment: \"" + comment + "\"");
		commentText.sendKeys(comment);
	}

	public void getBackContext() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.runAppInBackground(Duration.ofSeconds(5));
		driver.currentActivity();
	}

	public void clickSkipQuestion() {
		logger.info("Click skip question button");
		skipQuestion.click();
	}

	public void clickSkipDialog() {
		logger.info("Click skip question dialog");
		skipDialog.click();
	}

	public String getThirdQuestionMessage() {
		logger.info("Verify page is 3rd question and message");
		return thirdQuestionMessage.getText();
	}
}
