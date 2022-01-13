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
import com.ude.portalen.pageobject.Page_SendMsg_TwoTeacher_TC001;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_SendMsg_TwoTeacher_TC001 extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;

	public String expected_result;
	public String actual_result;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_SendReceive_New
	 * Test Case ID  : TC_SendMsg_TwoTeacher_TC001
	 * Test Summary  : Send a message from the Teacher to another Teacher and verifying the received message
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="testData")
	@Test
	public void sendMessageToAnotherTeacher() throws InterruptedException, Exception {
		String statusLog = "TC_SendMsg_TwoTeacher_TC001";
		
		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("TC_SendMsg_TwoTeacher_TC001", "Send a message from the Teacher to another Teacher and verifying the received message");

			//launch_second_app();
			//Send Msg to Student/Parent
			
			statusLog = "Logging in as Teacher to Elev app";
			test.log(Status.PASS, "Teacher One School Login process in Elav App Started");
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, "Teacher "+config.get_teacher_username()+" logged in successfully in elev app");
			statusLog = "Elev App login Completed";

			Page_SendMsg_TwoTeacher_TC001 page = new Page_SendMsg_TwoTeacher_TC001(driver2);

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Student("+config.get_student_username()+")");

			statusLog = "Clicked on Svar på to switch to Svar av";
			page.clickOnSvarAvToggle();
			test.log(Status.PASS,"Switched to Svar av from Svar på");
			
			statusLog = "Clicking Till(To) Button";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Clicked on Till(to) button to select the receipent student name from contact list");

			statusLog = "Clicking School drop down";
			page.clickOnSchoolDropDown();
			logger.info("School Drop Down clicked");
			test.log(Status.PASS, "Clicked on Velg Skole(select school) drop down and schools list displayed");

			statusLog = "Clicking School drop down options";
			page.clickOnSchoolDropDownOptions();
			logger.info("School Drop Down Option clicked");
			test.log(Status.PASS, "Clicked on CGI testgrunnskole from schools drop down options");

			statusLog = "Clicking Personar tab";
			page.clickOnPersonerTab();
			logger.info("Personer Tab clicked");
			test.log(Status.PASS, "Clicked on Personer tab");
			
			
			statusLog = "Searching for the Teacher "+config.get_teacher_username3();
			page.clickOnSearchInputEditTextForTeacher();
			logger.info("Searching for second Teacher contact");
			test.log(Status.PASS, "Teacher contact found: "+config.get_teacher_username3()+" in search box");

			
			statusLog = "Clicking on searched receipient Teacher";
			page.clickOnSearchResultOfTeacher();
			logger.info("Clicked on Searched Teacher");
			test.log(Status.PASS, "Clicked on Teacher "+config.get_teacher_username3());

			String teacher_selected = Base_Class.captureScreenExtent(driver2, "teacher_selected");
			test.pass("Recepient Teacher contact is selected", MediaEntityBuilder.createScreenCaptureFromPath(teacher_selected).build());
			
			
			statusLog = "Sending mail with mail body and title message";
			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Clicked on Emne and entered message title and message body text then clicked on Send button");

			statusLog = "Verifying sent message";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Clicked on Arkiv(archives), Search for sent message in Sendt folder and opening sent message is successfull");
			test.log(Status.PASS, "Teacher "+config.get_teacher_username()+"sent message successfully to other Teacher" +config.get_teacher_username3());

			actual_result = page.getActualResult(act_text);

			statusLog = "Logging out from first Teacher";
			page.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out from Teacher("+config.get_teacher_username()+") successfully");

			driver2.quit();
			
			
		} catch (Exception e) {
			
			String sent_msg = Base_Class.captureScreenExtent(driver2, "sent_email_01");
			test.fail("Test execution failed at", MediaEntityBuilder.createScreenCaptureFromPath(sent_msg).build());
			//test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+".");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			return;
		}

		

		try {
			statusLog = "Logging in as second Teacher "+config.get_teacher_username3();
			test.log(Status.PASS, "Logging in to other Teacher ("+config.get_teacher_username3()+") to verify email from Teacher");
			ElevLoginTest elav_login_student = new ElevLoginTest();
			elav_login_student.loginAsTeacherTwo();
			//elav_login_student._loginAsTeacher2();
			test.log(Status.PASS, "Login as Teacher("+config.get_teacher_username3()+") to verify email from Teacher("+config.get_teacher_username()+") is successful");

			Page_SendMsg_TwoTeacher_TC001 page2 = new Page_SendMsg_TwoTeacher_TC001(driver2);
			
			statusLog = "Clicking on Arkiv folder";
			test.log(Status.PASS, "Searching for received mail from first Teacher("+config.get_teacher_username()+")in Arkiv Received folder");
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Teacher ("+config.get_teacher_username3()+") successfully received email from Teacher("+config.get_teacher_username()+")");

			
			String teacher_msg = Base_Class.captureScreenExtent(driver2, "teacher_msg");
			test.pass("Teacher received below the message", MediaEntityBuilder.createScreenCaptureFromPath(teacher_msg).build());

			
			statusLog = "Comparing email sent by teacher with received mail in student";
			//expected_result = page2.getExpectedResult(exp_text);
			expected_result = page2.getExpectedResultForTC2(exp_text);
			logger.info("Expected Result matching with Actual Result");
			test.log(Status.PASS, "Email matching with the mail sent by Teacher("+config.get_teacher_username()+")");

			statusLog = "Log out as a second Teacher ";
			page2.logout();
			logger.info("Logged out as a Teacher successfully");
			test.log(Status.PASS, "Logged out as Teacher("+config.get_teacher_username3()+")");
			//String actual_result = "Du kan ikke svare på denne meldingen";


			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "received_email");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.PASS, "Sent a message from the Teacher to another Teacher and verified the received message");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Soft Assertion Test Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "received_email");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.FAIL, "Sending a message from the Teacher to another Teacher failed");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Soft Assertion Test Fail");
				logger.warn("Verification is done");
			}

		} catch (Exception e) {
			
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Sending a message from the Teacher to another Teacher failed");
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog + ".");
			logger.error(e.getMessage());
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
