package com.ude.portalen.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.Login.BrowserStudentLogin;
import com.ude.portalen.Login.BrowserTeacherLogin;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.Page_UDEMA_1985;
import com.ude.portalen.pageobject.Page_UDEMA_1988;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.XLUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;



public class TC_UDEMA_1988 extends Base_Class {

	SoftAssert softassert = new SoftAssert();
	public String expected_msg = null;
	public String actual_msg = null;

	String status = "";

	/*
	 * Test Suite ID : UDEMA_1988
	 * Test Case ID  : UDEMA_1988_TC001
	 * Test Summary  : Student send the Push notification message to the Teacher from active and opened state app and open the push notification message
	 * Test Author   : Varun
	 */

	//@Test(dataProvider="testData")
	@Test (enabled=true)
	public void teacher_Receive_Push_Notification() throws InterruptedException, Exception {


		try {

			//app will be ready with login session to receive notification

			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1988_TC001", "Eleven sender Push-varselmeldingen til læreren fra aktiv og åpnet statusapp og åpner pushvarslingsmeldingen fra appen");

			//app will be ready with login session to receive notification
			status = "Eleven logger inn på nettportalen for å sende meldingen om pushvarsling til lærer";
			BrowserStudentLogin  portalen_browser = new BrowserStudentLogin("student_username", "student_password");
			Thread tobj =new Thread(portalen_browser);
			tobj.start();     

			status = "Logger på som lærer";
			//get back to mobile driver session 
			ElevLoginTest elav_login2 = new ElevLoginTest();
			elav_login2._loginAsTeacher();

			while( start_thread_main==false) {
				System.out.println(start_thread_main);
				Thread.sleep(10000);

				AndroidDriver driver124=(AndroidDriver) driver2;
				//driver124.pressKeyCode(AndroidKeyCode.MENU);
				driver124.pressKeyCode(AndroidKeyCode.ENTER);
				if (start_thread_main==true) {
					start_thread_main=false;
					break;

				}
			}
			start_thread_main=false;
			Page_UDEMA_1988 page_2 = new Page_UDEMA_1988(driver2);
			
			status = "Klikk på varslingslinjen";
			page_2.click_Notification_Bar();

			captureScreen(driver2, "notification_bar");
			String screenshot_1 = Base_Class.captureScreenExtent(driver2, "notification_bar");
			test.pass("Varslingslinjen ble åpnet",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());

			status = "Varslingslinjen ble åpnet";
			page_2.open_Notification();

			test.log(Status.PASS, "Varslingslinjen ble åpnet og klikket på varselet");
			//test.pass("Notification bar opened and clicked on notification");
			captureScreen(driver2, "notification");
			String screenshot_2 = Base_Class.captureScreenExtent(driver2, "notification");
			test.pass("klikket på varselet",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());

			status = "Verifiserer meldingstittelen fra den mottatte meldingen i mobilappen";
			expected_msg = page_2.getMessageTitleTextFromReceivedMsg_MobileApp();
			actual_msg = "Msg_at"+msg_time_stamp;
			System.out.println(actual_msg + "\n" + expected_msg);


			//verification
			if(expected_msg.equals(actual_msg)) {
				test.pass("Pass - Testforsøk");
				test.log(Status.PASS, "Utførelse av testsak er fullført");

			}else {
				test.fail("Feil - Testforsøk");
				test.log(Status.FAIL, "Utførelse av testsak kan ikke fullføres, bekreftelse mislykkes");
				System.out.println("Notification not clciked/opened or Different notification opened!");
			}


		}catch (Exception e) {
			test.log(Status.FAIL, "Test saken mislyktes mens "+status+ " med "+e.getClass().getSimpleName()+".");
			String screenshot_3 = Base_Class.captureScreenExtent(driver2, "message_sent_failed");
			test.fail("Bekreftelse av testsak mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
			test.log(Status.FAIL, "Bekreftelse av testsak mislyktes");
			//test.log(Status.ERROR, e.getMessage());
			logger.error("Test case execution failed");
		}

		logger.info(" ==== TC execution is completed!! ===");
		//softassert.assertAll();
		extent.flush();
		driver2.quit();

	}

	/*
	 * Test Suite ID : UDEMA_1988
	 * Test Case ID  : UDEMA_1988_TC002
	 * Test Summary  : Teacher sends the push notification message to Student in active and opened app state and opening the push notification message
	 * Test Author   : Varun
	 */
	@Test(enabled=true)
	public void Student_Receive_Push_Notification() throws InterruptedException, Exception {


		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1988_TC002", "Lærer sender pushvarslingsmeldingen til Student inaktiv og åpnet appstatus og åpner pushvarslingsmeldingen");

			//send msg notification
			status="Lærer som sender en ny melding til en student fra nettportelan-appen";
			BrowserTeacherLogin  portalen_browser = new BrowserTeacherLogin("teacher_username", "teacher_password");
			Thread tobj =new Thread(portalen_browser);
			tobj.start();

			status = "Logger på som Elev";
			//get back to mobile driver session 
			ElevLoginTest elav_login2 = new ElevLoginTest();
			elav_login2._loginAsStudent();

			while( start_thread_main==false) {
				System.out.println(start_thread_main);
				Thread.sleep(10000);

				AndroidDriver driver124=(AndroidDriver) driver2;
				//driver124.pressKeyCode(AndroidKeyCode.MENU);
				driver124.pressKeyCode(AndroidKeyCode.ENTER);
				if (start_thread_main==true) {
					start_thread_main=false;
					break;

				}
			}


			start_thread_main=false;
			Page_UDEMA_1988 page_2 = new Page_UDEMA_1988(driver2);

			status = "Bla ned statuslinjen på den mobile enheten for å sjekke mottatt varsel";
			page_2.click_Notification_Bar();

			captureScreen(driver2, "notification_bar");
			String screenshot_1 = Base_Class.captureScreenExtent(driver2, "notification_bar");
			test.pass("Varslingslinjen klikket",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());

			status = "Åpningsvarsel";
			page_2.open_Notification();

			test.log(Status.PASS, "Varslingslinjen ble åpnet og klikket på varselet");
			//test.pass("Notification bar opened and clicked on notification");
			captureScreen(driver2, "notification");
			String screenshot_2 = Base_Class.captureScreenExtent(driver2, "notification");
			test.pass("Varslingslinjen ble åpnet og klikket på varselet",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());

			status = "Henter meldetitteltekst fra den mottatte meldingen i mobilappen";
			expected_msg = page_2.getMessageTitleTextFromReceivedMsg_MobileApp();
			actual_msg = "Msg_at"+msg_time_stamp;
			System.out.println(actual_msg + "\n" + expected_msg);


			//verification
			if(expected_msg.equals(actual_msg)) {
				test.pass("Testfall passerer");
				test.log(Status.PASS, "Utførelse av testsak er fullført");

			}else {
				test.fail("Test saken mislyktes");
				test.log(Status.FAIL, "Utførelse av testsak kan ikke fullføres, bekreftelse mislykkes");
				System.out.println("Notification not clciked/opened or Different notification opened!");
			}

		}catch (Exception e) {

			String screenshot_3 = Base_Class.captureScreenExtent(driver2, "message_sent_failed");
			test.fail("Test saken mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
			test.log(Status.FAIL, "Test saken mislyktes");
			test.log(Status.ERROR, e.getMessage());
			logger.error("Test case execution failed");
			test.log(Status.FAIL, "Test saken mislyktes mens "+status+ " med "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== TC execution is completed!! ===");
		//softassert.assertAll();
		extent.flush();
		driver2.quit();
	}

	/*
	 * Test Suite ID : UDEMA_1988
	 * Test Case ID  : UDEMA_1988_TC003
	 * Test Summary  : Teacher sends a push notification message to the Parent in active and opened app state and parent open the push notification message
	 * Test Author   : Varun
	 */
	@Test(enabled=true)
	public void Parent_Receive_Push_Notification() throws InterruptedException, Exception {


		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1988_TC003", "Lærer som sender en pushvarslingsmelding til Foresatte med aktiv og åpnet appstatus og foreldre åpner pushvarslingsmeldingen fra appen");

			//send msg notification
			status = "Lærer som sender en melding til Foresatte fra nettportelan-appen";
			BrowserTeacherLogin  portalen_browser = new BrowserTeacherLogin("teacher_username", "teacher_password");
			Thread tobj =new Thread(portalen_browser);
			tobj.start();      

			
			//get back to mobile driver session 
			status = "Logg inn som foresatte";
			ForesatteLoginTest Forsatte_login2 = new ForesatteLoginTest();
			Forsatte_login2._loginAsParent(); 

			//check for child thread completion

			while( start_thread_main==false) {
				System.out.println(start_thread_main);
				Thread.sleep(10000);
				AndroidDriver driver124=(AndroidDriver) driver;
				driver124.pressKeyCode(AndroidKeyCode.ENTER);
				if (start_thread_main==true) {
					start_thread_main=false;
					break;

				}
			}

			start_thread_main=false;
			//continue the mobile app driver session and click on status bar and notification
			Page_UDEMA_1988 page_2 = new Page_UDEMA_1988(driver);
			status = "Klikk på varslingslinjen";
			page_2.click_Parent_Notification_Bar();

			captureScreen(driver, "notification_bar");
			String screenshot_1 = Base_Class.captureScreenExtent(driver, "notification_bar");
			test.pass("Klikk på varslingslinjen",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());

			status = "Rull ned på enhetens statuslinje for å bekrefte pushvarsling";
			page_2.open_Notification();

			test.log(Status.PASS, "Varslingslinjen ble åpnet og klikket på varselet");
			//test.pass("Notification bar opened and clicked on notification");
			captureScreen(driver, "notification");
			String screenshot_2 = Base_Class.captureScreenExtent(driver, "notification");
			test.pass("Varslingslinjen ble åpnet og klikket på varselet",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());

			status = "Få taksttekst fra meldingen fra den mottatte meldingen i mobilappen";
			expected_msg = page_2.getMessageTitleTextFromReceivedMsg_MobileApp();
			actual_msg = "Msg_at"+msg_time_stamp;
			System.out.println(actual_msg + "\n" + expected_msg);


			//verification
			if(expected_msg.equals(actual_msg)) {
				test.pass("Testsak bestått");
				test.log(Status.PASS, "Utførelse av testsak er fullført");

			}else {
				test.fail("Test saken mislyktes");
				test.log(Status.FAIL, "Utførelse av testsak kan ikke fullføres, bekreftelse mislykkes");
				System.out.println("Notification not clciked/opened or Different notification opened!");
			}

		}catch (Exception e) {
			String screenshot_3 = Base_Class.captureScreenExtent(driver2, "message_sent_failed");
			test.fail("Test saken mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
			test.log(Status.FAIL, "Test saken mislyktes");
			logger.error("Test case execution failed");
			test.log(Status.FAIL, "Test saken mislyktes mens "+status+ " med "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== TC execution is completed!! ===");
		//softassert.assertAll();
		extent.flush();
		driver.quit();

	}

	
	/**
	 * Helper method to extract test data
	 * @author Ramana Gouda
	 * @return searchdata
	 * @throws IOException
	 */
	@DataProvider(name = "testData")
	String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/test-data/Test_Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet3");
		int colcount = XLUtils.getCellCount(path, "Sheet3", 1);
		String searchdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				searchdata[i - 1][j] = XLUtils.getCellData(path, "Sheet3", i, j);// 1 0
			}
		}
		return searchdata;
	}



}