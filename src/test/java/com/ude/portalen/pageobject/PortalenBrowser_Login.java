package com.ude.portalen.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ude.portalen.utilities.ReadConfig;
import com.ude.portalen.generic.Base_Class;





public class PortalenBrowser_Login extends Base_Class{

	public PortalenBrowser_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	/* objects for login*/
	@FindBy(xpath = "//input[@id='username']")
	@CacheLookup
	public WebElement  UserName;


	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	public WebElement  Password;


	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	public WebElement  Login_button;


	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	@CacheLookup
	public WebElement  Continue_button;   


	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	public WebElement  Continue;


	@FindBy(xpath = "//div[@id='header-menu-bar']//a[text()='Meldinger']")
	@CacheLookup
	public WebElement  Meldinger;   


	@FindBy(xpath = "//span[text()='Ny melding']/ancestor::button[1]")
	@CacheLookup
	public WebElement  NyMelding;


	@FindBy(xpath = "//input[@aria-label='Title']")
	@CacheLookup
	public WebElement  Emne;


	@FindBy(xpath = "//button[@aria-label='Til']")
	@CacheLookup
	public WebElement  TilPluse;


	@FindBy(xpath = "//button[text()=' Ansatte ']")
	@CacheLookup
	public WebElement  Ansatte;


	@FindBy(xpath = "//button[contains(text(),' Inger Lærer ')]")
	@CacheLookup
	public WebElement  IngerLaerer;


	@FindBy(xpath = "//button[contains(text(),' Inger Lærer ')]/ancestor::div[@class='modal-body']/preceding-sibling::div[1]//button[contains(text(),'OK')]")
	@CacheLookup
	public WebElement  OK;


	@FindBy(xpath = "//div[@class='tox-edit-area']/iframe")
	@CacheLookup
	public WebElement  TextFrame;


	@FindBy(xpath = "//button[contains(text(),'Send')]")
	@CacheLookup
	public WebElement  Send;

	
	//@FindBy(xpath = "//button[contains(text(),'CGI-alana')]")
	@FindBy(xpath = "//button[contains(text(),'Cgi-Alana')]")
	@CacheLookup
	public WebElement  Alexander_Profile;


	@FindBy(xpath = "//input[@placeholder= 'Search or choose from the list']")
	@CacheLookup
	public WebElement  ChooseAffiliation;


	@FindBy(xpath = "//div[normalize-space(text())= 'CGI Test']")
	@CacheLookup
	public WebElement  CgiTest;
	
	
	@FindBy(xpath = "//div[normalize-space(text())= 'CGI Akseptansetest']")
	@CacheLookup
	public WebElement  CgiAkseptansetest;

	@FindBy(xpath = "//strong[text()='Sendte meldinger']")
	@CacheLookup
	public WebElement  Sendte_meldinger;


	@FindBy(xpath = "//div[normalize-space(text())='time_stamp']")
	@CacheLookup
	public WebElement  sent_mail;


	@FindBy(xpath = "//button[contains(text(),'Personer')]")
	@CacheLookup
	public WebElement  Personer;


	@FindBy(xpath = "//button[@aria-label='Search']")
	@CacheLookup
	public WebElement  Search_Teacher;


	@FindBy(xpath = "//label[text()=' Eleven ']")
	@CacheLookup
	public WebElement  Eleven_check;


	@FindBy(xpath = "//label[contains(text(),' Foresatte ')]")
	@CacheLookup
	public WebElement  Foresatte_check;
	
	
	@FindBy(xpath = "//button[contains(text(),'CGI testgrunnskole')]")
	@CacheLookup
	public WebElement  CGI_testgrunnskole;


	//@FindBy(xpath = "//button[contains(text(),'Alexander Elev')]/ancestor::div[@class='modal-body']/preceding-sibling::div[1]//button[contains(text(),'OK')]")
	@FindBy(xpath = "//div[@class='modal common-modal fade modal-message in show']//button[@class='modal-message__submit common-button'][contains(text(),'OK')]")
	@CacheLookup
	public WebElement  Student_OK;


	@FindBy(xpath = "//input[@aria-label='Search']")
	@CacheLookup
	public WebElement  Search; 

	@FindBy(xpath = "//button[contains(text(),'Inger')]")
	@CacheLookup
	public WebElement  Inger; 


	//public static String msg_time_stamp=null;


	/**
	 * Frame Data entry  
	 * @param driver Webdriver
	 * @param element Element
	 * @param testdata TestData
	 * @param duration Duration
	 * @throws InterruptedException
	 */

