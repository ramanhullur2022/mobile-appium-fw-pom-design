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

public class TC_UDEMA_1984_TC007 extends Base_Class{

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
	 * Test Case ID  : UDEMA_1984_TC007
	 * Test Summary  : Parent sends a new message to the teacher 
	 * Test Author   : Ramana Gouda
	 */

	//@Test(dataProvider="Create another data provider")
	@Test
	public void send_Receive_New_Msg_Parent_to_Teacher() throws InterruptedException, Exception {
		String statusLog = "UDEMA_1984_TC007";

		try {
 
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1984_TC007", "Foresatte sender en ny melding til læreren");

			//launch_second_app();
			//Send SMS melding to Student/Parent

			statusLog = "Parent login into the App";
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("test");
			test.log(Status.PASS, "Foresatte ("+config.get_parent_login_id()+")logget på");
			statusLog = "Foresatte-apppålogging fullført";

			String screenshot_foresatte = Base_Class.captureScreenExtent(driver, "parentapp-foresatte");
			test.pass("Foresatte-pålogging fullført", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_foresatte).build());

			Page_UDEMA_1984 page = new Page_UDEMA_1984(driver);

			statusLog = "Klikk på knappen Skriv melding";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Klikk på å skrive ny melding til læreren("+config.get_teacher_username()+")");

			statusLog = "Klikk på Till-knappen";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Klikk på Till-knappen for å velge mottakerlærerens navn fra kontaktlisten");
			
			//New code
//			statusLog = "Velge student fra rullegardinmenyen";
//			page.selectStudentFromDropDown();
//			logger.info("Selected Student Alana from Drop down");
//			test.log(Status.PASS, "Valgte studenten "+config.get_student_username()+" fra rullegardinlisten");
//
//			statusLog = "Velge lærer fra Kontakt";
//			page.selectTeacherFromList();
//			logger.info("Teacher selected from school");
//			test.log(Status.PASS, "Lærer "+config.get_teacher_username()+ "valgt fra kontakt");
//			
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
			
			page.searchForUserAndSelect(driver, "parent_newui", "test","na");
			logger.info("Teacher selected from Kontakt list");
			test.log(Status.PASS, "Lærer "+config.get_teacher_username()+" valgt fra kontakt");

			
			statusLog = "Sender en melding med kropp og tittel";
			page.editMessageAndSendMessageInForesatte();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Tast inn meldingstittel og brødtekst og klikket deretter på Send-knappen");

			//String actual_result = page.verify_Sent_Message(act_text);
			statusLog = "Bekreftet sendt melding";
			page.verifySentMessageInForesatte(act_text);
			logger.info("Message sent and clicked on Arkiv and clicked on sent message");
			test.log(Status.PASS, "Melding sendt og klikket på Arkiv og klikket på den sendte meldingen");
			test.log(Status.PASS, "Foresatte("+config.get_parent_login_id()+" sendt melding til læreren "+config.get_teacher_username());

			String screenshot_7 = Base_Class.captureScreenExtent(driver, "parent_teacher");
			test.pass("Melding sendt fra foresatte til læreren", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_7).build());

			actual_result = page.getActualResult(act_text);

			//page.logout_Foresatte();
			//logger.info("Logged out successfully");
			//test.log(Status.PASS, "Logged out successfully");

			driver.quit();

		} catch (Exception e) {
			String screen_tc7 = Base_Class.captureScreenExtent(driver2, "parent_send_msg_teacher_07");
			test.fail("Bekreftelsen mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screen_tc7).build());
			test.log(Status.FAIL, " Feil - Bekreftelsen mislyktes");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog+ " med "+e.getClass().getSimpleName()+".");
			return;
		}

		
		try {

			statusLog = "Logger på som lærer "+config.get_teacher_username();
			test.log(Status.PASS, "Logger på som lærer ("+config.get_teacher_username()+") for å bekrefte melding fra foresatte");
			ElevLoginTest elav_login_student = new ElevLoginTest();
			//elav_login_student._loginAsTeacher();
			elav_login_student.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, "Logget inn som lærer ("+config.get_teacher_username()+") for å bekrefte melding fra foresatte ("+config.get_parent_login_id()+") er vellykket");

			Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);

			statusLog = "Klikk på Arkiv";
			test.log(Status.PASS, "Søker etter en mottatt melding fra Foresatte ("+config.get_parent_login_id()+")fra Arkiv");
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received message by searching from Arkiv");
			test.log(Status.PASS, "Lærer ("+config.get_teacher_username()+") mottatt en melding fra Foresatte ("+config.get_parent_login_id()+")");

			statusLog = "Sammenligning av meldingen sendt av læreren med den mottatte meldingen av eleven";
			expected_result = page2.getExpectedResult(exp_text);
			logger.info("Expected Result matching with Actual Result");
			test.log(Status.PASS, "Melding matchet med meldingen sendt av Foresatte ("+config.get_parent_login_id()+")");

			statusLog = "Logger ut fra Lærer";
			page2.logout();
			logger.info("Logged out from Teacher successfully");
			test.log(Status.PASS, "Logger ut fra Lærer ("+config.get_teacher_username()+")");



			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "parent_to_teacher");
				String screenshot_tc7 = Base_Class.captureScreenExtent(driver2, "parent_to_teacher");
				test.pass("Bekreftelse fullført",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc7).
						build());
				test.log(Status.PASS, "Bekreftelsen er fullført og testresultatet er bestått");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "parent_to_teacher");
				String screenshot_tc7 = Base_Class.captureScreenExtent(driver2, "parent_to_teacher");
				test.fail("Bekreftelsen mislyktes",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc7).
						build());
				test.log(Status.FAIL, "Egentlige resultatet: " + actual_result + "\n" + "Forventet resultat: " + expected_result);
				test.log(Status.FAIL, "Bekreftelsen mislyktes");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {
			String screenshot_tc7 = Base_Class.captureScreenExtent(driver2, "parent_to_teacher");
			test.fail("Bekreftelsen mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc7).build());
			test.log(Status.FAIL, "Bekreftelsen mislyktes og test saken mislyktes");
			logger.error(e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog+ " med "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Send Message Teacher from Parent App TC execution is completed!! ===");
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
