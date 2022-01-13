package com.ude.portalen.pageobject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Page_UDEMA_1983 extends Base_Class {

	public Page_UDEMA_1983(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();
	public String Msg_Body = "inlaa014 msg_body" + dtf.format(now);
	public String Msg_Title = "inlaa014 msg_title" + dtf.format(now);
	public String Reply_Msg = "Teacher Reply Message " + dtf.format(now);

	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Logg ut']")
	@CacheLookup
	public WebElement Click_Logout;

	@FindBy(xpath="//android.widget.Button[@content-desc='Clear all notifications.']")
	@CacheLookup
	public WebElement Click_Clear_Notifications;

	@FindBy(xpath="(//android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout)")
	@CacheLookup
	public WebElement Click_Notification;

	@FindBy(xpath="(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Received_Mag_Title_MobileApp;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='button-ok']")
	@CacheLookup
	public WebElement OK_Btton;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='input-pin-code']")
	@CacheLookup
	public WebElement Pin1;

	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	@CacheLookup
	public WebElement OK_Button_Forsatte;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='input-pin-code']")
	@CacheLookup
	public WebElement Input_Pin_Code_Forsatte;

	
	
	/**
	 * Get Message title text from received message
	 * @return message title text
	 * @throws InterruptedException
	 */

	public String getMessageTitleTextFromReceivedMsgInMobileApp() throws InterruptedException {
		Thread.sleep(5000);
		String msg_title = get_Received_Mag_Title_MobileApp.getText();
		return msg_title;
	}

	/**
	 * Click on Notification bar
	 * @throws InterruptedException
	 */
	//@SuppressWarnings("rawtypes")
	public void clickOnNotificationBar() throws InterruptedException {
		//driver2.quit();
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver2);
		touchAction.longPress(PointOption.point(460, 40)).moveTo(PointOption.point(480, 1140)).release().perform();
		Thread.sleep(1000);	
	}

	/**
	 * Click on parent notification bar
	 * @throws InterruptedException
	 */
	
	//@SuppressWarnings("rawtypes")
	public void clickOnParentNotificationBar() throws InterruptedException {
		//driver2.quit();
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.longPress(PointOption.point(460, 40)).moveTo(PointOption.point(480, 1140)).release().perform();
		Thread.sleep(1000);	
	}

	/**
	 * Open Notification
	 * @throws InterruptedException
	 */
	
	public void openNotification() throws InterruptedException {
		Thread.sleep(5000);
		Click_Notification.click();
		Thread.sleep(6000);	
	}

	/**
	 * Enter PIN and press OK
	 * @throws InterruptedException
	 */
	
	public void CodeEntry() throws InterruptedException {

		Thread.sleep(5000);
		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver2, OK_Btton, 60);

		if(Print_Screen_Present == true) {
			Pin1.sendKeys("2510");
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}
	}

	/**
	 * Enter PIN and press OK in Foresatte app
	 * @throws InterruptedException
	 */
	
	public void CodeEntry_Forsatte() throws InterruptedException {

		Thread.sleep(5000);
		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Button_Forsatte, 60);

		if(Print_Screen_Present == true) {
			Input_Pin_Code_Forsatte.sendKeys("2510");
			Thread.sleep(2000);
			OK_Button_Forsatte.click();
			Thread.sleep(3000);
		}
	}
}
