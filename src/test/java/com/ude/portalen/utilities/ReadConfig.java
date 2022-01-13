package com.ude.portalen.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;

	public ReadConfig() {
		File src = new File("./configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			try {
				pro.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception is" + e.getMessage());
			e.printStackTrace();
		}
	}

	
	public String getDeviceName() {

		String device = pro.getProperty("deviceName");
		return device;
	}

	public String getPlatformVersion() {

		String platformVersion = pro.getProperty("platformVersion");
		return platformVersion;
	}

	public String getEmailAddress() {
		String gmail = pro.getProperty("email");
		return gmail;

	}

	public String base_url() {
		String gmail = pro.getProperty("Base_URL");
		return gmail;

	}

	public String browser_selection() {
		String gmail = pro.getProperty("Browser");
		return gmail;

	}	
	
	
	
	public String get_4_digit_login_pin() {
		String login_pin = pro.getProperty("4_digit_login_pin");
		return login_pin;
	}
	
	public String get_student_username() {
		String student_username = pro.getProperty("student_username");
		return student_username;
		
	}
	
	public String get_student_password() {
		String student_password = pro.getProperty("student_password");
		return student_password;
	}
	
	public String get_teacher_username() {
		String teacher_username = pro.getProperty("teacher_username");
		return teacher_username;
	}
	
	public String get_teacher_password() {
		String teacher_password = pro.getProperty("teacher_password");
		return teacher_password;
	}
	
	
	public String get_parent_login_id() {
		String parent_login_id = pro.getProperty("parent_login_id");
		return parent_login_id;
	}
	
	public String get_parent_login_password() {
		String parent_login_password=pro.getProperty("parent_login_password");
		return parent_login_password;
	}
	
	public String get_parent_5_digit_login_pin() {
		String parent_5_digit_login_pin = pro.getProperty("parent_5_digit_login_pin");
		return parent_5_digit_login_pin;
	}
	
	
	public String get_student_username_one_School() {
		String student_password = pro.getProperty("student_username_withOneSchool");
		return student_password;
	}
	
	
	public String get_student_password_one_School() {
		String student_password = pro.getProperty("student_password_withOneSchool");
		return student_password;
	}
	
	
	
	public String get_teacher_username2() {
		String teacher_username2 = pro.getProperty("teacher_username2");
		return teacher_username2;
	}
	
	public String get_teacher_password2() {
		String teacher_password2 = pro.getProperty("teacher_password2");
		return teacher_password2;
	}
	
	public String get_teacher_username3() {
		String teacher_username3 = pro.getProperty("teacher_username3");
		return teacher_username3;
	}
	
	public String get_teacher_password3() {
		String teacher_password3 = pro.getProperty("teacher_password3");
		return teacher_password3;
	}
	
	public String get_fat_student_username() {
		String fat_student_username = pro.getProperty("fat_student_username");
		return fat_student_username;
	}
	
	public String get_fat_student_password() {
		String fat_student_username = pro.getProperty("fat_student_password");
		return fat_student_username;
	}
	
	public String get_fat_teacher_username() {
		String fat_student_username = pro.getProperty("fat_teacher_username");
		return fat_student_username;
	}
	
	public String get_fat_teacher_password() {
		String fat_student_username = pro.getProperty("fat_student_password");
		return fat_student_username;
	}
	
	public String get_student_username3() {
		String student_username = pro.getProperty("student_username3");
		return student_username;
		
	}
	
	public String get_student_password3() {
		String student_username = pro.getProperty("student_password3");
		return student_username;
		
	}
	
	public String get_teacher_profile() {
		String student_username = pro.getProperty("teacher_profile_email");
		return student_username;
		
	}
	
	public String get_student_profile() {
		String student_username = pro.getProperty("student_profile_email");
		return student_username;
		
	}
	
	public String get_parent_profile() {
		String student_username = pro.getProperty("parent_profile_name");
		return student_username;
		
	}
	
	//Varun
	public static String getPropertiesdata(String propery) {
        Properties properties = new Properties();
        // load a properties file from class path, inside static method

        try {
        	properties.load(new FileInputStream("configuration/config.properties"));
        } catch (FileNotFoundException e) {
               e.printStackTrace();
        } catch (IOException e) {
               e.printStackTrace();
        }

        String Prop_data = properties.getProperty(propery);
        return Prop_data;

 }
	
	//Dynamic Helper Methods
	public String get_student_username_dynamic() {
		String student_username_dynamic = pro.getProperty("student_username_dynamic");
		return student_username_dynamic;
	}
	
	
	
	public String get_fat_student_username_dynamic() {
		String student_username_dynamic = pro.getProperty("student_username_fat_dynamic");
		return student_username_dynamic;
	}
	
	public String get_fat_student_password_dynamic() {
		String student_username_dynamic = pro.getProperty("student_password_fat_dynamic");
		return student_username_dynamic;
	}
	
	public String get_prod_student_username_dynamic() {
		String student_username_dynamic = pro.getProperty("student_username_prod_dynamic");
		return student_username_dynamic;
	}
	
	public String get_prod_student_password_dynamic() {
		String student_username_dynamic = pro.getProperty("student_password_prod_dynamic");
		return student_username_dynamic;
	}


	

	public String get_teacher_username_dynamic() {
		String teacher_username_dynamic = pro.getProperty("teacher_username_dynamic");
		return teacher_username_dynamic;
	}
	
	public String get_teacher_name_dynamic_receipiant() {
		String teacher_username_dynamic = pro.getProperty("teacher_name_dynamic_receipiant");
		return teacher_username_dynamic;
	}


	

	public String get_school_name_dynamic(String env) {
		String student_schoolname_dynamic = "ZGS";
		if(env.equals("test")) {
			student_schoolname_dynamic = pro.getProperty("school_name_test");
		} else if (env.equals("fat")) {
			student_schoolname_dynamic = pro.getProperty("school_name_fat");
		} else if (env.equals("prod")){
			student_schoolname_dynamic = pro.getProperty("school_name_prod");
		}
		return student_schoolname_dynamic;
	}


	public String get_affiliation(String env) {
		String affiliation = "CGI-Test";
		if(env.equals("test")) {
			affiliation = pro.getProperty("affiliation_test");
		} else if(env.equals("fat")) {
			affiliation = pro.getProperty("affiliation_fat");
		}
		return affiliation;
	}


	public String get_student_password_dynamic() {
		String student_password_dynamic = pro.getProperty("student_password_dynamic");
		return student_password_dynamic;
	}


	public String get_teacher_password_dynamic() {
		String teacher_password_dynamic = pro.getProperty("teacher_password_dynamic");
		return teacher_password_dynamic;
	}


	public String getProfileName(String profileType) {
		String profileName = "";
		if(profileType.equals("student")) {
			profileName = pro.getProperty("student_profile_email");
		} else if(profileType.equals("teacher")) {
			profileName = pro.getProperty("teacher_profile_email");
		} else if(profileType.equals("parent")) {
			profileName = pro.getProperty("parent_profile_name");
		}
		return profileName;
	}
	
	public String get_fat_parent_login_id() {
		String fat_parent_login_id = pro.getProperty("fat_parent_login_id");
		return fat_parent_login_id;
	}
	
	public String get_fat_parent_login_password() {
		String fat_parent_login_password = pro.getProperty("fat_parent_login_password");
		return fat_parent_login_password;
	}
	
	public String get_fat_parent_5_digit_login_pin() {
		String fat_parent_5_digit_login_pin = pro.getProperty("fat_parent_5_digit_login_pin");
		return fat_parent_5_digit_login_pin;
	}
	
	public String get_prod_parent_login_id() {
		String prod_parent_login_id = pro.getProperty("prod_parent_login_id");
		return prod_parent_login_id;
	}
	
	public String get_prod_parent_login_password() {
		String prod_parent_login_password = pro.getProperty("prod_parent_login_password");
		return prod_parent_login_password;
	}
	
	public String get_prod_parent_5_digit_login_pin() {
		String prod_parent_5_digit_login_pin = pro.getProperty("prod_parent_5_digit_login_pin");
		return prod_parent_5_digit_login_pin;
	}
	
}