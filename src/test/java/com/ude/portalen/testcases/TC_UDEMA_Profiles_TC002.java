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
import com.ude.portalen.pageobject.ElevApp_Login;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_Profiles_TC002 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();
	public String expected;

	/*
	 * Test Suite ID : UDEMA_Profiles
	 * Test Case ID  : TC_UDEMA_Profiles_TC002
	 * Test Summary  : Logg in as Student and verify the email address in profile
	 * Test Author   : Ramana Gouda
	 */
	@Test
	public void verifyStudentProfile() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Profiles_TC002";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("TC_UDEMA_Profiles_TC002", "Logg inn som Student og bekreft e-postadressen i en profil");

			//Student App Login
			statusLog = "Logger på som Student";
			test.log(Status.PASS, "Starter pålogging av " + config.get_student_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logget på vellykket i Elev app");

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Student Login");
			test.pass("Logg på når studenten er fullført",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.PASS, "Logg på når studenten er fullført");

			ElevApp_Login page=new  ElevApp_Login(driver2);

			statusLog = "Bekreftelse av studentprofilen";
//			expected = page.getProfileName();
//			if(expected.equals(config.get_student_profile())) {
//				test.log(Status.PASS, "Verifisering av studentprofilen er fullført");
//				logger.info("Verification is pass");
//				captureScreen(driver2, "Student-profile");
//				String profile_verify = Base_Class.captureScreenExtent(driver2, "Student-profile-name");
//				test.pass("Verifisering av studentprofiler er fullført",
//						MediaEntityBuilder.
//						createScreenCaptureFromPath(profile_verify).
//						build());
//			}else {
//				test.log(Status.FAIL,"Verifisering av studentprofil mislyktes");
//				logger.info("Verification is failed");
//				captureScreen(driver2, "Student-profile");
//				String failed_profile_verify = Base_Class.captureScreenExtent(driver2, "Student-profile-name");
//				test.fail("Verifisering av studentprofil mislyktes kl" + statusLog,
//						MediaEntityBuilder.
//						createScreenCaptureFromPath(failed_profile_verify).
//						build());
//
//			}
			
			boolean result = verifyProfile(driver2, "student", "test");
			if(result) {
				test.log(Status.PASS, "Verifisering av studentprofilen er fullført");
				logger.info("Verification is pass");
				captureScreen(driver2, "Student-profile");
				String profile_verify = Base_Class.captureScreenExtent(driver2, "Student-profile-name");
				test.pass("Verifisering av studentprofiler er fullført",
						MediaEntityBuilder.
						createScreenCaptureFromPath(profile_verify).
						build());
			}else {
				test.log(Status.FAIL,"Verifisering av studentprofil mislyktes");
				logger.info("Verification is failed");
				captureScreen(driver2, "Student-profile");
				String failed_profile_verify = Base_Class.captureScreenExtent(driver2, "Student-profile-name");
				test.fail("Verifisering av studentprofil mislyktes kl" + statusLog,
						MediaEntityBuilder.
						createScreenCaptureFromPath(failed_profile_verify).
						build());

			}

		} catch (Exception e) {

			captureScreen(driver2, "Student profile verification failed at " + statusLog);
			String verification = Base_Class.captureScreenExtent(driver2, "Student_Login_Failed");
			test.fail("Verifisering av studentprofil mislyktes",
					MediaEntityBuilder.
					createScreenCaptureFromPath(verification).
					build());
			logger.error(e.getMessage());
			logger.error("Test Case Failed" + statusLog);
			test.log(Status.FAIL, "Test saken mislyktes mens"+ statusLog + ".");
			//test.log(Status.FAIL, "Test saken mislyktes mens"+ statusLog + " with " +e.getClass() +".");
			//softAssert_TC1.assertNotEquals(false, false);

		}

		logger.info(" ==== Student profile verification test case is completed ===");
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
