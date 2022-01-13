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

public class TC_UDEMA_Profiles_TC003 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();
	public String expected;

	/*
	 * Test Suite ID : UDEMA_Profiles
	 * Test Case ID  : TC_UDEMA_Profiles_TC002
	 * Test Summary  : Logg in as Teacher and verify the email address in profile
	 * Test Author   : Ramana Gouda
	 */
	@Test
	public void verifyTeacherProfile() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Profiles_TC003";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("TC_UDEMA_Profiles_TC003", "Logg inn som lærer og bekreft e-postadressen i profilen");

			//Teacher App Login
			statusLog = "Logger på som lærer";
			test.log(Status.PASS, "Starter pålogging av "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+ "logget på vellykket i Elev-appen");

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Logg inn som lærer fullført",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			test.log(Status.PASS, "Innlogging som lærer er fullført");


			ElevApp_Login page=new  ElevApp_Login(driver2);

			statusLog = "Bekreftelse av lærerprofilen";
//			expected = page.getProfileName();
//			if(expected.equals(config.get_teacher_profile())) {
//				test.log(Status.PASS, "Bekreftelsen av lærerprofilen er fullført");
//				logger.info("Verification is pass");
//				captureScreen(driver2, "Teacher-profile");
//				String profile_verify = Base_Class.captureScreenExtent(driver2, "Teacher-profile-name");
//				test.pass("Bekreftelse av lærerprofilen er fullført",
//						MediaEntityBuilder.
//						createScreenCaptureFromPath(profile_verify).
//						build());
//			}else {
//				test.log(Status.FAIL,"Bekreftelse av lærerprofil mislyktes");
//				logger.info("Verification is failed");
//				captureScreen(driver2, "Teacher-profile");
//				String failed_profile_verify = Base_Class.captureScreenExtent(driver2, "Teacher-profile-name");
//				test.fail("Bekreftelse av lærerprofil mislyktes kl" + statusLog,
//						MediaEntityBuilder.
//						createScreenCaptureFromPath(failed_profile_verify).
//						build());
//
//			}
			
			boolean result = verifyProfile(driver2, "teacher", "test");
			if(result) {
				test.log(Status.PASS, "Verifisering av teacherprofilen er fullført");
				logger.info("Verification is pass");
				captureScreen(driver2, "Teacher-profile");
				String profile_verify = Base_Class.captureScreenExtent(driver2, "Teacher-profile-name");
				test.pass("Verifisering av teacherprofiler er fullført",
						MediaEntityBuilder.
						createScreenCaptureFromPath(profile_verify).
						build());
			}else {
				test.log(Status.FAIL,"Verifisering av teacherprofil mislyktes");
				logger.info("Verification is failed");
				captureScreen(driver2, "teacher-profile");
				String failed_profile_verify = Base_Class.captureScreenExtent(driver2, "Teacher-profile-name");
				test.fail("Verifisering av teacherprofil mislyktes kl" + statusLog,
						MediaEntityBuilder.
						createScreenCaptureFromPath(failed_profile_verify).
						build());

			}

		} catch (Exception e) {

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Bekreftelse av lærerprofil mislyktes kl" + statusLog);
			test.fail("Teacher profile verification failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed at" + statusLog);
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog +".");
			//test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass()+".");
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
	 * @return searchdata
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
