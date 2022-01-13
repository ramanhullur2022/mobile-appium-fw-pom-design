package com.ude.portalen.testcases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.Page_UDEMA_1984;
import com.ude.portalen.pageobject.Page_UDEMA_1987;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;



public class TC_UDEMA_1987_FAT extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	private String exp_text;
	private String act_text;

	public String expected_result;
	public String actual_result;
	
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_1987
	 * Test Case ID  : UDEMA_1987_TC001
	 * Test Summary  : Parent sends an absence message to the Teacher
	 * Test Author   : Ramana Gouda
	 */
	
	//@Test(dataProvider="Create data provider")
	@Test
	public void send_Absence_Msg_To_Teacher() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_1987_TC001";

		try {
			
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1987_TC001", "Parent sends an absence message to the Teacher");

			//launch_second_app();
			//Send SMS melding to Student/Parent
			statusLog = "Logging in as Parent";
			test.log(Status.PASS, "Starting Login of Parent("+config.get_parent_login_id()+")");
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("fat");
			
			test.log(Status.PASS, "Log in as Parent - "+config.get_parent_login_id()+" is successful");

			String screenshot_absence_msg = Base_Class.captureScreenExtent(driver, "parentapp-foresatte-absence-msg");
			test.pass("Parent App - Foresatte login completed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_absence_msg).build());

			Page_UDEMA_1987 page = new Page_UDEMA_1987(driver);

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailCompose();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a absence message to the Teacher("+config.get_teacher_username()+")");

			statusLog = "Clicking on Send Absence Message";
			page.clickOnSendAbsenceMessage();
			logger.info("Send absence message button clicked");
			test.log(Status.PASS, "Clicked on Meld fravær to create absence message");

			//new code
//			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
//			page.selectRecipientTeacher();
//			logger.info("Select Student name to send absence message to Teacher");
//			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
			//page.searchForUserAndSelect(driver, "parent", "test", "na");
			searchForUserAndSelect(driver, "parent_newui", "fat", "na");
			logger.info("Select Student name to send absence message to Teacher");
			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			
			statusLog = "Setting Absence Duration";
			page.selectAbsenceDuration("i_dag");
			logger.info("Absence duration selected and clicked on Send button");
			test.log(Status.PASS, "Selected Absence duration as 'I Dag' and clicked on Send Button");

			statusLog = "Verifying whether Absence Message is successfully sent to Teacher";
			//String actual_result = page.verify_Sent_Message(act_text);
			page.verifySentMessageInForesatte("i dag");
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Verified that Absence Message is successfully sent to Teacher in Arkiv Sendt folder");

			String screenshot_1987 = Base_Class.captureScreenExtent(driver, "absence_msg");
			test.pass("Absence message sent to teacher", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1987).build());

			actual_result = page.getActualResult(act_text);
			
			statusLog = "Logging out from Parent";
			page.logoutFromForesatte();
			logger.info("Successfully logged out from Parent");
			test.log(Status.PASS, "Successfully logged out from Parent("+config.get_parent_login_id()+")");

			driver.quit();


		} catch (Exception e) {
			String screen_absence_msg = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screen_absence_msg).build());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher Test Case Failed!!");
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			return;
		}


		try {

			statusLog = "Logging in as Teacher in Elev App to verify Absence Message";
			ElevLoginTest elav_login_teacher = new ElevLoginTest();
			//elav_login_teacher._loginAsTeacher();
			elav_login_teacher.loginAsGeneric("teacher", "fat");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			//Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);

			Page_UDEMA_1987 page2 = new Page_UDEMA_1987(driver2);
			
			statusLog = "Clicking on Arkiv Folder";
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Clicked and opened Arkiv folder to check received email from Parent");

			statusLog = "Absence Message Receival verification in Teacher";
			expected_result = page2.getExpectedResult("i dag");
			logger.info("Expected Result is matching with Actual Result");
			test.log(Status.PASS, "Absence Message received and verified successfully in Teacher("+config.get_teacher_username()+")");


			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.PASS, "Parent sends an absence message to the Teacher Test Case Passed!!");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.FAIL, "Parent sends an absence message to the Teacher Test Case Failed!!");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc1).build());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher Test Case Failed!!");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info("==== Send Absence message to teacher TC execution is completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
		//close_CmdExe();
	}

	/*
	 * Test Suite ID : UDEMA_1987
	 * Test Case ID  : UDEMA_1987_TC002
	 * Test Summary  : Parent sends an absence message to the Teacher as Tomorrow
	 * Test Author   : S, Manjunath
	 */
	
	//@Test(dataProvider="Create data provider")
	@Test
	public void send_Absence_Msg_To_Teacher_morgen() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_1987_TC002";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1987_TC002", "Parent sends an absence message to the Teacher as Tomorrow");

			//launch_second_app();
			//Send SMS melding to Student/Parent
			statusLog = "Logging in as Parent";
			test.log(Status.PASS, "Starting Login of Parent("+config.get_parent_login_id()+")");
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("fat");;
			test.log(Status.PASS, "Log in as Parent - "+config.get_parent_login_id()+" is successful");

			String screenshot_absence_msg = Base_Class.captureScreenExtent(driver, "parentapp-foresatte-absence-msg");
			test.pass("Parent App - Foresatte login completed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_absence_msg).build());

			Page_UDEMA_1987 page = new Page_UDEMA_1987(driver);

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailCompose();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a absence message to the Teacher("+config.get_teacher_username()+")");

			statusLog = "Clicking on Send Absence Message";
			page.clickOnSendAbsenceMessage();
			logger.info("Send absence message button clicked");
			test.log(Status.PASS, "Clicked on Meld fravær to create absence message");

//			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
//			page.selectRecipientTeacher();
//			logger.info("Select Student name to send absence message to Teacher");
//			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
			//page.searchForUserAndSelect(driver, "parent", "test", "na");
			searchForUserAndSelect(driver, "parent_newui", "fat", "na");
			logger.info("Select Student name to send absence message to Teacher");
			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			
			statusLog = "Setting Absence Duration";
			page.selectAbsenceDuration("i_morgen");
			logger.info("Absence duration selected and clicked on Send button");
			test.log(Status.PASS, "Selected Absence duration as 'I Morgen' and clicked on Send Button");

			statusLog = "Verifying whether Absence Message is successfully sent to Teacher";
			//String actual_result = page.verify_Sent_Message(act_text);
			page.verifySentMessageInForesatte("i morgen");
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Verified that Absence Message is successfully sent to Teacher in Arkiv Sendt folder");

			String screenshot_1987 = Base_Class.captureScreenExtent(driver, "absence_msg");
			test.pass("Absence message sent to teacher", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1987).build());

			actual_result = page.getActualResult(act_text);
			
			statusLog = "Logging out from Parent";
			page.logoutFromForesatte();
			logger.info("Successfully logged out from Parent");
			test.log(Status.PASS, "Successfully logged out from Parent("+config.get_parent_login_id()+")");

			driver.quit();


		} catch (Exception e) {
			String screen_absence_msg = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screen_absence_msg).build());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher as Tomorrow Test Case Failed!!");
			test.log(Status.ERROR, e.getMessage());
			logger.error("Test Case Failed");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			return;
		}


		try {

			statusLog = "Logging in as Teacher in Elev App to verify Absence Message";
			ElevLoginTest elav_login_teacher = new ElevLoginTest();
			//elav_login_teacher._loginAsTeacher();
			elav_login_teacher.loginAsGeneric("teacher", "fat");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			//Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);
			
			Page_UDEMA_1987 page2 = new Page_UDEMA_1987(driver2);

			statusLog = "Clicking on Arkiv Folder";
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Clicked and opened Arkiv folder to check received email from Parent");

			statusLog = "Absence Message Receival verification in Teacher";
			expected_result = page2.getExpectedResult("i morgen");
			logger.info("Expected Result is matching with Actual Result");
			test.log(Status.PASS, "Absence Message received and verified successfully in Teacher("+config.get_teacher_username()+")");


			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.PASS, "Parent sends an absence message to the Teacher as Tomorrow Test Case Passed!!");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.FAIL, "Parent sends an absence message to the Teacher as Tomorrow Test Case Failed!!");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc1).build());
			logger.error(e.getStackTrace());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher as Tomorrow Test Case Failed!!");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
		}

		logger.info("==== Parent sends an absence message to the Teacher as Tomorrow TC execution is completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
		//close_CmdExe();
	}
	
	/*
	 * Test Suite ID : UDEMA_1987
	 * Test Case ID  : UDEMA_1987_TC003
	 * Test Summary  : Parent sends an absence message to the Teacher with later date and time
	 * Test Author   : S, Manjunath
	 */
	
	//@Test(dataProvider="Create data provider")
	@Test
	public void send_Absence_Msg_To_Teacher_dato_later() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_1987_TC003";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1987_TC003", "Parent sends an absence message to the Teacher with later date and time");

			//launch_second_app();
			//Send SMS melding to Student/Parent
			statusLog = "Logging in as Parent";
			test.log(Status.PASS, "Starting Login of Parent("+config.get_parent_login_id()+")");
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("fat");
			test.log(Status.PASS, "Log in as Parent - "+config.get_parent_login_id()+" is successful");

			String screenshot_absence_msg = Base_Class.captureScreenExtent(driver, "parentapp-foresatte-absence-msg");
			test.pass("Parent App - Foresatte login completed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_absence_msg).build());

			Page_UDEMA_1987 page = new Page_UDEMA_1987(driver);

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailCompose();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a absence message to the Teacher("+config.get_teacher_username()+")");

			statusLog = "Clicking on Send Absence Message";
			page.clickOnSendAbsenceMessage();
			logger.info("Send absence message button clicked");
			test.log(Status.PASS, "Clicked on Meld fravær to create absence message");

//			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
//			page.selectRecipientTeacher();
//			logger.info("Select Student name to send absence message to Teacher");
//			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			
			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
			//page.searchForUserAndSelect(driver, "parent", "test", "na");
			searchForUserAndSelect(driver, "parent_newui", "fat", "na");
			logger.info("Select Student name to send absence message to Teacher");
			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			
			statusLog = "Setting Absence Duration";
			page.selectAbsenceDuration("dato_later");
			logger.info("Absence duration selected and clicked on Send button");
			test.log(Status.PASS, "Selected Absence duration as 'I Morgen' and clicked on Send Button");

			statusLog = "Verifying whether Absence Message is successfully sent to Teacher";
			//String actual_result = page.verify_Sent_Message(act_text);
			page.verifySentMessageInForesatte("later");
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Verified that Absence Message is successfully sent to Teacher in Arkiv Sendt folder");

			String screenshot_1987 = Base_Class.captureScreenExtent(driver, "absence_msg");
			test.pass("Absence message sent to teacher", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1987).build());

			actual_result = page.getActualResult(act_text);
			
			statusLog = "Logging out from Parent";
			page.logoutFromForesatte();
			logger.info("Successfully logged out from Parent");
			test.log(Status.PASS, "Successfully logged out from Parent("+config.get_parent_login_id()+")");

			driver.quit();


		} catch (Exception e) {
			String screen_absence_msg = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screen_absence_msg).build());
			logger.error(e.getStackTrace());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher with date and time Test Case Failed!!");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			return;
		}


		try {
	
			statusLog = "Logging in as Teacher in Elev App to verify Absence Message";
			ElevLoginTest elav_login_teacher = new ElevLoginTest();
			//elav_login_teacher._loginAsTeacher();
			elav_login_teacher.loginAsGeneric("teacher", "fat");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			//Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);
			Page_UDEMA_1987 page2 = new Page_UDEMA_1987(driver2);
			
			statusLog = "Clicking on Arkiv Folder";
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Clicked and opened Arkiv folder to check received email from Parent");

			statusLog = "Absence Message Receival verification in Teacher";
			expected_result = page2.getExpectedResult("later");
			logger.info("Expected Result is matching with Actual Result");
			test.log(Status.PASS, "Absence Message received and verified successfully in Teacher("+config.get_teacher_username()+")");


			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.PASS, "Parent sends an absence message to the Teacher with Later date and time Test Case Passed");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.FAIL, "Parent sends an absence message to the Teacher with Later date and time Test Case Failed!!");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc1).build());
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher with Later date and time Test Case Failed!!");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
		}

		logger.info("==== Parent sends an absence message to the Teacher with Later date and time TC execution is completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
		//close_CmdExe();
	}
	
	/*
	 * Test Suite ID : UDEMA_1987
	 * Test Case ID  : UDEMA_1987_TC004
	 * Test Summary  : Parent sends an absence message to the Teacher with previous date and time
	 * Test Author   : S, Manjunath
	 */
	
	//@Test(dataProvider="Create data provider")
	@Test
	public void send_Absence_Msg_To_Teacher_dato_previous() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_1987_TC004";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1987_TC004", "Parent sends an absence message to the Teacher with previous date and time");

			//launch_second_app();
			//Send SMS melding to Student/Parent
			statusLog = "Logging in as Parent";
			test.log(Status.PASS, "Starting Login of Parent("+config.get_parent_login_id()+")");
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("fat");
			test.log(Status.PASS, "Log in as Parent - "+config.get_parent_login_id()+" is successful");

			String screenshot_absence_msg = Base_Class.captureScreenExtent(driver, "parentapp-foresatte-absence-msg");
			test.pass("Parent App - Foresatte login completed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_absence_msg).build());

			Page_UDEMA_1987 page = new Page_UDEMA_1987(driver);

			statusLog = "Clicking on Compose Mail Button";
			page.clickOnMailCompose();
			logger.info("Message compose button clicked");
			test.log(Status.PASS, "Clicked on Ny Melding(new message) to write a absence message to the Teacher("+config.get_teacher_username()+")");

			statusLog = "Clicking on Send Absence Message";
			page.clickOnSendAbsenceMessage();
			logger.info("Send absence message button clicked");
			test.log(Status.PASS, "Clicked on Meld fravær to create absence message");

//			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
//			page.selectRecipientTeacher();
//			logger.info("Select Student name to send absence message to Teacher");
//			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			statusLog = "Selecting Student to Send Absence Message to Respective Teacher";
			//page.searchForUserAndSelect(driver, "parent", "test", "na");
			searchForUserAndSelect(driver, "parent_newui", "fat", "na");
			logger.info("Select Student name to send absence message to Teacher");
			test.log(Status.PASS, "Selected Student "+config.get_student_username()+" to send absence message to Teacher "+config.get_teacher_username());

			
			statusLog = "Setting Absence Duration";
			page.selectAbsenceDuration("dato_previous");
			logger.info("Absence duration selected and clicked on Send button");
			test.log(Status.PASS, "Selected Absence duration as 'I Morgen' and clicked on Send Button");

			statusLog = "Verifying whether Absence Message is successfully sent to Teacher";
			//String actual_result = page.verify_Sent_Message(act_text);
			page.verifySentMessageInForesatte("previous");
			logger.info("Message sent and clicked on Arkiv-sent, clicked on sent mail mail");
			test.log(Status.PASS, "Verified that Absence Message is successfully sent to Teacher in Arkiv Sendt folder");

			String screenshot_1987 = Base_Class.captureScreenExtent(driver, "absence_msg");
			test.pass("Absence message sent to teacher", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1987).build());

			actual_result = page.getActualResult(act_text);
			
			statusLog = "Logging out from Parent";
			page.logoutFromForesatte();
			logger.info("Successfully logged out from Parent");
			test.log(Status.PASS, "Successfully logged out from Parent("+config.get_parent_login_id()+")");

			driver.quit();


		} catch (Exception e) {
			String screen_absence_msg = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screen_absence_msg).build());
			logger.error(e.getStackTrace());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher with Previous date and time Test Case Failed!!");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			return;
		}


		try {
	
			statusLog = "Logging in as Teacher in Elev App to verify Absence Message";
			ElevLoginTest elav_login_teacher = new ElevLoginTest();
			//elav_login_teacher._loginAsTeacher();
			elav_login_teacher.loginAsGeneric("teacher", "fat");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			//Page_UDEMA_1984 page2 = new Page_UDEMA_1984(driver2);
			Page_UDEMA_1987 page2 = new Page_UDEMA_1987(driver2);
			
			statusLog = "Clicking on Arkiv Folder";
			page2.clickOnArkiv();
			logger.info("Clicked on Arkiv then clicked received email by searching it from Arkiv");
			test.log(Status.PASS, "Clicked and opened Arkiv folder to check received email from Parent");

			statusLog = "Absence Message Receival verification in Teacher";
			expected_result = page2.getExpectedResult("previous");
			logger.info("Expected Result is matching with Actual Result");
			test.log(Status.PASS, "Absence Message received and verified successfully in Teacher("+config.get_teacher_username()+")");


			if (expected_result.equals(actual_result)) {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.pass("Verification Completed",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.PASS, "Parent sends an absence message to the Teacher with date and time Test Case Passed");
				softAssert_TC1.assertEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.info("Verification is done");

			} else {
				captureScreen(driver2, "absence_msg_teacher");
				String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
						createScreenCaptureFromPath(screenshot_tc1).
						build());
				test.log(Status.FAIL, "Parent sends an absence message to the Teacher with Previous date and time Test Case Failed!!");
				softAssert_TC1.assertNotEquals(actual_result, expected_result, "Test Assertion Pass");
				logger.warn("Verification is done");

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			String screenshot_tc1 = Base_Class.captureScreenExtent(driver2, "absence_msg_teacher");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_tc1).build());
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Parent sends an absence message to the Teacher with Previous date and time Test Case Failed!!");
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
		}

		logger.info("==== Parent sends an absence message to the Teacher with Previous date and time TC execution is completed!! ===");
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
