package com.ude.portalen.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.ElevApp_Login;
import com.ude.portalen.utilities.ReadConfig;

public class ElevLoginTest extends Base_Class {

	ReadConfig config = new ReadConfig();
	public String login_pin = config.get_4_digit_login_pin();
	public String student_username = config.get_student_username();
	public String student_password = config.get_student_password();
	public String teacher_username = config.get_teacher_username();
	public String teacher_password = config.get_teacher_password();
	public String parent_login_id = config.get_parent_login_id();
	public String parent_login_password = config.get_parent_login_password();
	public String parent_5_digit_login_pin = config.get_parent_5_digit_login_pin();

	public String teacher_username2 = config.get_teacher_username2();
	public String student_password_withOneSchool = config.get_student_password_one_School();
	public String student_username_withOneSchool = config.get_student_username_one_School();
	public String teacher_password2 = config.get_teacher_password2();

	public String teacher_username3 = config.get_teacher_username3();
	public String teacher_password3 = config.get_teacher_password3();

	public String fat_student_username = config.get_fat_student_username();
	public String fat_student_password = config.get_fat_student_password();
	public String fat_teacher_username = config.get_fat_teacher_username();
	public String fat_teacher_password = config.get_fat_teacher_password();
	public String student_username3 = config.get_student_username3();
	public String student_password3 = config.get_student_password3();

	public String teacher_username_two = config.get_teacher_username3();
	public String teacher_password_two = config.get_teacher_password3();

	//DYNAMIC SUPPORT
	public String student_username_dynamic = config.get_student_username_dynamic();
	public String student_password_dynamic = config.get_student_password_dynamic();
	public String teacher_username_dynamic = config.get_teacher_username_dynamic();
	public String teacher_password_dynamic = config.get_teacher_password_dynamic();

	
	public String student_fat_username_dynamic = config.get_fat_student_username_dynamic();
	public String student_fat_password_dynamic = config.get_fat_student_password_dynamic();
	
	public String student_prod_username_dynamic = config.get_prod_student_username_dynamic();
	public String student_prod_password_dynamic = config.get_prod_student_password_dynamic();
	

