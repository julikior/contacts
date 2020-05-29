package com.kwri.auto.ui.steps;

import com.kwri.auto.ui.pages.AddContactModal;
import com.kwri.auto.ui.pages.ContactsDetailPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddActivitySteps extends BasePage {
	@Inject
	public AddActivitySteps(World world) {
		super(world);
	}

	@Inject
	ContactsPage contactsHome;

	@Inject
	ContactsDetailPage contactsDetailPage;

	@Inject
	AddContactModal addContact;

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 15);
	JavascriptExecutor jsExecutor;

	@When("I search for contact {string}")
	public void i_search_for_contact(String email) {
		contactsHome.clearFiltersUpgrade();
		contactsHome.getTxt_contactsSearch().sendKeys(email);
		contactsHome.getTxt_contactsSearch().click();
		contactsHome.getBtn_minimizeSearchDropdown().click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='gridcell']/div")));
		contactsHome.getcolumn_lastContacted().click();
	}

	@When("I click on ellipses icon")
	public void i_click_on_ellipses_icon() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getIcon_ellipses()));
		contactsHome.getIcon_ellipses().click();
	}

	@When("I click on Add Activity link")
	public void i_click_on_Add_Activity_link() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getLink_addActivity()));
		contactsHome.getLink_addActivity().click();
	}

	@When("I click on Add Activity link on contact details page")
	public void i_click_on_Add_Activity_link_on_contact_details_page() {
		contactsDetailPage.clickAddActivityLink();
	}

	@When("I fill up Add Activity modal with meeting data")
	public void i_fill_up_Add_Activity_modal_with_meeting_data() throws InterruptedException {
		WebElement activityDropDown = world.driver
				.findElement(By.xpath("//label[text()='Interaction Type']/following::span[contains(@class, 'icon icon--caret-down icon--medium')]"));
		activityDropDown.click();
		Thread.sleep(1000);
		activityDropDown.findElement(By.xpath("//div[text()='Meeting']")).click();
		contactsHome.getTxt_interactionsDesc().click();
		contactsHome.getTxt_interactionsDesc().sendKeys("Automated Meeting Invite");
	}

	@When("^I click on 'Save' button of the activity$")
	public void i_click_on_save_button_of_the_activity() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(contactsHome.getBtn_saveInteraction()));
		contactsHome.getBtn_saveInteraction().click();
	}

	@Then("I select a contact {string} to see contact details")
	public void i_select_a_contact_to_see_contact_details(String contactName) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='gridcell']/div")));
		WebElement cont = world.driver.findElement(By.xpath("//a [contains(@href, '/command/contacts/')]"));
		contactsHome.javaScriptClick(cont);}
}

	/*	wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Interactions')]")));
		Assert.assertTrue(
				world.driver.findElement(By.xpath("//h2[contains(text(),'Interactions')]")).isDisplayed());
	}

	@When("I fill up Add Activity modal with call data")
	public void i_fill_up_Add_Activity_modal_with_call_data() throws InterruptedException {
		WebElement activityDropDown = world.driver
				.findElement(By.xpath("//label[text()='Interaction Type']/following::span[contains(@class, 'icon icon--caret-down icon--medium')]"));
		activityDropDown.click();
		Thread.sleep(1000);
		activityDropDown.findElement(By.xpath("//div[text()='Call']")).click();
		contactsHome.getTxt_interactionsDesc().click();
		contactsHome.getTxt_interactionsDesc().sendKeys("Automated Call");
	}

	@When("I fill up Add Activity modal with text data")
	public void i_fill_up_Add_Activity_modal_with_text_data() throws InterruptedException {
		WebElement activityDropDown = world.driver
				.findElement(By.xpath("//label[text()='Interaction Type']/following::span[contains(@class, 'icon icon--caret-down icon--medium')]"));
		activityDropDown.click();
		Thread.sleep(1000);
		activityDropDown.findElement(By.xpath("//div[text()='Text']")).click();
		contactsHome.getTxt_interactionsDesc().click();
		contactsHome.getTxt_interactionsDesc().sendKeys("Autmated Text");
	}

	@When("I fill up Add Activity modal with quick note data")
	public void i_fill_up_Add_Activity_modal_with_quick_note_data() throws InterruptedException {
		WebElement activityDropDown = world.driver
				.findElement(By.xpath("//label[text()='Interaction Type']/following::span[contains(@class, 'icon icon--caret-down icon--medium')]"));
		activityDropDown.click();
		Thread.sleep(1000);
		activityDropDown.findElement(By.xpath("//div[text()='Quick Note']")).click();
		contactsHome.getTxt_interactionsDesc().click();
		contactsHome.getTxt_interactionsDesc().sendKeys("Automated Note");
	}

	@Then("^I verify that the activity is added to the timeline$")
	public void i_verify_that_the_activity_is_added_to_the_timeline() {
		contactsHome.verifyActivityExist("Automated Meeting Invite");
	}

	@Then("^I verify that the call is added to the timeline$")
	public void i_verify_that_the_call_is_added_to_the_timeline() throws Throwable {
		contactsHome.verifyActivityExist("Automated Call");
	}

	@Then("^I verify that the text is added to the timeline$")
	public void i_verify_that_the_text_is_added_to_the_timeline() throws Throwable {
		contactsHome.verifyActivityExist("Autmated Text");
	}

	@Then("^I verify that the quick note is added to the timeline$")
	public void i_verify_that_the_quick_note_is_added_to_the_timeline() throws Throwable {
		contactsHome.verifyActivityExist("Automated Note");
	}

	/**
	 * Add New Note
	 */

	/**@When("I click on Add Note link")
	public void i_click_on_Add_Note_link() {
		wait.until(ExpectedConditions.visibilityOf(contactsHome.getLink_addNote()));
		contactsHome.getLink_addNote().click();
	}

	@When("I fill up Add New Note modal with note data")
	public void i_fill_up_Add_New_Note_modal_with_note_data() {
		contactsHome.getTxt_noteTitle().click();
		contactsHome.getTxt_noteTitle().sendKeys("New note");

		contactsHome.getTxt_interactionsDesc().click();
		contactsHome.getTxt_interactionsDesc().sendKeys("This is new note description");
	}

	@Then("^I verify that the note is added to the timeline$")
	public void i_verify_that_the_note_is_added_to_the_timeline() throws Throwable {
		contactsHome.verifyActivityExist("New note");
	}
}
*/
