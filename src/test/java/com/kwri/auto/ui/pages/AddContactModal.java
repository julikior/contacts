package com.kwri.auto.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

import java.util.List;
import java.util.Random;


public class AddContactModal extends BasePage {



	@Inject
	public AddContactModal(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);
	Actions actions = new Actions(world.driver);


	@FindBy(xpath = "//div[contains(@class,'modal__dialog styles__add-edit-contact')]")
	private WebElement modal_AddEditContact;

	@FindBy(xpath = "//input[@name='info.fullName']")
	private WebElement txt_fullName;

	@FindBy(xpath = "//input[@name='info.legalName']")
	private WebElement txt_addLegalName;

	@FindBy(xpath = "//input[@name='addresses[0]']")
	private WebElement txt_address;

	@FindBy(xpath = "(//div[contains(text(),'311 California Street')])[1]")
	private WebElement select_addressToSelect;

	@FindBy(xpath = "//*[contains(label, 'Apt/Unit/Suite')]//child::input")
	private WebElement txt_apartment;

	@FindBy(xpath = "//input[@name='addresses[0].isMailing']")
	private WebElement radio_sameAsMailingAddress;

	@FindBy(xpath = "//input[@name='emails[0].email']")
	private WebElement txt_primaryEmail;

	@FindBy(xpath = "//input[@name='emails[1].email']")
	private WebElement txt_additionalEmail;

	@FindBy(xpath = "//input[@name='phones[0]']")
	private WebElement txt_primaryPhoneNumber;

	@FindBy(xpath = "//input[@name='phones[1]']")
	private WebElement txt_additionalPhoneNumber;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement radio_preferredMethod;

	@FindBy(xpath = "//input[@id='captured'][@name='info.stage']")
	private WebElement checkbox_stage;

	@FindBy(xpath = "//input[@placeholder='Facebook URL']")
	private WebElement txt_socialProfile;

	@FindBy(xpath = "//label[contains(text(),'Job Title')]/..//input")
	private WebElement txt_jobTitle;

	@FindBy(xpath = "//textarea[@name='info.description']")
	private WebElement txt_description;

	@FindBy(xpath = "//a[text()='Add Custom Field']")
	private WebElement link_addCustomField;

	@FindBy(xpath = "//label[text()='Select Custom Field']")
	private WebElement label_selectCustomField;

	@FindBy(xpath = "//input[@placeholder='Enter agent']")
	private WebElement input_customField;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btn_createContact;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement btn_cancel;

	@FindBy(xpath = "//span[text()='Close']")
	private WebElement btn_close;

	@FindBy(xpath = "//div[@class='overlay']")
	private WebElement zone_overlay;

	@FindBy(xpath = "//div[text()='Add More Information']/../span")
	private WebElement add_more_info;

	@FindBy(xpath = "//h4[text()='Additional Contact Information']/../span")
	private WebElement additional_contact_info;

	@FindBy(xpath = "//h4[text()='About']/../span")
	private WebElement icon_about;

	@FindBy(xpath = "//div[contains(text(),'Error')]")
	private WebElement error_message;

	@FindBy(xpath = "//div[contains(text(),'Error')]")
	private WebElement error_phoneNum;

	@FindBy(xpath = "//div[contains(text(),'This email is already in use by another contact')]")
	private WebElement error_email;

	@FindBy(xpath = "//div[contains(text(),'Error')]")
	private WebElement error_invalidEmail;

	@FindBy(xpath = "//h4[contains(text(),'Sales Pipeline')]")
	private WebElement caret_SalesPipeline;

	@FindBy(xpath = "//*[contains(text(),'Select Lead Source')]")
	private WebElement drpdwn_leadSource;

	@FindBy(xpath = "//label[text()='Birthday']//following-sibling::div[1]//*[contains(text(),'Month')]")
	private WebElement monthOfBirthday;

	@FindBy(xpath = "//label[text()='Birthday']//following-sibling::div[1]//*[contains(text(),'Year')]")
	private WebElement select_YearOfBirthday;

	@FindBy(xpath = "//label[text()='Birthday']//following-sibling::div[1]//*[contains(text(),'Day')]")
	private WebElement select_DayOfBirthday;

	@FindBy(xpath = "//label[text()='Home Anniversary']//following-sibling::div//*[contains(text(),'Month')]")
	private WebElement select_MonthOfAnniversary;

