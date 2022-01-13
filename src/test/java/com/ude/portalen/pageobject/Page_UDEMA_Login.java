package com.ude.portalen.pageobject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.touch.offset.PointOption;


public class Page_UDEMA_Login extends Base_Class {

	public Page_UDEMA_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime currentDateTime = LocalDateTime.now();
	public String messageBody = "inlaa014 msg_body" + dateTimeFormat.format(currentDateTime);
	public String messageTitle = "inlaa014 msg_title" + dateTimeFormat.format(currentDateTime);

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Hjelp\"]/android.widget.TextView")
	@CacheLookup
	public WebElement clickHelpIcon;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Hjelp']")
	@CacheLookup
	public WebElement helpPageHeader;

	@FindBy(xpath = "//android.widget.TextView[@text='Logg inn']")
	@CacheLookup
	public WebElement Logg_inn;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ButtonLoggInn\"]/android.widget.TextView")
	@CacheLookup
	public WebElement Logg_inn_btn;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Do you need help? \"]")
	@CacheLookup
	public WebElement DoYouNeedHelpOption;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Go to the support webpage\"]")
	@CacheLookup
	public WebElement GoToSupportPageOption;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Tilgjengelige tjenester\"]")
	@CacheLookup
	public WebElement supportPageHeader;

	@FindBy(xpath = "//android.widget.EditText")
	@CacheLookup
	public WebElement Select_affiliation;

	@FindBy(xpath = "//android.view.View[@content-desc='CGI Test']")
	@CacheLookup
	public WebElement CGI_Test;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Continue  ']")
	@CacheLookup
	public WebElement Continue;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Forgot your username or password?\"]")
	@CacheLookup
	public WebElement forgotPasswordOption;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Lost account\"]")
	@CacheLookup
	public WebElement lostAccountPageHeader;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Privacy and cookie information\"]")
	@CacheLookup
	public WebElement privacyAndCookieInfoLink;

	@FindBy(xpath = "//android.view.View[@content-desc='Personvern og informasjonssikkerhet']")
	@CacheLookup
	public WebElement personvernPage;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Glemt pin-kode\"]/android.view.ViewGroup/android.widget.TextView")
	@CacheLookup
	public WebElement glemtPinCode;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Click_Settings_Tab;
	
	@FindBy(xpath="//android.widget.Switch[@content-desc=\"Bruk biometri\"]")
	@CacheLookup
	public WebElement biometricSwitch;
	
	//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[5]/android.widget.Switch
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[5]/android.widget.Switch")
	@CacheLookup
	public WebElement biometricSwitchStatus;
	
	@FindBy(xpath="//android.widget.Button[@text='AVBRYT']")
	@CacheLookup
	public WebElement skipBiometricBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	@CacheLookup
	public WebElement OK_Btton;


	/**
	 * Clicks on Help Icon
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void clickOnHelp() throws InterruptedException {
		clickHelpIcon.click();
		Thread.sleep(5000);
	}

	/**
	 * Click on Do You Need Help? option
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void clickOnDoYouNeedHelp() throws InterruptedException {
		boolean Logg_in_present=Base_Class.is_Element_Present(driver2, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(20000);
		}
		DoYouNeedHelpOption.click();
		Thread.sleep(2000);
		GoToSupportPageOption.click();
		Thread.sleep(2000);
	}

	/**
	 * Verify whether help page display
	 * @param pageName Page under test
	 * @return True or False based on help page display
	 * @author S, Manjunath
	 */
	public boolean verifyPageDisplay(String pageName) {
		boolean result = false;
		switch (pageName) {
		case "help":
			boolean isHelpPagePresent = Base_Class.is_Element_Present(driver2, helpPageHeader, 40);
			if(isHelpPagePresent) {
				System.out.println("Help page displayed - PASS");
				result = true;
			} else {
				System.out.println("Help page NOT displayed - FAIL");
				result = false;
			}
			break;
		case "support":
			boolean isSupportPagePresent = Base_Class.is_Element_Present(driver2, supportPageHeader, 40);
			if(isSupportPagePresent) {
				System.out.println("Support page displayed - PASS");
				result = true;
			} else {
				System.out.println("Support page NOT displayed - FAIL");
				result = false;
			}
			break;
		case "lost account":
			boolean isLostAccountPagePresent = Base_Class.is_Element_Present(driver2, lostAccountPageHeader, 40);
			if(isLostAccountPagePresent) {
				System.out.println("Lost Account page displayed - PASS");
				result = true;
			} else {
				System.out.println("Lost Account page NOT displayed - FAIL");
				result = false;
			}
			break;	
		case "privacy and cookie":
			boolean isPersonvernPagePresent = Base_Class.is_Element_Present(driver2, personvernPage, 40);
			if(isPersonvernPagePresent) {
				System.out.println("Personvern page displayed - PASS");
				result = true;
			} else {
				System.out.println("Personvern page NOT displayed - FAIL");
				result = false;
			}
			break;
		case "glemt pin-code":
		case "logg inn":
			boolean isLoginBtnPresent = Base_Class.is_Element_Present(driver2, Logg_inn, 40);
			if(isLoginBtnPresent) {
				System.out.println("Logg inn page displayed - PASS");
				result = true;
			} else {
				System.out.println("Logg inn page NOT displayed - FAIL");
				result = false;
			}
			break;
		case "logg inn PIN":
			boolean isLoginPINPresent = Base_Class.is_Element_Present(driver2, OK_Btton, 40);
			if(isLoginPINPresent) {
				System.out.println("Logg inn PIN page displayed - PASS");
				result = true;
			} else {
				System.out.println("Logg inn PIN page NOT displayed - FAIL");
				result = false;
			}
			break;	
		default:
			System.out.println("verifyPageDisplay : Invalid Argument Passed");
			break;
		}
		return result;
	}

	/**
	 * Clicks on Forgot Password Option
	 * @throws InterruptedException
	 */
	public void clickOnForgotPasswordOption() throws InterruptedException {
		boolean Logg_in_present=Base_Class.is_Element_Present(driver2, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(20000);
		}

		boolean Select_affiliation_present=Base_Class.is_Element_Present(driver2, Select_affiliation,80) ;

		if(Select_affiliation_present==true) {
			Select_affiliation.click();
			Thread.sleep(2000);
			CGI_Test.click();
			Thread.sleep(2000);
			Continue.click();
		}
		Thread.sleep(5000);
		forgotPasswordOption.click();
		Thread.sleep(5000);

	}

	/**
	 * Click on Privacy and Cookie Information
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void clickOnPrivacyAndCookieInfo() throws InterruptedException {
		boolean Logg_in_present=Base_Class.is_Element_Present(driver2, Logg_inn,5) ;

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(25000);
		}

		privacyAndCookieInfoLink.click();
		Thread.sleep(10000);

	}

	public void clickOnGlemtPinCode() throws InterruptedException {
		Thread.sleep(10000);
		glemtPinCode.click();
		boolean Logg_in_present=Base_Class.is_Element_Present(driver2, Logg_inn,5) ;
		if(Logg_in_present==true) {
			
		}

	}

	/**
	 * Sets WiFi Connectivity
	 * @param connectionStatus ON/OFF
	 * @author S, Manjunath
	 */
	public void setConnectivity(String connectionStatus) {
		if(connectionStatus.equals("OFF")){
			((HasNetworkConnection) driver2).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
			System.out.println("Connectivity Status set to OFF");
		} else if(connectionStatus.equals("ON")) {
			((HasNetworkConnection) driver2).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
			System.out.println("Connectivity Status set to ON");
		}
	}

	/**
	 * Click on Logg Inn button
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void clickOnLoggInn() throws InterruptedException {
		Thread.sleep(10000);
		boolean Logg_in_present=Base_Class.is_Element_Present(driver2, Logg_inn_btn, 40);

		if(Logg_in_present==true) {
			Logg_inn.click();
			Thread.sleep(15000);
		}
		
	}

	/**
	 * Sets Biometric Option based on parameter passed
	 * @param status enable/disable
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void setBiometricOption(String status) throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Settings_Tab, 40);
		if(is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
			Thread.sleep(3000);
		}
		
		System.out.println("Passed Status : "+status);
		String biometricCurrentStatus = biometricSwitchStatus.getText();
		System.out.println("Current Biometric Switch Status is "+biometricCurrentStatus);
		
		if(status.equals("enable")) {
			System.out.println("FINGERPRINT AUTHENTICATION SCREEN DISPLAYED!! NEED MANUAL INTERVENTION!!!!");
			Thread.sleep(15000);
			if(biometricCurrentStatus.equals("ON")) {
				System.out.println("Biometric Switch Status is already ON!!");
			} else {
				biometricSwitch.click();
				Thread.sleep(10000);
				System.out.println("Biometric Switch Status changed to : "+biometricSwitchStatus.getText());
			}
		} else if(status.equals("disable")) {
			if(biometricCurrentStatus.equals("OFF")) {
				System.out.println("Biometric Switch Status is already OFF!!");
			} else {
				biometricSwitch.click();
				System.out.println("Biometric Switch Status changed to : "+biometricSwitchStatus.getText());
			}
		}
	}
	
	public void isRealDevice() throws IOException, InterruptedException {
		System.out.println("isRealDevice() method begins!!");
        Process process = Runtime.getRuntime().exec("$ANDROID_HOME/platform-tools/adb devices");
        // for data access
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String data;
        while((data = br.readLine()) != null) {
        	System.out.println("Appending strng");
          sb.append(data);
        }
        br.close();
		
//		System.out.println("isRealDevice() method begins!!");
//		ProcessBuilder processBuilder = new ProcessBuilder();
//		processBuilder.command("bash", "-c", "$ANDROID_HOME/platform-tools/adb devices");
//		System.out.println("Command input");
//		
//		Process process = processBuilder.start();
//		StringBuilder output = new StringBuilder();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//		String line;
//		while ((line = reader.readLine()) != null) {
//			output.append(line + "\n");
//		}
//		int exitVal = process.waitFor();
//		if (exitVal == 0) {
//			System.out.println("Success!");
//			System.out.println(output);
//			System.exit(0);
//			return true;
//		} else {
//			//abnormal...
//			System.out.println("Error!!!");
//			return false;
//		}
		
//		String cmd = "$ANDROID_HOME/platform-tools/adb devices";
//		ProcessBuilder processBuilder = new ProcessBuilder();
//		String result = processBuilder.command("bash", "-c", cmd).toString();
//		System.out.println("Command result is : "+result);
		
		
	}

	public void skipBiometricAuthentication() throws InterruptedException {
		Thread.sleep(5000);
		skipBiometricBtn.click();
	}
		
		




}
