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
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_1989_TC001 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1989 
	 * Test Case ID  : UDEMA_1989_TC001
	 * Test Summary  : Logg inn verification as a Student
	 * Test Author   : Ramana Gouda
	 */
	@Test
	public void login_As_Student() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_1989_TC001";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1989_TC001", "Logg inn verification as a Student");

			//Student App Login
			statusLog = "Logging in as Student";
			test.log(Status.PASS, "Starting Login of "+config.get_student_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Student Login");
			test.pass("Login as Student completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			
			test.log(Status.PASS, "Verification Completed and Status is PASS");

			//softAssert_TC1.assertEquals(false, false);

		} catch (Exception e) {

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Student Login Failed");
			test.fail("Student Login Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");


			//softAssert_TC1.assertNotEquals(false, false);
		}

		logger.info(" ==== Student Login Test Case is completed ===");
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
