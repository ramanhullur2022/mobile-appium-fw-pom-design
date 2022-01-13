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


public class Page_SendMsg_Svar_Av_Sporshmal_TC003 extends Base_Class {

	public Page_SendMsg_Svar_Av_Sporshmal_TC003(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime currentDateTime = LocalDateTime.now();
	public String messageBody = "inlaa014 msg_body" + dateTimeFormat.format(currentDateTime);
	public String messageTitle = "inlaa014 msg_title" + dateTimeFormat.format(currentDateTime);

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alert-close-icon']")
	@CacheLookup
	public WebElement clk_Close_Button;

	@FindBy(xpath = "//android.widget.TextView[@text='Lesebekreftelse']")
	@CacheLookup
	public WebElement Click_Lesebekreftelse;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Spørsmål\"]")
	@CacheLookup
	public WebElement Click_Spørsmål;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Skriv spørsmål\"]")
	@CacheLookup
	public WebElement Enter_Msg_in_Sporsmal;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Filter']/android.widget.ImageView")
	@CacheLookup
	public WebElement Click_Post_Filter;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='isReplyAllowed']")
	@CacheLookup
	public WebElement Click_Svar_av_toggle;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Skriv melding']")
	@CacheLookup
	public WebElement mail_Compose;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-till']")
	@CacheLookup
	public WebElement Clk_Till;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement clk_Velg_Skole;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ZGS']/android.widget.TextView")
	@CacheLookup
	public WebElement clk_Velg_Skole_Options;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Personer']")
	@CacheLookup
	public WebElement clk_Personer_Tab;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='search-input-contact']")
	@CacheLookup
	public WebElement clk_Search_Input;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alana041']/android.view.ViewGroup")
	@CacheLookup
	public WebElement clk_Search_Alana041;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Eleven + Foresatte']")
	@CacheLookup
	public WebElement clk_Checkbox;

	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	@CacheLookup
	public WebElement verify_Selection;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='addContactText']")
	@CacheLookup
	public WebElement clk_Add_Contacts_OK;
	
	//FAT
	 @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"racga001\"]/android.view.ViewGroup")
	 @CacheLookup
	 public WebElement clk_Search_StudentRacga;

	@FindBy(xpath="//android.widget.EditText[@content-desc='bodyMessage']")
	@CacheLookup
	public WebElement Message_Body;

	@FindBy(xpath="//android.widget.EditText[@content-desc='input-title-message']")
	@CacheLookup
	public WebElement Message_Title;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='sendMessage']")
	@CacheLookup
	public WebElement Send_Message;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Filter']")
	@CacheLookup
	public WebElement Filter_Button;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Arkiv']")
	@CacheLookup
	public WebElement Arkiv_Sent;

	@FindBy(xpath="//android.widget.EditText[@content-desc='searchMessageInput']")
	@CacheLookup
	public WebElement Search_Sent_Msg_EditText;

	@FindBy(xpath="(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]")
	@CacheLookup
	public WebElement Click_Search_Result_SentMail;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Lukket']")
	@CacheLookup
	public WebElement Close_Mail;

	//Logout From inlaa014
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Click_Settings_Tab;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Logg ut']")
	@CacheLookup
	public WebElement Click_Logout;

	@FindBy(xpath="(//android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Mail_Title_Text;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Mottatt']")
	@CacheLookup
	public WebElement Click_Mottatt;

	@FindBy(xpath="(//android.view.ViewGroup[3]/android.widget.TextView)[3]")
	@CacheLookup
	public WebElement get_Expected_Text;

	@FindBy(xpath="(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Expected_Text_TC6;

	//TC4 locators
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Valg']")
	@CacheLookup
	public WebElement click_Valg;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='SMS-melding']")
	@CacheLookup
	public WebElement click_SMS_melding;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc='SMS-varsel']")
	@CacheLookup
	public WebElement click_SMS_varsel;

	@FindBy(xpath="//android.widget.EditText[@text='SMS-melding']")
	@CacheLookup
	public WebElement verify_SMS_melding_edit;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='bodyMessage']")
	@CacheLookup
	public WebElement SMS_Msg_Body;

	//TC5
	@FindBy(xpath = "//android.view.ViewGroup[4]/android.widget.TextView[2]")
	@CacheLookup
	public WebElement get_SMS_Msg_Body;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Spørsmål']")
	@CacheLookup
	public WebElement Click_Sporsmal;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='Skriv spørsmål']")
	@CacheLookup
	public WebElement edit_Sporsmal;

	//TC6
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Kontaktlærer']")
	@CacheLookup
	public WebElement verify_Kontakt;

	@FindBy(xpath = "//android.widget.TextView[@text='Inger Lærer']")
	@CacheLookup
	public WebElement click_Teacher;		

	//TC7
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alela010']/android.widget.TextView")
	@CacheLookup
	public WebElement Select_Parents_Student;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-dependant-dropdown']/android.widget.TextView")
	@CacheLookup
	public WebElement students_list_drop_down;

	//android.widget.TextView[@text='Alexander Elev']

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement schools_drop_down;

	//@FindBy(xpath = "//android.widget.TextView[@text='Ingvild Cgi Atttensen']")
	@FindBy(xpath = "//android.widget.TextView[@text='Cgi I-Cgi']")
	@CacheLookup
	public WebElement Click_Recipient_Contact;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	@CacheLookup
	public WebElement Click_OK;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"alana041\"]")
	@CacheLookup
	public WebElement ClickOnStudentAlana;
	
	//FAT
	@FindBy(xpath = "//android.widget.TextView[@text='Ingvild Cgi Atttensen']")
	@CacheLookup
	public WebElement click_Teacher_Ingvild;

	/**
	 * Selects Recipient Teacher from Drop down
	 * @throws InterruptedException
	 */
	public void selectRecipientTeacher() throws InterruptedException {
		boolean students_list_drop_down_isDisplayed = Base_Class.is_Element_Present(driver, students_list_drop_down, 15);
		if(students_list_drop_down_isDisplayed == true) {
			Select_Parents_Student.click();
			Thread.sleep(2000);
			students_list_drop_down.click();
			//Thread.sleep(2000);
			//schools_drop_down.click();
		}
	}
	
	public void selectStudentFromDropDown() throws InterruptedException {
		ClickOnStudentAlana.click();
		Thread.sleep(3000);
	}

	/**
	 * Click on Filter icon
	 * @throws InterruptedException
	 */
	public void clickOnFilter() throws InterruptedException {
		//boolean Close_Settings_present = Base_Class.is_Element_Present(driver, Click_Settings_Tab, 25);
		//if(Close_Settings_present == true)
		Thread.sleep(8000);
		Filter_Button.click();
		Thread.sleep(2000);
	}

	/**
	 * Click Lesebekreftelse option
	 * @throws InterruptedException
	 */
	//UDEMA-1984 TC2
	public void clickOnLesebekreftelse() throws InterruptedException {
		Click_Lesebekreftelse.click();
		Thread.sleep(2000);
		//clk_Add_Contacts_OK.click();
		//Thread.sleep(8000);
	}

	/**
	 * Click Sporsmal option
	 * @param val NA
	 * @return text of Sporsmal
	 * @throws InterruptedException
	 */
	//UDEMA-1984 TC3
	public String clickOnSpørsmål(String val) throws InterruptedException {
		Click_Spørsmål.click();
		Thread.sleep(2000);
		String text = Click_Spørsmål.getText();
		Thread.sleep(2000);
		return text;
	}
	
	/**
	 * Enter Sporsmal question 
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void enterSporsmalMsg() throws InterruptedException {
		Enter_Msg_in_Sporsmal.sendKeys("Are you coming to School?");
		Thread.sleep(2000);
	}

	/**
	 * Click on OK button
	 * @throws InterruptedException
	 */
	public void clickOnOKButton() throws InterruptedException {
		clk_Add_Contacts_OK.click();
		Thread.sleep(8000);
	}

	/**
	 * Click on mail compose button
	 * @throws InterruptedException
	 */
	public void clickOnMailComposeButton() throws InterruptedException {
		//boolean Close_btn_present = Base_Class.is_Element_Present(driver, Click_Settings_Tab, 15);
		//if(Close_btn_present == true) 
		//clk_Close_Button.click(); // not required this step
		Thread.sleep(4000);
		mail_Compose.click();
		Thread.sleep(2000);
	}

	/**
	 * Click on Svar av toggle button
	 * @throws InterruptedException
	 *
	 **/

	public void clickSvarAvButton() throws InterruptedException {
		if(Click_Svar_av_toggle.getText().equals("Svar av")) {
			System.out.println("Allow Reply is disabled, Enabling it. Current value : "+Click_Svar_av_toggle.getText());
			Click_Svar_av_toggle.click();
			Thread.sleep(2000);
		} else {
			System.out.println("Allow Reply is already enabled. Current value : "+Click_Svar_av_toggle.getText());
			//Click_Svar_av_toggle.click();
		}
	}

	/**
	 * Click on Till button
	 * @throws InterruptedException
	 */
	public void clickOnTillButton() throws InterruptedException {
		Clk_Till.click();
		Thread.sleep(2000);
	}
	
	public void clickOkBtn() throws InterruptedException {
		Click_OK.click();
		Thread.sleep(2000);
	}

	/** 
	 * Click on Velg Skole option
	 * @throws InterruptedException
	 */
	public void clickOnSchoolDropDown() throws InterruptedException {
		clk_Velg_Skole.click();
		Thread.sleep(2000);
	}

	/**
	 * Click on Velg Skole drop down options
	 * @throws InterruptedException
	 */
	public void clickOnSchoolDropDownOptions() throws InterruptedException {
		clk_Velg_Skole_Options.click();
		Thread.sleep(2000);		
	}

	/**
	 * Select Teacher from list and press OK
	 * @throws InterruptedException
	 */
	public void selectTeacherFromList() throws InterruptedException {
		//boolean verify_Kotakt_present = Base_Class.is_Element_Present(driver, verify_Kontakt, 15);
		//if(verify_Kotakt_present == true) 
		Thread.sleep(8000);
		click_Teacher.click();
		Thread.sleep(5000);
		clk_Add_Contacts_OK.click();		
	}

	/**
	 * Click Personer tab
	 * @throws InterruptedException
	 */
	public void clickOnPersonerTab() throws InterruptedException {
		clk_Personer_Tab.click();
		Thread.sleep(2000);
	}

	/** 
	 * Click on Search input box and enter "Alexander"
	 * @throws InterruptedException
	 */
	public void clickOnSearchInputEditText() throws InterruptedException {
		clk_Search_Input.sendKeys("alana041");
		Thread.sleep(15000);
	}

	/** 
	 * Click on Search input box and enter "FAT: Cgi-Racga Testelev "
	 * @throws InterruptedException
	 */

	public void clickOnSearchInputEditTextForStudent() throws InterruptedException {
		clk_Search_Input.sendKeys("racga001");
		Thread.sleep(15000);
	}

	/**
	 * FAT Select student from list and clicks on "Eleven + Foresatte" checkbox for 
	 * @throws InterruptedException
	 */

	public void clickOnSearchResultOfStudentName() throws InterruptedException {
		boolean is_Alela_Displayed = Base_Class.is_Element_Present(driver2, clk_Search_StudentRacga, 10);
		if(is_Alela_Displayed == true) {
			clk_Search_StudentRacga.click();
			Thread.sleep(500);
			clk_Search_StudentRacga.click();
			Thread.sleep(8000);
			clk_Checkbox.click();
			Thread.sleep(2000);
		}

		boolean isCheckbox_selected = Base_Class.is_Element_Present(driver2, verify_Selection, 10);
		if(isCheckbox_selected == true) {
			clk_Add_Contacts_OK.click();
			Thread.sleep(5000);
		}
	}

	/**
	 * Select student from list and clicks on "Eleven + Foresatte" checkbox
	 * @throws InterruptedException
	 */
	public void clickOnSearchResultOfStudent() throws InterruptedException {
		boolean is_Alela_Displayed = Base_Class.is_Element_Present(driver2, clk_Search_Alana041, 10);
		if(is_Alela_Displayed == true) {
			clk_Search_Alana041.click();
			Thread.sleep(500);
			clk_Search_Alana041.click();
			Thread.sleep(8000);
			clk_Checkbox.click();
			Thread.sleep(2000);
		}

		boolean isCheckbox_selected = Base_Class.is_Element_Present(driver2, verify_Selection, 10);
		if(isCheckbox_selected == true) {
			clk_Add_Contacts_OK.click();
			Thread.sleep(5000);
		}		
	}

	/**
	 * Send Message with Message body and Title
	 * @throws InterruptedException
	 */
	public void editMessageAndSendMessage() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver2, Send_Message, 5);
		if(is_Send_Message_Displayed == true) {
			//System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(messageBody);
			Thread.sleep(2000);
			Message_Title.sendKeys(messageTitle);
			Thread.sleep(2000);
			Send_Message.click();
		}
	}

	/**
	 * Send Message with Message body and Title in Foresatte App
	 * @throws InterruptedException
	 */
	public void editMessageAndSendMessageInForesatte() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver, Send_Message, 5);
		if(is_Send_Message_Displayed == true) {
			//System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(messageBody);
			Thread.sleep(2000);
			Message_Title.sendKeys(messageTitle);
			Thread.sleep(2000);
			Send_Message.click();
		}
	}

	/**
	 * Verifies sent message content by opening recent sent mail
	 * @param val Mail title
	 * @return Mail title text
	 * @throws InterruptedException
	 */
	public String verifySentMessage(String val) throws InterruptedException {
		//More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if(is_Filter_Displayed == true) {
			Arkiv_Sent.click();
			Thread.sleep(3000);
			Search_Sent_Msg_EditText.sendKeys(messageBody);
			Thread.sleep(10000);
			Click_Search_Result_SentMail.click();
			Thread.sleep(4000);
			val = get_Mail_Title_Text.getText();
			System.out.println(val);
			Thread.sleep(3000);
			//Close_Mail.click();
			//Thread.sleep(3000);
		}
		return val;
	}

	/**
	 * Verifies sent message content by opening recent sent mail in Foresatte app
	 * @param val Mail title
	 * @return Mail title text
	 * @throws InterruptedException
	 */
	public String verifySentMessageInForesatte(String val) throws InterruptedException {
		//More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver, Filter_Button, 40);
		if(is_Filter_Displayed == true) {
			Arkiv_Sent.click();
			Thread.sleep(3000);
			Search_Sent_Msg_EditText.sendKeys(messageBody);
			Thread.sleep(10000);
			Click_Search_Result_SentMail.click();
			Thread.sleep(4000);
			val = get_Mail_Title_Text.getText();
			System.out.println(val);
			Thread.sleep(3000);
			//Close_Mail.click();
			//Thread.sleep(3000);
		}
		return val;
	}

	/**
	 * Set message body with current timestamp and send message
	 * @throws InterruptedException
	 * TODO
	 */
	public void editMessageAndSendMessageForTC4() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver2, Send_Message, 5);
		if(is_Send_Message_Displayed == true) {
			//System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(messageBody);
			Thread.sleep(2000);
			//Message_Title.sendKeys(Msg_Title);
			//Thread.sleep(2000);
			Send_Message.click();
		}
	}

	/**
	 * Navigate to Arkiv Sendt, Searches for a mail, open it and get message body text
	 * @param val
	 * @return Message body text
	 * @throws InterruptedException
	 */
	public String verifySentMessageForTC4(String val) throws InterruptedException {
		//More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if(is_Filter_Displayed == true) {
			Arkiv_Sent.click();
			Thread.sleep(3000);
			Search_Sent_Msg_EditText.sendKeys(messageBody);
			//SMS_Msg_Body.sendKeys(Msg_Body);
			Thread.sleep(10000);
			Click_Search_Result_SentMail.click();
			Thread.sleep(4000);
			val = get_SMS_Msg_Body.getText();
			System.out.println(val);
			Thread.sleep(3000);
			Close_Mail.click();
			Thread.sleep(3000);
		}
		return val;	
	}

	/**
	 * Get actual text from Mail title
	 * @param val
	 * @return Mail title text
	 * @throws InterruptedException
	 */
	public String getActualResult(String val) throws InterruptedException {
		Thread.sleep(2000);
		val = get_Mail_Title_Text.getText();
		Close_Mail.click();
		Thread.sleep(3000);
		return val;
	}

	/**
	 * Go to settings and click logout
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

	/**
	 * Go to settings and click logout in Foresatte app
	 * @throws InterruptedException
	 */
	public void logoutInForesatte() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver, Click_Settings_Tab, 40);
		if (is_SettingsTab_Displayed == true) {
			Thread.sleep(3000);
		}
		Click_Settings_Tab.click();

		System.out.println("Settings");
		Thread.sleep(3000);
		
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.longPress(PointOption.point(460, 1240)).moveTo(PointOption.point(480, 140)).release().perform();
		
		System.out.println("Scrolling done");
		Click_Logout.click();
		System.out.println("Logouttttttttttt");}

	/**
	 * Navigate to Arkiv Mottatt folder, Search for a mail with msg title and open it
	 * @throws InterruptedException
	 */
	public void clickOnArkiv() throws InterruptedException {
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if(is_Filter_Displayed == true) {
			Arkiv_Sent.click();
			Thread.sleep(2000);
			Click_Mottatt.click();
			Thread.sleep(4000);
			//Search_Sent_Msg_EditText.click();
			Search_Sent_Msg_EditText.sendKeys(messageTitle);
			Thread.sleep(8000);
			Click_Search_Result_SentMail.click();	
		}
	}

	/**
	 * Navigate to Arkiv Mottatt folder, Search and click on sent mail
	 * @throws InterruptedException
	 * TODO
	 */
	public void clickOnArkivForTC5() throws InterruptedException {
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if(is_Filter_Displayed == true) {
			Arkiv_Sent.click();
			Thread.sleep(2000);
			Click_Mottatt.click();
			Thread.sleep(4000);
			//Search_Sent_Msg_EditText.click();
			Search_Sent_Msg_EditText.sendKeys(messageBody);
			Thread.sleep(8000);
			Click_Search_Result_SentMail.click();	
		}
	}

	/**
	 * Get expected Result text
	 * @param val
	 * @return expected text 
	 * @throws InterruptedException 
	 */
	public String getExpectedResult(String val) throws InterruptedException {
		boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
		if(is_Text_Displayed == true) {
			val = get_Expected_Text_TC6.getText();
			Close_Mail.click();
			Thread.sleep(2000);
		}
		System.out.println(val);
		return val;
	}

	/**
	 * Get expected text of mail title
	 * @param val
	 * @return Mail title text
	 * TODO
	 */
	public String getExpectedResultForTC2(String val) {
		boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
		if(is_Text_Displayed == true) {
			val = get_Mail_Title_Text.getText();
			System.out.println(val);
		}
		return val;
	}

	/**
	 * Get expected text of mail body
	 * @param val
	 * @return Mail text body
	 * TODO
	 */
	public String getExpectedResultForTC4(String val) {
		boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
		if(is_Text_Displayed == true) {
			val = get_SMS_Msg_Body.getText();
			System.out.println(val);
			Close_Mail.click();
		}
		return val;
	}

	/**
	 * Click on Valg option
	 * @throws InterruptedException 
	 */
	public void clickOnValgOption() throws InterruptedException {
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, Clk_Till, 10);
		if(is_Till_Displayed == true) {
			click_Valg.click();
			Thread.sleep(2000);
		}
	}

	/**
	 * Click on SMS melding option
	 * @throws InterruptedException
	 */
	public void clickOnSMSMelding() throws InterruptedException {
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, clk_Add_Contacts_OK, 10);
		if(is_Till_Displayed == true) {
			click_SMS_melding.click();
			Thread.sleep(2000);
		}
	}

	/**
	 * Click on SMS melding option
	 * @throws InterruptedException
	 */
	public void clickOnSMSVarsel() throws InterruptedException {
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, clk_Add_Contacts_OK, 15);
		if(is_Till_Displayed == true) {
			//click_SMS_melding.click();
			click_SMS_varsel.click();
			Thread.sleep(2000);
			//			Click_Sporsmal.click();
			//			Thread.sleep(2000);
			//			edit_Sporsmal.sendKeys("test question");
			//			Thread.sleep(2000);
			clk_Add_Contacts_OK.click();
		}
	}

	/**
	 * Send Message body with current timestamp
	 * @param val
	 */
	public void checkForSMSMeldingAndSendMessage(String val) {
		boolean is_SMS_Melding_Displayed = Base_Class.is_Element_Present(driver2, verify_SMS_melding_edit, 10);
		if(is_SMS_Melding_Displayed == true) {
			SMS_Msg_Body.sendKeys(messageBody);
			System.out.println("Test");
		}
		//return val;
	}

	/**
	 * Click on Send Message
	 * @throws InterruptedException
	 */
	public void clickOnSendMessage() throws InterruptedException {
		Send_Message.click();
		Thread.sleep(10000);
	}

	/**
	 * Select contact from a list
	 * @throws InterruptedException
	 */
	//patil
	public void selectContactFromList() throws InterruptedException {
		//boolean verify_Kotakt_present = Base_Class.is_Element_Present(driver, verify_Kontakt, 15);
		//if(verify_Kotakt_present == true) 
		Thread.sleep(8000);
		Click_Recipient_Contact.click();
		Thread.sleep(5000);
		clk_Add_Contacts_OK.click();

	}
	
	/**
	 * FAT : Select Teacher from list and press OK
	 * @throws InterruptedException
	 */
	public void selectTeacherIngvildFromList() throws InterruptedException {
		//boolean verify_Kotakt_present = Base_Class.is_Element_Present(driver, verify_Kontakt, 15);
		//if(verify_Kotakt_present == true) 
		Thread.sleep(8000);
		click_Teacher_Ingvild.click();
		Thread.sleep(5000);
		clk_Add_Contacts_OK.click(); 
	}

}
