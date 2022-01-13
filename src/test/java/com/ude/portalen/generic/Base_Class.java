package com.ude.portalen.generic;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Attachment;



public class Base_Class {

	ReadConfig readConfig = new ReadConfig();
	public static Logger logger;
	public static WebDriver driver;
	public static WebDriver driver2;
	public static WebDriver driver3;
	public final String apk_filePath = System.getProperty("user.dir") + "\\apk\\iSafe-app-release.apk";
	public static String msg_time_stamp=null;

	public static String geckDriverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	//public static String chromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	//public static String chromeDriverPath = System.getProperty("user.home") + "\\Users\\udecgi\\ude_portlen\\ude_mobile_android\\drivers\\chromedriver";
	public static String iEDriverPath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";

	public String deviceName = readConfig.getDeviceName();
	public String platformVersion = readConfig.getPlatformVersion();
	public static ExtentReports extent;
	public static ExtentTest test;

	public static Process process;
	public static String Start_Server = "C:\\NodeJS\\node.exe  C:\\Users\\ramana.gouda\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\lib\\appium.js";

	public final String test_elev_path = System.getProperty("user.dir") + "/test_build/app-elev-release.apk";
	public final String test_foresatte_path = System.getProperty("user.dir") + "/test_build/app-foresatte-release.apk";

	public final String fat_elev_path = System.getProperty("user.dir") + "/test_build/app-elev-release-143.apk";
	public final String fat_foresatte_path = System.getProperty("user.dir") + "/test_build/app-foresatte-release-143.apk";

	//C:\Users\ramana.gouda\Documents\Appium_1_2\Appium\node.exe
	//C:\Users\ramana.gouda\Documents\Appium_1_2\Appium\node_modules\appium\bin\appium.js

	ReadConfig config = new ReadConfig();
	public String Base_URL = config.base_url();
	public String Browser = config.browser_selection();
	public static boolean start_thread_main=false;

	//private static AppiumDriverLocalService server;


	/*
	 * Starting Appium Server programmatically
	 */

	/**
	 * Starts Appium Server
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void start_Server() throws IOException, InterruptedException {

		// C:\NodeJS\node.exe
		// C:\Program Files (x86)\Appium\node_modules\appium\lib\appium.js
		// public static String Start_Server="C:\\NodeJS\\node.exe
		// C:\\Users\\ramana.gouda\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\appium.js";
		// C:\Users\ramana.gouda\AppData\Local\Programs\Appium\resources\app\node_modules\appium\lib\appium.js

		/* process = Runtime.getRuntime().exec(Start_Server);
		Thread.sleep(20000);
		if (process != null) {
			System.out.println("===Appium Server is Started===");
		} else {
			System.out.println("===Appium Server didn't started===");
		}*/

		/*
		 * builder = new AppiumServiceBuilder(); builder.withIPAddress("127.0.0.1");
		 * builder.usingPort(4723); 
		 * builder.withCapabilities(cap);
		 * builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		 * builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		 * Start the server with the builder service = AppiumDriverLocalService.buildService(builder); service.start();
		 */


