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
import com.ude.portalen.pageobject.Page_UDEMA_Login;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.utilities.XLUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;

public class TC_UDEMA_Login extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();
	ReadConfig config = new ReadConfig();

	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC001
	 * Test Summary  : Check for Help page display in Login screen
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_check_help_page() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC001";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC001", "Se etter hjelpesidevisning på påloggingsskjermbildet");
			//logger.info("UDEMA_Login_TC001 : Check for Help page display in Login screen");

			//Student App Login
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");

			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);

			statusLog = "Klikk på Hjelp-ikonet";
			page.clickOnHelp();
			logger.info("Clicked on Help icon");
			test.log(Status.PASS, "Klikk på Hjelp-ikonet");

			statusLog = "Bekreft visning av hjelpesiden";
			boolean result = page.verifyPageDisplay("help");
			if(result) {
				logger.info("Help page displayed successfully");
				test.log(Status.PASS, "Hjelpesiden vises vellykket");
				captureScreen(driver2, "Hjelpesiden vises");
				String helpPagePass = Base_Class.captureScreenExtent(driver2, "Hjelpesiden vises");
				test.pass("Hjelpesiden vises",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPagePass).
						build());
				logger.info("Check for Help page display in Logg inn screen test case Passed");
				test.log(Status.PASS, "Se etter hjelpesidevisning i Logg inn-skjermens testsak bestått");
			} else {
				logger.info("Help page not displayed");
				test.log(Status.FAIL, "Hjelpesiden vises ikke");
				test.log(Status.FAIL, "Kontroller om hjelpesidevisningen er vist i Logg inn-skjermens testsak Mislyktes");
				captureScreen(driver2, "Hjelpesiden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Hjelpesiden vises ikke");
				test.pass("Hjelpesiden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}

		} catch (Exception e) {

			captureScreen(driver2, "Help page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Help page display failed");
			test.fail("Help page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Kontroller om hjelpesidevisningen er vist i Logg inn-skjermens testsak Mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}
	}


	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC002
	 * Test Summary  : Check accessing "Do you need help?" page and check for the support webpage display
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_check_support_page() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC002";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC002", " Sjekk tilgang \"Trenger du hjelp?\" og sjekk om støttesiden vises");
			//logger.info("UDEMA_Login_TC002 : Check accessing \"Do you need help?\" page and check for the support webpage display");

			//Student App Login
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");

			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);

			statusLog = "Ved å klikke på trenger du hjelpealternativ";
			page.clickOnDoYouNeedHelp();
			logger.info("Clicked on Do You Need Help option");
			test.log(Status.PASS, "Klikk på alternativet Trenger du hjelp");

			statusLog = "Bekreft visning av støttesiden";
			boolean result = page.verifyPageDisplay("support");
			if(result) {
				logger.info("Support page displayed successfully");
				test.log(Status.PASS, "Støttesiden vises");
				captureScreen(driver2, "Støttesiden vises");
				String helpPagePass = Base_Class.captureScreenExtent(driver2, "Støttesiden vises");
				test.pass("Støttesiden vises",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPagePass).
						build());
				logger.info("Check accessing \"Do you need help?\" page and check for the support webpage display test case passed");
				test.log(Status.PASS, "Sjekk tilgang \"Trenger du hjelp?\" og sjekk om støttesiden for testvisning er bestått");
			} else {
				logger.info("Support page not displayed");
				test.log(Status.FAIL, "Støttesiden vises ikke");
				test.log(Status.FAIL, "Kontroller at du får tilgang til \\ \"Trenger du hjelp? \\\" -Siden, og sjekk om støttesiden for testvisningssiden mislyktes");
				captureScreen(driver2, "Støttesiden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Støttesiden vises ikke");
				test.pass("Støttesiden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}

		} catch (Exception e) {

			captureScreen(driver2, "Support page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Support page display failed");
			test.fail("Support page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Kontroller at du får tilgang til \\ \"Trenger du hjelp? \\\" -Siden, og sjekk om støttesiden for testvisningssiden mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Check accessing \"Do you need help?\" page and check for the support webpage display test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}

	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC003
	 * Test Summary  : Check accessing "Forgot your username and password" option and check for the lost account screen display
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_check_lost_account_page() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC003";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC003", "Merk av for å få tilgang til alternativet \"Glemt brukernavn og passord\", og se etter skjermbildet for den tapte kontoen");
			//logger.info("UDEMA_Login_TC002 : Check accessing \"Do you need help?\" page and check for the support webpage display");

			//Student App Login
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");

			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);

			statusLog = "Klikk på alternativet Glemt brukernavn og passord";
			page.clickOnForgotPasswordOption();
			logger.info("Clicked on Forgot Username and password option");
			test.log(Status.PASS, "Klikk på alternativet Glemt brukernavn og passord");

			statusLog = "Bekreft visning av mistet kontoside";
			boolean result = page.verifyPageDisplay("lost account");
			if(result) {
				logger.info("Lost Account page displayed successfully");
				test.log(Status.PASS, "Siden for tapt konto vises");
				captureScreen(driver2, "Siden for tapt konto vises");
				String helpPagePass = Base_Class.captureScreenExtent(driver2, "Siden for tapt konto vises");
				test.pass("Støttesiden vises",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPagePass).
						build());
				logger.info("Check accessing \"Forgot your username and password\" option and check for the lost account screen display test case passed");
				test.log(Status.PASS, "Merk av for å få tilgang til alternativet \"Glemt ditt brukernavn og passord\", og sjekk om testfallet for den tapte kontoskjermen er bestått");
			} else {
				logger.info("Lost Account page not displayed");
				test.log(Status.FAIL, "Siden for tapt konto vises ikke");
				test.log(Status.FAIL, "Kontroller at du får tilgang til \\ \"Trenger du hjelp? \\\" -Siden, og sjekk om støttesiden for testvisningssiden mislyktes");
				captureScreen(driver2, "Siden for tapt konto vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Siden for tapt konto vises ikke");
				test.pass("Siden for tapt konto vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}

		} catch (Exception e) {

			captureScreen(driver2, "Lost Account page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Lost Account page display failed");
			test.fail("Lost Account page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Kontroller at du får tilgang til \\ \"Trenger du hjelp? \\\" -Siden, og sjekk om støttesiden for testvisningssiden mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Check accessing \"Forgot your username and password\" option and check for the lost account screen display test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}

	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC004
	 * Test Summary  : Check accessing "Privacy and cookie information" link and check for 'Personverg og informasjonssikkerhet' page is displayed
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_check_privacy_cookie_page() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC004";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC004", "Sjekk tilgangen til \"Personvern og informasjon om informasjonskapsler\" og se etter \"Personverg og informasjonssikkerhet\" -siden");
			//logger.info("UDEMA_Login_TC002 : Check accessing \"Do you need help?\" page and check for the support webpage display");

			//Student App Login
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");

			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);

			statusLog = "Klikk på koblingen Personvern og informasjonskapsel";
			page.clickOnPrivacyAndCookieInfo();
			logger.info("Clicked on Privacy and Cookie Information Link");
			test.log(Status.PASS, "Klikk på koblingen Personvern og informasjonskapsel");

			statusLog = "Verifiserer visning av siden Personvern og informasjonssikkerhet";
			boolean result = page.verifyPageDisplay("privacy and cookie");
			if(result) {
				logger.info("Personvern page displayed successfully");
				test.log(Status.PASS, "Personvern-siden ble vist");
				captureScreen(driver2, "Personvern-siden ble vist");
				String helpPagePass = Base_Class.captureScreenExtent(driver2, "Personvern-siden ble vist");
				test.pass("Støttesiden vises",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPagePass).
						build());
				logger.info("Check accessing \"Privacy and cookie information\" link and check for 'Personverg og informasjonssikkerhet' page is displayed test case passed");
				test.log(Status.PASS, "Sjekk tilgang til \"Personvern og informasjon om informasjonskapsler \" og sjekk for siden 'Personverg og informasjonssikkerhet' vises testsak bestått");
			} else {
				logger.info("Personvern page not displayed");
				test.log(Status.FAIL, "Personvern-siden ble vist ikke");
				test.log(Status.FAIL, "Den tsjekkiske tilgangen til \"Personvern og informasjon om informasjon \" og se etter \"Personverg og informasjonssikkerhet \" -siden testsak mislyktes");
				captureScreen(driver2, "Siden for tapt konto vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Personvern-siden ble vist ikke");
				test.pass("Siden for tapt konto vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}

		} catch (Exception e) {

			captureScreen(driver2, "Lost Account page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Lost Account page display failed");
			test.fail("Lost Account page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Den tsjekkiske tilgangen til \"Personvern og informasjon om informasjon \" og se etter \"Personverg og informasjonssikkerhet \" -siden testsak mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Check accessing \"Privacy and cookie information\" link and check for 'Personverg og informasjonssikkerhet' page is displayed test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}	

	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC005
	 * Test Summary  : Check Log in screen displayed when 'Glemt pin-code?' is accessed
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_glemt_pin_code() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC005";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC005", "Kontroller påloggingsskjermen som vises når 'Glemt pin-code?' er tilgjengelig");
			
			//Student App Login
			statusLog = "Logger på som Student";
			test.log(Status.PASS, "Starter pålogging av "+config.get_student_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logget på vellykket i elev-appen");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");
			
			((AppiumDriver)driver2).terminateApp("com.cgi.oslomelding");
			
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app_noreset();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");
			
			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);

			statusLog = "Klikk på Glemt pin-kode";
			page.clickOnGlemtPinCode();
			logger.info("Clicked on Glemt Pin-Code Option");
			test.log(Status.PASS, "Klikk på Glemt Pin-Code Option");

			statusLog = "Verifiser Logg inn sidevisning";
			boolean result = page.verifyPageDisplay("glemt pin-code");
			if(result) {
				logger.info("Logg inn page displayed successfully");
				test.log(Status.PASS, "Innloggingssiden ble vist");
				captureScreen(driver2, "Innloggingssiden ble vist");
				String LogginnPagePass = Base_Class.captureScreenExtent(driver2, "Innloggingssiden ble vist");
				test.pass("Innloggingssiden ble vist",
						MediaEntityBuilder.
						createScreenCaptureFromPath(LogginnPagePass).
						build());
				logger.info("Check Log in screen displayed when 'Glemt pin-code?' is accessed test case passed");
				test.log(Status.PASS, "Kontroller påloggingsskjermen som vises når 'Glemt pin-code?' får tilgang til prøvesak bestått");
			} else {
				logger.info("Logg inn page not displayed");
				test.log(Status.FAIL, "Logg inn-siden vises ikke");
				test.log(Status.FAIL, "Kontroller påloggingsskjermen som vises når 'Glemt pin-code?' testesaken mislyktes");
				captureScreen(driver2, "Logg inn-siden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Logg inn-siden vises ikke");
				test.pass("Logg inn-siden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}

		} catch (Exception e) {

			captureScreen(driver2, "Logg inn page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Logg inn page display failed");
			test.fail("Logg inn page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Kontroller påloggingsskjermen som vises når 'Glemt pin-code?' testesaken mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Check Log in screen displayed when 'Glemt pin-code?' is accessed test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC006
	 * Test Summary  : Enable "Bruk Biometric" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App
	 * Test Author   : S, Manjunath
	 * NOTE : REQUIRE REAL DEVICE
	 */
	@Test(enabled = false)
	public void login_enable_bruk_biometric_elev() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC006";

		try {
			
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC006", "Aktiver alternativet \"Bruk Biometrisk\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over i Elev-appen");
			
			//Student App Login
			statusLog = "Logger på som Student";
			test.log(Status.PASS, "Starter pålogging av "+config.get_student_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudentInRealDevice();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logget på vellykket i elev-appen");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");
			
			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);
			
			statusLog = "Aktivering av alternativet Bruk Biometri";
			page.setBiometricOption("enable");
			logger.info("Successfully Enabled Bruk Biometri option");
			test.log(Status.PASS, "Bruk Biometri-alternativet er vellykket");
			
			((AppiumDriver)driver2).terminateApp("com.cgi.oslomelding");
			
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app_noreset();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");
			
			statusLog = "Hopp over biometrisk autentisering";
			page.skipBiometricAuthentication();
			logger.info("Successfully Skipped Biometric Authentication Screen");
			test.log(Status.PASS, "Biometrisk autentiseringsskjerm har blitt hoppet over");

			statusLog = "Verifiser Logg inn sidevisning";
			boolean result = page.verifyPageDisplay("logg inn PIN");
			if(result) {
				logger.info("Logg inn page displayed successfully");
				test.log(Status.PASS, "Innloggingssiden ble vist");
				captureScreen(driver2, "Innloggingssiden ble vist");
				String LogginnPagePass = Base_Class.captureScreenExtent(driver2, "Innloggingssiden ble vist");
				test.pass("Innloggingssiden ble vist",
						MediaEntityBuilder.
						createScreenCaptureFromPath(LogginnPagePass).
						build());
				logger.info("Enable \"Bruk Biometric\" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App test case passed");
				test.log(Status.PASS, "Aktiver alternativet \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak bestått");
			} else {
				logger.info("Logg inn page not displayed");
				test.log(Status.FAIL, "Logg inn-siden vises ikke");
				test.log(Status.FAIL, "Aktiver alternativt \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak mislyktes");
				captureScreen(driver2, "Logg inn-siden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Logg inn-siden vises ikke");
				test.pass("Logg inn-siden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}	

		} catch (Exception e) {

			captureScreen(driver2, "Logg inn page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Logg inn page display failed");
			test.fail("Logg inn page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Aktiver alternativt \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Enable \"Bruk Biometric\" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC007
	 * Test Summary  : Disable "Bruk Biometric" option under settings and Confirm that biometric setup is NOT displayed in PIN screen in Elev App
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_disable_bruk_biometric_elev() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC007";

		try {
			
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC007", "Deaktiver alternativet \"Bruk Biometrisk\" under innstillinger og bekreft at biometrisk oppsett IKKE vises i PIN-skjermen i Elev-appen");
			
			//Student App Login
			statusLog = "Logger på som Student";
			test.log(Status.PASS, "Starter pålogging av "+config.get_student_username());
			ElevLoginTest elav_login = new ElevLoginTest();
			//elav_login._loginAsStudentInRealDevice();
			
			//elav_login._loginAsStudent();
			elav_login.loginAsGeneric("student", "test");
			test.log(Status.PASS, config.get_student_username()+" logget på vellykket i elev-appen");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");
			
			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);
			
			statusLog = "Deaktivering av alternativet Bruk Biometri";
			page.setBiometricOption("disable");
			logger.info("Successfully Disabled Bruk Biometri option");
			test.log(Status.PASS, "Vellykket deaktivert Bruk Biometri alternativ");
			
			((AppiumDriver)driver2).terminateApp("com.cgi.oslomelding");
			
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app_noreset();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");

			statusLog = "Verifiser Logg inn sidevisning";
			boolean result = page.verifyPageDisplay("logg inn PIN");
			if(result) {
				logger.info("Logg inn page displayed successfully");
				test.log(Status.PASS, "Innloggingssiden ble vist");
				captureScreen(driver2, "Innloggingssiden ble vist");
				String LogginnPagePass = Base_Class.captureScreenExtent(driver2, "Innloggingssiden ble vist");
				test.pass("Innloggingssiden ble vist",
						MediaEntityBuilder.
						createScreenCaptureFromPath(LogginnPagePass).
						build());
				logger.info("Disable \"Bruk Biometric\" option under settings and Confirm that biometric setup is NOT displayed in PIN screen in Elev App test case passed");
				test.log(Status.PASS, "Deaktiver alternativet \"Bruk Biometrisk\" under innstillinger, og bekreft at biometrisk oppsett IKKE vises i PIN-skjermen i Elev App-testsak bestått");
			} else {
				logger.info("Logg inn page not displayed");
				test.log(Status.FAIL, "Logg inn-siden vises ikke");
				test.log(Status.FAIL, "Deaktiver alternativet \"Bruk Biometrisk\" under innstillinger og bekreft at biometrisk oppsett IKKE vises i PIN-skjermen i Elev App-testtilfelle mislyktes");
				captureScreen(driver2, "Logg inn-siden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Logg inn-siden vises ikke");
				test.pass("Logg inn-siden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}	

		} catch (Exception e) {

			captureScreen(driver2, "Logg inn page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Logg inn page display failed");
			test.fail("Logg inn page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Deaktiver alternativet \"Bruk Biometrisk\" under innstillinger og bekreft at biometrisk oppsett IKKE vises i PIN-skjermen i Elev App-testtilfelle mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Disable \"Bruk Biometric\" option under settings and Confirm that biometric setup is NOT displayed in PIN screen in Elev App test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC008
	 * Test Summary  : Click on Logg inn when network is not available and check for error display
	 * Test Author   : S, Manjunath
	 */
	@Test
	public void login_no_network_error() throws InterruptedException, Exception {
		String statusLog = "TC_UDEMA_Login_TC008";

		try {

			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC008", "Klikk på Logg inn når nettverket ikke er tilgjengelig, og sjekk for feilvisning");
	
			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);
			
			//Student App Login
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");
			
			statusLog = "mens du setter WiFi til AV";
			page.setConnectivity("OFF");
			logger.info("WiFi connectivity set to OFF");
			test.log(Status.PASS, "WiFi-tilkobling satt til AV");
			
			driver2.quit();
			
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			//Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app_noreset();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");
			
			Page_UDEMA_Login page2 = new Page_UDEMA_Login(driver2);
			
			statusLog = "Klikk på Logg Inn-knappen";
			page2.clickOnLoggInn();
			logger.info("Clicked on Logg Inn button");
			test.log(Status.PASS, "Klikk på Logg Inn-knappen");

			statusLog = "Verifiser Logg inn sidevisning";
			boolean result = page2.verifyPageDisplay("logg inn");
			if(result) {
				logger.info("Logg inn page displayed successfully");
				test.log(Status.PASS, "Innloggingssiden ble vist");
				captureScreen(driver2, "Innloggingssiden ble vist");
				String LogginnPagePass = Base_Class.captureScreenExtent(driver2, "Innloggingssiden ble vist");
				test.pass("Innloggingssiden ble vist",
						MediaEntityBuilder.
						createScreenCaptureFromPath(LogginnPagePass).
						build());
				logger.info("Click on Logg inn when network is not available and check for error display test case passed");
				test.log(Status.PASS, "Klikk på Logg inn på nettet når det ikke er tilgjengelig, og sjekk for feilvisning av prøvesak");
			} else {
				logger.info("Logg inn page not displayed");
				test.log(Status.FAIL, "Logg inn-siden vises ikke");
				test.log(Status.FAIL, "Klikk på Logg inn på nettet når det ikke er tilgjengelig, og sjekk for feilvisning av test saken mislyktes");
				captureScreen(driver2, "Logg inn-siden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Logg inn-siden vises ikke");
				test.pass("Logg inn-siden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}
			
			statusLog = "Stiller WiFi til PÅ";
			page2.setConnectivity("ON");
			logger.info("WiFi connectivity set to ON");
			test.log(Status.PASS, "WiFi-tilkobling satt til ON");

		} catch (Exception e) {

			captureScreen(driver2, "Logg inn page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Logg inn page display failed");
			test.fail("Logg inn page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Klikk på Logg inn på nettet når det ikke er tilgjengelig, og sjekk for feilvisning av test saken mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Click on Logg inn when network is not available and check for error display test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC009
	 * Test Summary  : Enable "Bruk Biometric" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Foresatte App
	 * Test Author   : S, Manjunath
	 * NOTE : REQUIRE REAL DEVICE
	 */
	@Test(enabled = false)
	public void login_enable_bruk_biometric_foresatte() throws InterruptedException, Exception {
		//TODO
		String statusLog = "TC_UDEMA_Login_TC009";

		try {
			
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC009", "Aktiver alternativet \"Bruk Biometrisk\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over i Foresatte-appen");
			
			//Student App Login
			statusLog = "Logger på som Parent";
			test.log(Status.PASS, "Starter pålogging av "+config.get_student_username());
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParentInRealDevice();
			foresatte_login.loginAsParentGeneric("test");
			test.log(Status.PASS, config.get_parent_login_id()+" logget på vellykket i elev-appen");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");
			
			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);
			
			statusLog = "Aktivering av alternativet Bruk Biometri";
			page.setBiometricOption("enable");
			logger.info("Successfully Enabled Bruk Biometri option");
			test.log(Status.PASS, "Bruk Biometri-alternativet er vellykket");
			
			((AppiumDriver)driver2).terminateApp("com.cgi.oslomelding.foresatte");
			
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app_noreset();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");
			
			statusLog = "Hopp over biometrisk autentisering";
			page.skipBiometricAuthentication();
			logger.info("Successfully Skipped Biometric Authentication Screen");
			test.log(Status.PASS, "Biometrisk autentiseringsskjerm har blitt hoppet over");

			statusLog = "Verifiser Logg inn sidevisning";
			boolean result = page.verifyPageDisplay("logg inn PIN");
			if(result) {
				logger.info("Logg inn page displayed successfully");
				test.log(Status.PASS, "Innloggingssiden ble vist");
				captureScreen(driver2, "Innloggingssiden ble vist");
				String LogginnPagePass = Base_Class.captureScreenExtent(driver2, "Innloggingssiden ble vist");
				test.pass("Innloggingssiden ble vist",
						MediaEntityBuilder.
						createScreenCaptureFromPath(LogginnPagePass).
						build());
				logger.info("Enable \"Bruk Biometric\" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App test case passed");
				test.log(Status.PASS, "Aktiver alternativet \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak bestått");
			} else {
				logger.info("Logg inn page not displayed");
				test.log(Status.FAIL, "Logg inn-siden vises ikke");
				test.log(Status.FAIL, "Aktiver alternativt \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak mislyktes");
				captureScreen(driver2, "Logg inn-siden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Logg inn-siden vises ikke");
				test.pass("Logg inn-siden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}	

		} catch (Exception e) {

			captureScreen(driver2, "Logg inn page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Logg inn page display failed");
			test.fail("Logg inn page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Aktiver alternativt \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Enable \"Bruk Biometric\" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App test case Completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		driver2.quit();
	}
	
	/*
	 * Test Suite ID : UDEMA_Login 
	 * Test Case ID  : UDEMA_Login_TC010
	 * Test Summary  : Disable "Bruk Biometric" option under settings and Confirm that biometric setup is NOT displayed in PIN screen and can be skipped in Foresatte App
	 * Test Author   : S, Manjunath
	 * NOTE : REQUIRE REAL DEVICE
	 */
	@Test(enabled = false)
	public void login_disable_bruk_biometric_foresatte() throws InterruptedException, Exception {
		//TODO
		String statusLog = "TC_UDEMA_Login_TC009";

		try {
			
			//start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_Login_TC009", "Aktiver alternativet \"Bruk Biometrisk\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over i Foresatte-appen");
			
			//Student App Login
			statusLog = "Logger på som Parent";
			test.log(Status.PASS, "Starter pålogging av "+config.get_student_username());
			ForesatteLoginTest foresatte_login = new ForesatteLoginTest();
			//foresatte_login._loginAsParentInRealDevice();
			foresatte_login.loginAsParentGeneric("test");
			test.log(Status.PASS, config.get_parent_login_id()+" logget på vellykket i elev-appen");

			captureScreen(driver2, "Elev App Launch");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Elev App Launch");
			
			Page_UDEMA_Login page = new Page_UDEMA_Login(driver2);
			
			statusLog = "Aktivering av alternativet Bruk Biometri";
			page.setBiometricOption("enable");
			logger.info("Successfully Enabled Bruk Biometri option");
			test.log(Status.PASS, "Bruk Biometri-alternativet er vellykket");
			
			((AppiumDriver)driver2).terminateApp("com.cgi.oslomelding.foresatte");
			
			statusLog = "Lansering av Elev-app";
			test.log(Status.PASS, "Lansering av Elev-app");
			Base_Class baseClass = new Base_Class();
			baseClass.launch_Elev_app_noreset();
			logger.info("Elev App Launched Successfully");
			test.log(Status.PASS, "Elev-appen ble lansert vellykket");
			
			statusLog = "Hopp over biometrisk autentisering";
			page.skipBiometricAuthentication();
			logger.info("Successfully Skipped Biometric Authentication Screen");
			test.log(Status.PASS, "Biometrisk autentiseringsskjerm har blitt hoppet over");

			statusLog = "Verifiser Logg inn sidevisning";
			boolean result = page.verifyPageDisplay("logg inn PIN");
			if(result) {
				logger.info("Logg inn page displayed successfully");
				test.log(Status.PASS, "Innloggingssiden ble vist");
				captureScreen(driver2, "Innloggingssiden ble vist");
				String LogginnPagePass = Base_Class.captureScreenExtent(driver2, "Innloggingssiden ble vist");
				test.pass("Innloggingssiden ble vist",
						MediaEntityBuilder.
						createScreenCaptureFromPath(LogginnPagePass).
						build());
				logger.info("Enable \"Bruk Biometric\" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App test case passed");
				test.log(Status.PASS, "Aktiver alternativet \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak bestått");
			} else {
				logger.info("Logg inn page not displayed");
				test.log(Status.FAIL, "Logg inn-siden vises ikke");
				test.log(Status.FAIL, "Aktiver alternativt \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak mislyktes");
				captureScreen(driver2, "Logg inn-siden vises ikke");
				String helpPageFail = Base_Class.captureScreenExtent(driver2, "Logg inn-siden vises ikke");
				test.pass("Logg inn-siden vises ikke",
						MediaEntityBuilder.
						createScreenCaptureFromPath(helpPageFail).
						build());
			}	

		} catch (Exception e) {

			captureScreen(driver2, "Logg inn page display failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "Logg inn page display failed");
			test.fail("Logg inn page display failed",
					MediaEntityBuilder.
					createScreenCaptureFromPath(screenShotPath).
					build());
			logger.error("Test Case Failed");
			logger.error(e.getMessage());
			test.log(Status.FAIL, "Aktiver alternativt \\ \"Bruk Biometrisk \\\" under innstillinger og Sjekk om biometrisk oppsett vises i PIN-skjermen og kan hoppes over Elev-appens testsak mislyktes");
			test.log(Status.FAIL, "Test saken mislyktes mens "+statusLog);
			logger.error("Test Case Failed while "+statusLog+ " with "+e.getClass().getSimpleName()+".");

		}

		logger.info(" ==== Enable \"Bruk Biometric\" option under settings and Check whether biometric setup is displayed in PIN screen and can be skipped in Elev App test case Completed!! ===");
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
