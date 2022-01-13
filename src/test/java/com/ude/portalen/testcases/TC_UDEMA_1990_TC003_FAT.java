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

public class TC_UDEMA_1990_TC003_FAT extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String act_text;
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1990 
	 * Test Case ID  : UDEMA_1990_TC003 
	 * Test Summary  : Send reply from Teacher to Parent 
	 * Test Author   : S, Manjunath
	 */
	@Test
	@Description("UDEMA_1990_TC003 : Send reply to teacher from parent")
	@Severity(SeverityLevel.NORMAL)
	@Attachment(value = "UDEMA_1990_TC_003", type = "image/png")
	public void send_reply_from_teacher_to_parent() throws Exception {
		String statusLog = "TC_UDEMA_1990_TC003";

		try {

			// Initiate Extent Report
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1990_TC003", "Send Reply to Teacher from Parent");

			// Teacher Login begins
			statusLog = "Elev App Login";
			ElevLoginTest elev_login_teacher = new ElevLoginTest();
			//elev_login_teacher._loginAsTeacher();
			elev_login_teacher.loginAsGeneric("teacher", "fat");
			logger.info("Logged in as Teacher Successfully");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			// Click on Compose mail
			statusLog = "Clicking Message Compose Button";
			Page_UDEMA_1990 page = new Page_UDEMA_1990(driver2);
			page.clickOnMailComposeButton();
			logger.info("Message Compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Parent("+config.get_parent_login_id()+")");
			
			// Click on Svar av to enable reply
			statusLog = "Clicking Svar Av Button";
			page.clickSvarAvButton();
			logger.info("Svar av clicked - reply enabled");
			test.log(Status.PASS, "Clicking on Svar av button to enable reply");

			// Click on To Button
			statusLog = "Clicking Till(To) Button";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Clicked on Till(to) button to select the receipent student name from contact list");

//			// Click on School Drop down
//			statusLog = "Clicking School Drop down Button";
//			page.clickOnSchoolDropDown("Teacher");
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Clicked on Velg Skole(select school) drop down and schools list displayed");
//
//			// Select school from Drop down
//			statusLog = "Clicking School Drop down options";
//			page.clickOnSchoolDropDownOptions("Teacher");
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "Clicked on CGI testgrunnskole from schools drop down options");
//
//			// Select Personar tab
//			statusLog = "Clicking Personer tab";
//			page.clickOnPersonerTab();
//			logger.info("Personar tab clicked");
//			test.log(Status.PASS, "Clicked on Personer tab");
//
//			// Search for student 
//			statusLog = "Clicking Searching for student "+config.get_student_username();
//			page.clickSearchInputEditText("alana041");
//			logger.info("Student searched");
//			test.log(Status.PASS, "Searched student "+config.get_student_username()+" in search box");
//
//			// Click on student and press OK
//			statusLog = "Clicking on Searched student";
//			page.clickSearchResultStudent();
//			logger.info("Student selected");
//			test.log(Status.PASS, "Clicked on student "+config.get_student_username()+" and selected Eleven + Foresatte checkbox");

			searchForUserAndSelect(driver2, "student", "fat", "eleven_and_foresatte");
			
			// Take screenshot of Student selection
			String teacherSelectionScreenshot = Base_Class.captureScreenExtent(driver2, "TC_UDEMA_1990_TC_002_student_selected");
			test.pass("Student selected from Personar", MediaEntityBuilder.createScreenCaptureFromPath(teacherSelectionScreenshot).build());

			// Input Message title and body and Send
			statusLog = "Adding Message body and Message title";
			page.editMsgAndSendMsg();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Clicked on Emne and entered message title and message body text then clicked on Send button");

			// Verify sent message in Arkiv-Sendt folder
			statusLog = "Verifying Sent message";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Clicked on Arkiv(archives), Search for sent message in Sendt folder and opening sent message is successfull");
			test.log(Status.PASS, "Teacher "+config.get_teacher_username()+" sent message successfully to parent");

			// Logout from Teacher
			statusLog = "Logging out from Teacher";
			page.logout();
			logger.info("Logged out from Teacher successfully");
			test.log(Status.PASS, "Logged out from Teacher "+config.get_teacher_username()+" successfully");

			driver2.quit();

			// Parent Login Begins
			statusLog = "Loginng in as Parent in Foresatte App";
			logger.info("Foresatte App - Parent login Begins!!");
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			foresatte_login._loginAsParent();
			logger.info("Foresatte App - Parent login completed successfully");
			test.log(Status.PASS, "Log in as Parent - "+config.get_parent_login_id()+" is successful");

			Page_UDEMA_1990 pageWithDriver = new Page_UDEMA_1990(driver);

			// Click on Arkiv folder
			statusLog = "Clicking Arkiv folder";
			pageWithDriver.clickArkivFolder();
			logger.info("Clicked on Arkiv folder");
			test.log(Status.PASS, "Click and opened Arkive(Archives) folder");

			// Click on Mottatt folder
			statusLog = "Clicking Mottatt folder";
			pageWithDriver.clickMottatt();
			logger.info("Clicked on Mottatt folder");
			test.log(Status.PASS, "Click on Mottatt folder to check received messages");

			// Search for received message and open it
			statusLog = "Searching Received Message";
			pageWithDriver.searchReceivedMsgAndClick();
			logger.info("Opened received message");
			test.log(Status.PASS, "Search for message from Teacher"+config.get_teacher_username()+" and Open received message");
			test.log(Status.PASS, "Successfully opened message from Teacher "+config.get_teacher_username());

			// Reply to received message
			statusLog = "Sending Reply to Received Message";
			pageWithDriver.sendReplyToReceivedMsg("Parent");
			logger.info("Sent reply to received message");
			test.log(Status.PASS, "Sending Reply to Received message");
			test.log(Status.PASS, "Sending reply to received message from parent ("+config.get_parent_login_id()+" is successful");

			// Log out from Student
			statusLog = "Logging out from Parent";
			pageWithDriver.logoutFromParent();
			logger.info("Logged out from Parent successfully");
			test.log(Status.PASS, "Logged out from Parent "+config.get_parent_login_id()+" successfully");

			driver.quit();

			statusLog = "Relogin in as Teacher to check Reply from Parent";
			logger.info("Beginning of Teacher Re-Login to check reply from parent!!");
			test.log(Status.PASS, "Starting relogin of Teacher("+config.get_teacher_username()+") to verify reply from Parent("+config.get_parent_login_id()+")");
			elev_login_teacher._loginAsTeacher();
			test.log(Status.PASS, "Relogin as Teacher("+config.get_teacher_username()+") to verify reply from Parent("+config.get_parent_login_id()+") is successful");

			Page_UDEMA_1990 pageWithDriver2 = new Page_UDEMA_1990(driver2);

			// Click on Arkiv folder
			statusLog = "Clicking Arkiv Folder";
			pageWithDriver2.clickArkivFolder();
			logger.info("Clicked on Arkiv folder");
			test.log(Status.PASS, "Clicked and opened Arkiv folder");

			// Click on Mottatt folder
			statusLog = "Clicking Mottatt Folder";
			pageWithDriver2.clickMottatt();
			logger.info("Clicked on Mottatt folder");
			test.log(Status.PASS, "Clicked on Mottatt folder to check received messages");

			// Search for received message and open it
			statusLog = "Searching for Received Message";
			pageWithDriver2.searchReceivedMsgAndClick();
			logger.info("Opening received message");
			test.log(Status.PASS, "Opening received message from Parent "+config.get_parent_login_id()+" is successful");

			// Verify received replied message
			statusLog = "Verifying Reply Received from Parent";
			boolean testResult = pageWithDriver2.verifyReplyReceived("Parent");
			logger.info("Reply from Student verified");
			test.log(Status.PASS, "Reply from Parent ("+config.get_parent_login_id()+") is received by Teacher ("+config.get_teacher_username()+") and it is verified");

			String replyReceivedScreenshot = Base_Class.captureScreenExtent(driver2, "TC_UDEMA_1990_TC_003_reply_frm_parent");
			test.pass("Reply Received From Parent",
					MediaEntityBuilder.createScreenCaptureFromPath(replyReceivedScreenshot).build());

			if(testResult) {
				test.log(Status.PASS, "Verification Completed and Test case result is PASS");
				logger.info("Verification is done");
				captureScreen(driver2, "reply_from_parent_to_teacher");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_parent_to_teacher");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
			} else {
				test.log(Status.FAIL,  "Verification Failed");
				logger.info("Verification is failed");
				captureScreen(driver2, "reply_from_parent_to_teacher");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_parent_to_teacher");
				test.fail("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
			}


		} catch (Exception e) {
			logger.error("Test case execution failed here with exception : "+e);
			captureScreen(driver2, "reply_from_parent_to_teacher");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "reply_from_parent_to_teacher");
			test.fail("Verification Completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== TC_UDEMA_1990_TC003 : Send Reply from Parent to Teacher TC execution is completed!! ===");
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
