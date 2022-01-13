package com.ude.portalen.pageobject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.utilities.ReadConfig;

public class Page_UDEMA_1986 extends Base_Class {

	public Page_UDEMA_1986(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	ReadConfig config = new ReadConfig();
	public String student_username2 = config.get_student_username();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();
	public String Msg_Body = "ParentToTeacher" + dtf.format(now);
	public String Msg_Title = "ParentToTeacher" + dtf.format(now);

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alert-close-icon']")
	@CacheLookup
	public WebElement clk_Close_Button;

	@FindBy(xpath = "//android.widget.TextView[@text='Lesebekreftelse']")
	@CacheLookup
	public WebElement Click_Lesebekreftelse;

	@FindBy(xpath = "//android.widget.TextView[@text='Spørsmål']")
	@CacheLookup
	public WebElement Click_Spørsmål;

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

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alela010']/android.view.ViewGroup")
	@CacheLookup
	public WebElement clk_Search_Alela010;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='tttta006']/android.view.ViewGroup")
	@CacheLookup
	public WebElement clk_Search_ttta006;
	
	

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Eleven + Foresatte']")
	@CacheLookup
	public WebElement clk_Checkbox;

	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	@CacheLookup
	public WebElement verify_Selection;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='addContactText']")
	@CacheLookup
	public WebElement clk_Add_Contacts_OK;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='bodyMessage']")
	@CacheLookup
	public WebElement Message_Body;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='input-title-message']")
	@CacheLookup
	public WebElement Message_Title;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='sendMessage']")
	@CacheLookup
	public WebElement Send_Message;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Filter']")
	@CacheLookup
	public WebElement Filter_Button;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Arkiv']")
	@CacheLookup
	public WebElement Arkiv_Sent;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='searchMessageInput']")
	@CacheLookup
	public WebElement Search_Sent_Msg_EditText;

	@FindBy(xpath = "(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]")
	@CacheLookup
	public WebElement Click_Search_Result_SentMail;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Lukket']")
	@CacheLookup
	public WebElement Close_Mail;

	// Logout From inlaa014
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Click_Settings_Tab;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Logg ut']")
	@CacheLookup
	public WebElement Click_Logout;

	@FindBy(xpath = "(//android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Mail_Title_Text;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Mottatt']")
	@CacheLookup
	public WebElement Click_Mottatt;

	@FindBy(xpath = "(//android.view.ViewGroup[3]/android.widget.TextView)[3]")
	@CacheLookup
	public WebElement get_Expected_Text;

	@FindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView)[2]")
	@CacheLookup
	public WebElement get_Expected_Text_TC6;

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
	//@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alela010']/android.widget.TextView")
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alana041']/android.widget.TextView")
	@CacheLookup
	public WebElement Select_Parents_Student;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-dependant-dropdown']/android.widget.TextView")
	@CacheLookup
	public WebElement students_list_drop_down;

	// android.widget.TextView[@text='Alexander Elev']

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement schools_drop_down;
	
	
	

	public void select_Receipint_Teacher() throws InterruptedException {
		boolean students_list_drop_down_isDisplayed = Base_Class.is_Element_Present(driver, students_list_drop_down,
				15);
		if (students_list_drop_down_isDisplayed == true) {
			Select_Parents_Student.click();
		}
		Thread.sleep(2000);
		students_list_drop_down.click();
		// Thread.sleep(2000);
		// schools_drop_down.click();
	}
	
	public void select_Receipint_Teacher_New() throws InterruptedException {
		//boolean students_list_drop_down_isDisplayed = Base_Class.is_Element_Present(driver, students_list_drop_down, 15);
		//if(students_list_drop_down_isDisplayed == true) {
			Select_Parents_Student.click();
			Thread.sleep(8000);
			click_Teacher.click();
			Thread.sleep(3000);
			clk_Add_Contacts_OK.click();
			Thread.sleep(3000);
		//}
	}
	
	

	public void click_Filter() throws InterruptedException {
		// boolean Close_Settings_present = Base_Class.is_Element_Present(driver,
		// Click_Settings_Tab, 25);
		// if(Close_Settings_present == true)
		Thread.sleep(8000);
		Filter_Button.click();
		Thread.sleep(2000);
	}

	// UDEMA-1984 TC2
	public void click_Lesebekreftelse() throws InterruptedException {
		Click_Lesebekreftelse.click();
		Thread.sleep(2000);
		// clk_Add_Contacts_OK.click();
		// Thread.sleep(8000);
	}

	// UDEMA-1984 TC3
	public String click_Spørsmål(String val) throws InterruptedException {
		Click_Spørsmål.click();
		Thread.sleep(2000);
		String text = Click_Spørsmål.getText();
		Thread.sleep(2000);
		return text;
	}

	public void click_OK_Filter() throws InterruptedException {
		clk_Add_Contacts_OK.click();
		Thread.sleep(8000);
	}

	public void clickOnMailComposeButton() throws InterruptedException {
		// boolean Close_btn_present = Base_Class.is_Element_Present(driver,
		// Click_Settings_Tab, 15);
		// if(Close_btn_present == true)
		// clk_Close_Button.click(); // not required this step
		Thread.sleep(4000);
		mail_Compose.click();
		Thread.sleep(2000);
	}

	public void click_Svar_av() throws InterruptedException {
		Click_Svar_av_toggle.click();
		Thread.sleep(2000);
	}

	public void clickOnTillButton() throws InterruptedException {
		Clk_Till.click();
		Thread.sleep(2000);
	}

	public void clickOnSchoolDropDown() throws InterruptedException {
		clk_Velg_Skole.click();
		Thread.sleep(2000);
	}

	public void clickOnSchoolDropDownOptions() throws InterruptedException {
		clk_Velg_Skole_Options.click();
		Thread.sleep(2000);
	}

	public void select_Teacher_from_list() throws InterruptedException {
		// boolean verify_Kotakt_present = Base_Class.is_Element_Present(driver,
		// verify_Kontakt, 15);
		// if(verify_Kotakt_present == true)
		Thread.sleep(8000);
		click_Teacher.click();
		Thread.sleep(5000);
		clk_Add_Contacts_OK.click();
	}

	public void clickOnPersonerTab() throws InterruptedException {
		Thread.sleep(2000);
		clk_Personer_Tab.click();
		Thread.sleep(2000);
	}

	public void click_Search_Input_editText() throws InterruptedException {
		clk_Search_Input.sendKeys("alela010");
		Thread.sleep(15000);
	}
	
	public void click_Search_Input_editText_testcase3() throws InterruptedException {
		clk_Search_Input.sendKeys("tttta006");
		Thread.sleep(15000);
	}

	public void click_Search_Result_Student() throws InterruptedException {
		boolean is_Alela_Displayed = Base_Class.is_Element_Present(driver2, clk_Search_Alela010, 10);
		if (is_Alela_Displayed == true) {
			clk_Search_Alela010.click();
		}
		Thread.sleep(500);
		clk_Search_Alela010.click();
		Thread.sleep(8000);
		clk_Checkbox.click();
		Thread.sleep(2000);

		boolean isCheckbox_selected = Base_Class.is_Element_Present(driver2, verify_Selection, 10);
		if (isCheckbox_selected == true) {
			clk_Add_Contacts_OK.click();
		}
	}


	public void click_Search_Result_Student2() throws InterruptedException {
		boolean is_tttta_Displayed = Base_Class.is_Element_Present(driver2, clk_Search_ttta006, 10);
		if (is_tttta_Displayed == true) {
			clk_Search_ttta006.click();
		}
		Thread.sleep(1000);
		clk_Search_ttta006.click();
		Thread.sleep(8000);
		clk_Checkbox.click();
		Thread.sleep(2000);

		boolean isCheckbox_selected = Base_Class.is_Element_Present(driver2, verify_Selection, 10);
		if (isCheckbox_selected == true) {
			clk_Add_Contacts_OK.click();
		}
	}
	

	public void edit_Msg_And_send_Msg() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver2, Send_Message, 5);
		if (is_Send_Message_Displayed == true) {
			// System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(Msg_Body);
			Thread.sleep(2000);
			Message_Title.sendKeys(Msg_Title);
			Thread.sleep(2000);
			Send_Message.click();
		}
	}

	public void edit_Msg_And_send_Msg_Foresatte() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver, Send_Message, 5);
		if (is_Send_Message_Displayed == true) {
			// System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(Msg_Body);
			Thread.sleep(2000);
			Message_Title.sendKeys(Msg_Title);
			Thread.sleep(2000);
			Send_Message.click();
		}
	}

	public String verify_Sent_Message(String val) throws InterruptedException {
		// More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if (is_Filter_Displayed == true) {
			Arkiv_Sent.click();
		}
		Thread.sleep(3000);
		Search_Sent_Msg_EditText.sendKeys(Msg_Body);
		Thread.sleep(10000);
		Click_Search_Result_SentMail.click();
		Thread.sleep(4000);
		val = get_Mail_Title_Text.getText();
		System.out.println(val);
		Thread.sleep(3000);
		// Close_Mail.click();
		// Thread.sleep(3000);
		return val;
	}

	public String verify_Sent_Message_Foresatte(String val) throws InterruptedException {
		// More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver, Filter_Button, 40);
		if (is_Filter_Displayed == true) {
			Arkiv_Sent.click();
		}
		Thread.sleep(3000);
		Search_Sent_Msg_EditText.sendKeys(Msg_Body);
		Thread.sleep(10000);
		Click_Search_Result_SentMail.click();
		Thread.sleep(4000);
		val = get_Mail_Title_Text.getText();
		System.out.println(val);
		Thread.sleep(3000);
		// Close_Mail.click();
		// Thread.sleep(3000);
		return val;
	}

	public void edit_Msg_And_send_Msg_TC4() throws InterruptedException {
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver2, Send_Message, 5);
		if (is_Send_Message_Displayed == true) {
			// System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(Msg_Body);
			Thread.sleep(2000);
			// Message_Title.sendKeys(Msg_Title);
			// Thread.sleep(2000);
			Send_Message.click();
		}
	}

	public String verify_Sent_Message_TC4(String val) throws InterruptedException {
		// More time taking to send Msg
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if (is_Filter_Displayed == true) {
			Arkiv_Sent.click();
		}
		Thread.sleep(3000);
		Search_Sent_Msg_EditText.sendKeys(Msg_Body);
		// SMS_Msg_Body.sendKeys(Msg_Body);
		Thread.sleep(10000);
		Click_Search_Result_SentMail.click();
		Thread.sleep(4000);
		val = get_SMS_Msg_Body.getText();
		System.out.println(val);
		Thread.sleep(3000);
		Close_Mail.click();
		Thread.sleep(3000);
		return val;
	}

	public String get_Actual_Result(String val) throws InterruptedException {
		val = get_Mail_Title_Text.getText();
		Close_Mail.click();
		Thread.sleep(3000);
		return val;
	}

	public void logout() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Settings_Tab, 40);
		if (is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
		}
		Thread.sleep(3000);
		Click_Logout.click();
	}

	public void logout_Foresatte() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver, Click_Settings_Tab, 40);
		if (is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
		}
		Thread.sleep(3000);
		Click_Logout.click(); // work on logout scroll
	}

	public void click_Arkiv() throws InterruptedException {
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if (is_Filter_Displayed == true) {
			Arkiv_Sent.click();
		}
		Thread.sleep(2000);
		Click_Mottatt.click();
		Thread.sleep(4000);
		// Search_Sent_Msg_EditText.click();
		Search_Sent_Msg_EditText.sendKeys(Msg_Title);
		Thread.sleep(8000);
		Click_Search_Result_SentMail.click();
	}

	public void click_Arkiv_TC5() throws InterruptedException {
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver2, Filter_Button, 40);
		if (is_Filter_Displayed == true) {
			Arkiv_Sent.click();
		}
		Thread.sleep(2000);
		Click_Mottatt.click();
		Thread.sleep(4000);
		// Search_Sent_Msg_EditText.click();
		Search_Sent_Msg_EditText.sendKeys(Msg_Body);
		Thread.sleep(8000);
		Click_Search_Result_SentMail.click();
	}

	public String expected_Result(String val) {
		boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
		if (is_Text_Displayed == true) {
			val = get_Expected_Text_TC6.getText();
		}
		System.out.println(val);
		return val;
	}

	public String expected_Result_TC2(String val) {
		boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
		if (is_Text_Displayed == true) {
			val = get_Mail_Title_Text.getText();
		}
		System.out.println(val);
		return val;
	}

	public String expected_Result_TC4(String val) {
		boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
		if (is_Text_Displayed == true) {
			val = get_SMS_Msg_Body.getText();
		}
		System.out.println(val);
		return val;
	}

	public void click_Valg() {
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, Clk_Till, 10);
		if (is_Till_Displayed == true) {
			click_Valg.click();
		}
	}

	public void click_SMS_melding() throws InterruptedException {
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, clk_Add_Contacts_OK, 10);
		if (is_Till_Displayed == true) {
			click_SMS_melding.click();
		}
		Thread.sleep(2000);
	}

	public void click_SMS_varsel() throws InterruptedException {
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, clk_Add_Contacts_OK, 15);
		if (is_Till_Displayed == true) {
			// click_SMS_melding.click();
			click_SMS_varsel.click();
		}
		Thread.sleep(2000);
		//			Click_Sporsmal.click();
		//			Thread.sleep(2000);
		//			edit_Sporsmal.sendKeys("test question");
		//			Thread.sleep(2000);
		clk_Add_Contacts_OK.click();
	}

	public void sms_melding_displayed(String val) {
		boolean is_SMS_Melding_Displayed = Base_Class.is_Element_Present(driver2, verify_SMS_melding_edit, 10);
		if (is_SMS_Melding_Displayed == true) {
			SMS_Msg_Body.sendKeys(Msg_Body);
			System.out.println("Test");
		}
		// return val;
	}

	public void click_Send_Msg() throws InterruptedException {
		Send_Message.click();
		Thread.sleep(10000);
	}

}
