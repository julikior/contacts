package com.kwri.auto.ui.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.kwri.auto.ui.entities.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.junit.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

public class ContactsPage extends BasePage {
	@Inject
	public ContactsPage(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);
	JavascriptExecutor jsExecutor;
	Contacts expectedContact = new Contacts();


	@FindBy(xpath = "//button[text()='Add Contact']")
	private WebElement btn_addNewContact;

	@FindBy(xpath = "//span[contains(@class,'import icon')]")
	private WebElement btn_importContact;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement txt_contactsSearch;

	@FindBy(xpath = "//div[contains(text(),'All Contacts')]")
	private WebElement ddSmartView_AllContacts;

	@FindBy(xpath = "//div[@class='cursor-pointer d-flex align-items-center styles__caretDropdown___25mWi']")
	private WebElement btn_minimizeSearchDropdown;

	@FindBy(xpath = "//span[contains(text(),'Filters')]")
	private WebElement btn_Filters;

	@FindBy(xpath = "//span[contains(text(),'Filters On')]")
	private WebElement btn_FiltersOn;

	@FindBy(xpath = "//a[text()='Clear All']")
	private WebElement lnk_ClearAll;

	@FindBy(xpath = "//div[@class='rt-resizable-header-content' and text()='Last Contacted']")
	private WebElement column_lastContacted;

	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement btn_Apply;

	public WebElement getbtn_Apply() {
		return btn_Apply;
	}

	public WebElement getcolumn_lastContacted() {
		return column_lastContacted;
	}

	public WebElement getlnk_ClearAll() {
		return lnk_ClearAll;
	}

	public void SeeContact(String contactName) {
		world.driver.findElement(By.xpath("//div[text()='" + contactName + "']")).click();
	}

	private static final String contactName = "//*[contains(text(), '%s')]";

	public WebElement clickbtn_addNewContact() {
		return btn_addNewContact;
	}

	public WebElement getddSmartView_AllContacts() {
		return ddSmartView_AllContacts;
	}

	private WebElement getbtn_importContact() {
		return btn_importContact;
	}

	public WebElement getTxt_contactsSearch() {
		return txt_contactsSearch;
	}

	public WebElement getBtn_minimizeSearchDropdown() {
		return btn_minimizeSearchDropdown;
	}

	public WebElement getbtn_Filters() {
		return btn_Filters;
	}

	public WebElement getbtn_FiltersOn() {
		return btn_FiltersOn;
	}


	/**
	 * Locators for Import Contacts Modal
	 */

	@FindBy(xpath = "//span[text()='Import Contacts']")
	private WebElement txt_importContactsHeader;

	@FindBy(xpath = "//div[contains(@class,'dropzone')]/input")
	private WebElement btn_dropFiles;

	@FindBy(xpath = "(//span[text()='Import Contacts'])[2]/..")
	private WebElement btn_ImportContactsOnModal;

	@FindBy(xpath = "//span[text()='Submitted!']")
	private WebElement txt_uploadSuccess;

	@FindBy(xpath = "//span[text()='Finish']/..")
	private WebElement btn_finishUpload;

	private WebElement gettxt_importContactsHeader() {
		return txt_importContactsHeader;
	}

	public WebElement getbtn_ImportContactsOnModal() {
		return btn_ImportContactsOnModal;
	}

	public WebElement getbtn_dropFiles() {
		return btn_dropFiles;
	}

	public WebElement gettext_uploadSuccess() {
		return txt_uploadSuccess;
	}

	public WebElement getbtn_finishUpload() {
		return btn_finishUpload;
	}

	public void clickOnImportContacts() {
		wait.until(ExpectedConditions.visibilityOf(getbtn_importContact()));
		getbtn_importContact().click();
		wait.until(ExpectedConditions.visibilityOf((gettxt_importContactsHeader())));
	}

	public void browseAndUploadContact() {
		String filePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\testData\\ImportContactTestFile.csv";
		getbtn_dropFiles().sendKeys(filePath);
	}

	/**
	 * Share Contact Locators
	 */

	@FindBy(xpath = "//a[text()='Share Contact']")
	private WebElement link_shareContact;

	public WebElement getLink_shareContact() {
		return link_shareContact;
	}

	/**
	 * Locators for contact interactions
	 */

	@FindBy(xpath = "//span[@class='icon icon--ellipsis-horizontal icon--medium text-neutral05 cursor-pointer']")
	private WebElement icon_ellipses;

	@FindBy(xpath = "//a[text()='Add Activity']")
	private WebElement link_addActivity;

	@FindBy(xpath = "//label[contains(text(),'Description')]/../textarea")
	private WebElement txt_interactionsDesc;

	@FindBy(xpath = "//button/span[contains(text(),'Save')]")
	private WebElement btn_saveInteraction;

	@FindBy(xpath = "//a[contains(text(),'Add Note')]")
	private WebElement link_addNote;

