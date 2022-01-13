package com.ude.portalen.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.PortalenBrowser_Login;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;

 

public class PortalenBrowser_Login_TC extends Base_Class {

       public String url = ReadConfig.getPropertiesdata("Portalen_URL");
       //public String Student_User_Name=ReadConfig.getPropertiesdata("Portalen_Student_Name");
       //public String Student_User_Password=ReadConfig.getPropertiesdata("Student_User_Password");
       SoftAssert softAssert_TC1 = new SoftAssert();
       public String User_Name=null;
       public String User_Password=null;
       public String Digit_5_Login_Pin = null;

       
       PortalenBrowser_Login_TC(String name, String password ){
    	   
    	   this.User_Name=ReadConfig.getPropertiesdata(name);
    	   this.User_Password=ReadConfig.getPropertiesdata(password);
    	     
       }
       

       //@Test
       public void send_mail_from_web() throws Exception {

    	   try {
    		   
    		  extent = ExtentManager.GetExtent();
              test = extent.createTest("UDEMA-1985_Send_Message_From_Web", "Send message/notification to teacher from student");

              getDriver("Chrome");
              driver3.get(url);
              driver3.manage().window().maximize();
              test.log(Status.PASS, "Portalen_URL launched");
              test.pass("Portalen_URL launched");
  			 

              
              PortalenBrowser_Login PBL =new PortalenBrowser_Login(driver3);

              //web login
              PBL.login_PortalenApp(driver3, User_Name, User_Password); 

	              if (PBL.Alexander_Profile.isDisplayed()) {
	                test.log(Status.PASS, "Student Alexander is login successfully");
	                test.pass("Student Alexander is login successfully");
	                captureScreen(driver3, "login_success");
	   				String screenshot_1 = Base_Class.captureScreenExtent(driver3, "login_success");
	   				test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());
	   				
	                 
	                PBL.send_mail(driver3); 
	                test.log(Status.PASS, "Mail sent successfully");
	                test.pass("Mail sent successfully");
	                captureScreen(driver3, "sent_mail");
	   				String screenshot_2 = Base_Class.captureScreenExtent(driver3, "sent_mail");
	   				test.pass("TestCase Step Pass",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());
	   				
	           
	                
	                Thread.sleep(3000);
	                
	                if(PBL.mail_verification(driver3)) {
	                // PBL.mail_verification(driver3);
	                	test.pass("Student Alexander sent mail successfully");
		                captureScreen(driver3, "message_sent");
		   				String screenshot_3 = Base_Class.captureScreenExtent(driver3, "message_sent");
		   				test.pass("TestCase Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
		   				test.log(Status.PASS, "Student Alexander sent mail successfully");
	                } 
	                 
	              }else {
	            	test.log(Status.FAIL, "Test Case FAILED");
	            	captureScreen(driver3, "mail_sent_fail");
	  				String screenshot_4 = Base_Class.captureScreenExtent(driver3, "send_mail_failed");
	  				test.fail("TestCase Step Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_4).build());
	              }

              } catch (InterruptedException e) {
            	 test.log(Status.FAIL, e + "Test Case FAILED here");
                 captureScreen(driver3, "Mail_sent_failed");
     			 String screenshot_5 = Base_Class.captureScreenExtent(driver3, "mail_sent_failed");
     			 test.fail("Mail Sent Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_5).build());
                 test.log(Status.FAIL, "Student Alexander sent mail failed");
              }
    	   
    	   extent.flush();
    	   //driver3.quit();
    	   driver3.close();  
       } 
       
       
       //@Test
       public void teacher_send_mail_from_web() throws Exception {

          try {
                 
              extent = ExtentManager.GetExtent();
              test = extent.createTest("Portalen Web Login", "Send message from student");

              getDriver("Chrome");
              driver3.get(url);
              driver3.manage().window().maximize();
              test.log(Status.PASS, "Portalen_URL launched");
              test.pass("Portalen_URL launched");
              
              PortalenBrowser_Login PBL =new PortalenBrowser_Login(driver3);

              //web login
              PBL.login_PortalenApp(driver3, User_Name, User_Password); 
              WebElement image_page=driver3.findElement(By.xpath("//button[contains(text(),'Lukk')]"));
             
              if(image_page.isDisplayed()){
            	  image_page.click();
              }
              
                     if (PBL.Inger.isDisplayed()) {
       
                        test.log(Status.PASS, "Teacher Inger  is login successfully");
                        test.pass("Teacher Inger is login successfully");
                        
                        PBL.Teacher_send_mail(driver3);  
       
                        if(PBL.mail_verification(driver3)) {
                             captureScreen(driver3, "Message sent successfully");
                             String screenshot_1 = Base_Class.captureScreenExtent(driver3, "send_mail_success");
                             test.pass("TestCase Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_1).build());
                             test.pass("Student Alexander sent mail successfully");
                             test.log(Status.PASS, "Student Alexander sent mail successfully");            
                        } 
                     }else {      
                    	 	captureScreen(driver3, "Mail_sent_fail");
	                        String screenshot_2 = Base_Class.captureScreenExtent(driver3, "send_mail_failed");
	                        test.fail("TestCase Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshot_2).build());
	                        test.log(Status.FAIL, "Test Case FAIL");
                     }

              } catch (InterruptedException e) {
              
                 captureScreen(driver3, "Mail_sent_failed");
                 String screenShotPath = Base_Class.captureScreenExtent(driver3, "mail_sent_failed");
                 test.fail("Mail Sent Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
                 test.log(Status.FAIL, "Student Alexander sent mail failed");
              }
          
          	extent.flush();
            driver3.close();
       }

}
