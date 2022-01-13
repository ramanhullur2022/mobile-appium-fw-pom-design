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



public class TC_UDEMA_1986_TC002 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String act_text;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1986 
	 * Test Case ID  : UDEMA_1986_TC002 
	 * Test Summary  : Student send a new message to the Teacher - One School 
	 * Test Author   : Mahesh Shivanand Patil
	 */
	
	// Send New Message to Teacher by Student - One School
	@Test(enabled = true)
	public void send_Receive_New_Message_to_Teacher() throws InterruptedException, Exception {
		String statusLog = "UDEMA_1986_TC002";

		try {

			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1986_TC002", "Eleven sender en ny melding til læreren - en skole");

			statusLog = "Logger deg som Elev til Eleven-app";
			test.log(Status.PASS, "Logger deg som Elev til Eleven-app");
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudentWithOneSchool();
			elav_login.loginAsGeneric("studentOneSchool", "test");
			
			test.log(Status.PASS, "Eleven "+config.get_student_username_one_School()+" logget på vellykket i elev-appen");
			statusLog = "Elevinnlogging er fullført";
			
			String screenshot_tc2 = Base_Class.captureScreenExtent(driver2, "student_login_with_oneschool");
			test.pass("Elevinnlogging er fullført",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc2).build());
			
			Page_UDEMA_1984 page = new Page_UDEMA_1984(driver2);

			statusLog = "Klikk på skriv ny melding";
			page.clickOnMailComposeButton();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a message to the Teacher");

			statusLog = "Klikk på Till-knappen";
			page.clickOnTillButton();
			logger.info("Till Button clicked");
			test.log(Status.PASS, "Klikk på Till-knappen for å velge mottakerlærerens navn fra kontaktlisten");

			// Click on Teacher from Kontakt list
//			statusLog = "Klikk på mottakerlærer";
//			page.selectContactFromList();
//			logger.info("Teacher selected from Kontakt list");
//			test.log(Status.PASS, "Lærer valgt fra Kontaktliste");

			page.searchForUserAndSelect(driver2, "teacherOneSchool", "test", "na");
			logger.info("Teacher selected from Kontakt list");
			test.log(Status.PASS, "Lærer valgt fra Kontaktliste");
			
			// Teacher selection
			String screenshot_tc6 = Base_Class.captureScreenExtent(driver2, "teacher_selected");
			test.pass("Lærer valgt fra Kontakt",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc6).build());

			statusLog = "Writing Emne and body message";
			page.editMessageAndSendMessage();
			logger.info("Message title and body content edited then clicked on Send button");
			test.log(Status.PASS, "Klikkte på emne og skrev inn meldingstittel og tekstmeldingstekst og klikket deretter på Send-knappen");

			statusLog = "Bekreftelse av den sendte meldingen fra Sendt";
			page.verifySentMessage(act_text);
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Klikk på Arxiv, søk etter den sendte meldingen i Send og åpning av sendt melding er vellykket");
			test.log(Status.PASS, "Eleven "+config.get_student_username_one_School()+"sendt melding til læreren");

			String screenshot_tc21 = Base_Class.captureScreenExtent(driver2, "teacher_selected");
			test.pass("Lærer valgt fra Kontakt",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc21).build());

			
			System.out.println(page.getActualResult(act_text));

			test.log(Status.PASS, "Verifiseringen er vellykket og prøvesaken er bestått");
//			//page.logout();
//			logger.info("Logged out successfully");
//			test.log(Status.PASS, "Logged out from the app successfully");

			//driver2.quit();

		} catch (Exception e) {
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "screenshot_tc6");
			test.fail("test saken mislyktes", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "test saken mislyktes");
			//test.log(Status.ERROR, e.getMessage());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
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
