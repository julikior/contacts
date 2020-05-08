package com.kwri.auto.ui.steps;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsDetailPage;
import com.kwri.auto.ui.pages.ContactsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeeTimelineSteps extends BasePage {
	@Inject
	public SeeTimelineSteps(World world) {
		super(world);
	}

	@Inject
	ContactsPage contactspage;
	
	@Inject
	ContactsDetailPage contactsdetailpage;

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 15);


	@When("I Click on the contact {string}")
	public void i_Click_on_the_contact(String contactName) {
		contactspage.SeeContact(contactName);	
	}
	
	@Then("I Verify that {string} note is present in Timeline")
	public void i_Verify_that_note_is_present_in_Timeline(String string) {
		wait.until(ExpectedConditions.visibilityOf(contactsdetailpage.clicklbl_SourceChanged()));
		contactsdetailpage.clicklbl_SourceChanged().getText().contains(string);
	}
	
	@Then("I Verify that {string} interaction note is present in Timeline")
	public void i_Verify_that_interaction_note_is_present_in_Timeline(String string) {
		wait.until(ExpectedConditions.visibilityOf(contactsdetailpage.clicklbl_ViewedNewListing()));
		contactsdetailpage.clicklbl_ViewedNewListing().getText().contains(string);
	}

	@When("I Verify that {string} activity note is present in Timeline")
	public void i_Verify_that_activity_note_is_present_in_Timeline(String string) {		
		wait.until(ExpectedConditions.visibilityOf(contactsdetailpage.clicklbl_LoggedIntoAgentSite()));
		contactsdetailpage.clicklbl_LoggedIntoAgentSite().getText().contains(string);
	}
	
	@Then("I Verify that Mark as Lead checkbox is checked")
	public void i_Verify_that_Mark_as_Lead_checkbox_is_checked() {
		wait.until(ExpectedConditions.visibilityOf(contactsdetailpage.clicklbl_LoggedIntoAgentSite()));
		assertTrue(contactsdetailpage.clickchbox_MarkAsLead().isSelected());
	}
	@Then("I Verify that Mark as Lead checkbox is unchecked")
	public void i_Verify_that_Mark_as_Lead_checkbox_is_unchecked() {
		wait.until(ExpectedConditions.visibilityOf(contactsdetailpage.clicklbl_LoggedIntoAgentSite()));
		assertFalse(contactsdetailpage.clickchbox_MarkAsLead().isSelected());
	}
	
}
