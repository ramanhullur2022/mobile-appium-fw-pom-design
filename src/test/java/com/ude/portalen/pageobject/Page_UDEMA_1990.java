package com.ude.portalen.pageobject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Page_UDEMA_1990 extends Base_Class {

	public Page_UDEMA_1990(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	static LocalDateTime currentDateTime = LocalDateTime.now();
	public static String messageBody = "inlaa014 msg_body" + dateTimeFormat.format(currentDateTime);
	public static String messageTitle = "inlaa014 msg_title" + dateTimeFormat.format(currentDateTime);
	public static String replyMessage = "Teacher Reply Message " + dateTimeFormat.format(currentDateTime);

	public static String replyFromTeacherToStudent = "Teacher to Student Reply Msg ";
	public static String replyFromStudentToTeacher = "Student to Teacher Reply Msg ";
	public static String replyFromParentToTeacher = "Parent to Teacher Reply Msg ";
	ReadConfig config = new ReadConfig();
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alert-close-icon']")
	@CacheLookup
	public WebElement clickCloseButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Lesebekreftelse']")
	@CacheLookup
	public WebElement Click_Lesebekreftelse;

	@FindBy(xpath = "//android.widget.TextView[@text='Spørsmål']")
	@CacheLookup
	public WebElement Click_Spørsmål;

	@FindBy(xpath = "//android.widget.TextView[@text='Spørsmål']")
	@CacheLookup
	public WebElement Click_Spørsmål1;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Filter']/android.widget.ImageView")
	@CacheLookup
	public WebElement Click_Post_Filter;

	//@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='isReplyAllowed']")
	@CacheLookup
	public WebElement clickSvarAvToggleBtn;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"isReplyAllowed\"]/android.widget.TextView")
	@CacheLookup
	public WebElement svarAvToggleBtnStatus;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Skriv melding']")
	@CacheLookup
	public WebElement mail_Compose;

	@FindBy(xpath = "//android.widget.TextView[@text='Til']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-till']")
	@CacheLookup
	public WebElement Clk_Till;

	@FindBy(xpath = "//android.widget.TextView[@text='Velg Skole']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement clk_Velg_Skole;

	//Author : S, Manjunath
	@FindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")
	@CacheLookup
	public WebElement click_School_Dropdown_parent;

	@FindBy(xpath = "//android.widget.TextView[@text='CGI testgrunnskole']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ZGS']/android.widget.TextView")
	@CacheLookup
	public WebElement clk_Velg_Skole_Options;

	@FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Personer']")
	@CacheLookup
	public WebElement clk_Personer_Tab;

	@FindBy(xpath = "//android.widget.EditText[@text='Søk i personer']")
	//original//@FindBy(xpath = "//android.widget.EditText[@content-desc='search-input-contact']")
	@CacheLookup
	public WebElement clk_Search_Input;

	@FindBy(xpath = "//android.widget.ScrollView")
	@CacheLookup
	public WebElement scrollView_students;

	@FindBy(xpath = "//android.widget.TextView[@text='Alexander Elev']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alela010']/android.view.ViewGroup")
	@CacheLookup
	public WebElement clk_Search_Alela010;

	@FindBy(xpath = "//android.widget.TextView[@text='CGI-alana Testelev']")
	@CacheLookup
	public WebElement clk_Search_CGI_alana;

	@FindBy(xpath = "//android.widget.TextView[@text='Eleven + Foresatte']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Eleven + Foresatte']")
	@CacheLookup
	public WebElement clk_Checkbox;
	
	//FAT
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"alana032\"]/android.view.ViewGroup")
	@CacheLookup
	public WebElement clk_Search_StudentRacga;

	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	@CacheLookup
	public WebElement verify_Selection;

	@FindBy(xpath = "//android.widget.TextView[@text='OK']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='addContactText']")
	@CacheLookup
	public WebElement clk_Add_Contacts_OK;

	//@FindBy(xpath = "//android.widget.EditText[@text='Meldingstekst']")
	//original//@FindBy(xpath = "//android.widget.EditText[@content-desc='bodyMessage']")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Meldingstekst. Dobbeltklikk for å legge meldingstekst. Send ikke sensitiv informasjon, f.eks. helseopplysninger i meldingen.\"]/android.widget.EditText")
	@CacheLookup
	public WebElement Message_Body;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Dobbeltklikk for å legge emne\"]/android.widget.EditText")
	//original//@FindBy(xpath = "//android.widget.EditText[@content-desc='input-title-message']")
	@CacheLookup
	public WebElement Message_Title;

	@FindBy(xpath = "//android.widget.TextView[@text='Send']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='sendMessage']")
	@CacheLookup
	public WebElement Send_Message;

	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Filter']")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Filter\"]/android.view.ViewGroup/android.widget.TextView")
	@CacheLookup
	public WebElement Filter_Button;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Arkiv']")
	@CacheLookup
	public WebElement Arkiv_Sent;

	@FindBy(xpath = "//android.widget.EditText[@text='Søk i meldinger']")
	//original//@FindBy(xpath = "//android.widget.EditText[@content-desc='searchMessageInput']")
	@CacheLookup
	public WebElement Search_Sent_Msg_EditText;

	@FindBy(xpath = "//android.widget.EditText[@text='Søk i meldinger']")
	@CacheLookup
	public WebElement Search_Received_Msg_EditText;

	//original//@FindBy(xpath = "(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]")
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
	@CacheLookup
	public WebElement Click_Search_Result_SentMail;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
	@CacheLookup
	public WebElement Click_Search_Result_ReceivedMail;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Lukket\"]/android.view.ViewGroup/android.widget.TextView")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Lukket']")
	@CacheLookup
	public WebElement Close_Mail;

	// Logout From inlaa014
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Click_Settings_Tab;

	@FindBy(xpath = "//android.widget.TextView[@text='Logg ut']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Logg ut']")
	@CacheLookup
	public WebElement Click_Logout;

	@FindBy(xpath = "(//android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Mail_Title_Text;

	@FindBy(xpath="//android.widget.TextView[@text='Mottatt']")
	//original//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Mottatt']")
	@CacheLookup
	public WebElement Click_Mottatt;

	@FindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")
	@CacheLookup
	public WebElement get_reply_from_Teacher;

	@FindBy(xpath = "(//android.view.ViewGroup[3]/android.widget.TextView)[3]")
	@CacheLookup
	public WebElement get_Expected_Text;

	@FindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Expected_Text_TC6;

	@FindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Expected_Text_1990_TC1;

	// TC4 locators
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Valg']")
	@CacheLookup
	public WebElement click_Valg;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='SMS-melding']")
	@CacheLookup
	public WebElement click_SMS_melding;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='SMS-varsel']")
	@CacheLookup
	public WebElement click_SMS_varsel;

	@FindBy(xpath = "//android.widget.EditText[@text='SMS-melding']")
	@CacheLookup
	public WebElement verify_SMS_melding_edit;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='bodyMessage']")
	@CacheLookup
	public WebElement SMS_Msg_Body;

	// TC5
	@FindBy(xpath = "//android.view.ViewGroup[4]/android.widget.TextView[2]")
	@CacheLookup
	public WebElement get_SMS_Msg_Body;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Spørsmål']")
	@CacheLookup
	public WebElement Click_Sporsmal;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='Skriv spørsmål']")
	@CacheLookup
	public WebElement edit_Sporsmal;

	// TC6
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Kontaktlærer']")
	@CacheLookup
	public WebElement verify_Kontakt;

	@FindBy(xpath = "//android.widget.TextView[@text='Inger Lærer']")
	@CacheLookup
	public WebElement click_Teacher;

	// TC7
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alela010']/android.widget.TextView")
	@CacheLookup
	public WebElement Select_Parents_Student;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-dependant-dropdown']/android.widget.TextView")
	@CacheLookup
	public WebElement students_list_drop_down;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement schools_drop_down;

	// Reply Msg TC-1990
	@FindBy(xpath = "(//android.widget.EditText)[1]")
	// android.widget.EditText[@content-desc="Skriv svar her. Dobbeltklikk for å
	// skrive svar"]
	@CacheLookup
	public WebElement Edit_Reply_Msg;

	@FindBy(xpath = "//android.widget.TextView[@text='Send']")
	@CacheLookup
	public WebElement Send_Reply_Msg;

	@FindBy(xpath = "//android.widget.TextView[@text='I dag']")
	@CacheLookup
	public WebElement Verify_Msg_Sent;

	@FindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2])[2]")
	@CacheLookup
	public WebElement Replied_Msg;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
	@CacheLookup
	public WebElement Click_Reply;

	@FindBy(xpath = "//android.widget.TextView[@text='Teacher to Student Reply Msg ']")
	@CacheLookup
	public WebElement Received_Reply_Msg_Frm_Teacher_To_Student;

	@FindBy(xpath = "//android.widget.TextView[@text='Student to Teacher Reply Msg ']")
	@CacheLookup
	public WebElement Received_Reply_Msg_Frm_Student_To_Teacher;

	@FindBy(xpath = "//android.widget.TextView[@text='Parent to Teacher Reply Msg ']")
	@CacheLookup
	public WebElement Received_Reply_Msg_Frm_Parent_To_Teacher;
	
	//FAT
	@FindBy(xpath = "//android.widget.TextView[@text='Ingvild Cgi Atttensen']")
	@CacheLookup
	public WebElement click_Teacher_Ingvild; 

	/**
	 * Clicks on Mail Compose button
	 * @throws InterruptedException
	 */
	public void clickOnMailComposeButton() throws InterruptedException {
		// boolean Close_btn_present = Base_Class.is_Element_Present(driver,
		// Click_Settings_Tab, 15);
		// if(Close_btn_present == true)
		// clk_Close_Button.click(); // not required this step
		Thread.sleep(4000);
		mail_Compose.click();
		Thread.sleep(2000);
	}

	/**
	 * Clicks on Svar av toggle button
	 * @throws InterruptedException
	 */
	public void clickSvarAvButton() throws InterruptedException {
		if(svarAvToggleBtnStatus.getText().equals("Svar av")) {
			System.out.println("Allow Reply is disabled, Enabling it. Current value : "+svarAvToggleBtnStatus.getText());
			clickSvarAvToggleBtn.click();
			Thread.sleep(2000);
		} else {
			System.out.println("Allow Reply is already enabled. Current value : "+svarAvToggleBtnStatus.getText());
		}
	}

	/**
	 * Clicks on Till Button
	 * @throws InterruptedException
	 */
	public void clickOnTillButton() throws InterruptedException {
		Clk_Till.click();
		Thread.sleep(2000);
	}

	/**
	 * Clicks on School Drop down - Velg Skole
	 * @throws InterruptedException
	 */
	public void clickOnSchoolDropDown(String from) throws InterruptedException {
		if(config.get_student_username().equals("alana041")) {
			if(from.equals("Teacher")) {
				clk_Velg_Skole.click();
				Thread.sleep(2000);
			} else if(from.equals("Student")) {
				System.out.println("Student is "+config.get_student_username()+". Skipping drop down selection");
			} else {
				clk_Velg_Skole.click();
				Thread.sleep(2000);
			}
		}
	}

	/**
	 * Clicks on CGI testgrunnskole under School Drop down
	 * @throws InterruptedException
	 */
	public void clickOnSchoolDropDownOptions(String from) throws InterruptedException {
		if(config.get_student_username().equals("alana041")) {
			if(from.contentEquals("Teacher")) {
				clk_Velg_Skole_Options.click();
				Thread.sleep(2000);
			} else if(from.equals("Student")) {
				System.out.println("Student is "+config.get_student_username()+". Skipping drop down option selection");
			}
		} else {
			clk_Velg_Skole_Options.click();
			Thread.sleep(2000);
		}
	}

	/**
	 * Select 'Inger Lærer' teacher from teacher list and press OK
	 * @throws InterruptedException
	 */
	public void selectTeacherFromList() throws InterruptedException {
		// boolean verify_Kotakt_present = Base_Class.is_Element_Present(driver,
		// verify_Kontakt, 15);
		// if(verify_Kotakt_present == true)
		Thread.sleep(12000);
		click_Teacher.click();
		Thread.sleep(5000);
		clk_Add_Contacts_OK.click();
	}

	/**
	 * Click on Personer Tab
	 * @throws InterruptedException
	 */
	public void clickOnPersonerTab() throws InterruptedException {
		clk_Personer_Tab.click();
		Thread.sleep(2000);
	}

	/**
	 * Clicks on Search Input edit text and input name passed
	 * @param name : Name which should be sent
	 * @throws InterruptedException
	 */
	public void clickSearchInputEditText(String name) throws InterruptedException {
		clk_Search_Input.sendKeys(name);
		Thread.sleep(15000);
	}

	/**
	 * Click on Name listed from Search Result
	 * @throws InterruptedException
	 */
	public void clickSearchResultStudent() throws InterruptedException {
		//		boolean is_Alela_Displayed = Base_Class.is_Element_Present(driver2, clk_Search_Alela010, 10);
		//		if (is_Alela_Displayed == true) {
		//			clk_Search_Alela010.click();
		//		}
		boolean is_CGI_alana_displayed = Base_Class.is_Element_Present(driver2, clk_Search_CGI_alana, 10);
		if (is_CGI_alana_displayed == true) {
			clk_Search_CGI_alana.click();
		}
		Thread.sleep(500);
		//clk_Search_Alela010.click();
		clk_Search_CGI_alana.click();
		Thread.sleep(8000);
		clk_Checkbox.click();
		Thread.sleep(2000);

		boolean isCheckbox_selected = Base_Class.is_Element_Present(driver2, verify_Selection, 10);
		if (isCheckbox_selected == true) {
			clk_Add_Contacts_OK.click();
		}
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
	 * Enters Message Body and Message Title with current timestamp
	 * @throws InterruptedException
	 */
	public void editMsgAndSendMsg() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver2, Send_Message, 5);
		if (is_Send_Message_Displayed == true) {
			Message_Body.sendKeys(messageBody);
			Thread.sleep(2000);
			Message_Title.sendKeys(messageTitle);
			Thread.sleep(2000);
			Send_Message.click();
		}
	}

	/**
	 * Search for Mail with Message Body, Click on it and Close the mail
	 * @param val 
	 * @return Mail Title text
	 * @throws InterruptedException
	 */
	public String verifySentMessage(String val) throws InterruptedException {
		// More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if (is_Filter_Displayed == true) {
			Arkiv_Sent.click();
		}
		Thread.sleep(3000);
		Search_Sent_Msg_EditText.sendKeys(messageBody);
		Thread.sleep(10000);
		Click_Search_Result_SentMail.click();
		Thread.sleep(4000);
		val = get_Mail_Title_Text.getText();
		System.out.println(val);
		Thread.sleep(3000);
		Close_Mail.click();
		// Thread.sleep(3000);
		return val;
	}

	/**
	 * Navigates to Settings and clicks on Logout
	 * @throws InterruptedException
	 */
	public void logout() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Settings_Tab, 40);
		if (is_SettingsTab_Displayed == true) {
			Thread.sleep(3000);
		}
		Click_Settings_Tab.click();

		System.out.println("Settings");
		Thread.sleep(3000);
		
		Click_Logout.click();
		System.out.println("Logouttttttttttt");
	}
	
	/**
	 * Navigates to Settings, Scrolls for logout option and clicks on logout
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void logoutFromParent() throws InterruptedException {
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
		System.out.println("Logouttttttttttt");
	}

	/**
	 * Clicks on Arkiv Folder
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void clickArkivFolder() throws InterruptedException {
		//boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		//if (is_Filter_Displayed == true)
		Arkiv_Sent.click();
		Thread.sleep(15000);
	}

	/**
	 * Clicks on Mottatt Folder
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void clickMottatt() throws InterruptedException {
		Click_Mottatt.click();
		Thread.sleep(15000);
	}

	/**
	 * Clicks on Arkiv Mottatt folder, Searches for Msg Title with current timestamp and clicks it
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void searchReceivedMsgAndClick() throws InterruptedException {
		Arkiv_Sent.click();
		Thread.sleep(15000);
		Click_Mottatt.click();
		Thread.sleep(15000);
		Search_Sent_Msg_EditText.sendKeys(messageTitle);
		Thread.sleep(15000);
		Click_Search_Result_SentMail.click();
		Thread.sleep(15000);
	}

	/**
	 * Sends Reply to Received message based on replyType
	 * @author S, Manjunath
	 * @param replyType Specifies type of reply
	 * @throws InterruptedException
	 */
	public void sendReplyToReceivedMsg(String replyType) throws InterruptedException {
		Edit_Reply_Msg.click();
		Thread.sleep(5000);
		if(replyType.equals("Student")) {
			Edit_Reply_Msg.sendKeys(replyFromStudentToTeacher);
		} else if(replyType.equals("Teacher")){
			Edit_Reply_Msg.sendKeys(replyFromTeacherToStudent);	
		} else if(replyType.equals("Parent")) {
			Edit_Reply_Msg.sendKeys(replyFromParentToTeacher);
		}
		Thread.sleep(5000);
		Send_Reply_Msg.click();
		Thread.sleep(10000);
		Close_Mail.click();
		Thread.sleep(5000);
	}

	/**
	 * Verify Reply received
	 * @author S, Manjunath
	 * @param replyType Specifies type of reply
	 * @return True or False based on Reply verification
	 * @throws InterruptedException
	 */
	public boolean verifyReplyReceived(String replyType) throws InterruptedException {
		boolean testResult = false;
		Thread.sleep(10000);
		String expectedReply = "", actualReply = "";
		if(replyType.equals("Student")) {
			expectedReply = replyFromStudentToTeacher;
			actualReply = Received_Reply_Msg_Frm_Student_To_Teacher.getText();
		} else if(replyType.equals("Teacher")){
			expectedReply = replyFromTeacherToStudent;
			actualReply = Received_Reply_Msg_Frm_Teacher_To_Student.getText();
		} else if(replyType.equals("Parent")) {
			expectedReply = replyFromParentToTeacher;
			actualReply = Received_Reply_Msg_Frm_Parent_To_Teacher.getText();
		}

		if(expectedReply.equals(actualReply)) {
			testResult = true;
			System.out.println("Reply is matching in received mail");
		}
		return testResult;
	}
	
	/**
	 * FAT : Select Teacher 'Ingvild' from list and press OK
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
