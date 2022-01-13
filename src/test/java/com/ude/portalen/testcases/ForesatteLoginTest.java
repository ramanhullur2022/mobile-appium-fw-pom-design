package com.ude.portalen.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.ForesatteApp_Login;
import com.ude.portalen.utilities.ReadConfig;

public class ForesatteLoginTest extends Base_Class {

	ReadConfig config = new ReadConfig();
	public String login_pin = config.get_4_digit_login_pin();
	//	public String student_username = config.get_student_username();
	//	public String student_password = config.get_student_password();
	//	public String teacher_username = config.get_teacher_username();
	//	public String teacher_password = config.get_teacher_password();
	public String parent_login_id = config.get_parent_login_id();
	public String parent_login_password = config.get_parent_login_password();
	public String parent_5_digit_login_pin = config.get_parent_5_digit_login_pin();

	//Dynamic Test Data Support
	public String parent_login_id_fat = config.get_fat_parent_login_id();
	public String parent_login_password_fat = config.get_fat_parent_login_password();
	public String parent_5_digit_login_pin_fat = config.get_fat_parent_5_digit_login_pin();
	
	public String parent_login_id_prod = config.get_prod_parent_login_id();
	public String parent_login_password_prod = config.get_prod_parent_login_password();
	public String parent_5_digit_login_pin_prod = config.get_prod_parent_5_digit_login_pin();


	//@Test
	public void _loginAsParent() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Parent");

		launch_Foresatte_app();
		logger.info("Foresatte(Parent/Gaurdian) App Launched");
		//test.log(Status.PASS, "Foresatte(Parent/Gaurdian) App Launched");

		ForesatteApp_Login l1=new  ForesatteApp_Login(driver);

		boolean check =l1.loginAsParent(driver, parent_login_id, parent_login_password, parent_5_digit_login_pin);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}

	public void _loginAsParentInRealDevice() throws IOException, InterruptedException {

		//start_Server();
		//extent = ExtentManager.GetExtent();
		//test = extent.createTest("Login_As_Parent");

		launch_Foresatte_app();
		logger.info("Foresatte(Parent/Gaurdian) App Launched");
		//test.log(Status.PASS, "Foresatte(Parent/Gaurdian) App Launched");

		ForesatteApp_Login l1=new  ForesatteApp_Login(driver);

		boolean check =l1.loginAsParentInRealDevice(driver, parent_login_id, parent_login_password, parent_5_digit_login_pin);
		if (check==true)
			System.out.println("Login Success");
		logger.info("App Login completed");

	}
	
	  /**
		 * Dynamic Test Data Support : Generic Login Method for both Parent in all environments
		 * @param env Test/FAT/PROD
		 * @author S, Manjunath
		 * @throws MalformedURLException
		 * @throws InterruptedException
		 */
		public void loginAsParentGeneric(String env) throws MalformedURLException, InterruptedException {
			boolean isLoginSuccessful = false;
			launch_Foresatte_app();
			logger.info("Foresatte(Parent/Gaurdian) App Launched");

			ForesatteApp_Login l1=new  ForesatteApp_Login(driver);
			
			System.out.println("Environment Type : "+env);
			switch (env) {
			case "test":
				isLoginSuccessful =l1.loginAsParentProfileGeneric(driver, parent_login_id, parent_login_password, parent_5_digit_login_pin, env);
				break;
			case "fat":
				isLoginSuccessful =l1.loginAsParentProfileGeneric(driver, parent_login_id_fat, parent_login_password_fat, parent_5_digit_login_pin_fat, env);
				break;
			case "prod":
				isLoginSuccessful =l1.loginAsParentProfileGeneric(driver, parent_login_id_prod, parent_login_password_prod, parent_5_digit_login_pin_prod, env);
				break;
			default:
				System.out.println("Invalid Environment details!!");
				break;
			}
			
			if (isLoginSuccessful==true)
				System.out.println("Parent Login Success");
			logger.info("Parent Login Success");
			Thread.sleep(5000);
		}
	  

}
