package com.ude.portalen.Login;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.ElevApp_Login;
import com.ude.portalen.pageobject.Page_UDEMA_1983;
import com.ude.portalen.pageobject.Page_UDEMA_1985;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ElevLoginAsTeacher extends Base_Class  {

	ReadConfig config = new ReadConfig();
	public String login_pin = config.get_4_digit_login_pin();
	public String student_username = config.get_student_username();
	public String student_password = config.get_student_password();
	public  String teacher_username = config.get_teacher_username();
	public  String teacher_password = config.get_teacher_password();
	public String parent_login_id = config.get_parent_login_id();
	public String parent_login_password = config.get_parent_login_password();
	public String parent_5_digit_login_pin = config.get_parent_5_digit_login_pin();


	@SuppressWarnings("deprecation")
	@Description("Teacher  receive new message - Receive push notification")
	@Severity(SeverityLevel.NORMAL)
	@Attachment(value="Send_Reply_to_student", type ="image/png")


	/**
	 * Login As Teacher
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void _loginAsTeacher() throws Exception, InterruptedException {

		SoftAssert softassert = new SoftAssert();
		String expected_msg = null;
		String actual_msg = null;
		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		extent = ExtentManager.GetExtent();

		launch_Elev_app();

		//login with teacher account
		ElevApp_Login l1=new  ElevApp_Login(driver2);
		boolean check =l1.loginAsStudentOrTeacher(driver2, teacher_username, teacher_password);

		if (check==true) {
			System.out.println("Login Success");
			logger.info("App Login completed");
			test.pass("Portalen_Elev_App_Login_Successfull");

			//((AppiumDriver)driver2).pressKeyCode(new KeyEvent(AndroidKey.HOME));
			AndroidDriver driver123=(AndroidDriver) driver2;
			driver123.pressKeyCode(AndroidKeyCode.HOME);
			System.out.println("Login Success app running in background");
			logger.info("App is running in background");



		}

		//wait to finish the child thread

		while( start_thread_main==false) {
			System.out.println(start_thread_main);
			Thread.sleep(10000);
			AndroidDriver driver124=(AndroidDriver) driver2;
			driver124.pressKeyCode(AndroidKeyCode.HOME);
			if (start_thread_main==true) {
				start_thread_main=false;
				break;

			}
		}

		start_thread_main=false;
		Page_UDEMA_1983 page_2 = new Page_UDEMA_1983(driver2);
		page_2.clickOnNotificationBar();

		captureScreen(driver2, "notification_bar");
		String screenshot_1 = Base_Class.captureScreenExtent(driver2, "notification_bar");
		test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());

		page_2.openNotification();

		test.log(Status.PASS, "Notification bar opened and clicked on notification");
		test.pass("Notification bar opened and clicked on notification");
		captureScreen(driver2, "notification");
		String screenshot_2 = Base_Class.captureScreenExtent(driver2, "notification");
		test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());


		expected_msg = page_2.getMessageTitleTextFromReceivedMsgInMobileApp();
		actual_msg = "Msg_at"+msg_time_stamp;
		System.out.println(actual_msg + "\n" + expected_msg);


		//verification
		if(expected_msg.equals(actual_msg)) {
			test.pass("Test PASSED");
			test.log(Status.PASS, "Test case execution is completed");

		}else {
			test.fail("Test FAILED");
			test.log(Status.FAIL, "Test case execution is failed to complete, varification gets failed");
			System.out.println("Notification not clciked/opened or Different notification opened!");
		}


	}

	/**
	 * Login As Teacher and Close App
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Description("Teacher  receive new message - Receive push notification")
	@Severity(SeverityLevel.NORMAL)
	@Attachment(value="Send_Reply_to_student", type ="image/png")


	public void _loginAsTeacher_And_Close_App() throws Exception, InterruptedException {

		SoftAssert softassert = new SoftAssert();
		String expected_msg = null;
		String actual_msg = null;
		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		extent = ExtentManager.GetExtent();

		launch_Elev_app();

		//login with teacher account
		ElevApp_Login l1=new  ElevApp_Login(driver2);
		boolean check =l1.loginAsStudentOrTeacher(driver2, teacher_username, teacher_password);

		if (check==true) {
			System.out.println("Login Success");
			logger.info("App Login completed");
			//test.pass("Portalen_Elev_App_Login_Successfull");
			AndroidDriver driver123=(AndroidDriver) driver2;
			//driver123.closeApp();
			//driver123.pressKeyCode(AndroidKeyCode.BACK);
			driver123.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
			driver123.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CLEAR ALL\"));");
			MobileElement topCharts = ((AndroidDriver<MobileElement>)driver123).findElementByAndroidUIAutomator("new UiSelector().text(\"CLEAR ALL\")");
			TouchAction t = new TouchAction((PerformsTouchActions) driver2); 
			t.tap(tapOptions().withElement(element(topCharts))).perform();


			System.out.println("Login Success app now App  is close ");
			logger.info("App is close ");



		}

		//wait to finish the child thread

		while( start_thread_main==false) {
			System.out.println(start_thread_main);
			Thread.sleep(10000);
			AndroidDriver driver124=(AndroidDriver) driver2;
			driver124.pressKeyCode(AndroidKeyCode.ENTER);
			if (start_thread_main==true) {
				start_thread_main=false;
				break;

			}
		}

		start_thread_main=false;
		Page_UDEMA_1985 page_2 = new Page_UDEMA_1985(driver2);
		page_2.clickOnNotificationBar();

		captureScreen(driver2, "notification_bar");
		String screenshot_1 = Base_Class.captureScreenExtent(driver2, "notification_bar"+System.currentTimeMillis());
		test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());

		page_2.openNotification();


		page_2.codeEntryForsatte();

		test.log(Status.PASS, "Notification bar opened and clicked on notification");
		test.pass("Notification bar opened and clicked on notification");
		captureScreen(driver2, "notification");
		String screenshot_2 = Base_Class.captureScreenExtent(driver2, "notification"+System.currentTimeMillis());
		test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());



		expected_msg = page_2.getMessageTitleTextFromReceivedMsgInMobileApp();
		actual_msg = "Msg_at"+msg_time_stamp;
		System.out.println(actual_msg + "\n" + expected_msg);


		//verification
		if(expected_msg.equals(actual_msg)) {
			test.pass("Test PASSED");
			test.log(Status.PASS, "Test case execution is completed");

		}else {
			test.fail("Test FAILED");
			test.log(Status.FAIL, "Test case execution is failed to complete, varification gets failed");
			System.out.println("Notification not clciked/opened or Different notification opened!");
		}


	}

}





