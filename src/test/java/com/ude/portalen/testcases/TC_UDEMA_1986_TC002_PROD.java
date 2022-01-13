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
import com.ude.portalen.pageobject.Page_UDEMA_1986;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.XLUtils;



public class TC_UDEMA_1986_TC002_PROD extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String act_text;
	

	/*
	 * Test Suite ID : UDEMA_1986 
	 * Test Case ID  : UDEMA_1986_TC001 
	 * Test Summary  : Parent sends new message to the Teacher from Parent app - One school 
	 * Test Author   : Mahesh Shivanand Patil
	 */
	
	// Test Data needs to be changed once Amutha gives the one school associated
	@Test(enabled = true)
	public void send_Receive_New_Msg_Parent_to_Teacher() throws InterruptedException, Exception {
		String statusLog = "UDEMA_1986_TC001";
		
		try {

			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1986_TC001", "Foresatte sender ny melding til læreren fra Foresatte-appen - En skole");

			statusLog = "Logger som Foresatte";
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("prod");
			test.log(Status.PASS, "Foresatte-apppålogging ble fullført");

			statusLog = "Foresatte-apppålogging ble fullført";
			String screenshot_foresatte = Base_Class.captureScreenExtent(driver, "parent_app_login_succecc");
			test.pass("Foresatte-apppålogging ble fullført",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_foresatte).build());

			Page_UDEMA_1986 page = new Page_UDEMA_1986(driver);
			
			statusLog = "Klikk på smelta";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Meldingskomponering-knappen klikket");

			statusLog = "Klikk på till-knappen";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Till-knappen klikket");

			//Old UI
			//page.select_Receipint_Teacher();
//			statusLog = "Klikk på mottakerlærer";
//			page.select_Receipint_Teacher_New();
//			String screenshot_2 = Base_Class.captureScreenExtent(driver, "parent_teacher_selection");
//			test.pass("Melding sendt fra foresatte til lærer",
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());

			statusLog = "Klikk på mottakerlærer";
			page.searchForUserAndSelect(driver, "teacherOneSchool", "prod", "na");
			String screenshot_2 = Base_Class.captureScreenExtent(driver, "parent_teacher_selection");
		    test.pass("Melding sendt fra foresatte til lærer",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());


			/*
			page.click_School_Drop_Down();
			logger.info("School Drop Down clicked");
			test.log(Status.PASS, "Layout option clicked");

			page.click_School_Drop_Down_Options();
			logger.info("School Drop Down Option clicked");
			test.log(Status.PASS, "School Drop Down Option clicked");

			page.select_Teacher_from_list();
			logger.info("Teacher selected from school");
			test.log(Status.PASS, "Teacher selected from school");
			*/

			statusLog = "Legger til meldingstittel og brødtekst";
			page.edit_Msg_And_send_Msg_Foresatte();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Meldingstittel og kroppsinnhold redigert og deretter klikket på Send-knappen");

			statusLog = "Bekreftelse av den sendte meldingen fra Sendt-fanen";
			page.verify_Sent_Message_Foresatte(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Melding sendt og klikket på Arkiv-sendt, klikket på sendt melding");

			String screenshot_7 = Base_Class.captureScreenExtent(driver, "parent_teacher");
			test.pass("Melding sendt fra Foresatte til læreren",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_7).build());

			driver.quit();

			Thread.sleep(5000);

		} catch (Exception e) {
			String screenshot_01 = Base_Class.captureScreenExtent(driver, "parent_to_teacher");
			test.fail("Test saken mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_01).build());
			test.log(Status.FAIL, "Test saken mislyktes");
			//test.log(Status.ERROR, e.getMessage());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog+ " med "+e.getClass().getSimpleName()+".");
		}
		
		logger.info(" ==== Send Message to Teacher from Parent App - One School TC execution is completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver.quit();

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
