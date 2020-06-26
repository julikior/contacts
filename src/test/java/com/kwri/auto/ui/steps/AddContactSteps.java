package com.kwri.auto.ui.steps;

import com.google.inject.Inject;
import com.kwri.auto.ui.Enum.Month;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.entities.Contacts;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.AddContactModal;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsDetailPage;
import com.kwri.auto.ui.pages.ContactsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class AddContactSteps extends BasePage {

    static String nameValue = "AutoUser" + RandomStringUtils.random(5, true, false);
    static String email = "AutoUser" + RandomStringUtils.random(5, true, false) + "@test.com";

    @Inject
    public AddContactSteps(World world) {
        super(world);
    }

    @Inject
    ContactsPage contactsHome;

    @Inject
    AddContactModal addContact;

    @Inject
    ContactsDetailPage ContactsDetailPage;

    Common common = new Common(world.driver);
    WebDriverWait wait = new WebDriverWait(world.driver, 10);
    private static Contacts expectedContact = new Contacts();

    @When("^I click on 'Add new contact' button$")
    public void i_click_on_Add_new_contact_button() throws Throwable {
        contactsHome.clickAddContactButton();
    }

    @When("^I create user wih email$")
    public void i_create_user_with_email() {
        //Full Name
        addContact.fillTxt_fullName().sendKeys(nameValue);
        addContact.fillTxt_primaryEmail().sendKeys(email);
    }

    @When("^I create user wih the same email$")
    public void i_create_user_with_the_same_email() {
        //Full Name
        addContact.fillTxt_fullName().sendKeys(nameValue);
        addContact.fillTxt_primaryEmail().sendKeys(email);
    }

    @Then("I verify that 'This email is already in use' error is displayed")
    public void i_verify_email_in_use_error(){
        addContact.verifyEmailInUse();
    }

    @When("^Enter details on add new contact form$")
    public void enter_details_on_form_as() {
        //Full Name
        addContact.fillTxt_fullName().sendKeys(nameValue);
    }

    @When("^I click on 'Save Contact' button$")
    public void i_click_on_Save_Contact_button() {
        addContact.clickBtn_createContact();
        System.out.println(nameValue);
    }

    @When("^I click on 'Cancel' button$")
    public void i_click_on_Cancel_button() {
        addContact.clickBtn_cancel();
    }

    @Then("^I verify that the a new contact is added \"([^\"]*)\" to the contact list$")
    public void i_verify_that_the_a_new_contact_is_added_to_the_contact_list(String shouldExist) throws Throwable {
        System.out.println("yaha hai ..  " + nameValue);
        contactsHome.verifyContactExists(nameValue, Boolean.parseBoolean(shouldExist));
    }

    @When("^I select a preferred method$")
    public void i_select_a_preferred_method() {
       addContact.clickTxt_additionalEmail();
    }

    @When("^I select a stage as captured$")
    public void i_select_a_stage_as_captured() {
        //click and expand - Sales Pipeline
        addContact.selectStageAsCaptured();
    }

    @When("^I select a lead source \"([^\"]*)\"$")
    public void i_select_a_lead_source(String leadSource) {
        addContact.leadSourceDropDown().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addContact.leadSourceDropDown().click();
    }

    @When("^I select a system tag \"([^\"]*)\"$")
    public void i_select_a_system_tag(String tagName) {
        WebElement systemTagsDropDown = world.driver
                .findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[4]"));
        systemTagsDropDown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        systemTagsDropDown.findElement(By.xpath("./div[2]/div")).click();
    }

    @When("^I select a custom tag \"([^\"]*)\"$")
    public void i_select_a_custom_tag(String tagName) {
        WebElement systemTagsDropDown = world.driver
                .findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[5]"));
        systemTagsDropDown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        systemTagsDropDown.findElement(By.xpath("./div[2]/div")).click();
    }

    @When("^I enter a description$")
    public void i_enter_a_description() {
        addContact.setDescription(expectedContact.getDescription());
    }

    @When("^I add a social profile$")
    public void i_add_a_social_profile() {
        addContact.fillTxt_socialProfile().sendKeys(nameValue);
    }

    @When("^I select a transaction time frame$")
    public void i_select_a_transaction_time_frame() {
        WebElement transactionDropDown = world.driver
                .findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[11]"));
        transactionDropDown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transactionDropDown.findElement(By.xpath("./div[2]/div")).click();
    }

    @When("^I enter a new custom field$")
    public void i_enter_a_new_custom_field() throws Throwable {
        // scroll element into view and click on add custom field lik
        contactsHome.scrollElementIntoView(addContact.getLink_addCustomField());
        addContact.getLink_addCustomField().click();
        wait.until(ExpectedConditions.visibilityOf(addContact.getLabel_selectCustomField()));

        // month
        WebElement customField = world.driver.findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[15]"));
        customField.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customField.findElement(By.xpath("./div[2]/div/div[1]")).click();

        //wait for custom field text box to appear and enter value
        wait.until(ExpectedConditions.visibilityOf(addContact.getInput_customField()));
        addContact.getInput_customField().click();
        addContact.getInput_customField().sendKeys("Custom Agent PTest");
    }

    @When("I fill in Add Contacts Modal with following data")
    public void iCreateWithFollowingData(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        expectedContact.setNameValue(data.get(0).get(nameValue));
        expectedContact.setEmail(data.get(0).get("Email Address"));
        expectedContact.setPhoneNumber(data.get(0).get("Phone Number"));
        expectedContact.setAddEmail(data.get(0).get("Additional Email"));
        expectedContact.setAddPhone(data.get(0).get("Additional Phone"));
        expectedContact.setPrimaryAddress(data.get(0).get("Primary Address"));
        expectedContact.setApartmentNum(data.get(0).get("Apartment Num"));
        expectedContact.setLegalName(data.get(0).get("Legal Name"));
        expectedContact.setDescription(data.get(0).get("Description"));
        expectedContact.setJobTitle(data.get(0).get("Job Title"));
        expectedContact.setRelationName(data.get(0).get("Relation Name"));
        expectedContact.setCompanyName(data.get(0).get("Company Name"));
        expectedContact.setNameValue(nameValue);
        expectedContact.setEmail(nameValue + ".primary"+ "@gmail.com");
        expectedContact.setAddEmail(nameValue + ".additional"+ "@gmail.com");
        expectedContact.setSocialProfile("https://www.facebook.com/" + expectedContact.getNameValue());

        // Full Name
        addContact.fillTxt_fullName().sendKeys(expectedContact.getNameValue());

        //Primary Email Address
        addContact.fillTxt_primaryEmail().sendKeys(expectedContact.getEmail());

        //Primary Phone Number
        addContact.fillTxt_primaryPhoneNumber().sendKeys(expectedContact.getPhoneNumber());

        //Add More Info
        addContact.clickAddMoreInfo();

        //click and expand - additional cont info
        addContact.clickAdditionalContactInfo();

        //Preferred Method of Contact
        addContact.clickRadio_preferredMethod();

        //Additional Email Address
        addContact.clickTxt_additionalEmail().sendKeys(nameValue + ".additional"+ "@gmail.com");

        //Additional Phone Number
        addContact.getTxt_additionalPhoneNumber().sendKeys(expectedContact.getAddPhone());

        //Primary Address
        //addContact.fillPrimaryAddress();
        addContact.fillPrimaryAddress(expectedContact.getPrimaryAddress());

        //Apartment Number
        addContact.clickTxt_apartment().sendKeys(expectedContact.getApartmentNum());

        //Social Profiles
        addContact.clickTxt_socialProfile(expectedContact.getNameValue());

        //click and expand - About
        //addContact.clickAbout().click();

        //Legal Name
        addContact.fillLegalName(expectedContact.getLegalName());

        //Description
        addContact.setDescription(expectedContact.getDescription());

        //RelationShip
        addContact.setRelationship(expectedContact.getRelationName());
        expectedContact.setRelationName(addContact.getTxtRelationName());

        //Company Name
        addContact.addCompanyName(expectedContact.getCompanyName());
    }

    @When("I fill in Add Contacts Modal with invalid phone number {string}")
    public void i_fill_in_Add_Contacts_Modal_with_invalid_phone_number(String invalidPhone) throws Exception {
        // Full Name
        addContact.fillTxt_fullName().sendKeys(expectedContact.getNameValue());

        //Primary Invalid Phone Number
        common.waitAndSendText(10, addContact.fillTxt_primaryPhoneNumber(), invalidPhone);
    }

    @When("I click create contact button")
    public void i_click_create_contact_button(){
        addContact.clickBtn_createContact();
    }

    @When("I fill in Add Contacts Modal with invalid email {string}")
    public void i_fill_in_Add_Contacts_Modal_with_invalid_primary_email(String invalidEmail) throws Exception {
        // Full Name
        addContact.fillTxt_fullName().sendKeys(expectedContact.getNameValue());

        //Primary Invalid Email Address
        addContact.fillTxt_primaryPhoneNumber().sendKeys(invalidEmail);
    }

    @Then("I verify that email is invalid")
    public void i_verify_that_email_is_invalid () throws Exception{
        Thread.sleep(1000);
        addContact.verifyInvalidEmail();
    }

    @Then("I verify that phone is invalid")
    public void i_verify_that_phone_is_invalid () throws Exception{
        Thread.sleep(1000);
        addContact.verifyInvalidPhone();
    }

    @When("^I select a company name")
    public void i_select_a_company_name() {
        addContact.addCompanyName(expectedContact.getCompanyName());
    }

    @When("^I enter a job title$")
    public void i_enter_a_job_title() {
        addContact.fillJobTitle(expectedContact.getJobTitle());
    }

    @And("I select a home anniversary with random date")
    public void i_select_a_home_anniversary() {
        int randomMonth = addContact.selectARandomMonthOfAnniv();
        int randomDay = addContact.selectARandomDayOfAnniv();
        int randomYear = addContact.selectARandomYearOfAnniv();
        String anniversary = (Month.values()[randomMonth]) + " " + (randomDay+1) + ", " + (Calendar.getInstance().get(Calendar.YEAR) - randomYear);
        expectedContact.setHomeAnniversary(anniversary);
    }

    @And("I select a date of birth with random date")
    public void i_select_a_date_of_birth_with_random_date() {
        addContact.select_MonthOfBirthday().click();
        //wait.until(ExpectedConditions.visibilityOf(addContact.selectMonthBirth()));
        int randomMonthOfBirth = addContact.selectARandomMonth();
        int randomDayOfBirth = addContact.selectARandomDay();
        int randomYearOfBirth = addContact.selectARandomYear();
        String birthday = (Month.values()[randomMonthOfBirth]) + " " + (randomDayOfBirth+1) + ", " + (Calendar.getInstance().get(Calendar.YEAR) - randomYearOfBirth);
        expectedContact.setBirthday(birthday);
    }

    @Then("I verify contact data")
    public void i_verify_contact_data() {
        Contacts actualContacts = ContactsDetailPage.getContactData();
        assertReflectionEquals(expectedContact, actualContacts);
    }

    @And("I archive the contact")
    public void i_archive_the_contact() {
        ContactsDetailPage.getArchiveIcon();
    }
}
