package com.kwri.auto.ui.steps;

import com.kwri.auto.ui.pages.ContactsDetailPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteContactSteps extends BasePage {
	@Inject
	public DeleteContactSteps(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);

	@Inject
	ContactsPage contactsHome;

	@Inject
	ContactsDetailPage contactsDetailPage;

	@When("I click on archive icon")
	public void i_click_on_archive_icon() {
		wait.until(ExpectedConditions.visibilityOf(contactsDetailPage.clickIcon_archive()));
		contactsDetailPage.clickIcon_archive().click();
	}

	@When("I search and open first contact page starting with {string}")
	public void i_search_and_open_first_contact_page(String contactName) {
		contactsHome.searchAndOpenFirstContactPage("AutoUser");
	}

	@When("I search and select first contact starting with {string}")
	public void i_search_and_select_first_contact_starting_with(String contactName) {
		contactsHome.searchAndClickOnFirstContact("AutoUser");
	}

	@When("I click on Archive link")
	public void i_click_on_Archive_link() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getLink_archiveContact()));
		contactsHome.getLink_archiveContact().click();
	}

	@When("I click on Archive button on Confirm Archive modal")
	public void i_click_on_Archive_button_on_Confirm_Archive_modal() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getLabel_archiveContactHeader()));
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getBtn_archiveContactConfirm()));
		contactsHome.getBtn_archiveContactConfirm().click();
		Thread.sleep(3000);
	}

	@Then("I verify that {string} is archived from contact list")
	public void i_verify_that_is_archived_from_contact_list(String string) {
	}
}