	@FindBy(xpath = "//label[text()='Home Anniversary']//following-sibling::div//*[contains(text(),'Year')]")
	private WebElement select_YearOfAnniversary;

	@FindBy(xpath = "//label[text()='Home Anniversary']//following-sibling::div//*[contains(text(),'Day')]")
	private WebElement select_DayOfAnniversary;

	@FindBy(xpath = "//*[@id='dateSelect']/div[1]/div/div[2]")
	private WebElement drpdwn_monthBirth;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div[1]/div[1]")
	private WebElement drpdwn_relationships;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/input")
	private WebElement inputRelation;

	@FindBy(xpath = "//*[@id=\"about-section-v2\"]/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div[contains(text(), 'juliTest')]")
	private WebElement relatName;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[6]/div[1]/div/div/div/div/div[1]/div[2]/div/input")
	private WebElement inputCompName;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[6]/div[1]/div/div/div/div[2]/div")
	private WebElement compDropDown;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[6]/div[1]/div/div/div/div[2]/div/div/div")
	private WebElement btn_CreateCompany;

	@FindBy(xpath = "//div[@id='about-section-v2']/div[6]/div/div/div/div/div[2]/div/div[text()='KW']")
	private WebElement selectCompanyName;

	private static final String birthDate = "//*[contains(text(), '%s')]";

	private static final String annivDate = "//*[contains(text(), '%s')]";

	private static final String randomBirthMonth = "//*[text()='%s']";

	public WebElement getBtn_close() {
		return btn_close;
	}

	public WebElement getModal_AddEditContact() {
		return modal_AddEditContact;
	}

	public WebElement fillTxt_fullName() {
		common.waitAndClick(100, txt_fullName);
		return txt_fullName;
	}

	public WebElement clickTxt_addLegalName() {
		common.waitAndClick(30, txt_addLegalName);
		return txt_addLegalName;
	}

	public WebElement getTxt_address() {
		return txt_address;
	}

	public WebElement getSelect_addressToSelect() {
		return select_addressToSelect;
	}

	public WebElement getTxt_apartment() {
		common.waitAndClick(50, txt_apartment);
		return txt_apartment;
	}

	public WebElement getTxt_primaryEmail() {
		return txt_primaryEmail;
	}

	public WebElement getTxt_additionalEmail() {
		return txt_additionalEmail;
	}

	public WebElement getTxt_primaryPhoneNumber() {
		return txt_primaryPhoneNumber;
	}

	public WebElement getTxt_additionalPhoneNumber() {
		return txt_additionalPhoneNumber;
	}

	public WebElement getRadio_preferredMethod() {
		return radio_preferredMethod;
	}

	public WebElement getCheckbox_stage() {
		return checkbox_stage;
	}

	public WebElement getTxt_socialProfile() {
		return txt_socialProfile;
	}

	public WebElement getJobTitleTxt() {
		return txt_jobTitle;
	}

	public WebElement getTxt_description() {
		return txt_description;
	}

	public WebElement getLink_addCustomField() {
		return link_addCustomField;
	}

	public WebElement getLabel_selectCustomField() {
		return label_selectCustomField;
	}

	public WebElement getInput_customField() {
		return input_customField;
	}

	public WebElement clickBtn_createContact() {
		return btn_createContact;
	}

	public WebElement clickBtn_cancel() {
		return btn_cancel;
	}

	public WebElement clickzone_overlay() {
		wait.until(ExpectedConditions.invisibilityOf(zone_overlay));
		return zone_overlay;
	}

	public WebElement clickAddMoreInfo() {
		return add_more_info;
	}

	public WebElement clickAdditionalContactInfo() {
		return additional_contact_info;
	}

	public WebElement clickAbout() {
		return icon_about;
	}

	public WebElement getInvalidErrorMessage() {
		return error_invalidEmail;
	}

	public WebElement getErrorEmail() {
		common.waitForElement(500, error_email);
		return error_email;
	}

	public WebElement getErrorPhone(){
		return error_phoneNum;
	}

	public WebElement clickSalesPipeline() {
		return caret_SalesPipeline;
	}

	public WebElement leadSourceDropDown() {
		return drpdwn_leadSource;
	}

	public WebElement select_MonthOfBirthday() {
		return monthOfBirthday;
	}