	//Auther: Varun
	public static void  frame_dataentry (WebDriver driver , WebElement element,String testdata,int duration) throws InterruptedException {

		WebDriverWait webDriverWait = new WebDriverWait(driver,duration);
		WebElement PresentElement=webDriverWait.until(ExpectedConditions.visibilityOf(element));
		driver.switchTo().frame(PresentElement);
		Thread.sleep(5000);
		driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).sendKeys(testdata);
		driver.switchTo().defaultContent();
	}


	/**
	 * Login to Portalen App
	 * @param driver Webdriver
	 * @param usernameVal Login Username
	 * @param passwordVal Login Password
	 * @throws InterruptedException
	 */

	public void login_PortalenApp (WebDriver driver,String usernameVal,String passwordVal) throws InterruptedException {

		Navigate ( driver, ChooseAffiliation,20);
		Navigate ( driver, CgiTest,10);
		Navigate ( driver, Continue_button,10);
		dataentry (driver ,UserName,usernameVal,10);
		dataentry (driver ,Password,passwordVal,10);
		Navigate ( driver, Login_button,10);
		Navigate ( driver, Continue,10);
		Thread.sleep(5000);    
	}
	
	public void login_PortalenApp_Generic(WebDriver driver,String usernameVal,String passwordVal, String env) throws InterruptedException {
		if (env.equals("fat")) {
			Navigate ( driver, ChooseAffiliation,20);
			Navigate ( driver, CgiAkseptansetest,10);
			Navigate ( driver, Continue_button,10);
			dataentry (driver ,UserName,usernameVal,10);
			dataentry (driver ,Password,passwordVal,10);
			Navigate ( driver, Login_button,10);
			Navigate ( driver, Continue,10);
			Thread.sleep(5000);    
		}else if(env.equals("prod")) {
			Navigate ( driver, ChooseAffiliation,20);
			Navigate ( driver, CgiAkseptansetest,10);
			Navigate ( driver, Continue_button,10);
			dataentry (driver ,UserName,usernameVal,10);
			dataentry (driver ,Password,passwordVal,10);
			Navigate ( driver, Login_button,10);
			Navigate ( driver, Continue,10);
			Thread.sleep(5000);    
		}
	}

	/**
	 * Send mail
	 * @param driver Webdriver
	 * @throws InterruptedException
	 */

	public void send_mail (WebDriver driver) throws InterruptedException {

		msg_time_stamp=Msg_Time();
		Navigate ( driver, Meldinger,10);
		Navigate ( driver, NyMelding,10);
		dataentry (driver ,Emne,"Msg_at"+msg_time_stamp,10);
		Navigate ( driver, TilPluse,10);
		//Navigate ( driver, Ansatte,10);
		Navigate ( driver, IngerLaerer,10);
		// Navigate ( driver, IngerLaerer,10);
		Navigate ( driver, OK,10);
		Thread.sleep(5000);
		//dataentry (driver ,TextFrame,"Msg_at"+msg_time_stamp,10);
		frame_dataentry(driver ,TextFrame,"Msg_Body_at"+msg_time_stamp,10);
		Thread.sleep(3000);
		Navigate ( driver, Send,10);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		Navigate ( driver, Sendte_meldinger,10);

	}


	/**
	 * Send mail from teacher
	 * @param driver Webdriver
	 * @throws InterruptedException
	 */

	public void Teacher_send_mail (WebDriver driver) throws InterruptedException {
		msg_time_stamp=Msg_Time();
		Navigate ( driver, Meldinger,10);
		Navigate ( driver, NyMelding,10);
		dataentry (driver ,Emne,"Msg_at"+msg_time_stamp,10);
		Navigate ( driver, TilPluse,10);

		Navigate ( driver, Personer,10);
		dataentry (driver ,Search, ReadConfig.getPropertiesdata("student_username"),20);
		Thread.sleep(13000);
		Navigate ( driver, Search_Teacher,20);
		Thread.sleep(5000);
		Navigate ( driver, Eleven_check,10);
		Navigate ( driver, Foresatte_check,10);
		//Navigate ( driver, AlexanderElev,10);
		Navigate ( driver, Student_OK,10);
		Thread.sleep(5000);
		//dataentry (driver ,TextFrame,"Msg_at"+msg_time_stamp,10);
		frame_dataentry(driver ,TextFrame,"Msg_Body_at"+msg_time_stamp,10);
		Thread.sleep(3000);
		Navigate ( driver, Send,10);
		Thread.sleep(10000);

		Navigate ( driver, Sendte_meldinger,10);

	}

	//
	public void Teacher_send_mail_generic(WebDriver driver, String env) throws InterruptedException {
		msg_time_stamp=Msg_Time();
		Navigate ( driver, Meldinger,10);
		Navigate ( driver, NyMelding,10);
		dataentry (driver ,Emne,"Msg_at"+msg_time_stamp,10);
		Navigate ( driver, TilPluse,10);

		Navigate ( driver, Personer,10);
		if(env.equals("fat")) {
			dataentry (driver ,Search, ReadConfig.getPropertiesdata("student_username_fat_dynamic"),20);
			Thread.sleep(13000);
		}else if(env.equals("prod")) {
			dataentry (driver ,Search, ReadConfig.getPropertiesdata("student_username_prod_dynamic"),20);
			Thread.sleep(13000);
		}
		
		Navigate ( driver, Search_Teacher,20);
		Thread.sleep(5000);
		Navigate ( driver, Eleven_check,10);
		Navigate ( driver, Foresatte_check,10);
		//Navigate ( driver, AlexanderElev,10);
		Navigate ( driver, Student_OK,10);
		Thread.sleep(5000);
		//dataentry (driver ,TextFrame,"Msg_at"+msg_time_stamp,10);
		frame_dataentry(driver ,TextFrame,"Msg_Body_at"+msg_time_stamp,10);
		Thread.sleep(3000);
		Navigate ( driver, Send,10);
		Thread.sleep(10000);

		Navigate ( driver, Sendte_meldinger,10);

	}

	/**
	 * Mail verification
	 * @param driver Webdriver
	 * @return Returns true/false based on mail verification results
	 * @throws InterruptedException
	 */

	public boolean mail_verification(WebDriver driver) throws InterruptedException {

		String temp1 ="//div[contains(text(),'temp')]";
		String xpath =temp1.replaceAll("temp", "Msg_at"+msg_time_stamp);
		System.out.println(xpath);
		Thread.sleep(8000);
		sent_mail=driver.findElement(By.xpath(xpath));
		System.out.println(sent_mail.isDisplayed());
		return sent_mail.isDisplayed();

	}   



}