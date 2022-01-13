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

public class TC_UDEMA_1984_TC006 extends Base_Class{

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;

	public String expected_result;
	public String actual_result;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1984 
	 * Test Case ID  : UDEMA_1984_TC006
	 * Test Summary  : Student send new message to the Teacher 
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="testData")
	@Test
	public void send_Receive_New_Message_to_Teacher() throws InterruptedException, Exception {
		String statusLog = "UDEMA_1984_TC006";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1984_TC006", "Student som sender en ny melding til læreren");

			//launch_second_app();
			//Send Msg to Student/Parent

			statusLog = "Logg inn som Student i Elav App";
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, "Student "+config.get_student_username()+ "logget på vellykket i elev-appen");

			Page_UDEMA_1984 page = new Page_UDEMA_1984(driver2);

			statusLog = "Klikk på knappen Skriv melding";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Klikk på en ny melding for å skrive en melding til læreren ("+config.get_teacher_username()+")");

			statusLog = "Klikk på Till-knappen";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Klikk på Till-knappen for å velge mottakerlærer fra kontaktlisten");


//			page.clickOnSchoolDropDown();
//			logger.info("School Drop Down clicked");
//			test.log(Status.PASS, "Layout option clicked");
//
//
//			page.clickOnSchoolDropDownOptions();
//			logger.info("School Drop Down Option clicked");
//			test.log(Status.PASS, "School Drop Down Option clicked");

			
			//new code
			
//			//Click on Teacher from Kontakt list
//			statusLog = "Velge lærer fra kontaktliste";
//			page.selectTeacherFromList();
//			logger.info("Teacher selected from Kontakt list");
//			test.log(Status.PASS, "Lærer "+config.get_teacher_username()+" valgt fra kontakt");
			
			//page.searchForUserAndSelect(driver2, "teacher", "test", "na");
			searchForUserAndSelect(driver2, "teacher", "test", "na");
			logger.info("Teacher selected from Kontakt list");
			test.log(Status.PASS, "Lærer "+config.get_teacher_username()+" valgt fra kontakt");

			//Teacher selection
			String screenshot_tc6 = Base_Class.captureScreenExtent(driver2, "teacher_selected");
			test.pass("Lærer valgt fra kontakt", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc6).build());

			statusLog = "Sender en melding med kropp og tittel";
			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Tast inn meldingstittel og meldingstekst og klikket deretter på Send-knappen");

			statusLog = "Bekreftet sendt melding";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Klikk på Arkiv og søk deretter etter en sendt melding i Sendt og åpnet sendt melding");
			test.log(Status.PASS, "Student "+config.get_student_username()+ "sendt melding til læreren "+config.get_teacher_username());

			actual_result = page.getActualResult(act_text);

			statusLog = "Logg ut fra Student";
			page.logout();
			logger.info("Logg ut fra Student er vellykket");
			test.log(Status.PASS, "Logget ut fra Student ("+config.get_student_username()+") er vellykket");

			driver2.quit();

		} catch (Exception e) {
			String screen_tc6 = Base_Class.captureScreenExtent(driver2, "screenshot_06");
			test.fail("Bekreftelsen mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screen_tc6).build());
			test.log(Status.FAIL, "test saken mislyktes");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test saken mislyktes "+statusLog+ " med "+e.getClass().getSimpleName()+".");
			return;
		}

		try {
			statusLog = "Logger på som lærer "+config.get_teacher_username();
			test.log(Status.PASS, "Logger på lærer ("+config.get_teacher_username()+") for å bekrefte melding fra Student");
			ElevLoginTest elav_login_student = new ElevLoginTest();
			//elav_login_student._loginAsTeacher();
			elav_login_student.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, "Logger på lærer ("+config.get_teacher_username()+") for å bekrefte melding fra Student("+config.get_student_username()+") er vellykket");

			Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);
			
			statusLog = "Klikk på Arkiv";
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received message by searching from Arkiv");
			test.log(Status.PASS, "Lærer ("+config.get_teacher_username()+") mottok meldingen fra Student ("+config.get_student_username()+")");

			statusLog = "Sammenligning av en melding sendt av eleven med den mottatte meldingen i læreren";
			expected_result = page2.getExpectedResult(exp_text);
			logger.info("Message matched with Student("+config.get_student_username()+") sent message");
			test.log(Status.PASS, "Melding matchet med Student("+config.get_student_username()+") sendt melding");
			
			statusLog = "Logg ut fra Lærer";
			page2.logout();
			logger.info("Logged out from Teacher successfully");
			test.log(Status.PASS, "Logget ut fra læreren("+config.get_teacher_username()+")");

			//android.widget.EditText[@content-desc="Skriv svar her. Dobbeltklikk for å skrive svar"]

			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "screenshot_tc6");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
				test.pass("Bekreftelse fullført",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.PASS, "Verifisering Fullført og test case resultat er PASS");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Soft Assertion Test Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "screenshot_tc6");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
				test.fail("Bekreftelsen mislyktes her",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenShotPath).
						build());
				test.log(Status.FAIL, "Egentlige resultatet: " + actual_result + "\n" + "Forventet resultat: " + expected_result);
				test.log(Status.FAIL, "Bekreftelsen mislyktes");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Soft Assertion Test Fail");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {

			String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
			test.fail("Bekreftelsen mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Bekreftelsen mislyktes");
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog+ " med "+e.getClass().getSimpleName()+".");
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
