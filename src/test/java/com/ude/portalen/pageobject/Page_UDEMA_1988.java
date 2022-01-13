package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class Page_UDEMA_1988 extends Base_Class{

	public Page_UDEMA_1988(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout)")
	@CacheLookup
	public WebElement Click_Notification;

	@FindBy(xpath="(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Received_Mag_Title_MobileApp;

	
	/**
	 * Clicks on Notification
	 * @throws InterruptedException
	 */
	
	//@SuppressWarnings("rawtypes")
	public void click_Notification() throws InterruptedException {

		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver2);
		touchAction.longPress(PointOption.point(460, 40)).moveTo(PointOption.point(480, 1140)).release().perform();

		Thread.sleep(5000);
		//driver2.pressKeyCode(AndroidKeyCode.BACK);
		//driver2.pressKey(new KeyEvent(AndroidKey.BACK));
		Click_Notification.click();
		Thread.sleep(3000);	
	}

	/**
	 * Drags Notification Bar
	 * @throws InterruptedException
	 */
	
	//@SuppressWarnings("rawtypes")
	public void click_Notification_Bar() throws InterruptedException {
		//driver2.quit();
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver2);
		touchAction.longPress(PointOption.point(460, 40)).moveTo(PointOption.point(480, 1140)).release().perform();
		Thread.sleep(1000);	
	}

	/**
	 * Opens up Notification
	 * @throws InterruptedException
	 */
	
	public void open_Notification() throws InterruptedException {
		Thread.sleep(5000);
		Click_Notification.click();
		Thread.sleep(3000);	
	}

	/**
	 * Click on Parent Notification Bar
	 * @throws InterruptedException
	 */
	
	//@SuppressWarnings("rawtypes")
	public void click_Parent_Notification_Bar() throws InterruptedException {
		//driver2.quit();
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.longPress(PointOption.point(460, 40)).moveTo(PointOption.point(480, 1140)).release().perform();
		Thread.sleep(1000);	
	}

	/**
	 * Get Message Title Text from Received Message
	 * @return
	 * @throws InterruptedException
	 */
	
	public String getMessageTitleTextFromReceivedMsg_MobileApp() throws InterruptedException {
		Thread.sleep(3000);
		String msg_title = get_Received_Mag_Title_MobileApp.getText();
		return msg_title;
	}
}
