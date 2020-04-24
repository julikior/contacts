package com.kwri.auto.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

public class ShareContactsPage extends BasePage {
	@Inject
	public ShareContactsPage(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);

	@Inject
	ContactsPage contactsHome;

	@FindBy(xpath = "//span[text()='Share Contacts']")
	private WebElement label_ShareContactHeader;

	@FindBy(xpath = "//div[@class='toggle']")
	private WebElement toggle_EditContact;

	@FindBy(xpath = "//span[text()='Share']/..")
	private WebElement btn_ShareContact;
	
	public WebElement getLabel_ShareContactHeader() {
		return label_ShareContactHeader;
	}

	public WebElement getToggle_EditContact() {
		return toggle_EditContact;
	}

	public WebElement getBtn_ShareContact() {
		return btn_ShareContact;
	}

	public void selectTeamToShareContact() {
		WebElement teamDropDown = world.driver.findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[2]"));
		teamDropDown.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		teamDropDown.findElement(By.xpath("./div[2]/div")).click();
	}

	public void selectAgentsToShareContact() {
		WebElement agentDropdown = world.driver.findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[3]"));
		agentDropdown.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		agentDropdown.findElement(By.xpath("./div[2]/div")).click();
	}
}