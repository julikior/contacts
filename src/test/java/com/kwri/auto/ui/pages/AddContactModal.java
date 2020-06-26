package com.kwri.auto.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	@Inject
	ContactsPage contactsHome;

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);
	Actions actions = new Actions(world.driver);

	@FindBy(xpath = "//input[@name='info.fullName']")
	private WebElement txt_fullName;

	@FindBy(xpath = "//input[@name='info.legalName']")
	private WebElement txt_addLegalName;

	@FindBy(xpath = "//input[@name='addresses[0]']")
	private WebElement txt_address;

	@FindBy(xpath = "//*[contains(label, 'Apt/Unit/Suite')]//child::input")
	private WebElement txt_apartment;

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

	@FindBy(xpath = "//*[@id='about-section-v2']/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div/div[1]/div[1]")
	private WebElement txt_RealtionName;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[6]/div[1]/div/div/div/div/div[1]/div[2]/div/input")
	private WebElement inputCompName;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[6]/div[1]/div/div/div/div[2]/div/div/div")
	private WebElement btn_CreateCompany;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement btn_AddRelationships;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div[text() = ('Loading...')]")
	private WebElement contactLoading;

	@FindBy(xpath = "//div[@id='about-section-v2']/div[6]/div/div/div/div/div[2]/div/div[text() = ('Loading...')]")
	private WebElement companyLoading;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div")
	private WebElement firstElement;

	@FindBy(xpath = "//*[@id='about-section-v2']/div[6]/div[1]/div/div/div/div[2]//child::div")
	private WebElement firstCompElement;

	private static final String relatName = "//*[@id='about-section-v2']/div[5]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div[contains(text(), '%s')]";

	private static final String selectCompanyName = "//div[@id='about-section-v2']/div[6]/div/div/div/div/div[2]/div/div[text()='%s']";

	private static final String select_primaryAddress = "(//div[contains(text(),'%s')])[1]";

	public WebElement getBtn_close() {
		common.waitAndClick(50, btn_close);
		return btn_close;
	}

	public WebElement fillTxt_fullName() {
		return txt_fullName;
	}

	public WebElement clickTxt_addLegalName() {
		return txt_addLegalName;
	}

	public WebElement fillTxt_address() {
		return txt_address;
	}

	public WebElement clickTxt_apartment() {
		common.waitAndClick(50, txt_apartment);
		return txt_apartment;
	}

	public WebElement fillTxt_primaryEmail() {
		common.waitForElement(30, txt_primaryEmail);
		return txt_primaryEmail;
	}

	public WebElement clickTxt_additionalEmail() {
		common.waitAndClick(30, txt_additionalEmail);
		return txt_additionalEmail;
	}

	public WebElement fillTxt_primaryPhoneNumber() {
		common.waitForElement(30, txt_primaryPhoneNumber);
		return txt_primaryPhoneNumber;
	}

	public WebElement getTxt_additionalPhoneNumber() {
		return txt_additionalPhoneNumber;
	}

	public void clickRadio_preferredMethod() {
		common.waitAndClick(30, radio_preferredMethod);
	}

	public WebElement fillTxt_socialProfile() {
		return txt_socialProfile;
	}

	public WebElement getJobTitleTxt() {
		return txt_jobTitle;
	}

	public WebElement fillTxt_description() {
		common.waitAndClick(30, txt_description);
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

	public void clickBtn_createContact() {
		common.waitAndClick(30, btn_createContact);
	}

	public void clickBtn_cancel() {
		common.waitAndClick(30, btn_cancel);
	}

	public WebElement clickzone_overlay() {
		wait.until(ExpectedConditions.invisibilityOf(zone_overlay));
		return zone_overlay;
	}

	public void clickAddMoreInfo() {
		common.waitAndClick(30, add_more_info);
	}

	public void clickAdditionalContactInfo() {
		common.waitAndClick(30, additional_contact_info);
	}

	public WebElement clickAbout() {
		return icon_about;
	}

	public WebElement getInvalidErrorMessage() {
		common.waitForElement(30, error_invalidEmail);
		return error_invalidEmail;
	}

	public WebElement getErrorEmail() {
		common.waitForElement(30, error_email);
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

	public WebElement selectRelation() {
		return drpdwn_relationships;
	}

	public WebElement txtInputRelation() {
		return inputRelation;
	}

	public WebElement txtCompanyName() {
		return inputCompName;
	}

	public WebElement getFirstElement() {
		return firstElement;
	}

	public WebElement getFirstCompElement() {
		return firstCompElement;
	}

	public void clickTxt_socialProfile(String socialProfile) {
		common.waitAndClick(30, txt_socialProfile);
		fillTxt_socialProfile().clear();
		fillTxt_socialProfile().sendKeys(socialProfile);
	}

	public void fillJobTitle(String jobTitle) {
		wait.until(ExpectedConditions.elementToBeClickable(getJobTitleTxt()));
		getJobTitleTxt().sendKeys(jobTitle);
	}

	public void fillLegalName(String legalName) {
		common.waitForElement(30, clickAbout());
		clickAbout().click();
		contactsHome.scrollElementIntoView(clickTxt_addLegalName());
		clickTxt_addLegalName().sendKeys(legalName);
	}

	public void verifyEmailInUse() {
		Assert.assertTrue("This email is already in use by another contact", getErrorEmail().isDisplayed());
		common.waitAndClick(100, btn_close);
		getBtn_close().click();
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

	private void waitContactsLoading() {
		try {
			common.waitForElement(10, contactLoading);
			common.waitToDisappear(10, contactLoading);
		} catch (StaleElementReferenceException | TimeoutException e) {
			e.printStackTrace();
		}
	}

	private void waitCompaniesLoading() {
		try {
			common.waitForElement(10, companyLoading);
			common.waitToDisappear(10, companyLoading);
		} catch (StaleElementReferenceException | TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void addCompanyName(String company) {
		txtCompanyName().click();
		wait.until(ExpectedConditions.elementToBeClickable(txtCompanyName()));
		txtCompanyName().sendKeys(company);
		waitCompaniesLoading();

		if(!(getFirstCompElement().getText().equals("Create Company"))) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(selectCompanyName, company)))).click();
		} else {
			btn_CreateCompany.click();
		}
	}

	public void setRelationship(String relationName){
		contactsHome.scrollElementIntoView(selectRelation());
		selectRelation().click();
		wait.until(ExpectedConditions.elementToBeClickable(txtInputRelation()));
		txtInputRelation().sendKeys(relationName);
		waitContactsLoading();

			if (!(getFirstElement().getText().equals("No option"))) {
				//Relation does not exist
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(relatName, relationName)))).click();
			}
			else if(!(getFirstElement().getText().equals(String.format(selectCompanyName, relationName)))) {
				getFirstElement().click();
			} else {
				btn_AddRelationships.click();
			}
	}

	public String getTxtRelationName() {
		common.waitForElement(30, txt_RealtionName);
		return txt_RealtionName.getText();
	}

	public void setDescription(String description){
		wait.until(ExpectedConditions.elementToBeClickable(fillTxt_description()));
		fillTxt_description().sendKeys(description);
	}

	public void fillPrimaryAddress(String primaryAddress) {
		contactsHome.scrollElementIntoView(fillTxt_address());
		fillTxt_address().click();
		fillTxt_address().sendKeys(primaryAddress);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(select_primaryAddress, primaryAddress)))).click();
	}

	public void selectStageAsCaptured() {
		common.waitAndClick(30, caret_SalesPipeline);
		common.waitAndClick(30, checkbox_stage);
	}

	public void verifyInvalidEmail() {
		getInvalidErrorMessage();
		Assert.assertTrue("The error message is displayed",
				getInvalidErrorMessage().isDisplayed());
		getBtn_close();
	}

	public void verifyInvalidPhone() {
		Assert.assertTrue("The error message is displayed", getErrorPhone().isDisplayed());
		getBtn_close();
	}
}
