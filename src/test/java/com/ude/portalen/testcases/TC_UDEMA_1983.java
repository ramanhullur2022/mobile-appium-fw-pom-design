package com.ude.portalen.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.Login.BrowserStudentLogin;
import com.ude.portalen.Login.BrowserTeacherLogin;
import com.ude.portalen.Login.ElevLoginAsStudent;
import com.ude.portalen.Login.ElevLoginAsTeacher;
import com.ude.portalen.Login.ForsatteLoginAsParent;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.XLUtils;

public class TC_UDEMA_1983 extends Base_Class{
	
	SoftAssert softassert = new SoftAssert();
	public String expected_msg = null;
	public String actual_msg = null;
	public String status = "";
  
	/*
	 * Test Suite ID : UDEMA_1983 
	 * Test Case ID  : UDEMA_1983_TC001 
	 * Test Summary  : Teacher receive new push notifications message from Student in active and background app state and open the push notification message 
	 * Test Author   : Varun 
	 */
	//@Test(dataProvider="testData")
	@Test (enabled=true)
	public void teacher_Receive_Push_Notification() throws InterruptedException, Exception {
		
		try {
			
			//app will be ready with login session to receive notification
			
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1983_TC001", "Teacher(inlaa014) receiving new push notifications message from Student(alana041) in active and background app state and opening the push notification message from app");
			
			//send msg notification
			status = "Student(alana041) login to Web portelan and sending push notification message to teacher(inlaa014)";
			BrowserStudentLogin  portalen_browser = new BrowserStudentLogin("student_username", "student_password");
			Thread tobj =new Thread(portalen_browser);
			tobj.start();
							
			//app will be ready with login session to receive notification
			ElevLoginAsTeacher elav_login = new ElevLoginAsTeacher();
			elav_login._loginAsTeacher();      
							
		}catch (Exception e) {
			
			String screenshot_3 = Base_Class.captureScreenExtent(driver2, "message_sent_failed");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
			test.log(Status.FAIL, "Test case - FAILED");
			//test.log(Status.ERROR, e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+status+ " with "+e.getClass().getSimpleName()+".");
			logger.error("Test case execution failed");
			logger.error(e.getMessage());
		}
		
		logger.info(" ==== TC execution is completed!! ===");
		//softassert.assertAll();
			extent.flush();
			driver2.quit();

			
		}
 
	/*
	 * Test Suite ID : UDEMA_1983 
	 * Test Case ID  : UDEMA_1983_TC002 
	 * Test Summary  : Student receive new push notification message from Teacher in active and background app state and open the push notification message 
	 * Test Author   : Varun
	 */
	@Test (enabled = true)
	public void Student_Receive_Push_Notification() throws InterruptedException, Exception {
		
		try {
			
			//app will be ready with login session to receive notification
			
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1983_TC002", "Student receive new push notification message from Teacher in active and background app state and open the push notification message");
			
			//send msg notification
			status = "Teacher(inlaa014) sending mail notification message to Student(alana014) from web portelan";
			BrowserTeacherLogin  portalen_browser = new BrowserTeacherLogin("teacher_username", "teacher_password");
			Thread tobj =new Thread(portalen_browser);
			tobj.start();
					
			//app will be ready with login session to receive notification
			ElevLoginAsStudent elav_login = new ElevLoginAsStudent();
			elav_login._loginAsStudent();      
							
		}catch (Exception e) {
			
			String screenshot_3 = Base_Class.captureScreenExtent(driver2, "message_sent_failed");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
			test.log(Status.FAIL, "Test case - FAILED");
			//test.log(Status.ERROR, e.getMessage());
			test.log(Status.FAIL, "Test Case Failed while "+status+ " with "+e.getClass().getSimpleName()+".");
			logger.error("Test case execution failed");
			logger.error(e.getMessage());
		}
		
		logger.info(" ==== TC execution is completed!! ===");
		//softassert.assertAll();
		extent.flush();
		driver2.quit();

		
	}

	
	/*
	 * Test Suite ID : UDEMA_1983 
	 * Test Case ID  : UDEMA_1983_TC003 
	 * Test Summary  : Parent receive new push notification message from Teacher in active and background app state and open the push notification message 
	 * Test Author   : Varun
	 */
	@Test (enabled=true)
	public void Parent_Receive_Push_Notification() throws InterruptedException, Exception {
		
		try {
			
			//app will be ready with login session to receive notification
			
			extent = ExtentManager.GetExtent();
			test = extent.createTest("UDEMA_1983_TC003", "Parent receiving new push notification message from Teacher in active and background app state and open the push notification message from mobile app");
			
			//send msg notification
			status = "Teacher logging from web portelan and sending the push notification to Parent";
			BrowserTeacherLogin  portalen_browser = new BrowserTeacherLogin("teacher_username", "teacher_password");
			Thread tobj =new Thread(portalen_browser);
			tobj.start();
							
			//app will be ready with login session to receive notification
			ForsatteLoginAsParent Forsatte_login = new ForsatteLoginAsParent();
			Forsatte_login._loginAsParent(); 
							
		}catch (Exception e) {
			
			test.log(Status.FAIL, "Test Case Failed while "+status+ " with "+e.getClass().getSimpleName()+".");
			String screenshot_3 = Base_Class.captureScreenExtent(driver2, "message_sent_failed");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_3).build());
			test.log(Status.FAIL, "Test case - FAILED");
			//test.log(Status.ERROR, e.getMessage());
			logger.error("Test case execution failed");
		}
		
		logger.info(" ==== TC execution is completed!! ===");
		//softassert.assertAll();
		extent.flush();
		driver.quit();

		
	}	
	
	
	/**
	 * Helper method to extract test data
	 * @author Ramana Gouda
	 * @return searchdata
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
