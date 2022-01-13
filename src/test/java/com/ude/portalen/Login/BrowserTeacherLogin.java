
package com.ude.portalen.Login;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.PortalenBrowser_Login;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;

public class BrowserTeacherLogin  extends Base_Class implements Runnable {

	public String url = ReadConfig.getPropertiesdata("Portalen_URL");
    public String User_Name=null;
    public String User_Password=null;
    SoftAssert softAssert_TC1 = new SoftAssert();
    
 public BrowserTeacherLogin  (String name,String password ){
  	   this.User_Name=ReadConfig.getPropertiesdata(name);
  	   this.User_Password=ReadConfig.getPropertiesdata(password);
  	     
     }
	
 @Test
 public void Teacher_send_mail_from_web() throws Exception {

	   try {
		   
		   Thread.sleep(60000);
		  extent = ExtentManager.GetExtent();
        //test = extent.createTest("Portalen-Teacher sends notification to Student");

        getDriver("Chrome");
        driver3.get(url);
        driver3.manage().window().maximize();
        test.log(Status.PASS, "Portalen_Web_URL launched");
        test.pass("Portalen website launched");
        
        PortalenBrowser_Login PBL =new PortalenBrowser_Login(driver3);

        //web login
        PBL.login_PortalenApp(driver3, User_Name, User_Password); 

	              if (PBL.Inger.isDisplayed()) {
	            	 
	            	//TEMP  
	            	PBL.Inger.click();
	            	Thread.sleep(2000);
	            	PBL.CGI_testgrunnskole.click();
	            	//TEMP
	            	
	                 test.log(Status.PASS, "Teacher Inger is login in web portal successfully");
	                 test.pass("Teacher Inger is login in web portal  successfully");
	                 
	                 PBL.Teacher_send_mail(driver3);  
	
	                 if(PBL.mail_verification(driver3)) {
		                
		                captureScreen(driver3, "Message sent successfully");
		   				String screenshot_1 = Base_Class.captureScreenExtent(driver3, "send_mail_success"+System.currentTimeMillis());
		   				test.pass("Mail ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());
		                test.pass("Teacher Inger sent mail successfully");
		   				test.log(Status.PASS, "Teacher Inger sent mail successfully");
		   				
	                 } 
	                 
	              }else {
					
	            	captureScreen(driver3, "Mail_sent_fail");
	  				String screenshot_2 = Base_Class.captureScreenExtent(driver3, "send_mail_failed"+System.currentTimeMillis());
	  				test.fail("TestCase Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());
	  				test.log(Status.FAIL, "Test Case FAIL");
	              }

        } catch (InterruptedException e) {
      	  
           captureScreen(driver3, "Mail_sent_failed");
			 String screenShotPath = Base_Class.captureScreenExtent(driver3, "mail_sent_failed"+System.currentTimeMillis());
			 test.fail("Mail Sent Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
           test.log(Status.FAIL, "Teacher Inger sent mail failed");
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
			Teacher_send_mail_from_web();
			start_thread_main=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
}
