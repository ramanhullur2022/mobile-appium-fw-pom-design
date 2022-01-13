package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;

//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.touch.offset.PointOption;



public class Page_Settings_ResetPIN_TC001 extends Base_Class {

	public Page_Settings_ResetPIN_TC001(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alert-close-icon']")
	@CacheLookup
	public WebElement Clk_Close_Button;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Click_Settings_Tab;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Logg ut']")
	@CacheLookup
	public WebElement Click_Logout;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Endre PIN-kode']")
	@CacheLookup
	public WebElement Click_Endre_PIN_kode;
	
	
	
	/**
	 * Wait for Settings tab visible and click on it
	 * @throws InterruptedException
	 */
	public void clickOnSettings() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Settings_Tab, 40);
		if(is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
		}
	}
	
	/**
	 * Click on Endre PIN kode
	 * @throws InterruptedException
	 */
	public void clickOnEndrePinKode() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Endre_PIN_kode, 40);
		if(is_SettingsTab_Displayed == true) {
			Click_Endre_PIN_kode.click();
		}
	}
	
	
	/**
	 * Click on Logout
	 * @throws InterruptedException
	 */
	public void logout() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Settings_Tab, 40);
		if(is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
			Thread.sleep(3000);
			Click_Logout.click();
		}
	}
	
}
