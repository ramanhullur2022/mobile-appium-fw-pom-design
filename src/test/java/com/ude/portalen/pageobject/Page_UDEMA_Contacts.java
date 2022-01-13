package com.ude.portalen.pageobject;

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
import io.appium.java_client.touch.offset.PointOption;


public class Page_UDEMA_Contacts extends Base_Class {

	public Page_UDEMA_Contacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime currentDateTime = LocalDateTime.now();
	public String messageBody = "inlaa014 msg_body" + dateTimeFormat.format(currentDateTime);
	public String messageTitle = "inlaa014 msg_title" + dateTimeFormat.format(currentDateTime);
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"NewMessage-screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	@CacheLookup
	public WebElement removeContactIcon;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"NewMessage-screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.HorizontalScrollView")
	@CacheLookup
	public WebElement tillFieldContent;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'CGI-alana Testelev (Eleven + Foresatte)']")
	@CacheLookup
	public WebElement checkForContact;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Skriv melding']")
	@CacheLookup
	public WebElement mail_Compose;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-till']")
	@CacheLookup
	public WebElement Clk_Till;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='addContactText']")
	@CacheLookup
	public WebElement clk_Add_Contacts_OK;
	
	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	@CacheLookup
	public WebElement verify_Selection;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alana041']/android.view.ViewGroup")
	@CacheLookup
	public WebElement clk_Search_Alana041;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Eleven + Foresatte']")
	@CacheLookup
	public WebElement clk_Checkbox;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='search-input-contact']")
	@CacheLookup
	public WebElement clk_Search_Input;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement clk_Velg_Skole;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ZGS']/android.widget.TextView")
	@CacheLookup
	public WebElement clk_Velg_Skole_Options;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Personer']")
	@CacheLookup
	public WebElement clk_Personer_Tab;

	/**
	 * Add Contact to Til field
	 * @param type first time/ again
	 * @throws InterruptedException
	 */
	public void addContact(String type) throws InterruptedException {
		if(type.equals("first time")) {
			Thread.sleep(4000);
			mail_Compose.click();
			Thread.sleep(2000);	
		}
		Clk_Till.click();
		Thread.sleep(2000);
//		clk_Velg_Skole.click();
//		Thread.sleep(2000);
//		clk_Velg_Skole_Options.click();
//		Thread.sleep(2000);
//		clk_Personer_Tab.click();
//		Thread.sleep(2000);
//		clk_Search_Input.sendKeys("alana041");
//		Thread.sleep(15000);
//		boolean is_Alela_Displayed = Base_Class.is_Element_Present(driver2, clk_Search_Alana041, 10);
//		if(is_Alela_Displayed == true) {
//			clk_Search_Alana041.click();
//			Thread.sleep(500);
//			clk_Search_Alana041.click();
//			Thread.sleep(8000);
//			clk_Checkbox.click();
//			Thread.sleep(2000);
//		}
//
//		boolean isCheckbox_selected = Base_Class.is_Element_Present(driver2, verify_Selection, 10);
//		if(isCheckbox_selected == true) {
//			clk_Add_Contacts_OK.click();
//			Thread.sleep(5000);
//		}
		
		searchForUserAndSelect(driver2, "student", "test", "eleven_only");
		Thread.sleep(5000);
		
	}
	
	/**
	 * Removes Contact from Till field
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void removeContact() throws InterruptedException {
		Thread.sleep(2000);
		removeContactIcon.click();
	}

	/**
	 * Verify contact visibility in Till field
	 * @param contactVisibility visible/not visible
	 * @return True/false
	 * @author S, Manjunath
	 */
	public boolean verifyContactRemoval(String contactVisibility) {
		boolean result = false;
		boolean isContactPresent = false;
		if(contactVisibility.equals("visible")) {
			isContactPresent = Base_Class.is_Element_Present(driver2, checkForContact, 40);
			if(isContactPresent) {
				result = true;
				System.out.println("PASS : Contact is visible");
			} else {
				result = false;
				System.out.println("FAIL : Contact is not visible");
			}
		} else if(contactVisibility.equals("not visible")) {
			isContactPresent = Base_Class.is_Element_Present(driver2, tillFieldContent, 40);
			if(isContactPresent) {
				result = true;
				System.out.println("PASS : Contact is not visible");
			} else {
				result = false;
				System.out.println("FAIL : Contact is visible");
			}
		}
		return result;
		
	}

}
