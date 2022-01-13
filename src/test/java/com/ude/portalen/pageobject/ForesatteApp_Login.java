package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;


public class ForesatteApp_Login  extends Base_Class {

	public String profile_Name;

	public ForesatteApp_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//android.widget.TextView[@text='Logg inn']")
	@CacheLookup
	public WebElement  Logg_inn;

	@FindBy(xpath = "//android.view.View[@content-desc='MinID MINID Use codes from SMS or PIN code letter Select MinID']")
	@CacheLookup
	public WebElement  MINID;

	@FindBy(xpath = "//android.view.View[@resource-id='MinIDChain']")
	@CacheLookup
	public WebElement  MINID_RealDevice;

	@FindBy(xpath = "//android.view.View[@content-desc='SELECT AN ELECTRONIC ID']")
	@CacheLookup
	public WebElement Select_Electronic_Id;

	@FindBy(xpath = "//android.view.View[@text='SELECT AN ELECTRONIC ID']")
	@CacheLookup
	public WebElement Select_Electronic_Id_RealDevice;

	@FindBy(xpath = "//android.widget.EditText[@text='PERSONAL ID NUMBER:']")
	@CacheLookup
	public WebElement Personal_Id_Number;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='input_USERNAME_IDPORTEN']")
	@CacheLookup
	public WebElement Personal_Id_Number_RealDevice;

	@FindBy(xpath = "//android.widget.EditText[@text='PASSWORD:']")
	@CacheLookup
	public WebElement Password_Id;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='input_PASSWORD_IDPORTEN']")
	@CacheLookup
	public WebElement Password_Id_RealDevice;

	@FindBy(xpath = "//android.widget.Button[@content-desc='NEXT']")
	@CacheLookup
	public WebElement Next_Button;

	@FindBy(xpath = "//android.widget.Button[@resource-id='nextbtn']")
	@CacheLookup
	public WebElement Next_Button_RealDevice;

	@FindBy(xpath = "(//android.widget.EditText)[1]")
	@CacheLookup
	public WebElement Pin_Code_5_Digit;

	//		@FindBy(xpath = "//android.widget.Button[@content-desc='NEXT']")
	//		@CacheLookup
	//		public WebElement Next_Button2;

	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	@CacheLookup
	public WebElement OK_Button;

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

	@FindBy(xpath = "//android.widget.EditText[@content-desc='input-pin-code']")
	@CacheLookup
	public WebElement Input_Pin_Code;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Mail_Settings;

	@FindBy(xpath = "(//android.widget.TextView['Min bruker'])[2]")
	@CacheLookup
	public WebElement minBruker;

	@FindBy(xpath = "(//android.widget.TextView['CGI ID-porttest Tre Testforesatt'])[4]")
	@CacheLookup
	public WebElement profileName;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Use code from the PIN code letter\"]")
	@CacheLookup
	public WebElement useCodeFromPinLink;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"CONFIRM\"]")
	@CacheLookup
	public WebElement confirmBtn;

	/**
	 * Login As Parent
	 * @param driver Webdriver
	 * @param login_id Login ID of Parent
	 * @param login_password Login Password of Parent
	 * @param login_pin Login PIN of Parent
	 * @return Returns True or False based on login result 
	 * @throws InterruptedException
	 */
	public boolean loginAsParent(WebDriver driver, String login_id, String login_password, String login_pin) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5);
		if(Logg_in_present==true) {
			Logg_inn.click();

		}

