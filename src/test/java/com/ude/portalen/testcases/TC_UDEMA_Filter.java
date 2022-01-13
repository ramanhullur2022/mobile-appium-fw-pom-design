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
import com.ude.portalen.pageobject.Page_UDEMA_Filter;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_Filter extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC001
	 * Test Summary  : Select Uleste Meldinger filter in home and verify unread messages are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_Uleste_meldinger_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC001";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC001", "Select Uleste Meldinger filter in home and verify unread messages are displayed");

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

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Uleste Meldinger filter from Filter options";
			page.selectFilter("Uleste Meldinger");
			logger.info("Uleste Meldinger filter selected from Filter Options");
			test.log(Status.PASS, "Uleste Meldinger Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Uleste Meldinger filter";
			if(page.verifyMessagesAsPerSelectedFilter("Uleste Meldinger")) {
				logger.info("Uleste Meldinger filter successfully filtered unread messages");
				test.log(Status.PASS, "Uleste Meldinger filter successfully filtered unread messages");	
			} else {
				logger.info("Uleste Meldinger filter failed to filter unread messages");
				test.log(Status.PASS, "Uleste Meldinger filter failed to filter unread messages");
			}
			
			captureScreen(driver2, "Uleste Meldinger Filtered");
			String screenShotUleste = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger Filtered");
			test.pass("Uleste Meldinger Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger Filter Failed");
			test.fail("Uleste Meldinger Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Uleste Meldinger filter failed to filter unread messages");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Uleste Meldinger Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC002
	 * Test Summary  : Select Sporsmal filter in home and verify messages with Sporsmal tag are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_sporsmal_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC002";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC002", "Select Sporsmal filter in home and verify messages with Sporsmal tag are displayed");

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

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Sporsmal filter from Filter options";
			page.selectFilter("Spørsmål");
			logger.info("Sporsmal filter selected from Filter Options");
			test.log(Status.PASS, "Sporsmal Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Sporsmal filter";
			if(page.verifyMessagesAsPerSelectedFilter("Spørsmål")) {
				logger.info("Sporsmal filter successfully filtered messages with Sporsmal tag");
				test.log(Status.PASS, "Sporsmal filter successfully filtered messages with Sporsmal tag");	
			} else {
				logger.info("Sporsmal filter failed to filter messages with Sporsmal tag");
				test.log(Status.PASS, "Sporsmal filter failed to filter messages with Sporsmal tag");
			}
			
			captureScreen(driver2, "Student Login");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Sporsmal Filtered");
			test.pass("Sporsmal Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Student Login");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger Filter Failed");
			test.fail("Uleste Meldinger Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Sporsmal filter failed to filter messages with Sporsmal tag");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Sporsmal Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}

	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC003
	 * Test Summary  : Select Uleste meldinger and Sporsmal filter in home and verify unread messages with Sporsmal tag are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_Uleste_meldinger_sporsmal_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC003";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC003", "Select Uleste meldinger and Sporsmal filter in home and verify unread messages with Sporsmal tag are displayed");

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

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Uleste meldinger and Sporsmal filter from Filter options";
			page.selectFilter("Uleste meldinger and Sporsmal");
			logger.info("Uleste meldinger and Sporsmal filter selected from Filter Options");
			test.log(Status.PASS, "Uleste meldinger and Sporsmal Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Uleste meldinger and Sporsmal filter";
			if(page.verifyMessagesAsPerSelectedFilter("Uleste meldinger and Sporsmal")) {
				logger.info("Uleste meldinger and Sporsmal filter successfully filtered unread messages with Sporsmal tag");
				test.log(Status.PASS, "Uleste meldinger and Sporsmal filter successfully filtered unread messages with Sporsmal tag");	
			} else {
				logger.info("Uleste meldinger and Sporsmal filter failed to filter unread messages with Sporsmal tag");
				test.log(Status.PASS, "Uleste meldinger and Sporsmal filter failed to filter unread messages with Sporsmal tag");
			}
			
			captureScreen(driver2, "Student Login");
			String screenShotUlesteSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste meldinger and Sporsmal Filtered");
			test.pass("Uleste meldinger and Sporsmal Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotUlesteSporsmal).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Student Login");
			String screenShotUlesteSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger Filter Failed");
			test.fail("Uleste Meldinger Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotUlesteSporsmal).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Uleste meldinger and Sporsmal filter failed to filter unread messages with Sporsmal tag");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Uleste meldinger and Sporsmal Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC004
	 * Test Summary  : Select any contact under Avsender filter in home and verify messages from selected contact is displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_avsender_single_contact_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC004";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC004", "Select any contact under Avsender filter in home and verify messages from selected contact is displayed");

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

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting single contact under Avsender filter from Filter options";
			page.selectFilter("Avsender Single Contact");
			logger.info("Single contact from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Single contact from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Single Contact Selected");
			String screenShotSingleContactSelected = Base_Class.captureScreenExtent(driver2, "Single Contact Selected");
			test.pass("Single Contact Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSingleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting single contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Avsender Single Contact")) {
				logger.info("Single contact from Avsender filter successfully filtered messages from single contact");
				test.log(Status.PASS, "Single contact from Avsender filter successfully filtered messages from single contact");	
			} else {
				logger.info("Single contact from Avsender filter failed to filter messages from single contact");
				test.log(Status.PASS, "Single contact from Avsender filter failed to filter messages from single contact");
			}
			
			captureScreen(driver2, "Single contact from Avsender Filtered");
			String screenShotAvsenderSingleContact = Base_Class.captureScreenExtent(driver2, "Single contact from Avsender Filtered");
			test.pass("Single contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderSingleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Single contact from Avsender Filter Failed");
			String screenShotSingleContact = Base_Class.captureScreenExtent(driver2, "Single contact from Avsender Filter Failed");
			test.fail("Single contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSingleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Single contact from Avsender filter failed to filter messages from Single contact");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Single contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC005
	 * Test Summary  : Select multiple contacts under Avsender filter in home and verify messages from selected contacts are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_avsender_multiple_contact_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC005";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC005", "Select multiple contact under Avsender filter in home and verify messages from selected contacts are displayed");

			//Teacher App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting multiple contacts under Avsender filter from Filter options";
			page.selectFilter("Avsender Multiple Contact");
			logger.info("Multiple contacts from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Multiple contacts from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Multiple Contact Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Multiple Contact Selected");
			test.pass("Multiple Contact Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting Multiple contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Avsender Multiple Contact")) {
				logger.info("Multiple contact from Avsender filter successfully filtered messages from Multiple contact");
				test.log(Status.PASS, "Multiple contact from Avsender filter successfully filtered messages from Multiple contact");	
			} else {
				logger.info("Multiple contact from Avsender filter failed to filter messages from Multiple contact");
				test.log(Status.PASS, "Multiple contact from Avsender filter failed to filter messages from Multiple contact");
			}
			
			captureScreen(driver2, "Multiple contact from Avsender filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "Multiple contact from Avsender Filtered");
			test.pass("Multiple contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Multiple contact from Avsender Filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "Multiple contact from Avsender Filter Failed");
			test.fail("Multiple contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Multiple contact from Avsender filter failed to filter messages from Multiple contact");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Multiple contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC006
	 * Test Summary  : Select Elev icon in contact filter in home and verify messages from Student contact are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_student_icon_contact_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC006";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC006", "Select Elev icon in contact filter in home and verify messages from Student contact are displayed");

			//Teacher App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Contact Filter Icon";
			page.clickOnContactsFilter("Elev", "Elev");
			logger.info("Clicked on Contact Filter Icon");
			test.log(Status.PASS, "Clicked on Contact Filter Icon");
			
			captureScreen(driver2, "Contact Icon Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Contact Icon Selected");
			test.pass("Contact Icon Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting student contact from Contact filter";
			if(page.verifyMessagesAsPerSelectedFilter("Elev Contact filter in Elev")) {
				logger.info("Successfully filtered messages from student contact from Contact filter!!");
				test.log(Status.PASS, "Successfully filtered messages from student contact from Contact filter!!");	
			} else {
				logger.info("Failed to filter messages from student contact from Contact filter!!");
				test.log(Status.PASS, "Failed to filter messages from student contact from Contact filter!!");
			}
			
			captureScreen(driver2, "student contact from contact filter filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "student contact from contact filter filtered");
			test.pass("student contact from contact filter filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "student contact from contact filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "student contact from contact filter Failed");
			test.fail("student contact from contact filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Student contact filter from Contact filter failed to filter messages!!");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Student contact filtet from Contact Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Home_TC007
	 * Test Summary  : Select Foresatte icon in contact filter in home and verify messages from Parent contact are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_foresatte_icon_contact_home() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC007";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC007", "Select Foresatte icon in contact filter in home and verify messages from Parent contact are displayed");

			//Teacher App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Clicking on Contact Filter Icon";
			page.clickOnContactsFilter("Foresatte", "Elev");
			logger.info("Clicked on Contact Filter Icon");
			test.log(Status.PASS, "Clicked on Contact Filter Icon");
			
			captureScreen(driver2, "Contact Icon Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Contact Icon Selected");
			test.pass("Contact Icon Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting foresatte contact from Contact filter";
			if(page.verifyMessagesAsPerSelectedFilter("Foresatte Contact filter in Elev")) {
				logger.info("Successfully filtered messages from foresatte contact from Contact filter!!");
				test.log(Status.PASS, "Successfully filtered messages from foresatte contact from Contact filter!!");	
			} else {
				logger.info("Failed to filter messages from foresatte contact from Contact filter!!");
				test.log(Status.PASS, "Failed to filter messages from foresatte contact from Contact filter!!");
			}
			
			captureScreen(driver2, "foresatte contact from contact filter filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "foresatte contact from contact filter filtered");
			test.pass("foresatte contact from contact filter filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "foresatte contact from contact filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "foresatte contact from contact filter Failed");
			test.fail("foresatte contact from contact filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "foresatte contact filter from Contact filter failed to filter messages!!");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== foresatte contact filter from Contact Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC001
	 * Test Summary  : Select Sporsmal filter in Arkiv Sendt folder and verify messages with Sporsmal tag are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_sporsmal_arkiv() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC001";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC001", "Select Sporsmal filter in Arkiv Sendt folder and verify messages with Sporsmal tag are displayed");

			//Teacher App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Sendt Folder";
			page.goToArkivFolder("Sendt");
			logger.info("Navigated to Arkiv Sendt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Sendt Folder");

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Sporsmal filter from Filter options";
			page.selectFilter("Spørsmål");
			logger.info("Sporsmal filter selected from Filter Options");
			test.log(Status.PASS, "Sporsmal Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Sporsmal filter";
			if(page.verifyMessagesAsPerSelectedFilter("Spørsmål")) {
				logger.info("Sporsmal filter successfully filtered messages with Sporsmal tag");
				test.log(Status.PASS, "Sporsmal filter successfully filtered messages with Sporsmal tag");	
			} else {
				logger.info("Sporsmal filter failed to filter messages with Sporsmal tag");
				test.log(Status.PASS, "Sporsmal filter failed to filter messages with Sporsmal tag");
			}
			
			captureScreen(driver2, "Sporsmal filtered");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Sporsmal Filtered");
			test.pass("Sporsmal Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Sporsmal filtered failed");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Sporsmal Filter Failed");
			test.fail("Sporsmal Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Sporsmal filter failed to filter messages with Sporsmal tag");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Sporsmal Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC002
	 * Test Summary  : Select Uleste Meldinger filter in Arkiv Mottatt folder and verify messages with unread messages are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_Uleste_meldinger_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC002";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC001", "Select Uleste Meldinger filter in Arkiv Mottatt folder and verify messages with unread messages are displayed");

			//Student App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Uleste Meldinger filter from Filter options";
			page.selectFilter("Uleste Meldinger");
			logger.info("Uleste Meldinger filter selected from Filter Options");
			test.log(Status.PASS, "Uleste Meldinger Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Uleste Meldinger filter";
			if(page.verifyMessagesAsPerSelectedFilter("Uleste Meldinger")) {
				logger.info("Uleste Meldinger filter successfully filtered unread messages");
				test.log(Status.PASS, "Uleste Meldinger filter successfully filtered unread messages");	
			} else {
				logger.info("Uleste Meldinger filter failed to filter unread messages");
				test.log(Status.PASS, "Uleste Meldinger filter failed to filter unread messages");
			}
			
			captureScreen(driver2, "Uleste Meldinger Filtered");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger Filtered");
			test.pass("Uleste Meldinger Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Uleste Meldinger Filter failed");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger Filter Failed");
			test.fail("Uleste Meldinger Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Uleste Meldinger filter failed to filter unread messages in Arkiv Mottatt folder");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Uleste Meldinger Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC003
	 * Test Summary  : Select Sporsmal filter in Arkiv Mottatt folder and verify messages with Sporsmal tag are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_sporsmal_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC003";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC003", "Select Sporsmal filter in Arkiv Mottatt folder and verify messages with Sporsmal tag are displayed");

			//Student App Login
			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Sporsmal filter from Filter options";
			page.selectFilter("Spørsmål");
			logger.info("Sporsmal filter selected from Filter Options");
			test.log(Status.PASS, "Sporsmal Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Sporsmal filter";
			if(page.verifyMessagesAsPerSelectedFilter("Spørsmål")) {
				logger.info("Sporsmal filter successfully filtered messages with Sporsmal tag");
				test.log(Status.PASS, "Sporsmal filter successfully filtered messages with Sporsmal tag");	
			} else {
				logger.info("Sporsmal filter failed to filter messages with Sporsmal tag");
				test.log(Status.PASS, "Sporsmal filter failed to filter messages with Sporsmal tag");
			}
			
			captureScreen(driver2, "Sporsmal filtered");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Sporsmal Filtered");
			test.pass("Sporsmal Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Sporsmal filtered failed");
			String screenShotSporsmal = Base_Class.captureScreenExtent(driver2, "Sporsmal Filter Failed");
			test.fail("Sporsmal Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSporsmal).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Sporsmal filter failed to filter messages with Sporsmal tag");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Sporsmal Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC004
	 * Test Summary  : Select any contact under Avsender filter in Arkiv Mottatt folder and verify messages from selected contact is displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_avsender_single_contact_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC004";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC004", "Select any contact under Avsender filter in Arkiv Mottatt folder and verify messages from selected contact is displayed");

			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			
			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");
			
			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting single contact under Avsender filter from Filter options";
			page.selectFilter("Avsender Single Contact");
			logger.info("Single contact from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Single contact from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Single Contact Selected");
			String screenShotSingleContactSelected = Base_Class.captureScreenExtent(driver2, "Single Contact Selected");
			test.pass("Single Contact Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSingleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting single contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Avsender Single Contact")) {
				logger.info("Single contact from Avsender filter successfully filtered messages from single contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Single contact from Avsender filter successfully filtered messages from single contact in Arkiv Mottatt folder");	
			} else {
				logger.info("Single contact from Avsender filter failed to filter messages from single contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Single contact from Avsender filter failed to filter messages from single contact in Arkiv Mottatt folder");
			}
			
			captureScreen(driver2, "Single contact from Avsender Filtered");
			String screenShotAvsenderSingleContact = Base_Class.captureScreenExtent(driver2, "Single contact from Avsender Filtered");
			test.pass("Single contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderSingleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Single contact from Avsender Filter Failed");
			String screenShotSingleContact = Base_Class.captureScreenExtent(driver2, "Single contact from Avsender Filter Failed");
			test.fail("Single contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotSingleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Single contact from Avsender filter failed to filter messages from Single contact");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Single contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC005
	 * Test Summary  : Select Uleste meldinger and Sporsmal filter in Arkiv Mottatt folder and verify unread messages with Sporsmal tag are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_Uleste_meldinger_sporsmal_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC005";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC005", "Select Uleste meldinger and Sporsmal filter in home and verify unread messages with Sporsmal tag are displayed in Arkiv Mottatt folder");

			//Student App Login
			statusLog = "Logging in as Student";
			test.log(Status.PASS, "Starting Login of "+config.get_student_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			
			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");

			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Uleste meldinger and Sporsmal filter from Filter options";
			page.selectFilter("Uleste meldinger and Sporsmal");
			logger.info("Uleste meldinger and Sporsmal filter selected from Filter Options");
			test.log(Status.PASS, "Uleste meldinger and Sporsmal Filter selected from Filter Options");

			statusLog = "Verifying filtered messages after selecting Uleste meldinger and Sporsmal filter";
			if(page.verifyMessagesAsPerSelectedFilter("Uleste meldinger and Sporsmal")) {
				logger.info("Uleste meldinger and Sporsmal filter successfully filtered unread messages with Sporsmal tag in Arkiv Mottatt folder");
				test.log(Status.PASS, "Uleste meldinger and Sporsmal filter successfully filtered unread messages with Sporsmal tag in Arkiv Mottatt folder");	
			} else {
				logger.info("Uleste meldinger and Sporsmal filter failed to filter unread messages with Sporsmal tag in Arkiv Mottatt folder");
				test.log(Status.PASS, "Uleste meldinger and Sporsmal filter failed to filter unread messages with Sporsmal tag in Arkiv Mottatt folder");
			}
			
			captureScreen(driver2, "Uleste meldinger and Sporsmal filtered in Arkiv");
			String screenShotUlesteSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste meldinger and Sporsmal Filtered in Arkiv");
			test.pass("Uleste meldinger and Sporsmal Filtered in Arkiv",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotUlesteSporsmal).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Uleste Meldinger and Sporsmal Filter Failed");
			String screenShotUlesteSporsmal = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger and Sporsmal Filter Failed");
			test.fail("Uleste Meldinger and Sporsmal Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotUlesteSporsmal).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Uleste meldinger and Sporsmal filter failed to filter unread messages with Sporsmal tag in Arkiv Mottatt folder");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Uleste meldinger and Sporsmal Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC006
	 * Test Summary  : Select Uleste Meldinger and single contact under Avsender filter in Arkiv Mottatt folder and verify unread messages from single contact is displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_uleste_meldinger_avsender_single_contact_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC006";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC006", "Select Uleste Meldinger and single contact under Avsender filter in Arkiv Mottatt folder and verify unread messages from single contact is displayed");

			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");
			
			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Uleste meldinger and single contact under Avsender filter from Filter options";
			page.selectFilter("Uleste meldinger and Avsender Single Contact");
			logger.info("Uleste meldinger and Single contacts from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Uleste meldinger and Single contacts from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Uleste meldinger and Avsender Single Contact Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Uleste meldinger and Avsender Single Contact Selected");
			test.pass("Uleste meldinger and Avsender Single Contact",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting Uleste meldinger and Avsender Single Contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Uleste meldinger and Avsender Single Contact")) {
				logger.info("Uleste meldinger and Single Contact from Avsender filter successfully filtered unread messages from Single contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Uleste meldinger and Single contact from Avsender filter successfully filtered unread messages from Single contact in Arkiv Mottatt folder");	
			} else {
				logger.info("Uleste meldinger and Single contact from Avsender filter failed to filter unread messages from Single contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Uleste meldinger and Single contact from Avsender filter failed to filter unread messages from Single contact in Arkiv Mottatt folder");
			}
			
			captureScreen(driver2, "Uleste Meldinger and Single contact from Avsender filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger and Single contact from Avsender Filtered");
			test.pass("Uleste Meldinger and Single contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Uleste Meldinger and Single contact from Avsender Filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger and Single contact from Avsender Filter Failed");
			test.fail("Uleste Meldinger and Single contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Uleste Meldinger and Single contact from Avsender filter failed to filter unread messages from Multiple contact in Arkiv Mottatt folder");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Uleste Meldinger and Single contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC007
	 * Test Summary  : Select Uleste Meldinger and multiple contacts under Avsender filter in Arkiv Mottatt folder and verify unread messages from selected contacts are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_uleste_meldinger_avsender_multiple_contact_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC007";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC007", "Select Uleste Meldinger and multiple contacts under Avsender filter in Arkiv Mottatt folder and verify unread messages from selected contacts are displayed");

			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");
			
			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Uleste meldinger and multiple contacts under Avsender filter from Filter options";
			page.selectFilter("Uleste meldinger and Avsender Multiple Contact");
			logger.info("Uleste meldinger and Multiple contacts from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Uleste meldinger and Multiple contacts from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Uleste meldinger and Multiple Contact Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Uleste meldinger and Multiple Contact Selected");
			test.pass("Multiple Contact Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting Uleste meldinger and Multiple contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Uleste meldinger and Avsender Multiple Contact")) {
				logger.info("Uleste meldinger and Multiple contact from Avsender filter successfully filtered messages from Multiple contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Uleste meldinger and Multiple contact from Avsender filter successfully filtered messages from Multiple contact in Arkiv Mottatt folder");	
			} else {
				logger.info("Multiple contact from Avsender filter failed to filter messages from Multiple contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Multiple contact from Avsender filter failed to filter messages from Multiple contact in Arkiv Mottatt folder");
			}
			
			captureScreen(driver2, "Uleste Meldinger and Multiple contact from Avsender filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger and Multiple contact from Avsender Filtered");
			test.pass("Uleste Meldinger and Multiple contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Uleste Meldinger and Multiple contact from Avsender Filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "Uleste Meldinger and Multiple contact from Avsender Filter Failed");
			test.fail("Uleste Meldinger and Multiple contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Uleste Meldinger and Multiple contact from Avsender filter failed to filter unread messages from Multiple contact in Arkiv Mottatt folder");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Uleste Meldinger and Multiple contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC008
	 * Test Summary  : Select Sporsmal and single contact under Avsender filter in Arkiv Mottatt folder and verify messages from single contact is displayed with Sporsmal tag
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_sporsmal_avsender_single_contact_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC008";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC008", "Select Sporsmal and single contact under Avsender filter in Arkiv Mottatt folder and verify messages from single contact is displayed with Sporsmal tag");

			statusLog = "Logging in as Teacher";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher();
			elav_login.loginAsGeneric("teacher", "test");
			test.log(Status.PASS, config.get_teacher_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);

			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");
			
			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Sporsmal and single contact under Avsender filter from Filter options";
			page.selectFilter("Sporsmal and Avsender Single Contact");
			logger.info("Sporsmal and Single contacts from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Sporsmal and Single contacts from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Sporsmal and Avsender Single Contact Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Sporsmal and Avsender Single Contact Selected");
			test.pass("Sporsmal and Avsender Single Contact",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting Sporsmal and Avsender Single Contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Sporsmal and Avsender Single Contact")) {
				logger.info("Sporsmal and Single Contact from Avsender filter successfully filtered messages with Sporsmal tag from Single contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Sporsmal and Single contact from Avsender filter successfully filtered messages with Sporsmal tag from Single contact in Arkiv Mottatt folder");	
			} else {
				logger.info("Sporsmal and Single contact from Avsender filter failed to filter messages with Sporsmal tag from Single contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Sporsmal and Single contact from Avsender filter failed to filter messages with Sporsmal tag from Single contact in Arkiv Mottatt folder");
			}
			
			captureScreen(driver2, "Sporsmal and Single contact from Avsender filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "Sporsmal and Single contact from Avsender Filtered");
			test.pass("Sporsmal and Single contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Sporsmal and Single contact from Avsender Filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "Sporsmal and Single contact from Avsender Filter Failed");
			test.fail("Sporsmal and Single contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Sporsmal and Single contact from Avsender filter failed to filter messages with sporsmal tag from Single contact in Arkiv Mottatt folder");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Sporsmal and Single contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC009
	 * Test Summary  : Select Sporsmal and multiple contacts under Avsender filter in Arkiv Mottatt folder and verify messages with sporsmal tag from selected contacts are displayed
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=true)
	public void select_sporsmal_avsender_multiple_contact_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Arkiv_TC009";

		try {
			
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Arkiv_TC009", "Select Sporsmal and multiple contacts under Avsender filter in Arkiv Mottatt folder and verify messages with sporsmal tag from selected contacts are displayed");
			
			//Login as masya010 teacher to send a sporsmal message
			statusLog = "Logging in as Teacher Masya010";
			test.log(Status.PASS, "Starting Login of "+config.get_teacher_username3());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsTeacher3();
			elav_login.loginAsGeneric("teacher3", "test");
			test.log(Status.PASS, config.get_teacher_username3()+" logged in successfully in elev app");
			
			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Sending Sporsmal message from Teacher("+config.get_teacher_username3()+") to Student("+config.get_student_username()+")";
			page.sendMailFromTeacher();
			logger.info("Sent Sporsmal message from Teacher to Student");
			test.log(Status.PASS, "Sent Sporsmal message from Teacher("+config.get_teacher_username3()+") to Student("+config.get_student_username()+")");
			
			//Student App Login
			statusLog = "Logging in as Student";
			test.log(Status.PASS, "Starting Login of "+config.get_student_username());
			//ElevLoginTest elav_login = new ElevLoginTest();
			elav_login._loginAsStudent();
			test.log(Status.PASS, config.get_student_username()+" logged in successfully in elev app");

			captureScreen(driver2, "Student Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Student Login");
			test.pass("Login as Student completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");
			
			statusLog = "Clicking on Filter Icon";
			page.clickOnFilter();
			logger.info("Clicked on Filter Icon");
			test.log(Status.PASS, "Clicked on Filter Icon");

			statusLog = "Selecting Sporsmal and multiple contacts under Avsender filter from Filter options";
			page.selectFilter("Sporsmal and Avsender Multiple Contact");
			logger.info("Sporsmal and Multiple contacts from Avsender filter selected from Filter Options");
			test.log(Status.PASS, "Sporsmal and Multiple contacts from Avsender Filter selected from Filter Options");
			
			captureScreen(driver2, "Sporsmal and Multiple Contact Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Sporsmal and Multiple Contact Selected");
			test.pass("Sporsmal and Multiple Contact Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting Sporsmal and Multiple contact from Avsender filter";
			if(page.verifyMessagesAsPerSelectedFilter("Sporsmal and Avsender Multiple Contact")) {
				logger.info("Sporsmal and Multiple contact from Avsender filter successfully filtered messages with sporsmal tag from Multiple contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Sporsmal and Multiple contact from Avsender filter successfully filtered messages with sporsmal tag from Multiple contact in Arkiv Mottatt folder");	
			} else {
				logger.info("Sporsmal and Multiple contact from Avsender filter failed to filter messages with sporsmal tag from Multiple contact in Arkiv Mottatt folder");
				test.log(Status.PASS, "Sporsmal and Multiple contact from Avsender filter failed to filter messages with sporsmal tag from Multiple contact in Arkiv Mottatt folder");
			}
			
			captureScreen(driver2, "Sporsmal and Multiple contact from Avsender filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "Sporsmal and Multiple contact from Avsender Filtered");
			test.pass("Sporsmal and Multiple contact from Avsender Filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "Sporsmal and Multiple contact from Avsender Filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "Sporsmal and Multiple contact from Avsender Filter Failed");
			test.fail("Sporsmal and Multiple contact from Avsender Filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Sporsmal and Multiple contact from Avsender filter failed to filter messages with sporsmal tag from Multiple contact in Arkiv Mottatt folder");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Sporsmal and Multiple contact from Avsender Filter Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC009
	 * Test Summary  : Select single contact icon in contact filter in Arkiv Sendt
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_single_contact_arkiv_sendt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC009";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC009", "Select single contact icon in contact filter in Arkiv Sendt");

			//Teacher App Login
			statusLog = "Logging in as Parent";
			test.log(Status.PASS, "Starting Login of "+config.get_parent_login_id());
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("test");
			test.log(Status.PASS, config.get_parent_login_id()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Sendt Folder";
			page.goToArkivFolder("Sendt");
			logger.info("Navigated to Arkiv Sendt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Sendt Folder");

			statusLog = "Clicking on Contact Filter Icon";
			page.clickOnContactsFilter("Alana", "Foresatte");
			logger.info("Clicked on Contact Filter Icon");
			test.log(Status.PASS, "Clicked on Contact Filter Icon");
			
			captureScreen(driver2, "Contact Icon Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Contact Icon Selected");
			test.pass("Contact Icon Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting student contact from Contact filter in Arkiv Sendt folder";
			if(page.verifyMessagesAsPerSelectedFilter("Alana Contact filter in Arkiv Sendt Foresatte")) {
				logger.info("Successfully filtered messages from student contact from Contact filter in Arkiv Sendt folder!!");
				test.log(Status.PASS, "Successfully filtered messages from student contact from Contact filter in Arkiv Sendt folder!!");	
			} else {
				logger.info("Failed to filter messages from student contact from Contact filter in Arkiv Sendt folder!!");
				test.log(Status.PASS, "Failed to filter messages from student contact from Contact filter in Arkiv Sendt folder!!");
			}
			
			captureScreen(driver2, "student contact from contact filter filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "student contact from contact filter filtered");
			test.pass("student contact from contact filter filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "student contact from contact filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "student contact from contact filter Failed");
			test.fail("student contact from contact filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Select single contact icon in contact filter in Arkiv Sendt Test Case Failed!!");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Select single contact icon in contact filter in Arkiv Sendt Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Filter 
	 * Test Case ID  : UDEMA_Fiter_Arkiv_TC010
	 * Test Summary  : Select single contact icon in contact filter in Arkiv Mottatt
	 * Test Author   : S, Manjunath
	 */
	@Test(enabled=false)
	public void select_single_contact_arkiv_mottatt() throws InterruptedException, Exception {
		String statusLog = "UDEMA_Fiter_Home_TC010";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Fiter_Home_TC010", "Select single contact icon in contact filter in Arkiv Mottatt");

			//Teacher App Login
			statusLog = "Logging in as Parent";
			test.log(Status.PASS, "Starting Login of "+config.get_parent_login_id());
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParent();
			foresatte_login.loginAsParentGeneric("test");
			test.log(Status.PASS, config.get_parent_login_id()+" logged in successfully in elev app");

			captureScreen(driver2, "Teacher Login");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Teacher Login");
			test.pass("Login as Teacher completed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());

			Page_UDEMA_Filter page = new Page_UDEMA_Filter(driver2);
			
			statusLog = "Navigating to Arkiv Mottatt Folder";
			page.goToArkivFolder("Mottatt");
			logger.info("Navigated to Arkiv Mottatt Folder");
			test.log(Status.PASS, "Navigated to Arkiv Mottatt Folder");

			statusLog = "Clicking on Contact Filter Icon";
			page.clickOnContactsFilter("Alana", "Foresatte");
			logger.info("Clicked on Contact Filter Icon");
			test.log(Status.PASS, "Clicked on Contact Filter Icon");
			
			captureScreen(driver2, "Contact Icon Selected");
			String screenShotMultipleContactSelected = Base_Class.captureScreenExtent(driver2, "Contact Icon Selected");
			test.pass("Contact Icon Selected",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContactSelected).
					build());

			statusLog = "Verifying filtered messages after selecting student contact from Contact filter in Arkiv Mottatt folder";
			if(page.verifyMessagesAsPerSelectedFilter("Alana Contact filter in Arkiv Sendt Foresatte")) {
				logger.info("Successfully filtered messages from student contact from Contact filter in Arkiv Mottatt folder!!");
				test.log(Status.PASS, "Successfully filtered messages from student contact from Contact filter in Arkiv Mottatt folder!!");	
			} else {
				logger.info("Failed to filter messages from student contact from Contact filter in Arkiv Mottatt folder!!");
				test.log(Status.PASS, "Failed to filter messages from student contact from Contact filter in Arkiv Mottatt folder!!");
			}
			
			captureScreen(driver2, "student contact from contact filter filtered");
			String screenShotAvsenderMultipleContact = Base_Class.captureScreenExtent(driver2, "student contact from contact filter filtered");
			test.pass("student contact from contact filter filtered",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotAvsenderMultipleContact).
					build());

		} catch (Exception e) {

			captureScreen(driver2, "student contact from contact filter Failed");
			String screenShotMultipleContact = Base_Class.captureScreenExtent(driver2, "student contact from contact filter Failed");
			test.fail("student contact from contact filter Failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotMultipleContact).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+statusLog);
			test.log(Status.FAIL, "Select single contact icon in contact filter in Arkiv Mottatt Test Case Failed!!");
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");
		}

		logger.info(" ==== Select single contact icon in contact filter in Arkiv Mottatt Test Case is completed ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
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
