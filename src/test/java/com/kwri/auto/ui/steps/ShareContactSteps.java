package com.kwri.auto.ui.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsPage;
import com.kwri.auto.ui.pages.ShareContactsPage;

import cucumber.api.java.en.When;

public class ShareContactSteps extends BasePage {

	@Inject
	public ShareContactSteps(World world) {
		super(world);
	}

	@Inject
	ContactsPage contactsHome;
	
	@Inject
	ShareContactsPage shareContacts;
	
	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);
	
	@When("I click on Share contact link")
	public void i_click_on_Share_contact_link() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getLink_shareContact()));
		contactsHome.getLink_shareContact().click();
		wait.until(ExpectedConditions.visibilityOf(shareContacts.getLabel_ShareContactHeader()));
	}

	@When("On share contact modal, I select a Team")
	public void on_share_contact_modal_I_select_a_Team() {
		shareContacts.selectTeamToShareContact();
	}

	@When("I select members of team to share contact")
	public void i_select_members_of_team_to_share_contact() {
		shareContacts.selectAgentsToShareContact();
	}

	@When("I enable the toggle for agents to edit contacts")
	public void i_enable_the_toggle_for_agents_to_edit_contacts() {
		wait.until(ExpectedConditions.visibilityOf(shareContacts.getToggle_EditContact()));
		shareContacts.getToggle_EditContact().click();
	}

	@When("I click on share button")
	public void i_click_on_share_button() {
		wait.until(ExpectedConditions.visibilityOf(shareContacts.getBtn_ShareContact()));
		shareContacts.getBtn_ShareContact().click();
	}

	@When("I verify that contact is successfully shared")
	public void i_verify_that_contact_is_successfully_shared() {

	}
	
	/**
	 * Bulk share contact steps
	 */
	
	@When("I click on Select Bulk action dropdown")
	public void i_click_on_Select_Bulk_action_dropdown() {
	
	}

	@When("I select {string} option")
	public void i_select_option(String string) {
	   
	}
}