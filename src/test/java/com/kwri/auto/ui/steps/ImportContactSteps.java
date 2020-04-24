package com.kwri.auto.ui.steps;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class ImportContactSteps extends BasePage {

	@Inject
	public ImportContactSteps(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);

	@Inject
	ContactsPage contactsHome;

	/**
	 * ------------ Applitools Eyes Capabilities --------------
	 */
	// Initialize the eyes SDK and set your private API key.


	/**
	 * ------------- applitools Eyes Cap end ----------
	 */

	@When("I click on Import Contact button")
	public void i_click_on_Import_Contact_button() {
		// Visual checkpoint.
		contactsHome.clickOnImportContacts();	
		// Visual checkpoint.
	}

	@When("I browse and upload contact csv file")
	public void i_browse_and_upload_contact_csv_file() {
		contactsHome.browseAndUploadContact();
	}

	@When("I click on Import Contacts button to finish importing")
	public void i_click_on_Import_Contacts_button_to_finish_importing() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getbtn_ImportContactsOnModal()));
		contactsHome.getbtn_ImportContactsOnModal().click();
	}

	@Then("I verify the success message with title {string}")
	public void i_verify_the_success_message_with_title(String string) {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.gettext_uploadSuccess()));
		Assert.assertEquals(contactsHome.gettext_uploadSuccess().getText(), "Submitted!");
	}

	@Then("I click on Finish button")
	public void i_click_on_Finish_button() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getbtn_finishUpload()));
		contactsHome.getbtn_finishUpload().click();
		contactsHome.browseAndUploadContact();
	}

	@Then("I verify that the new contact is added to the contact list")
	public void i_verify_that_the_new_contact_is_added_to_the_contact_list() throws InterruptedException {
		contactsHome.wait_Until_Contact_Table_Loads();
		Thread.sleep(2000);
		//clear all filters
		// contactsHome.clearFilters();
		
		contactsHome.getTxt_contactsSearch().sendKeys("Neeti UploadUser");
		contactsHome.getTxt_contactsSearch().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Neeti UploadUser']")));
		Assert.assertTrue(world.driver.findElement(By.xpath("//div[text()='Neeti UploadUser']")).isDisplayed());
	}

}