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
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_1984_TC005 extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;

	public String expected_result;
	public String actual_result;

	/*
	 * Test Suite ID : UDEMA_1984 
	 * Test Case ID  : UDEMA_1984_TC005
	 * Test Summary  : Teacher sends new message with SMS-varsel to Student 
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="Create another data provider")
	@Test
	public void send_Receive_New_SMS_versal() throws InterruptedException, Exception {

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1984_TC005", "Teacher sends new message with SMS-varsel to Student");

			//launch_second_app();
			//Send SMS melding to Student/Parent

			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, "Elev App Login completed successfully");

			Page_UDEMA_1984 page = new Page_UDEMA_1984(driver2);

			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Message compose button clicked");

			page.clickOnValgOption();
			logger.info("Clicked on Valg");
			test.log(Status.PASS, "Clicked on Valg");

			page.clickOnSMSVarsel();
			logger.info("Clicked on SMS varsel");
			test.log(Status.PASS, "Clicked on SMS varsel");

			String sms_versal = Base_Class.captureScreenExtent(driver2, "sms_varsel");
			test.pass("SMS-varsel option selected", MediaEntityBuilder.createScreenCaptureFromPath(sms_versal).build());

			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Till Button clicked");


//			page.clickOnSchoolDropDown();
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Layout option clicked");
//
//
//			page.clickOnSchoolDropDownOptions();
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "School Drop Down Option clicked");
//
//
//			page.clickOnPersonerTab();
//			logger.info("Personer Tab clicked");
//			test.log(Status.PASS, "Personer Tab clicked");
//
//
//			page.clickOnSearchInputEditText();
//			page.clickOnSearchResultOfStudent();
//			logger.info("Clicked on Searched Student");
//			test.log(Status.PASS, "Clicked on Searched Student");
			
			page.searchForUserAndSelect(driver2, "student", "test", "eleven_and_foresatte");
			logger.info("Clicked on Searched Student");
			test.log(Status.PASS, "Clicked on Searched Student");


			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Message title and body content edited then clicked on Send button");


			//String actual_result = page.verify_Sent_Message(act_text);
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Message sent and clicked on Arkiv-sent, clicked on sent mail mail");

			String screenshot_sms2 = Base_Class.captureScreenExtent(driver2, "SMS-varsel");
			test.pass("SMS-varsel option selected", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_sms2).build());

			actual_result = page.getActualResult(act_text);

			page.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out successfully");

			driver2.quit();

		} catch (Exception e) {
			String sms_varsel = Base_Class.captureScreenExtent(driver2, "sms-varsel_05");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(sms_varsel).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			logger.error("Test Case Failed");
			return;
		}

		try {

			ElevLoginTest elav_login_student = new ElevLoginTest();
			//elav_login_student._loginAsStudent();
			elav_login_student.loginAsGeneric("student", "test");
			test.log(Status.PASS, "Elev App Logged inn as Student");

			Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);

			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Clicked on Arkiv then clicked received email by searching it from Arkiv");

			expected_result = page2.getExpectedResult(exp_text);
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out successfully");


			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "sms-varsel");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "sms-varsel");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.PASS, "Actual Result: " + actual_result + "\n" + "Expected Result: " + expected_result);
				test.log(Status.PASS, "Verification Completed - PASS");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "sms-varsel");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "sms-varsel");
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
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "sms-varsel");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			logger.error("Test Case Failed");
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
