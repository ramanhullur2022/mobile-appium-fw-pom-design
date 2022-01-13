package com.ude.portalen.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.MobileElement;

public class ElevApp_Login  extends Base_Class {
	
	public String profile_Name;
	
	ReadConfig config = new ReadConfig();

	public ElevApp_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Logg inn']")
	@CacheLookup
	public WebElement  Logg_inn;


	@FindBy(xpath = "//android.widget.EditText")
	//@FindBy(id="android:id/org_selector-selectized")
	//@FindBy(id="org_selector-selectized")
	@CacheLookup
	public WebElement Select_affiliation;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id='org_selector-selectized']")
	@CacheLookup
	public WebElement Select_affiliation_realDevice;


	//@FindBy(xpath = "//android.view.View[@text='CGI Test']")
	@FindBy(xpath = "//android.view.View[@content-desc='CGI Test']")
	@CacheLookup
	public WebElement CGI_Test;
	
	@FindBy(xpath = "//android.view.View[@text='CGI Test']")
	@CacheLookup
	public WebElement CGI_Test_RealDevice;

	@FindBy(xpath = "//android.view.View[@content-desc='CGI Akseptansetest']")
	@CacheLookup
	public WebElement FAT_CGI_Akseptansetest;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Continue  ']")
	//android.widget.Button[@content-desc='Continue  '] 
	//selectorg_button  - id
	@CacheLookup
	public WebElement Continue;

	@FindBy(xpath = "//android.widget.Button[@resource-id='selectorg_button']")
	@CacheLookup
	public WebElement ContinueInRealDevice;

	@FindBy(xpath = "(//android.widget.EditText)[1]")
	@CacheLookup
	public WebElement UserName;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='username']")
	@CacheLookup
	public WebElement UserNameInRealDevice;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='password']")
	@CacheLookup
	public WebElement PasswordInRealDevice;


	@FindBy(xpath = "(//android.widget.EditText)[1]")
	@CacheLookup
	public WebElement userCredentialScreen;



	@FindBy(xpath = "(//android.widget.EditText)[2]")
	@CacheLookup
	public WebElement Password;

	//android.widget.Button[@content-desc='Log in']
	@FindBy(xpath = "//android.widget.Button[@content-desc='Log in']")
	@CacheLookup
	public WebElement Log_in_Button;
	
	@FindBy(xpath = "//android.widget.Button[@text='Log in']")
	@CacheLookup
	public WebElement Log_in_Button_in_realDevice;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ButtonLoggInn']")
	@CacheLookup
	public WebElement clk_LoggInn;

	//@FindBy(xpath = "//android.widget.TextView[@content-desc='Skriv inn ditt 4-sifret personlig kode']")
	//original//@FindBy(xpath = "//android.widget.EditText[@content-desc='input-pin-code']")
	@FindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	public WebElement Pin1;

	@FindBy(xpath = "//android.widget.TextView[@text='2']")
	@CacheLookup
	public WebElement Keyboard_Key2;

	@FindBy(xpath = "//android.widget.TextView[@text='5']")
	@CacheLookup
	public WebElement Keyboard_Key5;

	@FindBy(xpath = "//android.widget.TextView[@text='1']")
	@CacheLookup
	public WebElement Keyboard_Key1;

	@FindBy(xpath = "//android.widget.TextView[@text='0']")
	@CacheLookup
	public WebElement Keyboard_Key0;

	////android.view.View[@content-desc='Feide']
	@FindBy(xpath = "//android.view.View[@content-desc='Feide']")
	@CacheLookup
	public WebElement Feide_Screen;
	
	@FindBy(xpath = "//android.view.View[@text='Feide']")
	@CacheLookup
	public WebElement Feide_Screen_realDevice;

	////android.widget.Button[@content-desc='Continue']
	@FindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
	@CacheLookup
	public WebElement Feide_Screen_Contune;	

	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	@CacheLookup
	public WebElement Feide_Screen_Contune_in_realDevice;	
	
	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	//original//@FindBy(xpath="//android.view.ViewGroup[@content-desc='button-ok']")
	@CacheLookup
	public WebElement OK_Btton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Nei takk!']")
	@CacheLookup
	public WebElement biometricNotNow;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Mail_Settings;
	
	@FindBy(xpath = "(//android.widget.TextView['Min bruker'])[2]")
	@CacheLookup
	public WebElement minBruker;
	
	@FindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]")
	@CacheLookup
	public WebElement profileName;

	/**
	 * Login as Student/Teacher in Elev App
	 * @param driver Webdriver
	 * @return Returns true/false based on login result
	 * @throws InterruptedException
	 */
	public boolean login(WebDriver driver) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,10) ;
		if(Logg_in_present==true) {
			Logg_inn.click();
		}


		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation.click();
			Thread.sleep(2000);
			CGI_Test.click();
			Thread.sleep(2000);
			Continue.click();

		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			UserName.sendKeys("inlaa014");
			Password.sendKeys("098asdf");
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune.click();
		Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		// boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 60);

		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}

		//		    if(Print_Screen_Present == true)
		//		    	Thread.sleep(2000);
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key1.click();
		//		    	Keyboard_Key0.click();
		//				Thread.sleep(2000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);


		return true;
		//return false;
	} 	

	/**
	 * Login As Student or Teacher
	 * @param driver Webdriver
	 * @param _username Login Username
	 * @param _password Login Password
	 * @return Returns true/false based on login result
	 * @throws InterruptedException
	 */
	public boolean loginAsStudentOrTeacher(WebDriver driver, String _username, String _password) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(10000);
		}

		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation.click();
			Thread.sleep(2000);
			CGI_Test.click();
			Thread.sleep(2000);
			Continue.click();

		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			UserName.sendKeys(_username);
			Password.sendKeys(_password);
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune.click();
		Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		//		    boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 80);
		//		    
		//		    if(Print_Screen_Present == true)
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key1.click();
		//		    	Keyboard_Key0.click();
		//				Thread.sleep(3000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);

		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}	

		return true;
		//return false;
	}


	/**
	 * Login As Student or Teacher in FAT environment
	 * @param driver Webdriver
	 * @param _username Login Username
	 * @param _password Login Password
	 * @return Returns true/false based on login result
	 * @throws InterruptedException
	 */
	public boolean loginAsStudentOrTeacherInFAT(WebDriver driver, String _username, String _password) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();

		}


		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation,80) ;

