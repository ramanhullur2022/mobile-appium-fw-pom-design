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
import com.ude.portalen.pageobject.Page_Settings_ResetPIN_TC001;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;



public class TC_Settings_ResetPIN_TC001 extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	public String expected_result;
	public String actual_result;
	public String statusLog = "TC_Settings_ResetPIN_TC001";
	ReadConfig config = new ReadConfig();



	/*
	 * Test Suite ID : UDEMA_Settings 
	 * Test Case ID  : TC_Settings_ResetPIN_TC001
	 * Test Summary  : Reset the login PIN from App Innstillinger and verifying the new PIN
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="testData")
	@Test
	public void resetPinCode() throws InterruptedException, Exception {


		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("TC_Settings_ResetPIN_TC001", "Reset the login PIN from App Innstillinger and verifying the new PIN");

			statusLog = "Logging in as Teacher to Elev app";
			test.log(Status.PASS, "Teacher Login process in Elav App Started");
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, "Teacher "+config.get_teacher_username()+" logged in successfully in elev app");
			statusLog = "Elev App login is ompleted";

			Page_Settings_ResetPIN_TC001 page = new Page_Settings_ResetPIN_TC001(driver2);

			statusLog = "Clicking on Settings";
			page.clickOnSettings();
			logger.info("Clicked on Settings tab");
			test.log(Status.PASS, "Clicked on Settings tab");

			statusLog = "Clicking on Endre PIN kode";
			page.clickOnEndrePinKode();
			logger.info("Clicked on Endre PIN-kode");
			test.log(Status.PASS, "Clicked on Endre PIN-kode");
			String screenshot_pinkode = Base_Class.captureScreenExtent(driver2, "pinkode");
			test.pass("Clicked on Endre PIN-kode", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_pinkode).build());

			statusLog = "Re entering the credintials to and clicking on continue in Fiede for new PIN reset to 2525";
			ElevLoginTest elav_login_pin_reset = new ElevLoginTest();
			elav_login_pin_reset.loginAsTeacherOrStudentForPinReset();
			logger.info("Entered the credintials to and clicking on continue in Fiede for new PIN resetting to 2525");
			test.log(Status.PASS, "Entered new PIN-kode by login again");


			elav_login_pin_reset.loginAsTeacherOrStudentForPinReset();
			test.log(Status.PASS, "Login with new PIN-kode and login is success");
			System.out.println("===2525 is working!!");

			captureScreen(driver2, "pincode_reset_done");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "pincode_reset");
			test.pass("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.PASS, "Resetting the login PIN code from Innstillinger is success and verified the new PIN");
			logger.info("Verification is completed");
			
			Page_Settings_ResetPIN_TC001 page2 = new Page_Settings_ResetPIN_TC001(driver2);

			statusLog = "Logging out from Teacher";
			page2.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logged out from Teacher("+config.get_teacher_username()+") successfully");

		} catch (Exception e) {
			String sent_msg = Base_Class.captureScreenExtent(driver2, "PIN_Code_Reset");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(sent_msg).build());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
			logger.error(e.getMessage());
			return;
		}

		logger.info(" ========== Send Message TC execution is completed!! =========");
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
