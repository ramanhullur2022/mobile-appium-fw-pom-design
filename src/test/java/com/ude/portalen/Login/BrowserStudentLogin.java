package com.ude.portalen.Login;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.PortalenBrowser_Login;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;

public class BrowserStudentLogin  extends Base_Class implements Runnable  {

	public String url = ReadConfig.getPropertiesdata("Portalen_URL");
	//public String url = ReadConfig.getPropertiesdata("Portalen_URL_FAT");
	public String User_Name=null;
	public String User_Password=null;
	public String fat=null;
	SoftAssert softAssert_TC1 = new SoftAssert();
	String status = "UDEMA_Browser_Student_Login";


	public BrowserStudentLogin (String name,String password ){
		this.User_Name=ReadConfig.getPropertiesdata(name);
		this.User_Password=ReadConfig.getPropertiesdata(password);

	}



	@Test
	public void Student_send_mail_from_web() throws Exception {

		try {

			Thread.sleep(60000);
			extent = ExtentManager.GetExtent();
			//test = extent.createTest("Portalen-Student sends notification to Teacher");

			getDriver("Chrome");
			driver3.get(url);
			driver3.manage().window().maximize();
			test.log(Status.PASS, "Portalen Web URL launched");
			test.pass("Portalen Website launched and login screen displayed");

			PortalenBrowser_Login PBL =new PortalenBrowser_Login(driver3);

			//web login
			status = "Portlen web login failed";
			PBL.login_PortalenApp(driver3, User_Name, User_Password); 
			//PBL.login_PortalenApp_Generic(driver3, User_Name, User_Password,fat); 
			//PBL.login_PortalenApp_Generic(driver3, User_Name, User_Password); 

			if (PBL.Alexander_Profile.isDisplayed()) {

				test.log(Status.PASS, "Student is login into web portal is successful");
				test.pass("Student(alana041) is login into web portal is successful");

				status = "Sending mail from Portlen web";
				PBL.send_mail(driver3); 
				test.pass("Clicked on NyMelding then selected the receipient teacher and added message title and body. Clicked on sent button");

				if(PBL.mail_verification(driver3)) {

					captureScreen(driver3, "Message sent successfully");
					String screenshot_1 = Base_Class.captureScreenExtent(driver3, "send_mail_success"+System.currentTimeMillis());
					test.pass("TestCase Passed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());
					test.pass("Student(alela010) sent mail successfully and verified from Sendte meldinger");
					test.log(Status.PASS, "Student(alela010) sent mail successfully and verified from Sendte meldinger");

				} 

			}else {

				captureScreen(driver3, "Mail_sent_fail");
				String screenshot_2 = Base_Class.captureScreenExtent(driver3, "send_mail_failed"+System.currentTimeMillis());
				test.fail("TestCase Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());
				test.log(Status.FAIL, status);
				start_thread_main=true;

			}

		} catch (InterruptedException e) {

			captureScreen(driver3, "Mail_sent_failed");
			String screenShotPath = Base_Class.captureScreenExtent(driver3, "mail_sent_failed"+System.currentTimeMillis());
			test.fail("Mail Sent Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Student Alexander sent mail failed");
			extent.flush();
			driver3.close();
			start_thread_main=true;
		}

		finally {

			extent.flush();
			driver3.close();
			start_thread_main=true;
		}
	}




	public void run(){
		try {
			Student_send_mail_from_web();
			start_thread_main=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