	public WebElement selectMonthBirth() {
		return drpdwn_monthBirth;
	}

	public WebElement selectRelation() {
		return drpdwn_relationships;
	}

	public WebElement txtInputRelation() {
		return inputRelation;
	}

	public WebElement selectRelatName() {
		//common.waitForElement(50, relatName);
		return relatName;
	}

	public WebElement txtCompanyName() {
		return inputCompName;
	}

	public WebElement listCompNames() {
		return compDropDown;
	}

	public WebElement getBtn_CreateCompany() {
		return btn_CreateCompany;
	}

	public WebElement getSelectCompanyName() {
		return selectCompanyName;
	}


	public int selectARandomMonth() {
		//monthOfBirthday.click();
		List<WebElement> itemsInDropdown = world.driver.findElements(By.xpath("//*[@id='dateSelect']/div[1]/div/div[2]/div/div"));
		Random rand = new Random();
		int randomMonth = rand.nextInt(itemsInDropdown.size());
		WebElement randomMonthOfBirth = itemsInDropdown.get(randomMonth);
		randomMonthOfBirth.click();
		System.out.println(randomMonth);
		return randomMonth;
	}

	public int selectARandomDay() {
		//dayOfBirthday.click()
		select_DayOfBirthday.click();
		List<WebElement> itemsInDropdown = world.driver.findElements(By.xpath("//*[@id='dateSelect']/div[2]/div/div[2]/div/div"));
		Random rand = new Random();
		int randomNumber = rand.nextInt(itemsInDropdown.size());
		WebElement randomDayOfBirth = itemsInDropdown.get(randomNumber);
		randomDayOfBirth.click();
		System.out.println(randomNumber);
		return randomNumber;
	}

	public int selectARandomYear() {
		//yearOfBirthday.click()
		select_YearOfBirthday.click();
		List<WebElement> itemsInDropdown = world.driver.findElements(By.xpath("//*[@id='dateSelect']/div[3]/div/div[2]/div/div"));
		Random rand = new Random();
		int randomNumber = rand.nextInt(itemsInDropdown.size());
		WebElement randomYearOfBirth  = itemsInDropdown.get(randomNumber);
		randomYearOfBirth.click();
		System.out.println(randomNumber);
		return randomNumber;
	}

	public int selectARandomMonthOfAnniv() {
		//monthOfAnniversary.click()
		select_MonthOfAnniversary.click();
		List<WebElement> itemsInDropdown = world.driver.findElements(By.xpath("//*[@id='dateSelect']/div[1]/div/div[2]/div/div"));
		Random rand = new Random();
		int randomNumber = rand.nextInt(itemsInDropdown.size());
		WebElement randomMonth = itemsInDropdown.get(randomNumber);
		randomMonth.click();
		System.out.println(randomNumber);
		return randomNumber;
	}

	public int selectARandomDayOfAnniv() {
		//dayOfAnniversary.click()
		select_DayOfAnniversary.click();
		List<WebElement> itemsInDropdown = world.driver.findElements(By.xpath("//*[@id='dateSelect']/div[2]/div/div[2]/div/div"));
		Random rand = new Random();
		int randomNumber = rand.nextInt(itemsInDropdown.size());
		WebElement randomDay = itemsInDropdown.get(randomNumber);
		randomDay.click();
		System.out.println(randomNumber);
		return randomNumber;
	}

	public int selectARandomYearOfAnniv() {
		//yearOfAnniversary.click()
		select_YearOfAnniversary.click();
		List<WebElement> itemsInDropdown = world.driver.findElements(By.xpath("//*[@id='dateSelect']/div[3]/div/div[2]/div/div"));
		Random rand = new Random();
		int randomNumber = rand.nextInt(itemsInDropdown.size());
		WebElement randomYear = itemsInDropdown.get(randomNumber);
		randomYear.click();
		System.out.println(randomNumber);
		return randomNumber;
	}

	public void veirfyCompanyNameExist() {
		this.listCompNames();

		if(world.driver.getPageSource().contains("KW")){
			wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(listCompNames(),
					By.xpath("//div[@id='about-section-v2']/div[6]/div/div/div/div/div[2]/div/div")));
			getSelectCompanyName().click();
			}
		else{
			btn_CreateCompany.click();
		}
	}



}
