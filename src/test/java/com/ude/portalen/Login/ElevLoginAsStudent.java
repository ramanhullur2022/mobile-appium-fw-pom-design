package com.ude.portalen.Login;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.ElevApp_Login;
import com.ude.portalen.pageobject.Page_UDEMA_1983;
import com.ude.portalen.pageobject.Page_UDEMA_1985;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ElevLoginAsStudent extends Base_Class  {
	

	 ReadConfig config = new ReadConfig();
	public String login_pin = config.get_4_digit_login_pin();
	public String student_username = config.get_student_username();
	public String student_password = config.get_student_password();
	public  String teacher_username = config.get_teacher_username();
	public  String teacher_password = config.get_teacher_password();
	public String parent_login_id = config.get_parent_login_id();
	public String parent_login_password = config.get_parent_login_password();
	public String parent_5_digit_login_pin = config.get_parent_5_digit_login_pin();
	
	/**
	 * Login As Student
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void _loginAsStudent() throws Exception, InterruptedException  {
		SoftAssert softassert = new SoftAssert();
		String expected_msg = null;
		String actual_msg = null; 
	    //start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");
	  
	  launch_Elev_app();
	  ElevApp_Login l1=new  ElevApp_Login(driver2);
		
	  
	  	
		boolean check =l1.loginAsStudentOrTeacher(driver2, student_username, student_password);
		if (check==true) {
		System.out.println("Login Success");
		logger.info("App Login completed");
		test.pass("Portalen_Elev_App_Login_Successfull");
		AndroidDriver driver123=(AndroidDriver) driver2;
		//Thread.sleep(60000);
		driver123.pressKeyCode(AndroidKeyCode.HOME);
		System.out.println("Login Success app running in background");
		logger.info("App is running in background");
		
		//Thread.sleep(60000);
		}
		
		//check for child thread completion
		
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
	 * Login As Student and Close app
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void _loginAsStudent_And_Close_App() throws Exception, InterruptedException  {
		SoftAssert softassert = new SoftAssert();
		String expected_msg = null;
		String actual_msg = null; 
	    //start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");
	  
	  launch_Elev_app();
	  ElevApp_Login l1=new  ElevApp_Login(driver2);
		
	  
	  	
		boolean check =l1.loginAsStudentOrTeacher(driver2, student_username, student_password);
		
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
		
		//check for child thread completion
		
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
		Page_UDEMA_1985 page_2 = new Page_UDEMA_1985(driver2);
		
		page_2.clickOnNotificationBar();
		
		captureScreen(driver2, "notification_bar");
		String screenshot_1 = Base_Class.captureScreenExtent(driver2, "notification_bar");
		test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());
		
		page_2.openNotification();

		
		
		page_2.codeEntryForsatte();
		
		
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
	
	
	
	




}
