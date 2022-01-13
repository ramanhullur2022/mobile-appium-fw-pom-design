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


public class Page_UDEMA_Filter extends Base_Class {

	public Page_UDEMA_Filter(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime currentDateTime = LocalDateTime.now();
	public String messageBody = "inlaa014 msg_body" + dateTimeFormat.format(currentDateTime);
	public String messageTitle = "inlaa014 msg_title" + dateTimeFormat.format(currentDateTime);

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Filter']/android.view.ViewGroup/android.widget.TextView")
	@CacheLookup
	public WebElement clickFilterIcon;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Uleste meldinger']")
	@CacheLookup
	public WebElement clickulesteMeldingerFilter;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Spørsmål']")
	@CacheLookup
	public WebElement clickSporsmalFilter;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Spørsmål']")
	@CacheLookup
	public WebElement sporsmalTag;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Avsender']")
	@CacheLookup
	public WebElement clickAvsenderFilter;

	@FindBy(xpath = "//android.widget.TextView[@text='CGI-alana Testelev']")
	@CacheLookup
	public WebElement clickOnAvsenderAlana;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Magnhild Cgi Syversen']")
	@CacheLookup
	public WebElement clickOnAvsenderMagnhild;

	@FindBy(xpath = "//android.widget.TextView[@text='Inger Lærer']")
	@CacheLookup
	public WebElement clickOnAvsenderInger;
	
	@FindBy(xpath = "//android.widget.TextView[@text='CGI ID-porttest Tre Testforesatt']")
	@CacheLookup
	public WebElement ForesatteLabel;

	@FindBy(xpath = "//android.widget.TextView[@text = 'OK']")
	@CacheLookup
	public WebElement clickOKBtn;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	@CacheLookup
	public WebElement unreadMsgIcon;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Arkiv']")
	@CacheLookup
	public WebElement clickArkivFolder;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Sendt']/android.widget.TextView")
	@CacheLookup
	public WebElement ClickOnSendtFolder;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Mottatt']/android.widget.TextView")
	@CacheLookup
	public WebElement ClickOnMottattFolder;
	
	//Teacher3 Login Selectors
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Skriv melding']")
	@CacheLookup
	public WebElement mail_Compose;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Valg']")
	@CacheLookup
	public WebElement click_Valg;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Spørsmål\"]")
	@CacheLookup
	public WebElement Click_Spørsmål;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Logg ut']")
	@CacheLookup
	public WebElement Click_Logout;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-till']")
	@CacheLookup
	public WebElement Clk_Till;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='Innstillinger']")
	@CacheLookup
	public WebElement Click_Settings_Tab;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Skriv spørsmål\"]")
	@CacheLookup
	public WebElement Enter_Msg_in_Sporsmal;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='sendMessage']")
	@CacheLookup
	public WebElement Send_Message;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='input-title-message']")
	@CacheLookup
	public WebElement Message_Title;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='bodyMessage']")
	@CacheLookup
	public WebElement Message_Body;
	
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
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Elev\"]")
	@CacheLookup
	public WebElement elev_contact_filter;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Foresatte\"]")
	@CacheLookup
	public WebElement foresatte_contact_filter;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"CGI-alana Testelev\"]")
	@CacheLookup
	public WebElement alana_contact_filter;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Ludvig Draget\"]")
	@CacheLookup
	public WebElement ludra_contact_filter;
	
	/**
	 * Clicks on Filter icon
	 * @throws InterruptedException
	 * @author S, Manjunath
	 */
	public void clickOnFilter() throws InterruptedException {
		Thread.sleep(10000);
		clickFilterIcon.click();
		Thread.sleep(2000);
	}

	/**
	 * Selects filter
	 * @param filterType Type of filter which needs to be selected
	 * @author S, Manjunath
	 * @throws InterruptedException 
	 */
	public void selectFilter(String filterType) throws InterruptedException {
		System.out.println("Passed filterType is : "+filterType);
		switch (filterType) {
		case "Uleste Meldinger":
			clickulesteMeldingerFilter.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Spørsmål":
			clickSporsmalFilter.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Uleste meldinger and Sporsmal":
			clickulesteMeldingerFilter.click();
			Thread.sleep(2000);
			clickSporsmalFilter.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(2000);
			break;
		case "Avsender Single Contact":
			clickAvsenderFilter.click();
			Thread.sleep(2000);
			clickOnAvsenderAlana.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Avsender Multiple Contact":
			clickAvsenderFilter.click();
			Thread.sleep(2000);
			clickOnAvsenderAlana.click();
			Thread.sleep(2000);
			clickOnAvsenderInger.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Uleste meldinger and Avsender Multiple Contact":
			clickulesteMeldingerFilter.click();
			Thread.sleep(2000);
			clickAvsenderFilter.click();
			Thread.sleep(2000);
			clickOnAvsenderAlana.click();
			Thread.sleep(2000);
			clickOnAvsenderInger.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Uleste meldinger and Avsender Single Contact":
			clickulesteMeldingerFilter.click();
			Thread.sleep(2000);
			clickAvsenderFilter.click();
			Thread.sleep(2000);
			clickOnAvsenderAlana.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Sporsmal and Avsender Single Contact":
			clickSporsmalFilter.click();
			Thread.sleep(2000);
			clickAvsenderFilter.click();
			Thread.sleep(2000);
			clickOnAvsenderInger.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;
		case "Sporsmal and Avsender Multiple Contact":
			clickSporsmalFilter.click();
			Thread.sleep(2000);
			clickAvsenderFilter.click();
			Thread.sleep(2000);
			clickOnAvsenderMagnhild.click();
			Thread.sleep(2000);
			clickOnAvsenderInger.click();
			Thread.sleep(2000);
			clickOKBtn.click();
			Thread.sleep(10000);
			break;	
		default:
			System.out.println("selectFilter : Entered default block. FilterType passed : "+filterType);
			break;
		}
	}

	public boolean verifyMessagesAsPerSelectedFilter(String filterType) throws InterruptedException {
		System.out.println("Passed filterType is : "+filterType);
		boolean result = false;
		switch (filterType) {
		case "Uleste Meldinger":
			if(Base_Class.is_Element_Present(driver2, unreadMsgIcon, 40)) {
				System.out.println("Unread Messages are Filtered");
				result = true;
			} else {
				System.out.println("Unread Messages are not Filtered");
				result = false;
			}
			Thread.sleep(5000);
			break;
		case "Spørsmål":
			if(Base_Class.is_Element_Present(driver2, sporsmalTag, 40)) {
				System.out.println("Sporsmal Messages are Filtered");
				result = true;
			} else {
				System.out.println("Sporsmal Messages are not Filtered");
				result = false;
			}
			Thread.sleep(5000);
			break;
		case "Uleste meldinger and Sporsmal":
			if(Base_Class.is_Element_Present(driver2, sporsmalTag, 40)) {
				if(Base_Class.is_Element_Present(driver2, unreadMsgIcon, 40)) {
					System.out.println("Uleste meldinger and Sporsmal messages are filtered");
					return true;
				} else {
					System.out.println("Uleste meldinger and Sporsmal messages are not filtered");
					return false;
				}
			}
			Thread.sleep(5000);
			break;
		case "Avsender Single Contact":
		case "Elev Contact filter in Elev":
		case "Alana Contact filter in Arkiv Sendt Foresatte":
		case "Alana Contact filter in Arkiv Mottatt Foresatte":
			if(Base_Class.is_Element_Present(driver2, clickOnAvsenderAlana, 40)) {
				System.out.println("Single contact messages are Filtered");
				result = true;
			} else {
				System.out.println("Single contact messages are not Filtered");
				result = false;
			}
			Thread.sleep(5000);
			break;
		case "Avsender Multiple Contact":
			if(Base_Class.is_Element_Present(driver2, clickOnAvsenderAlana, 40)) {
				if(Base_Class.is_Element_Present(driver2, clickOnAvsenderInger, 40)) {
					System.out.println("Avsender Multiple contact messages are Filtered");
					result = true;
				} else {
					System.out.println("Avsender Multiple contact messages are not Filtered");
					result = false;
				}
			}
			Thread.sleep(5000);
			break;
		case "Uleste meldinger and Avsender Multiple Contact":
			if(Base_Class.is_Element_Present(driver2, clickOnAvsenderAlana, 40)) {
				if(Base_Class.is_Element_Present(driver2, clickOnAvsenderInger, 40)) {
					if(Base_Class.is_Element_Present(driver2, unreadMsgIcon, 40)) {
						System.out.println("Uleste meldinger and Avsender Multiple Contact messages are filtered");
						return true;
					} else {
						System.out.println("Uleste meldinger and Avsender Multiple Contact messages are not filtered");
						return false;
					}
				}
			}
			Thread.sleep(5000);
			break;
		case "Uleste meldinger and Avsender Single Contact":
			if(Base_Class.is_Element_Present(driver2, clickOnAvsenderAlana, 40)) {
				if(Base_Class.is_Element_Present(driver2, unreadMsgIcon, 40)) {
					System.out.println("Uleste meldinger and Avsender Single Contact messages are filtered");
					return true;
				} else {
					System.out.println("Uleste meldinger and Avsender Single Contact messages are not filtered");
					return false;
				}
			}
			Thread.sleep(5000);
			break;
		case "Sporsmal and Avsender Single Contact":
			if(Base_Class.is_Element_Present(driver2, clickOnAvsenderInger, 40)) {
				if(Base_Class.is_Element_Present(driver2, sporsmalTag, 40)) {
					System.out.println("Uleste meldinger and Avsender Single Contact messages are filtered");
					return true;
				} else {
					System.out.println("Uleste meldinger and Avsender Single Contact messages are not filtered");
					return false;
				}
			}
			Thread.sleep(5000);
			break;
		case "Sporsmal and Avsender Multiple Contact":
			if(Base_Class.is_Element_Present(driver2, clickOnAvsenderMagnhild, 40)) {
				if(Base_Class.is_Element_Present(driver2, clickOnAvsenderInger, 40)) {
					if(Base_Class.is_Element_Present(driver2, sporsmalTag, 40)) {
						System.out.println("Sporsmal and Avsender Multiple Contact messages are filtered");
						return true;
					} else {
						System.out.println("Sporsmal and Avsender Multiple Contact messages are not filtered");
						return false;
					}
				}
			}
			Thread.sleep(5000);
			break;
		case "Foresatte Contact filter in Elev":
			if(Base_Class.is_Element_Present(driver2, ForesatteLabel, 40)) {
				System.out.println("Foresatte contact messages are Filtered");
				result = true;
			} else {
				System.out.println("Foresatte contact messages are not Filtered");
				result = false;
			}
			Thread.sleep(5000);
			break;
		default:
			System.out.println("verifyMessagesAsPerSelectedFilter : Entered default block. FilterType passed : "+filterType);
			break;
		}

		return result;
	}

	/**
	 * Navigates to Arkiv Sendt or Mottatt folder
	 * @param folderType Sendt or Mottatt
	 * @author S, Manjunath
	 * @throws InterruptedException 
	 */
	public void goToArkivFolder(String folderType) throws InterruptedException {
		switch (folderType) {
		case "Sendt":
			clickArkivFolder.click();
			Thread.sleep(2000);
			ClickOnSendtFolder.click();
			Thread.sleep(2000);
			break;
		case "Mottatt":
			clickArkivFolder.click();
			Thread.sleep(2000);
			ClickOnMottattFolder.click();
			Thread.sleep(2000);
			break;
		default:
			System.out.println("goToArkivFolder : Entered default block. FolderType passed : "+folderType);
			break;
		}
		
	}

	/**
	 * Send mail from teacher to student
	 * @throws InterruptedException
	 */
	public void sendMailFromTeacher() throws InterruptedException {
		Thread.sleep(4000);
		mail_Compose.click();
		Thread.sleep(2000);
		boolean is_Till_Displayed = Base_Class.is_Element_Present(driver2, Clk_Till, 10);
		if(is_Till_Displayed == true) {
			click_Valg.click();
			Thread.sleep(2000);
		}
		Click_Spørsmål.click();
		Thread.sleep(2000);
		Click_Spørsmål.getText();
		Thread.sleep(2000);
		Enter_Msg_in_Sporsmal.sendKeys("Are you coming to School?");
		Thread.sleep(2000);
		clk_Add_Contacts_OK.click();
		Thread.sleep(8000);
		Clk_Till.click();
		Thread.sleep(2000);
		clk_Velg_Skole.click();
		Thread.sleep(2000);
		clk_Velg_Skole_Options.click();
		Thread.sleep(2000);
		clk_Personer_Tab.click();
		Thread.sleep(2000);
		clk_Search_Input.sendKeys("alana041");
		Thread.sleep(15000);
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
		
		boolean is_Send_Message_Displayed = Base_Class.is_Element_Present(driver2, Send_Message, 5);
		if(is_Send_Message_Displayed == true) {
			//System.out.println(dtf.format(now)); //2016/11/16 12:08
			Message_Body.sendKeys(messageBody);
			Thread.sleep(2000);
			Message_Title.sendKeys(messageTitle);
			Thread.sleep(2000);
			Send_Message.click();
		}
		
		boolean is_SettingsTab_Displayed = Base_Class.is_Element_Present(driver2, Click_Settings_Tab, 40);
		if(is_SettingsTab_Displayed == true) {
			Click_Settings_Tab.click();
			Thread.sleep(3000);
			Click_Logout.click();
		}
	}

	public void clickOnContactsFilter(String contactType, String appType) throws InterruptedException {
		System.out.println("Passed contactType : "+contactType);
		System.out.println("Passed appType : "+appType);
		switch (appType) {
		case "Elev":
			if(contactType.equals("Elev")) {
				elev_contact_filter.click();
				Thread.sleep(5000);
			} else if(contactType.equals("Foresatte")) {
				foresatte_contact_filter.click();
				Thread.sleep(5000);
			}
			break;
		case "Foresatte":
			if(contactType.equals("Alana")) {
				alana_contact_filter.click();
				Thread.sleep(5000);
			} else if(contactType.equals("Ludra")) {
				ludra_contact_filter.click();
				Thread.sleep(5000);
			}
			break;
		default:
			break;
		}
		
	}

}
