package com.andfrankly.android.app.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andfrankly.andriod.app.test.BaseTest;
import com.andfrankly.autotest.util.Elements;

public class OnBoarding extends BaseTest{
	Logger logger = LoggerFactory.getLogger(OnBoarding.class);
	private AndroidDriver<MobileElement> driver;
	
	By pageTwoTitle = By.id(Elements.ID_PAGE_2_TITLE);
	By pageThreeTitle = By.id(Elements.ID_PAGE_3_TITLE);
	By pageFourTitle = By.id(Elements.ID_PAGE_4_TITLE);
	By iUnderstand = By.id(Elements.ID_UNDERSTAND);
	By start = By.id(Elements.ID_START);
	By questionBegin1 = By.id(Elements.ID_QUESTIONS_BEGIN1);
	By questionBegin2 = By.id(Elements.ID_QUESTIONS_BEGIN2);
	By companyLogo = By.id(Elements.ID_COMPANY_LOGO);
	
	public OnBoarding(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void swipeRightToLeft(){
		logger.info("Swipe onboarding");
		TouchAction<AndroidTouchAction> action = new TouchAction<AndroidTouchAction>(driver);
		action.press(PointOption.point(850, 789));
		action.moveTo(PointOption.point(150, 733));
		action.release();
		action.perform();
	}
	
	public String getPageTwoTitle(){
		return driver.findElement(pageTwoTitle).getText();
	}
	
	public String getPageThreeTitle(){
		return driver.findElement(pageThreeTitle).getText();
	}
	
	public String getPageFourTitle(){
		return driver.findElement(pageFourTitle).getText();
	}
	
	public Boolean isLogoDiaplayed(){
		return driver.findElement(companyLogo).isDisplayed();
	}

	public void clickIUnderstand() {
		driver.findElement(iUnderstand).click();
	}

	public void clickStart() {
		driver.findElement(start).click();
	}

	public void clickBegin1() {
		driver.findElement(questionBegin1).click();
	}

	public void clickBegin2() {
		driver.findElement(questionBegin2).click();
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
