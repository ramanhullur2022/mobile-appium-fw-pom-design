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

public class TC_UDEMA_1990_TC001 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String act_text;
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1990
	 * Test Case ID  : UDEMA_1990_TC001 
	 * Test Summary  : Send reply from Teacher to Student 
	 * Test Author   : S, Manjunath
	 */
	
	@Test
	@Description("UDEMA_1990_TC001 : Send reply from Teacher to Student")
	@Severity(SeverityLevel.NORMAL)
	@Attachment(value = "UDEMA_1990_TC_001", type = "image/png")
	public void send_reply_from_teacher_to_student() throws Exception {
		String statusLog = "TC_UDEMA_1990_TC001";

		try {
			// Initiate Extent Report
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1990_TC001", "Send Reply from Teacher to Student");

			// Login as Student
			statusLog = "Elev App Login";
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logged in successfully in elev app");

			// Click on Compose mail
			statusLog = "Clicking Message Compose Button";
			Page_UDEMA_1990 page = new Page_UDEMA_1990(driver2);
			page.clickOnMailComposeButton();
			logger.info("Message Compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Teacher("+config.get_teacher_username()+")");

			// Click on To Button
			statusLog = "Clicking Til(To) Button";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Clicked on Till(to) button to select the receipent teacher name from contact list");

//			// Click on School Drop down
//			statusLog = "Clicking school drop down";
//			page.clickOnSchoolDropDown("Student");
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Clicked on Velg Skole(select school) drop down and schools list displayed");
//
//			// Select school from Drop down
//			statusLog = "Clicking school drop down options";
//			page.clickOnSchoolDropDownOptions("Student");
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "Clicked on CGI testgrunnskole from schools drop down options");
//
//			// Click on Teacher from Kontakt list
//			statusLog = "selecting Teacher from the List";
//			page.selectTeacherFromList();
//			logger.info("Teacher selected from Kontakt list");
//			test.log(Status.PASS, "Clicked and selected the Teacher(Inger Laerer) from receiver list and clicked on OK button");

			searchForUserAndSelect(driver2, "teacher", "test", "na");
			logger.info("Teacher selected from Kontakt list");
			test.log(Status.PASS, "Clicked and selected the Teacher from receiver list and clicked on OK button");

			
			// Take screenshot of Teacher selection
			String teacherSelectionScreenshot = Base_Class.captureScreenExtent(driver2, "TC_UDEMA_1990_TC_001_teacher_selected");
			test.pass("Teacher selected from Kotakt",
					MediaEntityBuilder.createScreenCaptureFromPath(teacherSelectionScreenshot).build());

			// Input Message title and body and Send
			statusLog = "Adding Message title and Body";
			page.editMsgAndSendMsg();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Clicked on Emne and entered message title and message body text then clicked on Send button");

			// Verify sent message in Arkiv-Sendt folder
			statusLog = "Verifying sent message";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Clicked on Arkiv(archives), Search for sent message in Sendt folder and opening sent message is successfull");
			test.log(Status.PASS, "Student "+config.get_student_username()+" sent message successfully to teacher");

			// Logout from Student
			statusLog = "Logging out from Student";
			page.logout();
			logger.info("Logged out from Student successfully");
			test.log(Status.PASS, "Log out from Student("+config.get_student_username()+") is successful");

			//driver2.quit();

			// Login to Elev app as Teacher
			//extent = ExtentManager.GetExtent();
			//test = extent.createTest("UDEMA_1990_TC001", "Send Reply from Teacher to Student");
			statusLog = "Logging as Teacher with existing session";
			logger.info("Beginning of Teacher Login to reply to student!!");
			ElevLoginTest elev_login_teacher = new ElevLoginTest();
			elev_login_teacher._loginAsTeacherWithExistingSession();
			//elev_login_teacher._loginAsTeacher();
			test.log(Status.PASS, "Log in as Teacher - "+config.get_teacher_username()+" is successful");

			//Page_UDEMA_1990 page = new Page_UDEMA_1990(driver2);

			// Click on Arkiv folder
			statusLog = "Clicking Arkiv folder";
			page.clickArkivFolder();
			logger.info("Clicked on Arkiv folder");
			test.log(Status.PASS, "Click and opened Arkive(Archives) folder");

			// Click on Mottatt folder
			statusLog = "Clicking Mottatt folder";
			page.clickMottatt();
			logger.info("Clicked on Mottatt folder");
			test.log(Status.PASS, "Click on Mottatt folder to check received messages");

			// Search for received message and open it
			statusLog = "Opening received message";
			page.searchReceivedMsgAndClick();
			logger.info("Opening received message");
			test.log(Status.PASS, "Search for message from Student"+config.get_student_username()+" and Open received message");
			test.log(Status.PASS, "Successfully opened message from Student "+config.get_student_username());

			// Reply to received message
			statusLog = "Sending Reply to Received message from Student";
			page.sendReplyToReceivedMsg("Teacher");
			logger.info("Sent reply to received message");
			test.log(Status.PASS, "Sending Reply to Received message");
			test.log(Status.PASS, "Sending reply to received message from student("+config.get_student_username()+" is successful");

			// Log out from Teacher
			statusLog = "Logging out from Teacher";
			page.logout();
			logger.info("Logged out from Teacher successfully");
			test.log(Status.PASS, "Logged out from Teacher("+config.get_teacher_username()+") successfully");

			statusLog = "Relogin into Student to verify reply from teacher";
			logger.info("Beginning of Student relogin to verify reply from teacher!!");
			test.log(Status.PASS, "Starting relogin of Student("+config.get_student_username()+") to verify reply from Teacher("+config.get_teacher_username()+")");
			// Login to Elev app as Student to check reply received
			ElevLoginTest elev_login_student = new ElevLoginTest();
			elev_login_student._loginAsStudentWithExistingSession();
			test.log(Status.PASS, "Relogin as Student("+config.get_student_username()+") to verify reply from Teacher("+config.get_teacher_username()+") is successful");

			// Click on Arkiv folder
			statusLog = "Clicking on Arkiv folder";
			page.clickArkivFolder();
			logger.info("Clicked on Arkiv folder");
			test.log(Status.PASS, "Clicked and opened Arkiv folder");

			// Click on Mottatt folder
			statusLog = "Clicking on Mottatt folder";
			page.clickMottatt();
			logger.info("Clicked on Mottatt folder");
			test.log(Status.PASS, "Clicked on Mottatt folder to check received messages");

			// Search for received message and open it
			statusLog = "Opening received message";
			page.searchReceivedMsgAndClick();
			logger.info("Opened received message");
			test.log(Status.PASS, "Opening received message from Teacher "+config.get_teacher_username()+" is successful");

			// Verify received replied message
			statusLog = "Verifying Reply Received";
			boolean testResult = page.verifyReplyReceived("Teacher");
			logger.info("Reply from teacher verified");
			test.log(Status.PASS, "Reply from Teacher("+config.get_teacher_username()+") is received by Student("+config.get_student_username()+") and it is verified");

			String replyReceivedScreenshot = Base_Class.captureScreenExtent(driver2, "TC_UDEMA_1990_TC_001_reply_frm_teacher");
			test.pass("Reply Received",
					MediaEntityBuilder.createScreenCaptureFromPath(replyReceivedScreenshot).build());

			if(testResult) {
				test.log(Status.PASS, "Verification Completed and Test case result is PASS");
				logger.info("Verification is done");
				captureScreen(driver2, "reply_from_teacher_to_student");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_teacher_to_student");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
			} else {
				test.log(Status.FAIL,  "Verification Failed");
				logger.info("Verification is failed");
				captureScreen(driver2, "reply_from_teacher_to_student");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_teacher_to_student");
				test.fail("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.FAIL, "Test Case Failed!! Reply is not matching");
			}

		} catch (Exception e) {
			logger.error("Test case execution failed here with exception : "+e);
			captureScreen(driver2, "reply_from_teacher_to_student");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_teacher_to_student");
			test.fail("Test Execution Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== TC_UDEMA_1990_TC001 : Send Reply from Teacher to Student TC execution is completed!! ===");
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
