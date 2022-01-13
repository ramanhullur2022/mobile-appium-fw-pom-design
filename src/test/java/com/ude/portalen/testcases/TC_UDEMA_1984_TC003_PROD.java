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

public class TC_UDEMA_1984_TC003_PROD extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;
	private String sporsmal;

	public String expected_result;
	public String actual_result;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1984 
	 * Test Case ID  : UDEMA_1984_TC003_FAT
	 * Test Summary  : Send new message to Teacher with the option Spørsmål 
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="Create another data provider")
	@Test
	public void send_Receive_New_Message_with_Spørsmål() throws InterruptedException, Exception {

		String statusLog = "TC_UDEMA_1984_TC001";
		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1984_TC003_FAT", "Send new message to Teacher with the option Spørsmål");

			//launch_second_app();
			//Send Msg to Student/Parent

			statusLog = "Teacher login in Elav App";
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacherInFAT();
			elav_login.loginAsGeneric("teacher", "prod");
			test.log(Status.PASS, "Teacher "+config.get_fat_teacher_username()+" logged in successfully in elev app");

			Page_UDEMA_1984 page = new Page_UDEMA_1984(driver2);

//			//Different than above Testcase
//			page.clickOnFilter();
//			logger.info("Filter button clicked");
//			test.log(Status.PASS, "Filter button clicked");


			String screenshot = Base_Class.captureScreenExtent(driver2, "question");
			test.pass("Spørsmål option selected", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Student("+config.get_student_username()+")");

//			page.clickOnSvarAvToggle();
//			logger.info("Clicked Svar av and switched to Svar pa");
//			test.log(Status.PASS, "Clicked Svar av and switched to Svar pa");

			String screenShot2 = Base_Class.captureScreenExtent(driver2, "svar_pa");
			test.pass("Spørsmål option selected", MediaEntityBuilder.createScreenCaptureFromPath(screenShot2).build());

			statusLog = "Clicking on Valg option";
			page.clickOnValgOption();
			logger.info("Clicked on Valg option to select Sporsmal");
			
			//Unique Step compare to other TC in this class
			String actual_res = page.clickOnSpørsmål(sporsmal);
			if(actual_res.equals("Spørsmål")) {
				logger.info("Spørsmål option selected");
				test.log(Status.PASS, "Spørsmål option selected");
			}
			
			statusLog = "Entering Sporsmal Message";
			page.enterSporsmalMsg();
			logger.info("Entered Sporsmal Message");
			test.log(Status.PASS, "Clicked on Sporsmal edit box and Entered the question");
			
			statusLog = "Clicking OK Button";
			page.clickOnOKButton();
			test.log(Status.PASS, "Clicked OK button after entering Sporsmal message");

			statusLog = "Clicking Till(To) Button";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Clicked on Till(to) button to select the receipent student name from contact list");

//			statusLog = "Clicking on School Drop down ";
//			page.clickOnSchoolDropDown();
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Clicked on Velg Skole(select school) drop down and schools list displayed");
//
//			statusLog = "Clicking on CGI testgrunnskole option from School drop down options";
//			page.clickOnSchoolDropDownOptions();
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "Clicked on CGI testgrunnskole from schools drop down options");
//
//			statusLog = "Clicking on Personer Tab";
//			page.clickOnPersonerTab();
//			logger.info("Personer Tab clicked");
//			test.log(Status.PASS, "Clicked on Personer tab");
//
//			statusLog = "Searching for student "+config.get_student_username();
//			page.clickOnSearchInputEditTextForStudent();
//			logger.info("Searching for student");
//			test.log(Status.PASS, "Searched student "+config.get_student_username()+" in search box");
//			
//			statusLog = "Clicking on searched student";
//			page.clickOnSearchResultOfStudentName();
//			logger.info("Clicked on Searched Student");
//			test.log(Status.PASS, "Clicked on student "+config.get_student_username()+" and selected Eleven + Foresatte checkbox");
			
			statusLog = "Searching for a student and adding it to To field";
			searchForUserAndSelect(driver2, "student", "prod", "eleven_and_foresatte");
			logger.info("Student("+config.get_student_username()+") successfully searched and added to To Field");
			test.log(Status.PASS, "Student("+config.get_student_username()+") successfully searched and added to To Field");

			statusLog = "Sending mail with mail body and title";
			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Clicked on Emne and entered message title and message body text then clicked on Send button");

			//String actual_result = page.verify_Sent_Message(act_text);
			statusLog = "Verifying sent message";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail");
			test.log(Status.PASS, "Clicked on Arkiv(archives), Search for sent message in Sendt folder and opening sent message is successfull");
			test.log(Status.PASS, "Teacher "+config.get_teacher_username()+" sent message successfully to student");

			actual_result = page.getActualResult(act_text);

			statusLog = "Logging out from Teacher";
			page.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out from Teacher("+config.get_teacher_username()+") successfully");

			driver2.quit();
			//Student/parent receiving the Msg with Du kan ikke svare på denne meldingen

		} catch (Exception e) {
			String sent_msg = Base_Class.captureScreenExtent(driver2, "sent_email-03");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(sent_msg).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
			return;
		}

		try {
			statusLog = "Logging in as Student "+config.get_student_username();
			test.log(Status.PASS, "Logging in to Student("+config.get_fat_student_username()+") to verify email from Teacher");
			ElevLoginTest elav_login_student = new ElevLoginTest();
			//elav_login_student._loginAsStudentInFAT();;
			elav_login_student.loginAsGeneric("student", "prod");
			test.log(Status.PASS, "Login as Student("+config.get_fat_student_username()+") to verify email from Teacher("+config.get_fat_teacher_username()+") is successful");

			Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);

			statusLog = "Clicking on Arkiv folder";
			test.log(Status.PASS, "Searching for received mail from Teacher("+config.get_fat_teacher_username()+")in Arkiv Received folder");
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Student("+config.get_fat_student_username()+") Successfully received email from Teacher("+config.get_fat_teacher_username()+")");

			statusLog = "Comparing email sent by teacher with received mail in student";
			//String expected_result = page2.expected_Result_TC2(exp_text);
			expected_result = page2.getExpectedResult(exp_text);
			logger.info("Expected Result matching with Actual Result");
			test.log(Status.PASS, "Sporsmal Email matching with the mail sent by Teacher("+config.get_fat_teacher_username()+")");
			
			statusLog = "Logging out from Student";
			page2.logout();
			logger.info("Logged out from Student successfully");
			test.log(Status.PASS, "Logged out from Student("+config.get_fat_student_username()+")");

			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "received_email-tc3");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email-tc3");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.PASS, "Verification Completed and Test Case Result is PASS");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "received_email-tc3");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email-tc3");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.FAIL, "Actual Result: " + actual_result + "\n" + "Expected Result: " + expected_result);
				test.log(Status.FAIL, "Verfication Completed - FAIL");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {
			
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email-tc3");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Send Message with Spørsmål TC execution is completed!! ===");
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