		Runtime runtime = Runtime.getRuntime(); 
		try { 
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"true\"\"}\"\""); 
			Thread.sleep(10000); 
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); 
		}


		/*
		 * CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		 * cmd.
		 * addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"
		 * ); cmd.addArgument("--address"); cmd.addArgument("127.0.0.1");
		 * cmd.addArgument("--port"); cmd.addArgument("4723");
		 * 
		 * DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		 * DefaultExecutor executor = new DefaultExecutor(); executor.setExitValue(1);
		 * try { executor.execute(cmd, handler); Thread.sleep(10000); } catch
		 * (IOException | InterruptedException e) { e.printStackTrace(); }
		 */


		/* AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		  serviceBuilder.usingAnyFreePort(); 
		  serviceBuilder.usingDriverExecutable(new File("C:\\NodeJS\\node.exe")); 
		  serviceBuilder.withAppiumJS(new File("C:\\Users\\ramana.gouda\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\appium.js")); 
		  //HashMap<String, String> environment = new HashMap<String, String>();
		  //environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		  //serviceBuilder.withEnvironment(environment);

		  server = AppiumDriverLocalService.buildService(serviceBuilder);
		  server.start();*/


	}

	/**
	 * Stops Appium Server
	 */
	// to Stop  the server 
	public static void Stop_Server() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sppium server stopped ");
	}

	/**
	 * Captures Screenshot
	 * @param driver Webdriver
	 * @param tname Name
	 * @return File name
	 * @throws IOException
	 */
	// capture screenshots
	public static String captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		//System.out.println("Screenshot taken");
		return tname;
	}

	/**
	 * Captures screenshot for Extent Report
	 * @param driver Webdriver
	 * @param screenshotname Screenshot name
	 * @return destination path
	 * @throws IOException
	 */
	// screenshot for extent report
	//	public static String captureScreenExtent(WebDriver driver, String screenshotname) throws IOException {
	//		TakesScreenshot ts = (TakesScreenshot) driver;
	//		File source = ts.getScreenshotAs(OutputType.FILE);
	//		String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotname + ".png";
	//		File destination = new File(dest);
	//		FileUtils.copyFile(source, destination);
	//		return dest;
	//	}

	/**
	 * Captures screenshot for Extent Report
	 * @param driver Webdriver
	 * @param screenshotName Screenshot Name
	 * @return imgfile
	 * @throws Exception
	 */
	public static String captureScreenExtent(WebDriver driver, String screenshotName) throws Exception {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imgPath = "./" +"test-output/screenshots/" + screenshotName + "_"+ System.currentTimeMillis() + ".png";
		File path = new File("./test-output/" + imgPath);
		FileUtils.copyFile(sourceFile, path);
		return imgPath;
	}

	/**
	 * Captures video logs
	 * @param driver Webdriver
	 * @param videoLogname video log name
	 * @return path of video
	 * @throws IOException
	 */
	//video log capture 
	public static String captureVideoLog(WebDriver driver, String videoLogname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest_video = System.getProperty("user.dir") + "/video-log/" + videoLogname + ".mp4";
		File destination = new File(dest_video);
		FileUtils.copyFile(source, destination);
		return dest_video;
	}

	/**
	 * Launch Foresatte App
	 * @return Webdriver 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	// first application launch
	public WebDriver launch_Foresatte_app() throws MalformedURLException, InterruptedException {

		// logger = Logger.getLogger("UDE Portalen");
		// PropertyConfigurator.configure("log4j.properties");
		initiate_Logging();

		// Extent Report
		extent = ExtentManager.GetExtent();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		File appDir = new File(test_foresatte_path);
		//File appDir = new File(fat_foresatte_path);

		// File appDir = new File(apk_filePath);
		// capabilities.setCapability("noRest", true);
		// capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
		// capabilities.setCapability("automationName", "UiAutomator2");
		System.out.println("====== Foresatte App Found in Device/Emulator ======");

		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		//capabilities.setCapability("noRest", true);
		capabilities.setCapability("newCommandTimeout", "60000");
		//capabilities.setCapability("newCommandTimeout", "120000");

		//capabilities.setCapability("appPackage", "com.android.settings");
		//capabilities.setCapability("appActivity", "com.android.settings.Settings");

		capabilities.setCapability("appPackage", "com.cgi.oslomelding.foresatte");
		capabilities.setCapability("appActivity", "com.cgi.oslomelding.MainActivity");


		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("======Foresatte App Launching - Success======");
		Thread.sleep(20000);
		return driver;
	}

	/**
	 * Launch Elev App
	 * @return Webdriver
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	// second application launch
	public WebDriver launch_Elev_app() throws MalformedURLException, InterruptedException {

		// logger = Logger.getLogger("UDE Portalen");
		// PropertyConfigurator.configure("log4j.properties");
		initiate_Logging();

		// Extent Report
		extent = ExtentManager.GetExtent();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		File appDir = new File(test_elev_path);
		//File appDir = new File(fat_elev_path);

		// File appDir = new File(apk_filePath);
		// capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
		System.out.println("====== Elav App Found in Device/Emulator ======");

		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		//capabilities.setCapability("noRest", true);
		capabilities.setCapability("newCommandTimeout", "60000");
		//capabilities.setCapability("newCommandTimeout", "120000");

		//capabilities.setCapability("appPackage", "com.google.android.apps.photos");
		//capabilities.setCapability("appActivity", "com.google.android.apps.photos.home.HomeActivity");

		capabilities.setCapability("appPackage", "com.cgi.oslomelding");
		capabilities.setCapability("appActivity", "com.cgi.oslomelding.MainActivity");

		driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("======Elav App Launching - Success======");
		Thread.sleep(20000);
		return driver2;
	}

	/**
	 * Launch Elev App
	 * @return Webdriver
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public WebDriver launch_Elev_app_noreset() throws MalformedURLException, InterruptedException {

		initiate_Logging();

		// Extent Report
		extent = ExtentManager.GetExtent();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		File appDir = new File(test_elev_path);
		//File appDir = new File(fat_elev_path);

		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
		System.out.println("====== Elav App Found in Device/Emulator ======");

		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("newCommandTimeout", "60000");
		capabilities.setCapability("appPackage", "com.cgi.oslomelding");
		capabilities.setCapability("appActivity", "com.cgi.oslomelding.MainActivity");

		driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("======Elav App Launching - Success======");
		Thread.sleep(20000);
		return driver2;
	}

	/**
	 * Gets webdriver instance
	 * @param driverType Browser driver type
	 * @return webdriver instance
	 */
	// webApp driver
	public WebDriver getDriver(String driverType) {

		switch (driverType) {
		case "Firefox":
			DesiredCapabilities firefox_capabilities = DesiredCapabilities.firefox();
			firefox_capabilities.setCapability("marionette", true);
			System.setProperty("webdriver.gecko.driver", geckDriverPath);
			return driver3 = new FirefoxDriver();

		case "Chrome":
			//System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			return driver3 = new ChromeDriver();

		case "IE":
			DesiredCapabilities IE_capabilities = DesiredCapabilities.internetExplorer();
			IE_capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			System.setProperty("webdriver.ie.driver", iEDriverPath);
			return driver3 = new InternetExplorerDriver();

		case "Safari":
			return driver3 = new SafariDriver();
		}
		return driver3;
	}

	/**
	 * Navigate helper method
	 * @author Varun Chaubey
	 * @param driver Webdriver
	 * @param element WebElement
	 * @param duration Duration
	 * @throws InterruptedException
	 */
	//Auther: Varun
	public static void  Navigate (WebDriver driver , WebElement element,int duration) throws InterruptedException {

		//boolean User_Present=Base_Class.is_Element_Present(driver,element,duration) ;
		WebDriverWait webDriverWait = new WebDriverWait(driver,duration);
		Thread.sleep(7000);
		WebElement PresentElement=webDriverWait.until(ExpectedConditions.visibilityOf(element));

		if(PresentElement.isDisplayed()){
			if(PresentElement.isEnabled()) {
				PresentElement.click();
			}
			else {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", PresentElement);
			}  
		}
	}

	/**
	 * Dataentry method
	 * @author Varun Chaubey
	 * @param driver Webdriver
	 * @param element Webelement
	 * @param testdata TestData
	 * @param duration Duration
	 * @throws InterruptedException
	 */
	//Auther: Varun
	public static void  dataentry (WebDriver driver , WebElement element,String testdata,int duration) throws InterruptedException {

		WebDriverWait webDriverWait = new WebDriverWait(driver,duration);
		WebElement PresentElement=webDriverWait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(7000);
		PresentElement.sendKeys(testdata);
	}


	//	//Auther: Varun
	//	public static void  frame_dataentry (WebDriver driver , WebElement element,String testdata,int duration) throws InterruptedException {
	//
	//       WebDriverWait webDriverWait = new WebDriverWait(driver3,duration);
	//       WebElement PresentElement=webDriverWait.until(ExpectedConditions.visibilityOf(element));
	//       driver3.switchTo().frame(PresentElement);
	//       Thread.sleep(3000);
	//       driver3.findElement(By.id("tinymce")).click();
	//       driver3.findElement(By.id("tinymce")).sendKeys(testdata);
	//       driver3.switchTo().defaultContent();
	//	}

	/**
	 * Returns message time
	 * @return message time
	 */
	public static String Msg_Time() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String value = dateFormat.format(date);
		String FinalValue = value.replaceFirst(" ", "_");
		// System.out.println(FinalValue);
		String actValue = FinalValue.replace(":", "_");
		// System.out.println(actValue);
		String filename = "File";
		String File = filename + "_" + actValue;
		return File;
	}

	/**
	 * Initiates Logging
	 */
	// Log4j logs
	public void initiate_Logging() {
		logger = Logger.getLogger("UDE Portalen");
		PropertyConfigurator.configure("log4j.properties");
	}

	/**
	 * Implicit wait
	 */
	// implicit wait
	public void Implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	 * PageObject pob= new PageObject(driver);
	 * ExplicitwaitBrowser(PageClassObj.Locatorname, 5);
	 */

	/**
	 * Explicit wait
	 * @param ele Webelement
	 * @param T1 time
	 */
	// explict wait
	public void ExplicitwaitBrowser(WebElement ele, long T1) {
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}

	/**
	 * After Method
	 */
	// close resources
	@AfterMethod
	public void tearDown() {
		if ((driver != null) && (driver2 != null) && driver3 != null ) {
			driver.quit();
		} 
	}

	/**
	 * Web app initialization
	 */
	// web app launcher
	public void init_webapp() {
		getDriver(Browser);
		driver3.get(Base_URL);
		driver3.manage().window().maximize();
	}

	// stopping Appium server
	//	public static void Stop_Server() throws InterruptedException {
	//
	//		if (process != null) {
	//			Thread.sleep(4000);
	//			extent.flush();
	//			process.destroy();
	//			System.out.println("======Stopped Appium Server=====");
	//		}
	//	}

	/**
	 * Closes command prompt
	 */
	// Closing the cmd.exe by killing the task 
	public static void close_CmdExe(){
		try {
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}

	/**
	 * Helper method for checking element presence
	 * @param driver Webdriver
	 * @param element Webelement
	 * @param duration Duration
	 * @return True/False based on element presence
	 */
	public static boolean is_Element_Present(WebDriver driver , WebElement element,int duration) {

		WebDriverWait webDriverWait = new WebDriverWait(driver,duration);
		WebElement Present=webDriverWait.until(ExpectedConditions.visibilityOf(element));
		if(Present.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Screenshot helper method
	 * @param driver Webdriver
	 * @return 
	 */
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	/**
	 * Dynamic Test Data Support : Searches For User(Student/Teacher) and adds it into To Field
	 * @author S, Manjunath
	 * @param driver WebDriver
	 * @param userType Student/Teacher
	 * @param env Test/FAT/Prod
	 * @param sendTo Only Eleven/Only Foresatte/Eleven and Foresatte
	 * @throws InterruptedException
	 */
	public void searchForUserAndSelect(WebDriver driver, String userType, String env, String sendTo) throws InterruptedException {

		String schoolPlaceholder = readConfig.get_school_name_dynamic(env);
		String studentPlaceholder = readConfig.get_student_username_dynamic();

		String fatStudentPlaceholder = readConfig.get_fat_student_username_dynamic();              
		String prodStudentPlaceholder = readConfig.get_prod_student_username_dynamic();

		System.out.println("School Name Fetched : "+schoolPlaceholder);
		System.out.println("Student Name Fetched : "+studentPlaceholder);

		if(userType.equals("student")) {

			Thread.sleep(5000);
			if(env.equals("test")) {
				WebElement schoolElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+schoolPlaceholder+"]/android.widget.TextView"));
				schoolElement.click();
			}else if(env.equals("fat")) {
				WebElement schoolElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+schoolPlaceholder+"]/android.widget.TextView"));
				schoolElement.click();
			}else if(env.equals("prod")) {
				WebElement schoolElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+schoolPlaceholder+"]/android.widget.TextView"));
				schoolElement.click(); 
			}else {
				System.out.println("Environment is : "+env+" School Name not displayed!!");
			}

			Thread.sleep(5000);
			WebElement personarElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Personer\"]/android.widget.TextView"));
			personarElement.click();

			if(env.equals("test")) {
				Thread.sleep(5000);
				WebElement personarSearchBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search-input-contact\"]"));
				String studentPlaceholderWOQuotes = studentPlaceholder.replaceAll("^\"|\"$", "");
				System.out.println("StudentPlaceHolder Now : "+studentPlaceholder);
				System.out.println("StudentPlaceHolderWOQuotes Now : "+studentPlaceholderWOQuotes);
				personarSearchBox.sendKeys(studentPlaceholderWOQuotes);
			}else if(env.equals("fat")) {
				Thread.sleep(5000);
				WebElement personarSearchBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search-input-contact\"]"));
				String studentPlaceholderWOQuotes = fatStudentPlaceholder.replaceAll("^\"|\"$", "");
				System.out.println("StudentPlaceHolder Now : "+fatStudentPlaceholder);
				System.out.println("StudentPlaceHolderWOQuotes Now : "+studentPlaceholderWOQuotes);
				personarSearchBox.sendKeys(studentPlaceholderWOQuotes);
			}else if(env.equals("prod")) {
				Thread.sleep(5000);
				WebElement personarSearchBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search-input-contact\"]"));
				String studentPlaceholderWOQuotes = prodStudentPlaceholder.replaceAll("^\"|\"$", "");
				System.out.println("StudentPlaceHolder Now : "+prodStudentPlaceholder);
				System.out.println("StudentPlaceHolderWOQuotes Now : "+studentPlaceholderWOQuotes);
				personarSearchBox.sendKeys(studentPlaceholderWOQuotes);
			}

			if(env.equals("test")) {
				Thread.sleep(10000);
				WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
				studentElement.click();
				studentElement.click();
			}else if(env.equals("fat")) {
				Thread.sleep(10000);
				WebElement fatStudentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+fatStudentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
				fatStudentElement.click();
				fatStudentElement.click();
			}else if(env.equals("prod")) {
				Thread.sleep(10000);
				WebElement prodStudentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+prodStudentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
				prodStudentElement.click();
				prodStudentElement.click();
			}

			Thread.sleep(5000);
			if(sendTo.equals("eleven_only")) {
				WebElement elevenCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven\"]/android.widget.TextView"));
				elevenCheckBox.click();
			} else if(sendTo.equals("foresatte_only")) {
				WebElement foresatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Foresatte\"]/android.widget.TextView"));
				foresatteCheckBox.click();
			} else if(sendTo.equals("eleven_and_foresatte")) {
				WebElement elevenForesatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven + Foresatte\"]/android.widget.TextView"));
				elevenForesatteCheckBox.click();
			}


			Thread.sleep(5000);
			WebElement oKButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addContactText\"]/android.view.ViewGroup/android.widget.TextView"));
			oKButton.click();

			System.out.println(userType+" "+readConfig.get_student_username_dynamic()+" successfully added to Til Field");

		} else if(userType.equals("teacher")){
			if(env.equals("test")) {
				String teacherPlaceholder = readConfig.get_teacher_username_dynamic();
				WebElement teacherElement = driver.findElement(By.xpath("//android.widget.TextView[@text="+teacherPlaceholder+"]"));
				teacherElement.click();

				Thread.sleep(5000);
				WebElement oKButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addContactText\"]/android.view.ViewGroup/android.widget.TextView"));
				oKButton.click();
			}else if(env.equals("fat")) {
				Thread.sleep(5000);
				WebElement schoolElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+schoolPlaceholder+"]/android.widget.TextView"));
				schoolElement.click();

				Thread.sleep(5000);
				WebElement personarElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Personer\"]/android.widget.TextView"));
				personarElement.click();

				Thread.sleep(5000);
				WebElement personarSearchBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search-input-contact\"]"));
				String studentPlaceholderWOQuotes = fatStudentPlaceholder.replaceAll("^\"|\"$", "");
				System.out.println("StudentPlaceHolder Now : "+fatStudentPlaceholder);
				System.out.println("StudentPlaceHolderWOQuotes Now : "+studentPlaceholderWOQuotes);
				personarSearchBox.sendKeys(studentPlaceholderWOQuotes);

				if(env.equals("test")) {
					Thread.sleep(10000);
					WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
					studentElement.click();
					studentElement.click();
				}else if(env.equals("fat")) {
					Thread.sleep(10000);
					WebElement fatStudentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+fatStudentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
					fatStudentElement.click();
					fatStudentElement.click();
				}else if(env.equals("prod")) {
					Thread.sleep(10000);
					WebElement prodStudentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+prodStudentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
					prodStudentElement.click();
					prodStudentElement.click();
				}


				Thread.sleep(5000);
				if(sendTo.equals("eleven_only")) {
					WebElement elevenCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven\"]/android.widget.TextView"));
					elevenCheckBox.click();
				} else if(sendTo.equals("foresatte_only")) {
					WebElement foresatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Foresatte\"]/android.widget.TextView"));
					foresatteCheckBox.click();
				} else if(sendTo.equals("eleven_and_foresatte")) {
					WebElement elevenForesatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven + Foresatte\"]/android.widget.TextView"));
					elevenForesatteCheckBox.click();
				}


			}else if(env.equals("prod")) {
				System.out.println("prod - yet to start");
			}

			System.out.println(userType+" "+readConfig.get_teacher_username_dynamic()+" successfully added to Til Field");
		} else if(userType.equals("teacherOneSchool")) {
			//String teacherPlaceholder = readConfig.get_teacher_username_dynamic();
			String teacherPlaceholder = readConfig.get_teacher_username2();
			WebElement teacherElement = driver.findElement(By.xpath("//android.widget.TextView[@text="+teacherPlaceholder+"]"));
			teacherElement.click();

			Thread.sleep(5000);
			WebElement oKButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addContactText\"]/android.view.ViewGroup/android.widget.TextView"));
			oKButton.click();

			System.out.println(userType+" "+readConfig.get_teacher_username_dynamic()+" successfully added to Til Field");
		} else if(userType.equals("parent")) {
			Thread.sleep(10000);
			//WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
			WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.widget.TextView"));

			studentElement.click();

			System.out.println(userType+" "+readConfig.get_student_username_dynamic()+" selected!!");

		} else if(userType.equals("parent_newui")) {
			Thread.sleep(10000);
			//WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
			WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.widget.TextView"));
			studentElement.click();
			Thread.sleep(5000);
			String teacherPlaceholder = readConfig.get_teacher_name_dynamic_receipiant();
			WebElement teacherNameElement = driver.findElement(By.xpath("//android.widget.TextView[@text="+teacherPlaceholder+"]"));
			teacherNameElement.click();
			System.out.println(userType+" "+readConfig.get_teacher_name_dynamic_receipiant()+" selected!!");

			Thread.sleep(3000);
			WebElement oKButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addContactText\"]/android.view.ViewGroup/android.widget.TextView"));
			oKButton.click();


		} else if(userType.equals("studentOneSchool")) {
			String schoolPlaceholder2 = readConfig.get_school_name_dynamic(env);
			String studentPlaceholder2 = readConfig.get_student_username3();
			//String studentPlaceholder = readConfig.get_student_username_dynamic();
			System.out.println("School Name Fetched : "+schoolPlaceholder2);
			System.out.println("Student Name Fetched : "+studentPlaceholder2);

			Thread.sleep(5000);
			if(env.equals("test")) {
				WebElement schoolElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+schoolPlaceholder+"]/android.widget.TextView"));
				schoolElement.click();
			} else {
				System.out.println("Environment is : "+env+" School Name not displayed!!");
			}

			Thread.sleep(5000);
			WebElement personarElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Personer\"]/android.widget.TextView"));
			personarElement.click();

			Thread.sleep(5000);
			WebElement personarSearchBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search-input-contact\"]"));
			String studentPlaceholderWOQuotes = studentPlaceholder.replaceAll("^\"|\"$", "");
			System.out.println("StudentPlaceHolder Now : "+studentPlaceholder2);
			System.out.println("StudentPlaceHolderWOQuotes Now : "+studentPlaceholderWOQuotes);
			personarSearchBox.sendKeys(studentPlaceholderWOQuotes);

			Thread.sleep(10000);
			WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholder+"]/android.view.ViewGroup/android.widget.TextView[1]"));
			studentElement.click();
			studentElement.click();

			Thread.sleep(5000);
			if(sendTo.equals("eleven_only")) {
				WebElement elevenCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven\"]/android.widget.TextView"));
				elevenCheckBox.click();
			} else if(sendTo.equals("foresatte_only")) {
				WebElement foresatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Foresatte\"]/android.widget.TextView"));
				foresatteCheckBox.click();
			} else if(sendTo.equals("eleven_and_foresatte")) {
				WebElement elevenForesatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven + Foresatte\"]/android.widget.TextView"));
				elevenForesatteCheckBox.click();
			}

			Thread.sleep(5000);
			WebElement oKButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addContactText\"]/android.view.ViewGroup/android.widget.TextView"));
			oKButton.click();
			System.out.println(userType+" "+readConfig.get_student_username_dynamic()+" successfully added to Til Field");

			Thread.sleep(5000);

		} else if (userType.equals("student_two")) {

			String schoolPlaceholderTwo = readConfig.get_school_name_dynamic(env);
			String studentPlaceholderTwo= readConfig.get_student_username3();
			System.out.println("School Name Fetched : "+schoolPlaceholderTwo);
			System.out.println("Student Name Fetched : "+studentPlaceholderTwo);

			Thread.sleep(5000);
			if(env.equals("test")) {
				WebElement schoolElement2 = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+schoolPlaceholderTwo+"]/android.widget.TextView"));
				schoolElement2.click();
			} else {
				System.out.println("Environment is : "+env+" School Name not displayed!!");
			}

			Thread.sleep(5000);
			WebElement personarElement2 = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Personer\"]/android.widget.TextView"));
			personarElement2.click();

			Thread.sleep(5000);
			WebElement personarSearchBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"search-input-contact\"]"));
			String studentPlaceholderWOQuotes = studentPlaceholderTwo.replaceAll("^\"|\"$", "");
			System.out.println("StudentPlaceHolder Now : "+studentPlaceholderTwo);
			System.out.println("StudentPlaceHolderWOQuotes Now : "+studentPlaceholderWOQuotes);
			personarSearchBox.sendKeys(studentPlaceholderWOQuotes);

			Thread.sleep(10000);
			WebElement studentElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc="+studentPlaceholderTwo+"]/android.view.ViewGroup/android.widget.TextView[1]"));
			studentElement.click();
			studentElement.click();

			Thread.sleep(5000);
			if(sendTo.equals("eleven_only")) {
				WebElement elevenCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven\"]/android.widget.TextView"));
				elevenCheckBox.click();
			} else if(sendTo.equals("foresatte_only")) {
				WebElement foresatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Foresatte\"]/android.widget.TextView"));
				foresatteCheckBox.click();
			} else if(sendTo.equals("eleven_and_foresatte")) {
				WebElement elevenForesatteCheckBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Eleven + Foresatte\"]/android.widget.TextView"));
				elevenForesatteCheckBox.click();
			}


			Thread.sleep(5000);
			WebElement oKButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"addContactText\"]/android.view.ViewGroup/android.widget.TextView"));
			oKButton.click();

			System.out.println(userType+" "+readConfig.get_student_username_dynamic()+" successfully added to Til Field");


		}
		Thread.sleep(5000);
	}

	/**
	 * Verifies Profile Name in Settings screen
	 * @param driver 
	 * @param profileType Student/Teacher/Parent
	 * @param env Test/FAT/PROD
	 * @return verification results
	 * @author S, Manjunath
	 * @throws InterruptedException 
	 */
	public boolean verifyProfile(WebDriver driver, String profileType, String env) throws InterruptedException {
		System.out.println("Passed profileType : "+profileType+" and Environment : "+env);
		boolean result = false;
		WebElement settingsBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Innstillinger']"));
		settingsBtn.click();
		Thread.sleep(5000);
		WebElement profileEmailActualText = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]"));
		switch (profileType) {
		case "student":
			String profileNameStudent = readConfig.getProfileName("student");	
			System.out.println("Profile Text from Config : "+profileNameStudent);
			String studentProfileValue = profileEmailActualText.getText();
			System.out.println("Profile Text from Settings : "+studentProfileValue);
			if(profileNameStudent.equals(studentProfileValue)) {
				result = true;
			} else {
				result =  false;
			}
			break;
		case "teacher":
			String profileNameTeacher = readConfig.getProfileName("teacher");
			System.out.println("Profile Text from Config : "+profileNameTeacher);
			String teacherProfileValue = profileEmailActualText.getText();
			System.out.println("Profile Text from Settings : "+teacherProfileValue);
			if(profileNameTeacher.equals(teacherProfileValue)) {
				result = true;
			} else {
				result =  false;
			}
			break;
		case "parent":
			String profileNameParent = readConfig.getProfileName("parent");
			System.out.println("Profile Text from Config : "+profileNameParent);
			String ParentProfileValue = profileEmailActualText.getText();
			System.out.println("Profile Text from Settings : "+ParentProfileValue);
			if(profileNameParent.equals(ParentProfileValue)) {
				result = true;
			} else {
				result =  false;
			}
			break;	
		default:
			break;
		}
		return result;
	}

}
