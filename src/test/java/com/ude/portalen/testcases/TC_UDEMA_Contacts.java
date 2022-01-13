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
import com.ude.portalen.pageobject.Page_UDEMA_Contacts;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_Contacts extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_Contacts 
	 * Test Case ID  : UDEMA_Contacts_TC001
	 * Test Summary  : Add and Remove contact from Till field in meldinger
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void add_remove_contact() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Contacts_TC001";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Contacts_TC001", "Add and Remove contact from Til field in meldinger");

			//Teacher App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			
			Page_UDEMA_Contacts page = new Page_UDEMA_Contacts(driver2);
	
			statusLog = "Adding Contact in Til Field";
			page.addContact("first time");
			logger.info("Added Contact to Til Field");
			test.log(Status.PASS, "Added Contact to Til Field");
			
			statusLog = "Removing Contact in Til Field";
			page.removeContact();
			logger.info("Removed Contact to Til Field");
			test.log(Status.PASS, "Removed Contact to Til Field");
			
			statusLog = "Verifying Contact in Til field";
			page.verifyContactRemoval("not visible");
			logger.info("Successfully verified contact to Til Field");
			test.log(Status.PASS, "Successfully verified contact to Til Field");

			test.log(Status.FAIL, "Add and Remove contact from Til field in meldinger Test Case Passed");
			
		} catch (Exception e) {

			captureScreen(driver2, "Contact Removal");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Contact Removal Failed");
			test.fail("Contact Removal Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error(e.getStackTrace());
			test.log(Status.FAIL, "Add and Remove contact from Til field in meldinger Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
		}

		logger.info(" ==== Add and Remove contact from Til field in meldinger Test Case Executed  ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
		//close_CmdExe();

	}
	
	/*
	 * Test Suite ID : UDEMA_Contacts 
	 * Test Case ID  : UDEMA_Contacts_TC002
	 * Test Summary  : Add, Remove and again add contact from Till field in meldinger
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void add_remove_add_contact() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Contacts_TC002";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Contacts_TC002", "Add, Remove and again add contact from Till field in meldinger");

			//Teacher App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			
			Page_UDEMA_Contacts page = new Page_UDEMA_Contacts(driver2);
	
			statusLog = "Adding Contact in Til Field";
			page.addContact("first time");
			logger.info("Added Contact to Til Field");
			test.log(Status.PASS, "Added Contact to Til Field");
			
			statusLog = "Removing Contact in Til Field";
			page.removeContact();
			logger.info("Removed Contact to Til Field");
			test.log(Status.PASS, "Removed Contact to Til Field");
			
			statusLog = "Again Adding Contact in Til Field";
			page.addContact("again");
			logger.info("Again Added Contact to Til Field");
			test.log(Status.PASS, "Again Added Contact to Til Field");
			
			statusLog = "Verifying Contact in Til field";
			page.verifyContactRemoval("visible");
			logger.info("Successfully verified contact in Til Field");
			test.log(Status.PASS, "Successfully verified contact in Til Field");

			test.log(Status.FAIL, "Add, Remove and Again add contact from Til field in meldinger Test Case Passed");
			
		} catch (Exception e) {

			captureScreen(driver2, "Contact Removal");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Contact Removal Failed");
			test.fail("Contact Removal Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error(e.getStackTrace());
			test.log(Status.FAIL, "Add, Remove and Again add contact from Til field in meldinger Test Case Passed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
		}

		logger.info(" ==== Add, Remove and Again add contact from Til field in meldinger Test Case Passed  ===");
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
