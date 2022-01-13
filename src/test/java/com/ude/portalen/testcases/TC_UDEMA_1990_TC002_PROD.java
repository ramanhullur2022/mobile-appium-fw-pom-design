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
import com.ude.portalen.pageobject.Page_UDEMA_1990;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_UDEMA_1990_TC002_PROD extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String act_text;
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1990 
	 * Test Case ID  : UDEMA_1990_TC002 
	 * Test Summary  : Send reply from Student to Teacher 
	 * Test Author   : S, Manjunath
	 */
	@Test
	@Description("UDEMA_1990_TC002 : Send reply from Student to Teacher")
	@Severity(SeverityLevel.NORMAL)
	@Attachment(value = "UDEMA_1990_TC_002", type = "image/png")
	public void send_reply_from_student_to_teacher() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_1990_TC002";
		try {
			// Initiate Extent Report
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1990_TC002_FAT", "Send Reply from Student to Teacher");

			// Teacher Login begins
			statusLog = "Elev App Login";
			ElevLoginTest elev_login_teacher = new ElevLoginTest();
			//elev_login_teacher._loginAsTeacherInFAT();
			elev_login_teacher.loginAsGeneric("teacher", "prod");
			test.log(Status.PASS, config.get_fat_teacher_username()+" logged in successfully in elev app");
			logger.info("Logged in as Teacher Successfully");

			// Click on Compose mail
			statusLog = "Clicking Message Compose button";
			Page_UDEMA_1990 page = new Page_UDEMA_1990(driver2);
			page.clickOnMailComposeButton();
			logger.info("Message Compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Student("+config.get_fat_student_username()+")");

			// Click on Svar av to enable reply
			statusLog = "Clicking Svar av toggle button";
			page.clickSvarAvButton();
			logger.info("Svar av clicked - reply enabled");
			test.log(Status.PASS, "Clicked on Svar av toggle button to enable reply");

			// Click on To Button
			statusLog = "Clicking Till(To) button";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Clicked on Till(to) button to select the receipent student name from contact list");

//			// Click on School Drop down
//			statusLog = "Clicking School Drop down";
//			page.clickOnSchoolDropDown("Teacher");
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Clicked on Velg Skole(select school) drop down and schools list displayed");
//
//			// Select school from Drop down
//			statusLog = "Clicking Scholl Drop down options";
//			page.clickOnSchoolDropDownOptions("Teacher");
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "Clicked on CGI testgrunnskole from schools drop down options");
//
//			// Select Personar tab
//			statusLog = "Clicking Personer tab";
//			page.clickOnPersonerTab();
//			logger.info("Personar tab clicked");
//			test.log(Status.PASS, "Click on Personer Tab to select student "+config.get_fat_student_username());
//
//			// Search for student
//			statusLog = "Clicking search input box and searching for student";
//			page.clickSearchInputEditText("alana032");
//			logger.info("Student searched");
//			test.log(Status.PASS, "Clicked on search input box and search for student "+config.get_fat_student_username());
//
//			// Click on student and press OK
//			statusLog = "Clicking searched student";
//			page.clickOnSearchResultOfStudentName();
//			logger.info("Student selected");
//			test.log(Status.PASS, "Searched for student "+config.get_fat_student_username()+" and click on Eleven + Foresatte checkbox");

			page.searchForUserAndSelect(driver2, "student", "prod", "eleven_and_foresatte");
			
			// Take screenshot of Student selection
			String studentSelectionScreenshot = Base_Class.captureScreenExtent(driver2, "TC_UDEMA_1990_TC_002_student_selected");
			test.pass("Student selected from Personar", MediaEntityBuilder.createScreenCaptureFromPath(studentSelectionScreenshot).build());

			// Input Message title and body and Send
			statusLog = "Entering message body and message title";
			page.editMsgAndSendMsg();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Clicked on Emne and entered message title and message body text then clicked on Send button");

			// Verify sent message in Arkiv-Sendt folder
			statusLog = "Verifying sent message from teacher to student";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Clicked on Arkiv(archives), Search for sent message in Sendt folder and opening sent message is successfull");
			test.log(Status.PASS, "Teacher "+config.get_fat_teacher_username()+" sent message successfully to student "+config.get_fat_student_username());

			// Logout from Teacher
			statusLog = "Logging out from Teacher";
			page.logout();
			logger.info("Logged out from Teacher successfully");
			test.log(Status.PASS, "Logged out from Teacher "+config.get_fat_teacher_username()+" successfully");

			statusLog = "Logging in as Student to verify reply received";
			logger.info("Beginning of Student Login!!");
			// Login to Elev app as Student to check reply received
			ElevLoginTest elev_login_student = new ElevLoginTest();
			elev_login_student._loginAsStudentWithExistingSessionInFAT();
			test.log(Status.PASS, "Log in as Student - "+config.get_fat_student_username()+" is successful");

			// Click on Arkiv folder
			statusLog = "Clicking on Arkiv folder";
			page.clickArkivFolder();
			logger.info("Clicked on Arkiv folder");
			test.log(Status.PASS, "Click and opened Arkive(Archives) folder");

			// Click on Mottatt folder
			statusLog = "Clicking on Mottatt folder";
			page.clickMottatt();
			logger.info("Clicked on Mottatt folder");
			test.log(Status.PASS, "Click and opened Mottatt(Received) folder to check received messages");

			// Search for received message and open it
			statusLog = "Searching for message from teacher and opening it";
			page.searchReceivedMsgAndClick();
			logger.info("Opened received message");
			test.log(Status.PASS, "Search for message from Teacher "+config.get_fat_teacher_username()+" and Open received message");
			test.log(Status.PASS, "Successfully opened message from Teacher "+config.get_fat_teacher_username());

			// Reply to received message
			statusLog = "Sending Reply to Received message";
			page.sendReplyToReceivedMsg("Student");
			logger.info("Sent reply to received message");
			test.log(Status.PASS, "Sending Reply to Received message");
			test.log(Status.PASS, "Sending reply to received message from teacher("+config.get_fat_teacher_username()+" is successful");

			// Log out from Student
			statusLog = "Logging out from Student";
			page.logout();
			logger.info("Logged out from Student successfully");
			test.log(Status.PASS, "Logged out from Student "+config.get_fat_student_username()+" successfully");
			
			statusLog = "Relogin as Teacher to verify reply from Student";
			test.log(Status.PASS, "Starting relogin of Teacher("+config.get_fat_teacher_username()+") to verify reply from Student("+config.get_fat_student_username()+")");
			logger.info("Beginning of Teacher Re-Login to check reply from student!!");
			elev_login_teacher._loginAsTeacherWithExistingSessionInFAT();
			test.log(Status.PASS, "Relogin as Teacher("+config.get_fat_teacher_username()+") to verify reply from Student("+config.get_fat_student_username()+") is successful");

			// Click on Arkiv folder
			statusLog = "Clicking on Arkiv folder";
			page.clickArkivFolder();
			logger.info("Clicked on Arkiv folder");
			test.log(Status.PASS, "Click and open Arkiv folder");

			// Click on Mottatt folder
			statusLog = "Clicking on Mottatt folder";
			page.clickMottatt();
			logger.info("Clicked on Mottatt folder");
			test.log(Status.PASS, "Clicked on Mottatt folder to check received messages");

			// Search for received message and open it
			statusLog = "Opening received message from Student";
			page.searchReceivedMsgAndClick();
			logger.info("Opening received message");
			test.log(Status.PASS, "Opening received message from Student "+config.get_fat_student_username()+" is successful");

			// Verify received replied message
			statusLog = "Verifying Reply Received from Student";
			boolean testResult = page.verifyReplyReceived("Student");
			logger.info("Reply from Student verified");
			test.log(Status.PASS, "Reply from Student("+config.get_fat_student_username()+") is received by Teacher("+config.get_fat_teacher_username()+") and it is verified");

			String replyReceivedScreenshot = Base_Class.captureScreenExtent(driver2, "TC_UDEMA_1990_TC_001_reply_frm_teacher");
			test.pass("Reply from Student",
					MediaEntityBuilder.createScreenCaptureFromPath(replyReceivedScreenshot).build());

			if(testResult) {
				test.log(Status.PASS, "Verification Completed and test case result is PASS");
				logger.info("Verification is done");
				captureScreen(driver2, "reply_from_student_to_teacher");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_student_to_teacher");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
			} else {
				test.log(Status.FAIL,  "Verification Failed");
				logger.info("Verification is failed");
				captureScreen(driver2, "reply_from_student_to_teacher");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_student_to_teacher");
				test.fail("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
			}

		}catch (Exception e) {
			logger.error("Test case execution failed here with exception : "+e);
			captureScreen(driver2, "reply_from_student_to_teacher");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_student_to_teacher");
			test.fail("Verification Completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== TC_UDEMA_1990_TC002 : Send Reply from Student to Teacher TC execution is completed!! ===");
		extent.flush();
		driver2.quit();
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