	@FindBy(xpath = "//label[contains(text(),'Note Title')]/../input")
	private WebElement txt_noteTitle;

	public WebElement getIcon_ellipses() {
		return icon_ellipses;
	}

	public WebElement getLink_addActivity() {
		return link_addActivity;
	}

	public WebElement getTxt_interactionsDesc() {
		return txt_interactionsDesc;
	}

	public WebElement getBtn_saveInteraction() {
		return btn_saveInteraction;
	}

	public WebElement getLink_addNote() {
		return link_addNote;
	}

	public WebElement getTxt_noteTitle() {
		return txt_noteTitle;
	}

	public void verifyActivityExist(String name) {
		Assert.assertTrue(world.driver.findElement(By.xpath("//p[contains(text(),'" + name + "')]")).isDisplayed(),
				"Activity is not displayed in Timeline");
	}

	/**
	 * Locators for archive contact
	 */

	@FindBy(xpath = "//a[text()='Archive']")
	private WebElement link_archiveContact;

	@FindBy(xpath = "//button//span[text()='Archive']")
	private WebElement btn_archiveContactConfirm;

	@FindBy(xpath = "//span[text()='Confirm Archive Contacts']")
	private WebElement label_archiveContactHeader;

	@FindBy(xpath = "//span[text()='Your search did not return any contacts. Please adjust your search query.']")
	private WebElement contact_not_found_msg;

	@FindBy(xpath = "//div[text()='Loading...']")
	private WebElement txt_Loading;

	public WebElement getLink_archiveContact() {
		return link_archiveContact;
	}

	public WebElement getBtn_archiveContactConfirm() {
		return btn_archiveContactConfirm;
	}

	public WebElement getLabel_archiveContactHeader() {
		return label_archiveContactHeader;
	}

	/**
	 * Generic functions
	 */

	public void scrollElementIntoView(WebElement element) {
		jsExecutor = (JavascriptExecutor) world.driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void javaScriptClick(WebElement element) {
		jsExecutor = (JavascriptExecutor) world.driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void wait_Until_Contact_Table_Loads() {
		// wait until contacts are loaded
		wait.until(ExpectedConditions.invisibilityOfAllElements(txt_Loading));
	}


	public boolean isElementPresent(String xpath) {
		try {
			world.driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clearFiltersUpgrade() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		if (isElementPresent("//span[(text()='Filters')]")) {
			wait.until(ExpectedConditions.visibilityOf(btn_addNewContact));
		} else {
			getbtn_FiltersOn().click();
			wait.until(ExpectedConditions.visibilityOf(getlnk_ClearAll()));
			getlnk_ClearAll().click();
			getbtn_Apply().click();
			wait.until(ExpectedConditions.visibilityOf(btn_addNewContact));
		}
	}

	public void searchAndClickOnFirstContact(String searchName) {
		// search for contact
		this.getTxt_contactsSearch().sendKeys(searchName);
		this.getTxt_contactsSearch().click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> contactList = world.driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"));

		String fullName = contactList.get(1).findElement(By.xpath("//div[2]/div/a/div[1]")).getText();
		System.out.println("full name hai : " + fullName);

		//click on ellipses icon
		world.driver.findElement(By.xpath("(//div[@class='rt-tbody']//div[@class='rt-tr-group']//div/div/div/div/span)[1]")).click();
	}

	public void searchAndOpenFirstContactPage(String searchName) {
		// search for contact
		this.getTxt_contactsSearch().sendKeys(searchName);
		this.getTxt_contactsSearch().click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> contactList = world.driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"));

		String fullName = contactList.get(1).findElement(By.xpath("//div[2]/div/a/div[1]")).getText();
		System.out.println("full name hai : " + fullName);

		//click on user and open contact detail page
		world.driver.findElement(By.xpath("//div[2]/div/a/div[1]")).click();
	}

	public Contacts verifyContactExists(String contactName, boolean shouldExist) {
		this.wait_Until_Contact_Table_Loads();
		// search for contact
		this.getTxt_contactsSearch().sendKeys(expectedContact.getNameValue());
		this.getTxt_contactsSearch().click();
		this.wait_Until_Contact_Table_Loads();

		if(shouldExist){Assert.assertTrue((world.driver.findElement(By.xpath("//div[contains(text(), '" +
				contactName.replaceAll("AutoUser", "") + "')]")).isDisplayed()), contactName + " was not found");}
		else{Assert.assertFalse((world.driver.findElements(By.xpath("//div[contains(text(), '" +
				contactName.replaceAll("AutoUser", "") + "')]")).size() > 0), contactName + " still exists");}


		try {
			Assert.assertTrue(true, "Contact exist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expectedContact;

	}


	/*public boolean isContactExist(String nameValue) {
		world.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getTxt_contactsSearch().sendKeys(expectedContact.getNameValue());
		return common.isPresent(100, world.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div[1]/div/div[2]/div/a/div")));
	}*/
}