//		if(Select_affiliation_present==true) {
//			Select_affiliation.click();
//			Thread.sleep(2000);
//			FAT_CGI_Akseptansetest.click();
//			Thread.sleep(2000);
//			Continue.click();
//
//		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			UserName.sendKeys(_username);
			Password.sendKeys(_password);
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune.click();
		Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		//		    boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 80);
		//		    
		//		    if(Print_Screen_Present == true)
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key1.click();
		//		    	Keyboard_Key0.click();
		//				Thread.sleep(3000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);
		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}	

		return true;
		//return false;
	}

	/**
	 * Login As Student or Teacher
	 * @param driver Webdriver
	 * @param _username Login Username
	 * @param _password Login Password
	 * @return Returns true/false based on login result
	 * @throws InterruptedException
	 */
	public boolean loginAsStudentOrTeacherforPinReset(WebDriver driver, String _username, String _password) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(10000);
		}

		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation.click();
			Thread.sleep(2000);
			CGI_Test.click();
			Thread.sleep(2000);
			Continue.click();

		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			UserName.sendKeys(_username);
			Password.sendKeys(_password);
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune.click();
		Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		//		    boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 80);
		//		    
		//		    if(Print_Screen_Present == true)
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//				Thread.sleep(3000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);

		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}

		return true;
		//return false;
	}
	
	/**
	 * Login As Student or Teacher in Real Device(8.1.0)
	 * @param driver Webdriver
	 * @param _username Login Username
	 * @param _password Login Password
	 * @return Returns true/false based on login result
	 * @throws InterruptedException
	 */
	public boolean loginAsStudentOrTeacherInDevice(WebDriver driver, String _username, String _password) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();

		}


		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation_realDevice,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation_realDevice.click();
			Thread.sleep(2000);
			CGI_Test_RealDevice.click();
			Thread.sleep(2000);
			ContinueInRealDevice.click();

		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			Thread.sleep(5000);
			UserNameInRealDevice.click();
			Thread.sleep(2000);
			UserNameInRealDevice.sendKeys(_username);
			Thread.sleep(5000);
			PasswordInRealDevice.click();
			Thread.sleep(2000);
			//UserNameInRealDevice.sendKeys(_username);
			PasswordInRealDevice.sendKeys(_password);
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button_in_realDevice.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen_realDevice,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune_in_realDevice.click();
		Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		//		    boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 80);
		//		    
		//		    if(Print_Screen_Present == true)
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key1.click();
		//		    	Keyboard_Key0.click();
		//				Thread.sleep(3000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);
		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune_in_realDevice.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}
		
		biometricNotNow.click();
		Thread.sleep(5000);

		return true;
		//return false;
	}
	
	/**
	 * Fetch the Student/Teacher profile email
	 * @author Ramana
	 * @return profile_Name
	 * @throws InterruptedException
	 */

	public String getProfileName() throws InterruptedException {

		boolean  Settings_Screen_Present=Base_Class.is_Element_Present(driver2, Mail_Settings, 30);
		if(Settings_Screen_Present == true)
			Mail_Settings.click();
		Thread.sleep(2000);
		
		boolean  minBruker_Displayed=Base_Class.is_Element_Present(driver2, minBruker, 30);
		if(minBruker_Displayed == true) 
			profile_Name = profileName.getText();
		System.out.println(profile_Name);
		return profile_Name;

	}

	/**
	 * Dynamic Test Data Support : Generic Login method for Student or Teacher login in all environments
	 * @param driver Webdriver
	 * @param _username Login Username
	 * @param _password Login Password
	 * @param env Test/FAT/PROD
	 * @author S, Manjunath
	 * @return Returns true/false based on login result
	 * @throws InterruptedException
	 */
	public boolean loginAsStudentOrTeacherGeneric(WebDriver driver, String _username, String _password, String env) throws InterruptedException {
		String affiliationPlaceholder = config.get_affiliation(env);
		
		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(10000);
		}

		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation.click();
			Thread.sleep(2000);
			WebElement affiliationSelector = driver.findElement(By.xpath("//android.view.View[@content-desc="+affiliationPlaceholder+"]"));
    		affiliationSelector.click();
			
			Thread.sleep(2000);
			Continue.click();

		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			UserName.sendKeys(_username);
			Password.sendKeys(_password);
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune.click();
		Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		//		    boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 80);
		//		    
		//		    if(Print_Screen_Present == true)
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key1.click();
		//		    	Keyboard_Key0.click();
		//				Thread.sleep(3000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);

		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}	

		return true;
		//return false;
	} 
	
	
	public boolean loginAsStudentOrTeacherGenericForFat(WebDriver driver, String _username, String _password, String env) throws InterruptedException {
		String affiliationPlaceholder = config.get_affiliation(env);
		
		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(10000);
		}

		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver, Select_affiliation,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation.click();
			Thread.sleep(2000);
			WebElement affiliationSelector = driver.findElement(By.xpath("//android.view.View[@content-desc="+affiliationPlaceholder+"]"));
    		affiliationSelector.click();
			Thread.sleep(2000);
			Continue.click();

		}

		boolean UserName_present=Base_Class.is_Element_Present(driver, userCredentialScreen,10) ;

		if(UserName_present==true) {
			UserName.sendKeys(_username);
			Password.sendKeys(_password);
			//CGI_Test.click();
			Thread.sleep(4000);
			Log_in_Button.click();
			Thread.sleep(4000);

		}

		boolean  Feide_Screen_Present=Base_Class.is_Element_Present(driver, Feide_Screen,15) ;

		if(Feide_Screen_Present == true)
			Feide_Screen_Contune.click();
		    Thread.sleep(2000);

		//android.view.ViewGroup[@content-desc="button-ok"]
		//		    boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 80);
		//		    
		//		    if(Print_Screen_Present == true)
		//		    	//Pin1.sendKeys("2510");
		//		    	Keyboard_Key2.click();
		//		    	Keyboard_Key5.click();
		//		    	Keyboard_Key1.click();
		//		    	Keyboard_Key0.click();
		//				Thread.sleep(3000);
		//				OK_Btton.click();
		//				Thread.sleep(3000);

		boolean  Print_Screen_Present=Base_Class.is_Element_Present(driver, OK_Btton, 200);

		if(Print_Screen_Present == true) {
			//Pin1.sendKeys("2510");
			Thread.sleep(2000);
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}else {
			Feide_Screen_Contune.click();
			Thread.sleep(3000);
			//Pin1.sendKeys("2510");
			Keyboard_Key2.click();
			Keyboard_Key5.click();
			Keyboard_Key1.click();
			Keyboard_Key0.click();
			Thread.sleep(2000);
			OK_Btton.click();
			Thread.sleep(3000);
		}	

		return true;
		//return false;
	} 
	
	
}













