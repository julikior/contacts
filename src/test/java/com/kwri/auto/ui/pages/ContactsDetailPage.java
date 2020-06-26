package com.kwri.auto.ui.pages;

import com.kwri.auto.ui.entities.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

public class ContactsDetailPage extends BasePage {

	@Inject
	public ContactsDetailPage(World world) {
		super(world);
	}

	@Inject
	ContactsPage contactsHome;

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);
	JavascriptExecutor jsExecutor;
	private static Contacts expectedContact = new Contacts();


	@FindBy(xpath = "//*[@id='contactIntro']/div[2]/span[3]")
	private WebElement icon_archive;

	@FindBy(xpath = "//div[8]//child::button[2]")
	private WebElement btn_archive;

	@FindBy(xpath = "//a[text()='Add Neighborhoods']")
	private WebElement link_addNeighborhoods;

	@FindBy(xpath = "//input[@name='neighborhood-keyword']")
	private WebElement txt_neighborhoodSearch;

	@FindBy(xpath = "//h5[contains(text(),'Source Changed to Command Web Pages')]")
	private WebElement lbl_SourceChanged;

	@FindBy(xpath = "//div[@id='timelineLoginRegister' or @class='cursor-pointer']")
	private WebElement lbl_LoggedIntoAgentSite;

	@FindBy(xpath = "//h5[contains(text(),'Viewed a New Listing')]")
	private WebElement lbl_ViewedNewListing;

	@FindBy(xpath = "//div[@id='activityModal']")
	private WebElement link_AddActivity;

	@FindBy(xpath = "//div[@class='checkbox-wrapper']/child::input")
	private WebElement chbox_MarkAsLead;

	@FindBy(xpath = "//*[@id='contactIntro']/div[2]/span[2]/span")
	private WebElement span_EditIcon;

	@FindBy(xpath = "//*[contains(text(), 'Timeline')]//parent::div")
	private WebElement tab_Timeline;

	@FindBy(xpath = "//*[@id='socialLogo']")
	private WebElement img_SocialLogo;

	private static final String contactAttribute = "//*[text()='%s']//ancestor::div[2]/div[2]";

	private static final String contactName = "//*[@id='contact-name']/h2";

	private static final String phoneNumber = "//*[@id='__next']//child::div[1]/div/a/h3";
	@FindBy(xpath = phoneNumber)
	private WebElement txtPhoneNumber;

	private static String primaryEmail = "//*[@id='__next']//child::div[2]/div/a/h3";

	private static String additionalEmail = "//*[@id='nonPrimaryEmail']";

	private static String apartmentNum = "//*[@id='secondHomeAddress']//ancestor::div[1]/p[2]";

	private static String primaryAddress = "//*[@id='mainHomeAddress']//ancestor::div[1]/p[1]";

	private static String socialProfile = "//*[contains(@href, 'https://www.facebook.com')]";

	private static String link_relationName = "//*[@id='relationName']";

	public WebElement clickIcon_archive() { return icon_archive; }

	public WebElement clickLink_AddActivity() { return link_AddActivity; }

	public WebElement clicklbl_ViewedNewListing() {
		return lbl_ViewedNewListing;
	}

	public WebElement clickspan_EditIcon() {
		return span_EditIcon;
	}

	public WebElement clickchbox_MarkAsLead() {
		return chbox_MarkAsLead;
	}

	public WebElement clicklbl_SourceChanged() {
		return lbl_SourceChanged;
	}

	public WebElement clicklbl_LoggedIntoAgentSite() {
		return lbl_LoggedIntoAgentSite;
	}

	public WebElement clickLink_addNeighborhoods() {
		return link_addNeighborhoods;
	}

	public WebElement clickTxt_neighborhoodSearch() {
		return txt_neighborhoodSearch;
	}

	public WebElement getImg_SocialLogo(){
		return img_SocialLogo;
	}

	public WebElement clickArchive() {
		return icon_archive;
	}

	public WebElement clickBtnArchive() {
		return btn_archive;
	}

	public enum TimelineItems {
		TODAY, WEEK, MONTH, ALL
	}

	public void clickEditIcon (String Edit) {
		common.waitAndClick(30, span_EditIcon);
	}

	public void clickAddActivityLink () {
		this.wait.until(ExpectedConditions.visibilityOf(clickLink_AddActivity()));
		this.clickLink_AddActivity().click();
	}

	public Contacts getContactData (){
		Contacts contact = new Contacts();
		this.wait.until(ExpectedConditions.visibilityOf(clickspan_EditIcon()));
		contact.setNameValue(getContactName());
		contact.setPhoneNumber(getPhoneNumber());
		contact.setEmail(getPrimaryEmail());
		contact.setAddEmail(getAdditionalEmail());
		contact.setAddPhone(getAdditionalPhone());
		contact.setPrimaryAddress(getPrimaryAddress());
		contact.setApartmentNum(getApartmentNum());
		contact.setLegalName(getContactAttribute("Legal Name"));
		contact.setDescription(getContactAttribute("Description"));
		contact.setJobTitle(getContactAttribute("Title"));
		contact.setSocialProfile(getSocialProfile());
		contact.setBirthday(getContactAttribute("Birthday"));
		contact.setHomeAnniversary(getContactAttribute("Home Anniversary"));
		contact.setRelationName(getRelationship());
		contact.setCompanyName(getContactAttribute("Company"));

		return contact;
	}

	private String getContactAttribute(String contactAttributeData) {
		return world.driver.findElement(By.xpath(String.format(contactAttribute, contactAttributeData))).getText();
	}

	private String getContactName(){
		return world.driver.findElement(By.xpath(ContactsDetailPage.contactName)).getText();
	}

	private String getPrimaryEmail(){
		return world.driver.findElement(By.xpath(ContactsDetailPage.primaryEmail)).getText();
	}

	private String getAdditionalEmail(){
		return world.driver.findElement(By.xpath(ContactsDetailPage.additionalEmail)).getText();
	}

	private String getPhoneNumber() {
		String phoneFmt = world.driver.findElement(By.xpath(ContactsDetailPage.phoneNumber)).getText();
		return phoneFmt.replaceFirst("1", "").replaceAll("[+\\s\\-]", "");
	}

	private String getApartmentNum() {
		contactsHome.scrollElementIntoView(getImg_SocialLogo());
		return world.driver.findElement(By.xpath(ContactsDetailPage.apartmentNum)).getText();
	}

	private String getPrimaryAddress() {
		String primaryAddress =  world.driver.findElement(By.xpath(ContactsDetailPage.primaryAddress)).getText();
		return primaryAddress.replaceFirst("\\nPrimary", "");
	}

	private String getAdditionalPhone() {
		String phoneFmt = getContactAttribute("Phone");
		return phoneFmt.replaceFirst("1", "").replaceAll("[+\\s\\-]", "");
	}

	private String getSocialProfile() {
		return world.driver.findElement(By.xpath(ContactsDetailPage.socialProfile)).getAttribute("href");
	}

	private String getRelationship() {
		return world.driver.findElement(By.xpath(ContactsDetailPage.link_relationName)).getText();
	}

	public void getArchiveIcon() {
		Actions actions = new Actions(world.driver);
		actions.moveToElement(clickArchive()).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(clickBtnArchive()));
		clickBtnArchive().click();
	}



}
