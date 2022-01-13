package com.ude.portalen.pageobject;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Page_UDEMA_1987 extends Base_Class {

	public Page_UDEMA_1987(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime currentDateTime = LocalDateTime.now();
	public String messageBody = "inlaa014 msg_body" + dateTimeFormat.format(currentDateTime);
	public String messageTitle = "inlaa014 msg_title" + dateTimeFormat.format(currentDateTime);
	LocalDate dt = LocalDate.parse(LocalDate.now().toString());
	int currentDate = dt.getDayOfMonth();
	LocalDate currentDateWithYear = dt.now();
	
	public String absenceMessageTitle = "Melding om fravaer";

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alert-close-icon']")
	@CacheLookup
	public WebElement clk_Close_Button;

	@FindBy(xpath = "//android.widget.TextView[@text='Lesebekreftelse']")
	@CacheLookup
	public WebElement Click_Lesebekreftelse;

	//	@FindBy(xpath = "//android.widget.TextView[@text='Spørsmål']")
	//	@CacheLookup
	//	public WebElement Click_Spørsmål;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Filter']/android.widget.ImageView")
	@CacheLookup
	public WebElement Click_Post_Filter;

	//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='isReplyAllowed']")
	//	@CacheLookup
	//	public WebElement Click_Svar_av_toggle;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Skriv melding']")
	@CacheLookup
	public WebElement mail_Compose;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement clk_Velg_Skole;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ZGS']/android.widget.TextView")
	@CacheLookup
	public WebElement clk_Velg_Skole_Options;

	//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alela010']/android.view.ViewGroup")
	//	@CacheLookup
	//	public WebElement clk_Search_Alela010;
	//	
	//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Eleven + Foresatte']")
	//	@CacheLookup
	//	public WebElement clk_Checkbox;

	//	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	//	@CacheLookup
	//	public WebElement verify_Selection;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='addContactText']")
	@CacheLookup
	public WebElement clk_Add_Contacts_OK;

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

	@FindBy(xpath = "//android.widget.EditText[@content-desc='bodyMessage']")
	@CacheLookup
	public WebElement SMS_Msg_Body;

	//TC5
	@FindBy(xpath = "//android.view.ViewGroup[4]/android.widget.TextView[2]")
	@CacheLookup
	public WebElement get_SMS_Msg_Body;

	//TC6
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Kontaktlærer']")
	@CacheLookup
	public WebElement verify_Kontakt;		

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='alana041']/android.widget.TextView")
	@CacheLookup
	public WebElement Select_Parents_Student;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-dependant-dropdown']/android.widget.TextView")
	@CacheLookup
	public WebElement students_list_drop_down;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='show-school-dropdown']")
	@CacheLookup
	public WebElement schools_drop_down;

	//New
	@FindBy(xpath = "//android.widget.TextView[@text='Meld fravær']")
	@CacheLookup
	public WebElement send_absence_msg;

	@FindBy(xpath = "//android.widget.TextView[@text='I dag']")
	@CacheLookup
	public WebElement click_I_Dag;
	
	@FindBy(xpath = "//android.widget.TextView[@text='I morgen']")
	@CacheLookup
	public WebElement click_I_Morgen;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Dato/tidspunkt']")
	@CacheLookup
	public WebElement click_dato;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]")
	@CacheLookup
	public WebElement click_date_picker_fra;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[6]")
	@CacheLookup
	public WebElement click_date_picker_til;
	
	@FindBy(xpath = "//android.view.View[@text='21']")
	@CacheLookup
	public WebElement click_date_fra;
	
	@FindBy(xpath = "//android.view.View[@text='24']")
	@CacheLookup
	public WebElement click_date_til;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	@CacheLookup
	public WebElement click_date_OK;
	
	/**
	 * Click on Absense Message
	 * @throws InterruptedException 
	 */
	public void clickOnSendAbsenceMessage() throws InterruptedException {
		send_absence_msg.click();
		Thread.sleep(5000);
	}

	/**
	 * Click on I Dag and click on Send Message
	 * @author S, Manjunath
	 * @throws InterruptedException
	 */
	public void selectAbsenceDuration(String duration) throws InterruptedException{
		boolean send_Button_isDisplayed = Base_Class.is_Element_Present(driver, Send_Message, 15);
		if(send_Button_isDisplayed == true) {
			switch (duration) {
			case "i_dag":
				click_I_Dag.click();
				Thread.sleep(3000);
				break;
			case "i_morgen":
				click_I_Morgen.click();
				Thread.sleep(3000);
				break;
			case "dato_later":
				click_dato.click();
				Thread.sleep(3000);
				click_date_picker_fra.click();
				Thread.sleep(3000);
				//click_date_fra.click();
				//Thread.sleep(2000);
				setDateInFra(currentDate, "later");
				Thread.sleep(2000);
				click_date_OK.click();
				Thread.sleep(2000);
				click_date_picker_til.click();
				Thread.sleep(3000);
//				click_date_til.click();
//				Thread.sleep(3000);
				setDateInTil(currentDate, "later");
				click_date_OK.click();
				Thread.sleep(2000);
				break;
			case "dato_previous":
				click_dato.click();
				Thread.sleep(3000);
				click_date_picker_fra.click();
				Thread.sleep(3000);
				//click_date_fra.click();
				//Thread.sleep(2000);
				setDateInFra(currentDate, "previous");
				Thread.sleep(2000);
				click_date_OK.click();
				Thread.sleep(2000);
				click_date_picker_til.click();
				Thread.sleep(3000);
//				click_date_til.click();
//				Thread.sleep(3000);
				setDateInTil(currentDate, "previous");
				click_date_OK.click();
				Thread.sleep(2000);
				break;
			default:
				System.out.println("Invalid argument passed!!");
				break;
			}
			
			Send_Message.click();
		}
	}
	
	/**
	 * Sets Date in Fra field of Date picker
	 * @param currentDate
	 * @param type
	 * @author S, Manjunath
	 */
	public void setDateInFra(int currentDate, String type) {
		System.out.println("currentDate passed : "+currentDate);
		System.out.println("type passed : "+type);
		int newDate = 0;
		if(type.equals("later")) {
			if(currentDate != 30 || currentDate != 31) {
				System.out.println("Fra : currentDate is not 30 or 31. Setting currentDate to next 2 days");
				newDate = currentDate + 2;
				System.out.println("Fra : New Date set is : "+newDate);
			} else {
				System.out.println("Fra : currentDate is either 30 or 31. Keeping currentDate as it is.");
			}
			WebElement dateFraLater = driver.findElement(By.xpath("//android.view.View[@text="+newDate+"]"));
			dateFraLater.click();
		} else if(type.equals("previous")) {
			if(!(currentDate <= 3)) {
				System.out.println("Fra : currentDate is not less than 3. Setting currentDate to previous 2 days");
				newDate = currentDate - 2;
				System.out.println("Fra : New Date set is : "+newDate);
			} else {
				System.out.println("Fra : currentDate is less than 3. Keeping currentDate as it is.");
			}
			WebElement dateFraPrevious = driver.findElement(By.xpath("//android.view.View[@text="+newDate+"]"));
			dateFraPrevious.click();
		}
	}
	
	/**
	 * Sets Date in Til Field(DatePicker)
	 * @param currentDate Current System Date
	 * @param type Later/Previous
	 * @author S, Manjunath
	 */
	public void setDateInTil(int currentDate, String type) {
		System.out.println("currentDate passed : "+currentDate);
		System.out.println("type passed : "+type);
		int newDate = 0;
		if(type.equals("later")) {
			if(currentDate != 30 || currentDate != 31) {
				System.out.println("Til : currentDate is not 30 or 31. Setting currentDate to next 2 days");
				newDate = currentDate + 3;
				System.out.println("Til : New Date set is : "+newDate);
			} else {
				System.out.println("Til : currentDate is either 30 or 31. Keeping currentDate as it is.");
			}
			WebElement dateFraLater = driver.findElement(By.xpath("//android.view.View[@text="+newDate+"]"));
			dateFraLater.click();
		} else if(type.equals("previous")) {
			if(!(currentDate <= 3)) {
				System.out.println("Til : currentDate is not less than 3. Setting currentDate to previous 2 days");
				newDate = currentDate - 1;
				System.out.println("New Date set is : "+newDate);
			} else {
				System.out.println("Til : currentDate is less than 3. Keeping currentDate as it is.");
			}
			WebElement dateTilPrevious = driver.findElement(By.xpath("//android.view.View[@text="+newDate+"]"));
			dateTilPrevious.click();
		}
	}

	/**
	 * Select student from drop down
	 * @throws InterruptedException
	 */
	public void selectRecipientTeacher() throws InterruptedException {
//		boolean students_list_drop_down_isDisplayed = Base_Class.is_Element_Present(driver, students_list_drop_down, 15);
//		if(students_list_drop_down_isDisplayed == true) {
//			Select_Parents_Student.click();
//			Thread.sleep(2000);
//			//students_list_drop_down.click();
//			//Thread.sleep(2000);
//			//schools_drop_down.click();
//		}
		Select_Parents_Student.click();
	}

	/**
	 * Click on OK after selecting contact
	 * @throws InterruptedException
	 */
	public void clickOnOKAfterSelectingContact() throws InterruptedException {
		clk_Add_Contacts_OK.click();
		Thread.sleep(8000);
	}

	/**
	 * Click on Mail compose button
	 * @throws InterruptedException
	 */
	public void clickOnMailCompose() throws InterruptedException {
		boolean Close_btn_present = Base_Class.is_Element_Present(driver, Click_Settings_Tab, 15);
		if(Close_btn_present == true) {
			//clk_Close_Button.click(); 
			Thread.sleep(4000);
			mail_Compose.click();
			Thread.sleep(2000);
		}
	}

	/**
	 * Click on Velg Skole drop down
	 * @throws InterruptedException
	 */
	public void clickOnSchoolDropDown() throws InterruptedException {
		clk_Velg_Skole.click();
		Thread.sleep(2000);
	}

	/**
	 * Click on School drop down options
	 * @throws InterruptedException
	 */
	public void clickOnSchoolDropDownOptions() throws InterruptedException {
		clk_Velg_Skole_Options.click();
		Thread.sleep(2000);
	}

	/**
	 * Search and verify for sent message 
	 * @author S, Manjunath
	 * @param val
	 * @return Message title text
	 * @throws InterruptedException
	 */
	public String verifySentMessageInForesatte(String val) throws InterruptedException {
		boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver, Filter_Button, 40);
		if(is_Filter_Displayed == true) {
			Arkiv_Sent.click();
			Thread.sleep(3000);
			Search_Sent_Msg_EditText.sendKeys(absenceMessageTitle);
			Thread.sleep(10000);
			Click_Search_Result_SentMail.click();
			Thread.sleep(4000);
		}
		switch (val) {
		case "later":
			LocalDateTime curTime = LocalDateTime.now();
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTime = curTime.format(format1);   
		    System.out.println(formatDateTime); 
		    LocalDateTime startDate = curTime.plusDays(2);
		    String startDateFormatted = startDate.format(format1);
		    System.out.println("FOrmatted StartDate : "+startDate.format(format1));
		    LocalDateTime endDate = curTime.plusDays(3);
		    String endDateFormatted = endDate.format(format1);
		    System.out.println("FOrmatted endDate : "+startDate.format(format1));
		    String verificationXpath = "\"Tidspunkt for fravær: "+startDateFormatted+" til "+endDateFormatted+"\"";
			System.out.println("Verification XPath is : "+verificationXpath);
			String xpath = "//android.widget.TextView[@text="+verificationXpath+"]";
			System.out.println("Xpath is : "+xpath);
			//WebElement dateFraLater = driver.findElement(By.xpath("//android.widget.TextView[@text="+verificationXpath+"]"));
			WebElement dateFraLater = driver.findElement(By.xpath(xpath));
			if(dateFraLater.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraLater.click();
			break;
		case "previous":	
			LocalDateTime curTimePrevious = LocalDateTime.now();
			DateTimeFormatter format1Previous = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTimePrevious = curTimePrevious.format(format1Previous);   
		    System.out.println(formatDateTimePrevious);
		    LocalDateTime startDatePrevious = curTimePrevious.minusDays(2);
		    String startDateFormattedPrevious = startDatePrevious.format(format1Previous);
		    System.out.println("FOrmatted StartDate : "+startDatePrevious.format(format1Previous));
		    LocalDateTime endDatePrevious = curTimePrevious.minusDays(1);
		    String endDateFormattedPrevious = endDatePrevious.format(format1Previous);
		    System.out.println("FOrmatted endDate : "+startDatePrevious.format(format1Previous));
		    String verificationXpathPrevious = "\"Tidspunkt for fravær: "+startDateFormattedPrevious+" til "+endDateFormattedPrevious+"\"";
			System.out.println("Verification XPath is : "+verificationXpathPrevious);
			String xpathPrevious = "//android.widget.TextView[@text="+verificationXpathPrevious+"]";
			System.out.println("Xpath is : "+xpathPrevious);
			//WebElement dateFraLater = driver.findElement(By.xpath("//android.widget.TextView[@text="+verificationXpath+"]"));
			WebElement dateFraPrevious = driver.findElement(By.xpath(xpathPrevious));
			if(dateFraPrevious.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraPrevious.click();
			break;
		case "i dag":
			LocalDateTime curTimeIDag = LocalDateTime.now();
			DateTimeFormatter format1IDag = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTimeIDag = curTimeIDag.format(format1IDag);   
		    System.out.println(formatDateTimeIDag);
		    String verificationXpathIDag = "\"Tidspunkt for fravær: "+formatDateTimeIDag+" (Hel dag)"+"\"";
			System.out.println("Verification XPath is : "+verificationXpathIDag);
			String xpathIDag = "//android.widget.TextView[@text="+verificationXpathIDag+"]";
			System.out.println("Xpath is : "+xpathIDag);
			WebElement dateFraIdag = driver.findElement(By.xpath(xpathIDag));
			if(dateFraIdag.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraIdag.click();
			break;
		case "i morgen":
			LocalDateTime curTimeIMorgen = LocalDateTime.now();
			DateTimeFormatter format1IMorgen = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTimeIMorgen = curTimeIMorgen.format(format1IMorgen);
		    System.out.println(formatDateTimeIMorgen);
		    LocalDateTime absenceDateIMorgen = curTimeIMorgen.plusDays(1);
		    String formatAbsenceDateIMorgen = absenceDateIMorgen.format(format1IMorgen);
		    System.out.println(formatAbsenceDateIMorgen);
		    String verificationXpathIMorgen = "\"Tidspunkt for fravær: "+formatAbsenceDateIMorgen+" (Hel dag)"+"\"";
			System.out.println("Verification XPath is : "+verificationXpathIMorgen);
			String xpathIMorgen = "//android.widget.TextView[@text="+verificationXpathIMorgen+"]";
			System.out.println("Xpath is : "+xpathIMorgen);
			WebElement dateFraIMorgen = driver.findElement(By.xpath(xpathIMorgen));
			if(dateFraIMorgen.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraIMorgen.click();
			break;	
		default:
			
			System.out.println("val is : "+val+" Entering default block");
			
//			boolean is_Filter_Displayed = Base_Class.is_Element_Present(driver, Filter_Button, 40);
//			if(is_Filter_Displayed == true) {
//				Arkiv_Sent.click();
//				Thread.sleep(3000);
//				Search_Sent_Msg_EditText.sendKeys(absenceMessageTitle);
//				Thread.sleep(10000);
//				Click_Search_Result_SentMail.click();
//				Thread.sleep(4000);
				val = get_Mail_Title_Text.getText();
				System.out.println(val);
				Thread.sleep(3000);
				//Close_Mail.click();
				//Thread.sleep(3000);
			break;
		}
		return val;
	}

	/**
	 * Get actual result text from mail title
	 * @param val 
	 * @return Message title text
	 * @throws InterruptedException
	 */
	public String getActualResult(String val) throws InterruptedException {
		val = get_Mail_Title_Text.getText();
		Close_Mail.click();
		Thread.sleep(3000);
		return val;
	}

	/**
	 * Logout from Foresatte app
	 * @throws InterruptedException
	 */
	public void logoutFromForesatte() throws InterruptedException {
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver, Click_Settings_Tab, 40);
		if(is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
			
			System.out.println("Settings");
			Thread.sleep(3000);
			
			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
			touchAction.longPress(PointOption.point(460, 1240)).moveTo(PointOption.point(480, 140)).release().perform();
			
			System.out.println("Scrolling done");
			Click_Logout.click();
			System.out.println("Logouttttttttttt");
		}
	}

	/**
	 * Click on Arkiv Mottatt folder, search for sent message with message title and open it
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
			Thread.sleep(5000);
		}
	}

	/**
	 * Get expected text
	 * @param val
	 * @author S, Manjunath
	 * @return
	 */
	public String getExpectedResult(String val) {
		switch (val) {
		case "later":
			LocalDateTime curTime = LocalDateTime.now();
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTime = curTime.format(format1);   
		    System.out.println(formatDateTime); 
		    LocalDateTime startDate = curTime.plusDays(2);
		    String startDateFormatted = startDate.format(format1);
		    System.out.println("FOrmatted StartDate : "+startDate.format(format1));
		    LocalDateTime endDate = curTime.plusDays(3);
		    String endDateFormatted = endDate.format(format1);
		    System.out.println("FOrmatted endDate : "+endDate.format(format1));
		    String verificationXpath = "\"Tidspunkt for fravær: "+startDateFormatted+" til "+endDateFormatted+"\"";
			System.out.println("Verification XPath is : "+verificationXpath);
			String xpath = "//android.widget.TextView[@text="+verificationXpath+"]";
			System.out.println("Xpath is : "+xpath);
			//WebElement dateFraLater = driver.findElement(By.xpath("//android.widget.TextView[@text="+verificationXpath+"]"));
			WebElement dateFraLater = driver2.findElement(By.xpath(xpath));
			if(dateFraLater.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraLater.click();
			break;
		case "previous":	
			LocalDateTime curTimePrevious = LocalDateTime.now();
			DateTimeFormatter format1Previous = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTimePrevious = curTimePrevious.format(format1Previous);   
		    System.out.println(formatDateTimePrevious); 
		    LocalDateTime startDatePrevious = curTimePrevious.minusDays(2);
		    String startDateFormattedPrevious = startDatePrevious.format(format1Previous);
		    System.out.println("FOrmatted StartDate : "+startDatePrevious.format(format1Previous));
		    LocalDateTime endDatePrevious = curTimePrevious.minusDays(1);
		    String endDateFormattedPrevious = endDatePrevious.format(format1Previous);
		    System.out.println("FOrmatted endDate : "+endDatePrevious.format(format1Previous));
		    String verificationXpathPrevious = "\"Tidspunkt for fravær: "+startDateFormattedPrevious+" til "+endDateFormattedPrevious+"\"";
			System.out.println("Verification XPath is : "+verificationXpathPrevious);
			String xpathPrevious = "//android.widget.TextView[@text="+verificationXpathPrevious+"]";
			System.out.println("Xpath is : "+xpathPrevious);
			//WebElement dateFraLater = driver.findElement(By.xpath("//android.widget.TextView[@text="+verificationXpath+"]"));
			WebElement dateFraPrevious = driver2.findElement(By.xpath(xpathPrevious));
			if(dateFraPrevious.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraPrevious.click();
			break;
		case "i dag":
			LocalDateTime curTimeIDag = LocalDateTime.now();
			DateTimeFormatter format1IDag = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTimeIDag = curTimeIDag.format(format1IDag);   
		    System.out.println(formatDateTimeIDag);
		    String verificationXpathIDag = "\"Tidspunkt for fravær: "+formatDateTimeIDag+" (Hel dag)"+"\"";
			System.out.println("Verification XPath is : "+verificationXpathIDag);
			String xpathIDag = "//android.widget.TextView[@text="+verificationXpathIDag+"]";
			System.out.println("Xpath is : "+xpathIDag);
			WebElement dateFraIdag = driver2.findElement(By.xpath(xpathIDag));
			if(dateFraIdag.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraIdag.click();
			break;	
		case "i morgen":
			LocalDateTime curTimeIMorgen = LocalDateTime.now();
			DateTimeFormatter format1IMorgen = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		    String formatDateTimeIMorgen = curTimeIMorgen.format(format1IMorgen);
		    System.out.println(formatDateTimeIMorgen);
		    LocalDateTime absenceDateIMorgen = curTimeIMorgen.plusDays(1);
		    String formatAbsenceDateIMorgen = absenceDateIMorgen.format(format1IMorgen);
		    System.out.println(formatAbsenceDateIMorgen);
		    String verificationXpathIMorgen = "\"Tidspunkt for fravær: "+formatAbsenceDateIMorgen+" (Hel dag)"+"\"";
			System.out.println("Verification XPath is : "+verificationXpathIMorgen);
			String xpathIMorgen = "//android.widget.TextView[@text="+verificationXpathIMorgen+"]";
			System.out.println("Xpath is : "+xpathIMorgen);
			WebElement dateFraIMorgen = driver2.findElement(By.xpath(xpathIMorgen));
			if(dateFraIMorgen.isDisplayed()) {
				val = "Absence Message is displayed";
			} else {
				val = "Absence Message is Not displayed";
			}
			System.out.println(val);
			dateFraIMorgen.click();
			break;	
		default:
			boolean is_Text_Displayed = Base_Class.is_Element_Present(driver2, Close_Mail, 30);
			if(is_Text_Displayed == true) {
				val = get_Expected_Text_TC6.getText();
			}
			System.out.println(val);
			break;
		}
		return val;
	}
}
