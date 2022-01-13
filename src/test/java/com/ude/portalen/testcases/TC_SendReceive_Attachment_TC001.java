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
import com.ude.portalen.pageobject.Page_SendReceive_SendAttachment_TC001;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;



public class TC_SendReceive_Attachment_TC001 extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;
	public String expected_result;
	public String actual_result;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_Send_Attachment
	 * Test Case ID  : TC_SendReceive_SendAttachment_TC001
	 * Test Summary  : Teacher attach a file then removes from the attachment and selecting the new attachment and sending to the Student
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="testData")
	@Test
	public void addRemoveAndAddAttachmentWithMsg() throws InterruptedException, Exception {
		String statusLog = "TC_SendReceive_SendAttachment_TC001";
		
		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("TC_SendReceive_SendAttachment_TC001", "Teacher attach a file then removes from the attachment and selecting the new attachment and sending to the Student");
			
			//launch_second_app();
			
			statusLog = "Logging in as Teacher to Elev app";
			test.log(Status.PASS, "Teacher login process in Elav App Started");
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, "Student "+config.get_student_username()+" logged in successfully in elev app");
			statusLog = "Elev App login Completed";
			
			String screenShot = Base_Class.captureScreenExtent(driver2, "login_completed");
			test.pass("login completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
			
			Page_SendReceive_SendAttachment_TC001 page = new Page_SendReceive_SendAttachment_TC001(driver2);

			statusLog = "Clicking on Message compose button";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Message compose button clicked");
			
			
			statusLog = "Clicking on Vedlegg then clicking Legg til vedlegg";
			page.addAnAttachmentWithMessage();
			logger.info("Clicked on Vedlegg then clicked Legg til vedlegg");
			test.log(Status.PASS, "Clicked on Vedlegg then clicked Legg til vedlegg");
			
			String screenshot2 = Base_Class.captureScreenExtent(driver2, "Legg_til_vedlegg");
			test.pass("Clicked on Legg til vedlegg", MediaEntityBuilder.createScreenCaptureFromPath(screenshot2).build());
			
			statusLog = "Searching attachment file and searching the file from File System";
			page.searchAttachmentAndSelect();
			logger.info("File found from search results");
			test.log(Status.PASS, "File found in search results");
			
			String sc_attachemnt = Base_Class.captureScreenExtent(driver2, "attachement_file");
			test.pass("Attachment file found", MediaEntityBuilder.createScreenCaptureFromPath(sc_attachemnt).build());
			
			statusLog = "Attachment file selecting";
			page.clickOnFileAndAttach();
			logger.info("Attachment file selected and attached");
			test.log(Status.PASS, "Attachment file selected and attached with the message");
			
			String file_attached = Base_Class.captureScreenExtent(driver2, "file_attached");
			test.pass("File attached with the message", MediaEntityBuilder.createScreenCaptureFromPath(file_attached).build());
		
			
			statusLog = "Attachment removed from message";
			page.clickAndRemoveAttchement();
			logger.info("Attachment removed from message");
			test.log(Status.PASS, "Attachment file removed");
			
			String file_removed = Base_Class.captureScreenExtent(driver2, "file_removed");
			test.pass("Attachment removed from the message", MediaEntityBuilder.createScreenCaptureFromPath(file_removed).build());
		
			
			//attaching new file again
			statusLog = "Clicking on Vedlegg then clicking Legg til vedlegg";
			page.addAnAttachmentWithMessage();
			logger.info("Clicked on Vedlegg then clicked Legg til vedlegg");
			test.log(Status.PASS, "Clicked on Vedlegg then clicked Legg til vedlegg");
			
			String legg_till_vedlegg = Base_Class.captureScreenExtent(driver2, "Legg_til_vedlegg");
			test.pass("Clicked on Legg til vedlegg", MediaEntityBuilder.createScreenCaptureFromPath(legg_till_vedlegg).build());
			
			statusLog = "Searching attachment file and searching the file from File System";
			page.searchAddAttachmentAgain();
			logger.info("File found from search results");
			test.log(Status.PASS, "File found in search results");
			
			String sc_attachemnt_2 = Base_Class.captureScreenExtent(driver2, "attachement_file");
			test.pass("Attachment file found", MediaEntityBuilder.createScreenCaptureFromPath(sc_attachemnt_2).build());
			
			statusLog = "Attachment file selecting";
			page.clickOnFileAndAttachAagin();
			logger.info("Attachment file selected and attached");
			test.log(Status.PASS, "Attachment file selected and attached with the message");
			
			String file_attached3 = Base_Class.captureScreenExtent(driver2, "file_attached");
			test.pass("File attached with the message", MediaEntityBuilder.createScreenCaptureFromPath(file_attached3).build());

			
			
//			page.clickOnSvarAvToggle();
//			logger.info("Clicked Svar av and switched to Svar pa");
//			test.log(Status.PASS, "Clicked Svar av and switched to Svar pa");
//			String screenShot2 = Base_Class.captureScreenExtent(driver2, "Svar pa");
//			test.pass("Clicked Svar av and switched to Svar pa", MediaEntityBuilder.createScreenCaptureFromPath(screenShot2).build());

			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Till Button clicked");

//			page.clickOnSchoolDropDown();
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Layout option clicked");
//
//			page.clickOnSchoolDropDownOptions();
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "School Drop Down Option clicked");
//
//			page.clickOnPersonerTab();
//			logger.info("Personer Tab clicked");
//			test.log(Status.PASS, "Personer Tab clicked");
//
//			page.clickOnSearchInputEditText();
//			page.clickOnSearchResultOfStudent();
//			logger.info("Clicked on Searched Student");
//			test.log(Status.PASS, "Clicked on Searched Student");
			
			statusLog = "Searching for a student and adding it to To field";
			searchForUserAndSelect(driver2, "student", "test", "eleven_and_foresatte");
			logger.info("Student("+config.get_student_username()+") successfully searched and added to To Field");
			test.log(Status.PASS, "Student("+config.get_student_username()+") successfully searched and added to To Field");

			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Message title and body content edited then clicked on Send button");

			//String actual_result = page.verify_Sent_Message(act_text);
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Message sent and clicked on Arkiv-sent, clicked on sent mail mail");

			actual_result = page.getActualResult(act_text);

			page.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out successfully");

			driver2.quit();

		} catch (Exception e) {
			
			String sent_msg = Base_Class.captureScreenExtent(driver2, "sent_email_01");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(sent_msg).build());
			test.log(Status.FAIL, "Test case failed at" + statusLog);
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
			logger.error(e.getMessage());
			//logger.error("Test Case Failed");
			return;
		}

		

		try {
			statusLog = "Logging in as Student "+config.get_student_username();
			test.log(Status.PASS, "Logging in to Student("+config.get_student_username()+") to verify email from Teacher");
			ElevLoginTest elav_login_student = new ElevLoginTest();
			//elav_login_student._loginAsStudent();
			elav_login_student.loginAsGeneric("student", "test");
			test.log(Status.PASS, "Login as Student("+config.get_student_username()+") to verify email from Teacher("+config.get_teacher_username()+") is successful");

			Page_SendReceive_SendAttachment_TC001 page2 = new Page_SendReceive_SendAttachment_TC001(driver2);
			
			statusLog = "Clicking on Arkiv folder";
			test.log(Status.PASS, "Searching for received mail from Teacher("+config.get_teacher_username()+")in Arkiv Received folder");
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Student("+config.get_student_username()+") Successfully received email from Teacher("+config.get_teacher_username()+")");

			statusLog = "Comparing email sent by teacher with received mail in student";
			expected_result = page2.getExpectedResult(exp_text);
			logger.info("Expected Result matching with Actual Result");
			test.log(Status.PASS, "Email matching with the mail sent by Teacher("+config.get_teacher_username()+")");

			statusLog = "Logging out from Student";
			page2.logoutWithToggleEnable();
			logger.info("Logged out from Student successfully");
			test.log(Status.PASS, "Logged out from Student("+config.get_student_username()+")");
			//String actual_result = "Du kan ikke svare på denne meldingen";


			if (expected_result.equals(actual_result)) {
			//if (expected_result != actual_result) {
				captureScreen(driver2, "received_email");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.PASS, "Teacher attach a file then removes from the attachment and selecting the new attachment and successfully sent to the Student");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Soft Assertion Test Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "received_email");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.FAIL, "Teacher couldn't able to attach a file then removes from the attachment and selecting the new attachment to send the Student");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Soft Assertion Test Fail");
				logger.warn("Verification is done");
			}

		} catch (Exception e) {
			
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Verfication unsuccessful - FAILED");
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
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