//		boolean Select_Electronic =Base_Class.is_Element_Present(driver, Select_Electronic_Id, 120);
//		if(Select_Electronic==true) {
//			MINID.click();
//			Thread.sleep(8000);
//			Personal_Id_Number.sendKeys(login_id);
//			Thread.sleep(1000);
//			Password_Id.sendKeys(login_password);
//			Thread.sleep(1000);
//			Next_Button.click();
//			Thread.sleep(5000);
//			Pin_Code_5_Digit.sendKeys(login_pin);
//			Thread.sleep(1000);
//			Next_Button.click();
//
//		}
		
		
		boolean Select_Electronic =Base_Class.is_Element_Present(driver, Select_Electronic_Id, 120);
		if(Select_Electronic==true) {
			MINID.click();
			Thread.sleep(8000);
			Personal_Id_Number.sendKeys(login_id);
			Thread.sleep(1000);
			Password_Id.sendKeys(login_password);
			Thread.sleep(1000);
			Next_Button.click();
			Thread.sleep(5000);
			boolean isCodeFromPinLinkDisplayed = Base_Class.is_Element_Present(driver, useCodeFromPinLink, 40);
			if(isCodeFromPinLinkDisplayed) {
				useCodeFromPinLink.click();
				Thread.sleep(5000);
				Pin_Code_5_Digit.sendKeys(login_pin);
				Thread.sleep(1000);
				Next_Button.click();
				Thread.sleep(5000);
				confirmBtn.click();
			} else {
				Pin_Code_5_Digit.sendKeys(login_pin);
				Thread.sleep(1000);
				Next_Button.click();	
			}

		}
		
		
		

		boolean  Pin_Screen_Present=Base_Class.is_Element_Present(driver, OK_Button, 80);

		if(Pin_Screen_Present == true)
			//Input_Pin_Code.sendKeys("2510");
			Keyboard_Key2.click();
		Keyboard_Key5.click();
		Keyboard_Key1.click();
		Keyboard_Key0.click();
		Thread.sleep(2000);
		OK_Button.click();
		Thread.sleep(3000);


		boolean  Settings_Screen_Present=Base_Class.is_Element_Present(driver, Mail_Settings, 30);
		if(Settings_Screen_Present == true)
			Mail_Settings.click();

		return true;

	}

	/**
	 * Login As Parent in Real Device
	 * @param driver Webdriver
	 * @param login_id Login ID of Parent
	 * @param login_password Login Password of Parent
	 * @param login_pin Login PIN of Parent
	 * @return Returns True or False based on login result 
	 * @throws InterruptedException
	 */
	public boolean loginAsParentInRealDevice(WebDriver driver, String login_id, String login_password, String login_pin) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5);
		if(Logg_in_present==true) {
			Logg_inn.click();

		}

		boolean Select_Electronic =Base_Class.is_Element_Present(driver, Select_Electronic_Id_RealDevice, 120);
		if(Select_Electronic==true) {
			MINID_RealDevice.click();
			Thread.sleep(8000);
			Personal_Id_Number_RealDevice.sendKeys(login_id);
			Thread.sleep(1000);
			Password_Id_RealDevice.sendKeys(login_password);
			Thread.sleep(1000);
			Next_Button_RealDevice.click();
			Thread.sleep(5000);
			Pin_Code_5_Digit.sendKeys(login_pin);
			Thread.sleep(1000);
			Next_Button.click();

		}

		boolean  Pin_Screen_Present=Base_Class.is_Element_Present(driver, OK_Button, 80);

		if(Pin_Screen_Present == true)
			//Input_Pin_Code.sendKeys("2510");
			Keyboard_Key2.click();
		Keyboard_Key5.click();
		Keyboard_Key1.click();
		Keyboard_Key0.click();
		Thread.sleep(2000);
		OK_Button.click();
		Thread.sleep(3000);


		boolean  Settings_Screen_Present=Base_Class.is_Element_Present(driver, Mail_Settings, 30);
		if(Settings_Screen_Present == true)
			Mail_Settings.click();

		return true;

	}

	/**
	 * Get profile details
	 * @author Ramana
	 * @return profile_Name
	 * @exception InterruptedException
	 * @throws InterruptedException
	 */

	public String getProfileName() throws InterruptedException {

		boolean  Settings_Screen_Present=Base_Class.is_Element_Present(driver, Mail_Settings, 30);
		if(Settings_Screen_Present == true)
			Mail_Settings.click();
		Thread.sleep(2000);
		boolean  minBruker_Displayed=Base_Class.is_Element_Present(driver, minBruker, 30);
		if(minBruker_Displayed == true) 
			profile_Name = profileName.getText();
		System.out.println(profile_Name);
		return profile_Name;
	}

	/**
	 * Dynamic Test Data Support : Generic Parent login method for all environments
	 * @param driver Webdriver
	 * @param login_id Parent MINID
	 * @param login_password Parent password
	 * @param login_pin 5 digit PIN
	 * @param env Test/FAT/Prod
	 * @return True if login is successful, False if login failed
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public boolean loginAsParentProfileGeneric(WebDriver driver, String login_id, String login_password, String login_pin, String env) throws InterruptedException {

		boolean Logg_in_present=Base_Class.is_Element_Present(driver, Logg_inn,5);
		if(Logg_in_present==true) {
			Logg_inn.click();

		}

		boolean Select_Electronic =Base_Class.is_Element_Present(driver, Select_Electronic_Id, 120);
		if(Select_Electronic==true) {
			MINID.click();
			Thread.sleep(8000);
			Personal_Id_Number.sendKeys(login_id);
			Thread.sleep(1000);
			Password_Id.sendKeys(login_password);
			Thread.sleep(1000);
			Next_Button.click();
			Thread.sleep(5000);
			boolean isCodeFromPinLinkDisplayed = Base_Class.is_Element_Present(driver, useCodeFromPinLink, 40);
			if(isCodeFromPinLinkDisplayed) {
				useCodeFromPinLink.click();
				Thread.sleep(5000);
				Pin_Code_5_Digit.sendKeys(login_pin);
				Thread.sleep(1000);
				Next_Button.click();
				Thread.sleep(5000);
				confirmBtn.click();
			} else {
				Pin_Code_5_Digit.sendKeys(login_pin);
				Thread.sleep(1000);
				Next_Button.click();	
			}

		}

		boolean  Pin_Screen_Present=Base_Class.is_Element_Present(driver, OK_Button, 80);

		if(Pin_Screen_Present == true)
			//Input_Pin_Code.sendKeys("2510");
			Keyboard_Key2.click();
		Keyboard_Key5.click();
		Keyboard_Key1.click();
		Keyboard_Key0.click();
		Thread.sleep(2000);
		OK_Button.click();
		Thread.sleep(3000);


		boolean  Settings_Screen_Present=Base_Class.is_Element_Present(driver, Mail_Settings, 30);
		if(Settings_Screen_Present == true)
			//Mail_Settings.click();
			System.out.println("login completed");

		return true;

	}

}













