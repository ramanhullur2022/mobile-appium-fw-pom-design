package com.ude.portalen.Login;

import java.io.IOException;
import java.time.Duration;

import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.ElevApp_Login;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ElevLoginTest extends Base_Class  {

	ReadConfig config = new ReadConfig();
	public String login_pin = config.get_4_digit_login_pin();
	public String student_username = config.get_student_username();
	public String student_password = config.get_student_password();
	public  String teacher_username = config.get_teacher_username();
	public  String teacher_password = config.get_teacher_password();
	public String parent_login_id = config.get_parent_login_id();
	public String parent_login_password = config.get_parent_login_password();
	public String parent_5_digit_login_pin = config.get_parent_5_digit_login_pin();

	/**
	 * Login to Elev App	
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test(enabled=false)
	public void _login() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_Test");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.login(driver2);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}


	/**
	 * Login As Student
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void _loginAsStudent() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");
		launch_Elev_app();
		ElevApp_Login l1=new  ElevApp_Login(driver2);

		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");



		boolean check =l1.loginAsStudentOrTeacher(driver2, student_username, student_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test(enabled=false)
	public void _loginAsTeacher() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacher(driver2, teacher_username, teacher_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher in background  
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	public  void _loginAsTeacher_Background() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacher(driver2, teacher_username, teacher_password);
		if (check==true)
			// driver2.pressKey(new KeyEvent(AndroidKey.HOME));
			//((AndroidDriver) driver2).pressKeyCode(AndroidKeyCode.HOME);
			((AppiumDriver)driver2).runAppInBackground(Duration.ofSeconds(180));
		System.out.println("Login Success app running in background");
		logger.info("App Login completed");

	}

}