	/**
	 * Login to Elev App
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
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
	 * Login As Student in Elev App
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void _loginAsStudent() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacher(driver2, student_username, student_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Student in Elev App in FAT Environment
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void _loginAsStudentInFAT() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacherInFAT(driver2, fat_student_username, fat_student_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher in Elev App
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
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
		Thread.sleep(5000);
	}

	/**
	 * Login As Teacher in Elev App in FAT 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void _loginAsTeacherInFAT() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacherInFAT(driver2, teacher_username, teacher_password);
		//boolean check =l1.loginAsStudentOrTeacherInFAT(driver2, fat_teacher_username, fat_teacher_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");
		Thread.sleep(5000);
	}


	/**
	 * Login As Student with One School
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void _loginAsStudentWithOneSchool() throws IOException, InterruptedException {

		// start_Server();
		// extent = ExtentManager.GetExtent();
		// test = extent.createTest("Login_As_Student");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		// test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1 = new ElevApp_Login(driver2);
		boolean check = l1.loginAsStudentOrTeacher(driver2, student_username_withOneSchool, student_password_withOneSchool);
		if (check == true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher 2
	 * @throws IOException
	 * @throws InterruptedException
	 */
	// @Test
	public void _loginAsTeacher2() throws IOException, InterruptedException {

		// start_Server();
		// extent = ExtentManager.GetExtent();
		// test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		// test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1 = new ElevApp_Login(driver2);

		boolean check = l1.loginAsStudentOrTeacher(driver2, teacher_username2, teacher_password2);
		if (check == true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher 3
	 * @throws IOException
	 * @throws InterruptedException
	 */
	// @Test
	public void _loginAsTeacher3() throws IOException, InterruptedException {

		// start_Server();
		// extent = ExtentManager.GetExtent();
		// test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		// test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1 = new ElevApp_Login(driver2);

		boolean check = l1.loginAsStudentOrTeacher(driver2, teacher_username3, teacher_password3);
		if (check == true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Student With Existing Driver Session
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	//Author : S, Manjunath
	public void _loginAsStudentWithExistingSession() throws InterruptedException {

		ElevApp_Login l1=new  ElevApp_Login(driver2);
		boolean check =l1.loginAsStudentOrTeacher(driver2, student_username, student_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");
		Thread.sleep(5000);

	}

	/**
	 * Login As Student With Existing Driver Session in FAT
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	//Author : S, Manjunath
	public void _loginAsStudentWithExistingSessionInFAT() throws InterruptedException {

		ElevApp_Login l1=new  ElevApp_Login(driver2);
		boolean check =l1.loginAsStudentOrTeacherInFAT(driver2, fat_student_username, fat_student_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");
		Thread.sleep(5000);

	}

	/**
	 * Login As Teacher With Existing Driver Session
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	//Author : S, Manjunath

	public void _loginAsTeacherWithExistingSession() throws InterruptedException {
		ElevApp_Login l1=new  ElevApp_Login(driver2);
		boolean check =l1.loginAsStudentOrTeacher(driver2, teacher_username, teacher_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed"); 
		Thread.sleep(5000);

	}

	/**
	 * Login As Teacher With Existing Driver Session in FAT
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	//Author : S, Manjunath

	public void _loginAsTeacherWithExistingSessionInFAT() throws InterruptedException {
		ElevApp_Login l1=new  ElevApp_Login(driver2);
		boolean check =l1.loginAsStudentOrTeacherInFAT(driver2, fat_teacher_username, fat_teacher_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed"); 
		Thread.sleep(5000);

	}

	/**
	 * Login As Student in Elev App
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void loginAsStudentForMultipleContacts() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacher(driver2, student_username3, student_password3);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher in Elev App for PIN kode reset
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void loginAsTeacherOrStudentForPinReset() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacherforPinReset(driver2, teacher_username, teacher_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");
		Thread.sleep(5000);
	}

	/**
	 * Login As Student in Elev App in Real Device
	 * @throws IOException
	 * @throws InterruptedException
	 * @author S, Manjunath
	 */
	//@Test
	public void _loginAsStudentInRealDevice() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Student");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacherInDevice(driver2, student_username, student_password);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	/**
	 * Login As Teacher2 in Elev App
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void loginAsTeacherTwo() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Teacher");

		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		boolean check =l1.loginAsStudentOrTeacher(driver2, teacher_username_two, teacher_password_two);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");
		Thread.sleep(5000);
	}

	/**
	 * Dynamic Test Data Support : Generic Login Method for both Student/Teacher in all environments
	 * @param loginType Student/Teacher
	 * @param env Test/FAT/PROD
	 * @author S, Manjunath
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public void loginAsGeneric(String loginType, String env) throws MalformedURLException, InterruptedException {
		boolean isLoginSuccessful = false;
		launch_Elev_app();
		logger.info("Elev(Teacher/Student) App Launched");
		//test.log(Status.PASS, "Elev(Teacher/Student) App Launched");

		ElevApp_Login l1=new  ElevApp_Login(driver2);

		if(loginType.equals("student")) {
			if(env.equals("test")) {
				System.out.println("Login Type : "+loginType);
				student_username_dynamic = student_username_dynamic.replaceAll("^\"|\"$", "");
				isLoginSuccessful =l1.loginAsStudentOrTeacherGeneric(driver2, student_username_dynamic, student_password_dynamic, env); 
			} else if(env.equals("fat")) {
				student_fat_username_dynamic = student_fat_username_dynamic.replaceAll("^\"|\"$", "");
				isLoginSuccessful =l1.loginAsStudentOrTeacherGenericForFat(driver2, student_fat_username_dynamic, student_fat_password_dynamic, env);
			} else if(env.equals("prod")) {
				student_prod_username_dynamic = student_prod_username_dynamic.replaceAll("^\"|\"$", "");
				isLoginSuccessful =l1.loginAsStudentOrTeacherGeneric(driver2, student_prod_username_dynamic, student_prod_password_dynamic, env);
			}

		} else if(loginType.equals("teacher")) {
			if(env.equals("test")) {
				System.out.println("Login Type : "+loginType);
				teacher_username_dynamic = teacher_username_dynamic.replaceAll("^\"|\"$", "");
				isLoginSuccessful =l1.loginAsStudentOrTeacherGeneric(driver2, teacher_username_dynamic, teacher_password_dynamic, env);
			}else if(env.equals("fat")) {
				System.out.println("Login Type : "+loginType);
				teacher_username_dynamic = teacher_username_dynamic.replaceAll("^\"|\"$", "");
				isLoginSuccessful =l1.loginAsStudentOrTeacherGenericForFat(driver2, teacher_username_dynamic, teacher_password_dynamic, env);
			}
			
		} else if(loginType.equals("studentOneSchool")) {
			System.out.println("Login Type : "+loginType);
			teacher_username2 = teacher_username2.replaceAll("^\"|\"$", "");
			isLoginSuccessful =l1.loginAsStudentOrTeacherGeneric(driver2, student_username3, student_password3, env);
		} else if(loginType.equals("teacherOneSchool")) {
			System.out.println("Login Type : "+loginType);
			teacher_username2 = teacher_username2.replaceAll("^\"|\"$", "");
			isLoginSuccessful =l1.loginAsStudentOrTeacherGeneric(driver2, teacher_username2, teacher_password2, env);
		} else if(loginType.contentEquals("teacher3")) {
			System.out.println("Login Type : "+loginType);
			teacher_username3 = teacher_username3.replaceAll("^\"|\"$", "");
			isLoginSuccessful =l1.loginAsStudentOrTeacherGeneric(driver2, teacher_username3, teacher_password3, env);
		}

		if (isLoginSuccessful==true)
			System.out.println(loginType+ "Login Success");
		logger.info(loginType+ "Login Success");
		Thread.sleep(5000);
	}
}
