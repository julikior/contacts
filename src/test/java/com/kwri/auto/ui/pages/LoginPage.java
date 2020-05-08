package com.kwri.auto.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.helpers.ConfigFileReader;
import com.kwri.auto.ui.managers.FileReaderManager;
import com.kwri.auto.ui.methods.Common;

public class LoginPage extends BasePage {

	@Inject
	public LoginPage(World world) {
		super(world);
	}

	@Inject
	ConfigFileReader configFileReader;

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);

	@FindBy(xpath = "//input[@id='username']")
	private WebElement txtbx_userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtbx_password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_login;

	@FindBy(xpath = "//button[text()='Accept Cookies']")
	private WebElement cookieButton;

	@FindBy(xpath = "//a[@href='/command/contacts']")
	private WebElement contactsApp;

	@FindBy(xpath = "//img[contains(@src,'https://avatar.kwconnect.com/556397.jpeg')]")
	private WebElement btn_profile;

	@FindBy(xpath = "//div[contains(text(),'Log out')]")
	private WebElement btn_logout;

	public WebElement getContactsApp() {
		return contactsApp;
	}

	public WebElement getBtn_profile() {
		return btn_profile;
	}

	public WebElement getBtn_logout() {
		return btn_logout;
	}

	public void navigateTo_HomePage() {
		world.driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void loginWithCredentials(String username, String password) {
		common.waitForElement(20, txtbx_userName);
		txtbx_userName.sendKeys(username);
		txtbx_password.sendKeys(password);
		btn_login.click();
	}

	public void login() {

		String username = FileReaderManager.getInstance().getConfigReader().getUserName();
		String password = FileReaderManager.getInstance().getConfigReader().getPassword();
		wait.until(ExpectedConditions.visibilityOf(txtbx_userName));
		txtbx_userName.sendKeys(username);

		txtbx_password.sendKeys(password);
		btn_login.click();
	}
	public void LoginAsAgent() {

		String username = FileReaderManager.getInstance().getConfigReader().getPropertyValue("userNameAgent");
		String password = FileReaderManager.getInstance().getConfigReader().getPassword();
		wait.until(ExpectedConditions.visibilityOf(txtbx_userName));

		txtbx_userName.sendKeys(username);
		txtbx_password.sendKeys(password);
		btn_login.click();

	}

	public void navigateTo_ContactsHome() {
		wait.until(ExpectedConditions.visibilityOf(contactsApp));
		contactsApp.click();
		wait.until(ExpectedConditions.urlContains("contacts"));
	}

	public void acceptCookieConsent() {
		wait.until(ExpectedConditions.visibilityOf(contactsApp));
		if (cookieButton.isDisplayed()) {
			cookieButton.click();
		}
	}

	public void logout(){
		wait.until(ExpectedConditions.visibilityOf(getBtn_profile()));
		getBtn_profile().click();
		getBtn_logout().click();
		world.driver.close();
	}
}
