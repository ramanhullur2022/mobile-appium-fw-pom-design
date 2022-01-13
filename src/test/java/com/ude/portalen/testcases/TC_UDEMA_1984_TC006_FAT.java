package com.ude.portalen.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.Page_UDEMA_1984;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_1984_TC006_FAT extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;

	public String expected_result;
	public String actual_result;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1984 
	 * Test Case ID  : UDEMA_1984_TC006
	 * Test Summary  : Student send new message to the Teacher 
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="testData")
	@Test
	public void send_Receive_New_Message_to_Teacher() throws Exception {
		String statusLog = "UDEMA_1984_TC006";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1984_TC006_FAT", "Student send new message to the Teacher");

			//launch_second_app();
			//Send Msg to Student/Parent

			statusLog = "Logging in as Student in Elav App";
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudentInFAT();
			elav_login.loginAsGeneric("student", "fat");
			test.log(Status.PASS, "Student "+config.get_student_username()+" logged in successfully in elev app");

			Page_UDEMA_1984 page = new Page_UDEMA_1984(driver2);

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Teacher("+config.get_teacher_username()+")");

			statusLog = "Clicking Till(To) Button";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Clicked on Till(to) button to select the receipent teacher name from contact list");


//			page.clickOnSchoolDropDown();
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Layout option clicked");
//
//
//			page.clickOnSchoolDropDownOptions();
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "School Drop Down Option clicked");

			//Click on Teacher from Kontakt list
			statusLog = "Selecting Teacher from Contact List";
			//page.selectTeacherFromList();
			//page.selectTeacherIngvildFromList();
			searchForUserAndSelect(driver2, "teacher", "fat", "na");
			logger.info("Teacher selected from Kontakt list");
			test.log(Status.PASS, "Teacher "+config.get_teacher_username()+" selected from Kontakt list");

			//Teacher selection
			String screenshot_tc6 = Base_Class.captureScreenExtent(driver2, "teacher_selected");
			test.pass("Teacher selected from Kotakt", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc6).build());

			statusLog = "Sending mail with mail body and title";
			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Clicked on Emne and entered message title and message body text then clicked on Send button");

			statusLog = "Verifying sent message";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Clicked on Arkiv(archives), Search for sent message in Sendt folder and opening sent message is successfull");
			test.log(Status.PASS, "Student "+config.get_student_username()+" sent message successfully to teacher "+config.get_teacher_username());

			actual_result = page.getActualResult(act_text);

			statusLog = "Logging out from Student";
			page.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out from Student("+config.get_student_username()+") successfully");

			driver2.quit();

		} catch (Exception e) {
			String screen_tc6 = Base_Class.captureScreenExtent(driver2, "screenshot_06");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screen_tc6).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
			return;
		}

		try {
			statusLog = "Logging in as Teacher "+config.get_teacher_username();
			test.log(Status.PASS, "Logging in to Teacher("+config.get_teacher_username()+") to verify email from Student");
			ElevLoginTest elav_login_student = new ElevLoginTest();
			//elav_login_student._loginAsTeacherInFAT();
			elav_login_student.loginAsGeneric("teacher", "fat");
			test.log(Status.PASS, "Login as Teacher("+config.get_teacher_username()+") to verify email from Student("+config.get_student_username()+") is successful");

			Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);
			
			statusLog = "Clicking on Arkiv folder";
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Teacher("+config.get_teacher_username()+") Successfully received email from Student("+config.get_student_username()+")");

			statusLog = "Comparing email sent by student with received mail in teacher";
			expected_result = page2.getExpectedResult(exp_text);
			logger.info("Email matching with the mail sent by Student("+config.get_student_username()+")");
			test.log(Status.PASS, "Email matching with the mail sent by Student("+config.get_student_username()+")");
			
			statusLog = "Logging out from Teacher";
			page2.logout();
			logger.info("Logged out from Teacher successfully");
			test.log(Status.PASS, "Logged out from Teacher("+config.get_teacher_username()+")");

			//android.widget.EditText[@content-desc="Skriv svar her. Dobbeltklikk for å skrive svar"]

			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "screenshot_tc6");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.PASS, "Verification Completed and test case result is PASS");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Soft Assertion Test Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "screenshot_tc6");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.FAIL, "Actual Result: " + actual_result + "\n" + "Expected Result: " + expected_result);
				test.log(Status.FAIL, "Verfication is FAILED");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Soft Assertion Test Fail");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {

			String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Send Message TC execution is completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
		//close_CmdExe();

	}
	
	
	/**
	 * Helper method to extract test data
	 * @author Ramana Gouda
	 * @return
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
