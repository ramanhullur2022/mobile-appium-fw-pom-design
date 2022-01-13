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
import com.ude.portalen.pageobject.ForesatteApp_Login;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_Profiles_TC001 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();
	public String expected;

	/*
	 * Test Suite ID : UDEMA_Profiles
	 * Test Case ID  : UDEMA_Profiles_TC001
	 * Test Summary  : Login as Parent and verify the email address in profile
	 * Test Author   : Ramana Gouda
	 */
	
	@Test
	public void verifyParentProfile() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Profiles_TC001";
		
		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Profiles_TC001", "Logg inn som overordnet og bekreft e-postadressen i en profil");
			
			//Parent App Login
			statusLog = "Logg inn som overordnet";
			test.log(Status.PASS, "Starter pålogging av overordnet("+config.get_parent_login_id()+")");
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("test");
			test.log(Status.PASS, "Foresatt("+config.get_parent_login_id()+") logget på vellykket i Foresatte-appen");
			
			captureScreen(driver, "Parent-Login");
		    String parent_login = Base_Class.captureScreenExtent(driver, "Parent_Login");
			test.pass("Foreldrepålogging fullført",MediaEntityBuilder.createScreenCaptureFromPath(parent_login).build());
			test.log(Status.PASS, "Foreldrepålogging fullført");
			
			
			ForesatteApp_Login page=new  ForesatteApp_Login(driver);
			
			statusLog = "Bekreftelse av overordnet profil";
			boolean result = verifyProfile(driver, "parent", "test");
//			expected = page.getProfileName();
//			if(expected.equals(config.get_parent_profile())) {
//				test.log(Status.PASS, "Verifiseringen av foreldreprofilen er fullført");
//				logger.info("Verification is pass");
//				captureScreen(driver, "parent-profile");
//				String profile_verify = Base_Class.captureScreenExtent(driver, "parent-profile-name");
//				test.pass("Verifisering av foreldreprofil er fullført",
//						MediaEntityBuilder.
//						createScreenCaptureFromPath(profile_verify).
//						build());
//			}else {
//				test.log(Status.FAIL,"Verifisering av foreldreprofil mislyktes");
//				logger.info("Verification is failed");
//				captureScreen(driver, "parent-profile");
//				String failed_profile_verify = Base_Class.captureScreenExtent(driver, "parent-profile-name");
//				test.fail("Verifisering av foreldreprofil mislyktes kl" + statusLog,
//						MediaEntityBuilder.
//						createScreenCaptureFromPath(failed_profile_verify).
//						build());
//			
//			}
			
			if(result) {
				test.log(Status.PASS, "Verifiseringen av foreldreprofilen er fullført");
				logger.info("Verification is pass");
				captureScreen(driver, "parent-profile");
				String profile_verify = Base_Class.captureScreenExtent(driver, "parent-profile-name");
				test.pass("Verifisering av foreldreprofil er fullført",
						MediaEntityBuilder.
						createScreenCaptureFromPath(profile_verify).
						build());
			}else {
				test.log(Status.FAIL,"Verifisering av foreldreprofil mislyktes");
				logger.info("Verification is failed");
				captureScreen(driver, "parent-profile");
				String failed_profile_verify = Base_Class.captureScreenExtent(driver, "parent-profile-name");
				test.fail("Verifisering av foreldreprofil mislyktes kl" + statusLog,
						MediaEntityBuilder.
						createScreenCaptureFromPath(failed_profile_verify).
						build());
			
			}
		

		} catch (Exception e) {

			captureScreen(driver, "Verifisering av foreldreprofil mislyktes kl " + statusLog);
			String verification = Base_Class.captureScreenExtent(driver, "Parent_Login_Failed");
			test.fail("Verifisering av foreldreprofil mislyktes",
					MediaEntityBuilder.
					createScreenCaptureFromPath(verification).
					build());
			logger.error("Test Case Failed" + statusLog);
			test.log(Status.FAIL, "Test saken mislyktes mens "+ statusLog + ".");
			//test.log(Status.FAIL, "Test saken mislyktes mens "+ statusLog + " med " +e.getClass() +".");
			//softAssert_TC1.assertNotEquals(false, false);
		}

		logger.info(" ==== Parent profile verification test case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver.quit();
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
