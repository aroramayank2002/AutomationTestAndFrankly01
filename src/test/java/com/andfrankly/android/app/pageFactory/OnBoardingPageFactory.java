package com.andfrankly.android.app.pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andfrankly.andriod.app.test.BaseTest;
import com.andfrankly.autotest.util.Elements;

public class OnBoardingPageFactory extends BaseTest {
	Logger logger = LoggerFactory.getLogger(OnBoardingPageFactory.class);
	private AndroidDriver<MobileElement> driver;

	@FindBy(how = How.ID, using = Elements.ID_PAGE_2_TITLE)
	WebElement pageTwoTitle;
	
	@FindBy(how = How.ID, using = Elements.ID_PAGE_3_TITLE)
	WebElement pageThreeTitle;
	
	@FindBy(how = How.ID, using = Elements.ID_PAGE_4_TITLE)
	WebElement pageFourTitle;
	
	@FindBy(how = How.ID, using = Elements.ID_UNDERSTAND)
	WebElement iUnderstand;
	
	@FindBy(how = How.ID, using = Elements.ID_START)
	WebElement start;
	
	@FindBy(how = How.ID, using = Elements.ID_QUESTIONS_BEGIN1)
	WebElement questionBegin1;
	
	@FindBy(how = How.ID, using = Elements.ID_QUESTIONS_BEGIN2)
	WebElement questionBegin2;
	
	@FindBy(how = How.ID, using = Elements.ID_COMPANY_LOGO)
	WebElement companyLogo;

	public OnBoardingPageFactory(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void swipeRightToLeft() {
		logger.info("Swipe onboarding");
		TouchAction<AndroidTouchAction> action = new TouchAction<AndroidTouchAction>(
				driver);
		action.press(PointOption.point(850, 789));
		action.moveTo(PointOption.point(150, 733));
		action.release();
		action.perform();
	}

	public String getPageTwoTitle() {
		return pageTwoTitle.getText();
	}

	public String getPageThreeTitle() {
		return pageThreeTitle.getText();
	}

	public String getPageFourTitle() {
		return pageFourTitle.getText();
	}

	public Boolean isLogoDiaplayed() {
		return companyLogo.isDisplayed();
	}

	public void clickIUnderstand() {
		iUnderstand.click();
	}

	public void clickStart() {
		start.click();
	}

	public void clickBegin1() {
		questionBegin1.click();
	}

	public void clickBegin2() {
		questionBegin2.click();
	}

	public void getBackContext() {
		driver.runAppInBackground(Duration.ofSeconds(5));
		driver.currentActivity();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
