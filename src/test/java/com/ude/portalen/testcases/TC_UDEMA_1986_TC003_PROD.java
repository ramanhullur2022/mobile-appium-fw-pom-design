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
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;



public class TC_UDEMA_1986_TC003_PROD extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String act_text;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1986 
	 * Test Case ID  : UDEMA_1986_TC003 
	 * Test Summary  : Teacher sends new message to the Student - One School
	 * Test Author   : Mahesh Shivanand Patil
	 */
	// Send New Message Student by Teacher - One School
	@Test(enabled = true)
	public void send_Receive_New_Message_with_Svar_Av() throws InterruptedException, Exception {
		String statusLog = "UDEMA_1986_TC003";
			
		try {

			// start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1986_TC003", "Lærer sender en ny melding til Elev - en skole");

			// launch_second_app();
			// Send Msg to Student/Parent
			statusLog = "Logg inn som Lærer i Elav app";
			test.log(Status.PASS, "Lærerpålogging behandles i Elav App Started");
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher2();
			elav_login.loginAsGeneric("teacherOneSchool", "prod");
			
			test.log(Status.PASS, "Lærer "+config.get_teacher_username2()+ " logget på vellykket i elev-appen");
			statusLog = "Elev App Login as Teacher is completed";

			String screenshot_tc3 = Base_Class.captureScreenExtent(driver2, "teacher_login_with_oneschool");
			test.pass("Lærer valgt fra Kontakt",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc3).build());
			
			
			statusLog = "Klikk på ny medling for å skrive en ny melding";
			Page_UDEMA_1986 page = new Page_UDEMA_1986(driver2);

			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Klikk på Ny Melding for å skrive en melding til eleven");

			statusLog = "Klikk på Till-knappen for å velge mottaker";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Klikk på Till-knappen for å velge mottakerens studentnavn fra kontaktlisten");

			/*
			page.click_School_Drop_Down();
			logger.info("School Drop Down clicked");
			test.log(Status.PASS, "Layout option clicked");

			page.click_School_Drop_Down_Options();
			logger.info("School Drop Down Option clicked");
			test.log(Status.PASS, "School Drop Down Option clicked");
			*/
			
			//new code
//			statusLog = "Klikk på Personer";
//			page.clickOnPersonerTab();
//			logger.info("Personer Tab clicked");
//			test.log(Status.PASS, "Klikk på Personer");
//
//			statusLog = "Klikk på kategorien Søk for å finne Elev-kontakt og velge";
//			page.click_Search_Input_editText_testcase3();
//			test.log(Status.PASS, "Søkte student tttta006 i søkefeltet");
//			
//			page.click_Search_Result_Student2();
//			logger.info("Clicked on Searched Student");
//			test.log(Status.PASS, "Klikk på Søkt elev");
			
			page.searchForUserAndSelect(driver2, "studentOneSchool", "prod", "eleven_and_foresatte");
			String screenshot_04 = Base_Class.captureScreenExtent(driver2, "student_contact_selected");
			test.pass("Eleven er valgt",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_04).build());

			
			statusLog = "Skriv meldingstittel og meldingsorgan og klikk på Send-knappen";
			page.edit_Msg_And_send_Msg();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Klikk på Emne og skrev inn meldingstittel og tekstmeldingstekst, og klikk deretter på Send-knappen");

			statusLog = "Åpne og bekrefte den sendte meldingen fra Sendt-fanen";
			page.verify_Sent_Message(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Klikk på Arkiv (arkiver), Søk etter den sendte meldingen i Sendt-mappen og åpning av sendt melding er vellykket");
			test.log(Status.PASS, "Lærer "+config.get_teacher_username2()+" sendt melding til eleven");
			

			String screenshot_05 = Base_Class.captureScreenExtent(driver2, "sent_message_from_sendt");
			test.pass("Lærer valgt fra Kontakt",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_05).build());
			

			System.out.println(page.get_Actual_Result(act_text));
			test.log(Status.PASS, "Testsak er bestått");

			statusLog = "Logger ut fra Lærer";
			page.logout();
			logger.info("Logged out successfully");
			test.log(Status.PASS, "Logget ut fra læreren");

			//driver2.quit();

		} catch (Exception e) {
			test.log(Status.ERROR, statusLog);
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "received_email");
			test.fail("Bekreftelsen mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Bekreftelsen mislyktes");
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog+ " med "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Send Message TC execution is completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();

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
