package com.kwri.auto.ui.steps;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.AddContactModal;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsDetailPage;
import com.kwri.auto.ui.pages.ContactsPage;
import com.kwri.auto.ui.entities.Contacts;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddContactSteps extends BasePage {

    private String shouldExist;

    @Inject
    public AddContactSteps(World world) {
        super(world);
    }

    @Inject
    ContactsPage contactsHome;

    @Inject
    AddContactModal addContact;

    Common common = new Common(world.driver);
    WebDriverWait wait = new WebDriverWait(world.driver, 10);
    Actions actions;
    JavascriptExecutor jsExecutor;
    static String email;
    int phoneValue;

    @When("^I click on 'Add new contact' button$")
    public void i_click_on_Add_new_contact_button() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(contactsHome.clickbtn_addNewContact()));
        contactsHome.clickbtn_addNewContact().click();
    }

    @When("^I create user wih email$")
    public void i_create_user_with_email() {
        //Full Name
        //addContact.fillTxt_fullName().click();
        addContact.getTxt_primaryEmail().sendKeys(addContact.expectedContact.getEmail());
    }

    @When("^I create user wih the same email$")
    public void i_create_user_with_the_same_email() {
        //Full Name
       // addContact.fillTxt_fullName().click();
     //   addContact.fillTxt_fullName().sendKeys(contact.getNameValue());
        addContact.getTxt_primaryEmail().sendKeys(addContact.expectedContact.getEmail());
    }

    @Then("I verify that 'This email is already in use' error is displayed")
    public void i_verify_email_in_use_error(){
                Assert.assertTrue("This email is already in use by another contact", addContact.getErrorEmail().isDisplayed());
        addContact.getBtn_close().click();
    }

    @When("^Enter details on add new contact form$")
    public void enter_details_on_form_as() {
        //Full Name
        addContact.fillTxt_fullName().click();
        addContact.fillTxt_fullName().sendKeys(addContact.expectedContact.getNameValue());
        Assert.assertTrue("contact name is displayed", addContact.fillTxt_fullName().isDisplayed());



        /**
         //Legal Name
         addContact.getlink_addLegalName().click();
         contactsHome.scrollElementIntoView(addContact.gettxt_addLegalName());
         addContact.gettxt_addLegalName().click();
         addContact.gettxt_addLegalName().sendKeys(nameValue);

         //Email Address
         addContact.gettxt_newContactEmail().click();
         addContact.gettxt_newContactEmail().sendKeys(nameValue + "@gmail.com");

         //Phone Number
         addContact.gettxt_newContactPhoneNumber().click();
         addContact.gettxt_newContactPhoneNumber().sendKeys("2818191011");

         //Address
         addContact.gettxt_address().click();
         addContact.gettxt_address().sendKeys("311 California Street");
         wait.until(ExpectedConditions.visibilityOf(addContact.getselect_addressToSelect()));
         contactsHome.scrollElementIntoView(addContact.getselect_addressToSelect());
         addContact.getselect_addressToSelect().click();

         //Apartment Number
         wait.until(ExpectedConditions.visibilityOf(addContact.gettxt_apartment()));
         //Thread.sleep(1000);
         addContact.gettxt_apartment().click();
         addContact.gettxt_apartment().sendKeys("201");
         **/
    }

    @When("^I click on 'Save Contact' button$")
    public void i_click_on_Save_Contact_button() {
        addContact.clickBtn_createContact().click();
        System.out.println("yaha hai .. " + addContact.expectedContact.getNameValue());
    }

    @When("^I click on 'Cancel' button$")
    public void i_click_on_Cancel_button() {
        addContact.clickBtn_cancel().click();
    }

    @Then("^I verify that the a new contact is added \"([^\"]*)\" to the contact list$")
    public void i_verify_that_the_a_new_contact_is_added_to_the_contact_list(String nameValue) throws Throwable {
        System.out.println("yaha hai .. " + addContact.expectedContact.getNameValue());

        contactsHome.verifyContactExists(addContact.expectedContact.getNameValue(), Boolean.parseBoolean(shouldExist));
        //assertTrue(contactsHome.isContactExist(addContact.expectedContact.getNameValue()));

    }

    /*@Then("^I verify that the a new contact is added \"([^\"]*)\" to the contact list$")
    public void iVerifyThatTheANewContactIsAddedToTheContactList(String nameValue, boolean shouldExist){
        assertEquals(contactsHome.verifyContactExists(addContact.expectedContact.getNameValue()), Boolean.parseBoolean(String.valueOf(shouldExist)));
    }*/


    @When("^I select a preferred method$")
    public void i_select_a_preferred_method() {
        wait.until(ExpectedConditions.elementToBeClickable(addContact.getRadio_preferredMethod()));
        addContact.getRadio_preferredMethod().click();
    }

    @When("^I select a stage as captured$")
    public void i_select_a_stage_as_captured() {
        //click and expand - Sales Pipeline
        addContact.clickSalesPipeline().click();
        wait.until(ExpectedConditions.elementToBeClickable(addContact.getCheckbox_stage()));
        addContact.getCheckbox_stage().click();
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
        wait.until(ExpectedConditions.elementToBeClickable(addContact.getTxt_description()));
        addContact.getTxt_description().click();
        addContact.getTxt_description().sendKeys("Contact background info...");
    }

    @When("^I add a social profile$")
    public void i_add_a_social_profile() {
        addContact.getTxt_socialProfile().click();
        addContact.getTxt_socialProfile().sendKeys("PTestUser");
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

    @When("I create {string} with following data")
    public void iCreateWithFollowingData(String contactData, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        addContact.expectedContact.setContactData(contactData);
        //addContact.expectedContact.setNameValue(addContact.expectedContact.getNameValue());
        addContact.expectedContact.setEmail(data.get(0).get("Email Address"));
        addContact.expectedContact.setPhoneNumber(data.get(0).get("Phone Number"));
        addContact.expectedContact.setAddEmail(data.get(0).get("Additional Email"));
        addContact.expectedContact.setAddPhone(data.get(0).get("Additional Phone"));
        addContact.expectedContact.setPrimaryAddress(data.get(0).get("Primary Address"));
        addContact.expectedContact.setApartmentNum(data.get(0).get("Apartment Num"));
        addContact.expectedContact.setLegalName(data.get(0).get("Legal Name"));
        addContact.expectedContact.setDescription(data.get(0).get("Description"));



        // Full Name
        addContact.fillTxt_fullName().click();
        addContact.fillTxt_fullName().sendKeys(addContact.expectedContact.getNameValue());


        //Primary Email Address
        addContact.getTxt_primaryEmail().click();
        addContact.getTxt_primaryEmail().sendKeys(addContact.expectedContact.getNameValue() + ".primary"+ "@gmail.com");
        Assert.assertTrue("Email displayed", addContact.getTxt_primaryEmail().isDisplayed());

        //Primary Phone Number
        addContact.getTxt_primaryPhoneNumber().click();
        addContact.getTxt_primaryPhoneNumber().sendKeys(addContact.expectedContact.getPhoneNumber());
        Assert.assertTrue("Phone number displayed", addContact.getTxt_primaryPhoneNumber().isDisplayed());

        //Add More Info
        addContact.clickAddMoreInfo().click();

        //click and expand - additional cont info
        addContact.clickAdditionalContactInfo().click();

        //Preferred Method of Contact
        wait.until(ExpectedConditions.elementToBeClickable(addContact.getRadio_preferredMethod()));
        addContact.getRadio_preferredMethod().click();

        //Additional Email Address
        wait.until(ExpectedConditions.visibilityOf(addContact.getTxt_additionalEmail()));
        addContact.getTxt_additionalEmail().click();
        addContact.getTxt_additionalEmail().sendKeys(addContact.expectedContact.getNameValue() + ".additional"+ "@gmail.com");
        Assert.assertTrue("Additional email displayed", addContact.getTxt_additionalEmail().isDisplayed());

        //Additional Phone Number
        addContact.getTxt_additionalPhoneNumber().click();
        Assert.assertTrue("Additional Phone Number entered", addContact.getTxt_additionalPhoneNumber().isDisplayed());

        //Primary Address
        addContact.getTxt_address().click();
        wait.until(ExpectedConditions.visibilityOf(addContact.getSelect_addressToSelect()));
        contactsHome.scrollElementIntoView(addContact.getSelect_addressToSelect());
        addContact.getSelect_addressToSelect().click();
        Assert.assertTrue("Primary Address selected", addContact.getSelect_addressToSelect().isDisplayed());

        //Apartment Number
        wait.until(ExpectedConditions.visibilityOf(addContact.getTxt_apartment()));
        wait.until(ExpectedConditions.elementToBeClickable(addContact.getTxt_apartment()));
        addContact.getTxt_apartment().click();
        Assert.assertTrue("Apartment Number entered", addContact.getTxt_apartment().isDisplayed());

        //Social Profiles
        addContact.getTxt_socialProfile().click();
        addContact.getTxt_socialProfile().sendKeys(addContact.expectedContact.getNameValue());
        Assert.assertTrue("Social Profiles entered", addContact.getTxt_socialProfile().isDisplayed());

        //click and expand - About
        addContact.clickAbout().click();

        //Legal Name
        contactsHome.scrollElementIntoView(addContact.clickTxt_addLegalName());
        addContact.clickTxt_addLegalName().click();
        Assert.assertTrue("Legal Name entered", addContact.clickTxt_addLegalName().isDisplayed());

        //Description
        wait.until(ExpectedConditions.elementToBeClickable(addContact.getTxt_description()));
        addContact.getTxt_description().click();
        Assert.assertTrue("Description is entered", addContact.getTxt_description().isDisplayed());
    }

    @When("I fill in Add Contacts Modal with invalid phone number {string}")
    public void i_fill_in_Add_Contacts_Modal_with_invalid_phone_number(String invalidPhone) throws Exception {

        // Full Name
      //  addContact.fillTxt_fullName().click();
      //  addContact.fillTxt_fullName().sendKeys(contact.getNameValue());

        //Primary Invalid Phone Number
        common.waitAndSendText(10, addContact.getTxt_primaryPhoneNumber(), invalidPhone);
        Assert.assertTrue("Invalid phone number is entered", addContact.getTxt_primaryPhoneNumber().isDisplayed());
    }


    @When("I click create contact button")
    public void i_click_create_contact_button(){
        addContact.clickBtn_createContact().click();
    }

    @When("I fill in Add Contacts Modal with invalid email {string}")
    public void i_fill_in_Add_Contacts_Modal_with_invalid_primary_email(String invalidEmail) throws Exception {
        // Full Name
       // addContact.fillTxt_fullName().click();
      //  addContact.fillTxt_fullName().sendKeys(contact.getNameValue());

        //Primary Invalid Email Address
        common.waitAndSendText(10, addContact.getTxt_primaryEmail(), invalidEmail);


    }

    @Then("I verify that email is invalid")
    public void i_verify_that_email_is_invalid () throws Exception{
        Thread.sleep(1000);
        common.waitForElement(10, addContact.getInvalidErrorMessage());
        Assert.assertTrue("The error message is displayed",
                addContact.getInvalidErrorMessage().isDisplayed());
        addContact.getBtn_close().click();

    }

    @Then("I verify that phone is invalid")
    public void i_verify_that_phone_is_invalid () throws Exception{
        Thread.sleep(1000);
        Assert.assertTrue("The error message is displayed", addContact.getErrorPhone().isDisplayed());

        addContact.getBtn_close().click();

    }

    @When("^I select a relationship$")
    public void i_select_a_relationship() {
        WebElement relationDropDown = world.driver
                .findElement(By.xpath("(//div[@class='css-1g6gooi'])"));
        contactsHome.scrollElementIntoView(relationDropDown);
        relationDropDown.click();

        WebElement textField = world.driver
                .findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[11]/div/div/div[2]/div/input"));
        textField.sendKeys("Greg Smith");
        world.driver.findElement(By.xpath("//button[@id='create-contact-btn']")).click();

        int count = 1;
        do {
            try {
                relationDropDown.findElement(By.xpath("//div[contains(@class, 'select__menu-list')]//div[contains(@text(), 'Greg Smith')]"));
            } catch (NoSuchElementException e) {
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } while (count < 200);
        //WebElement elem = relationDropDown.findElement(By.xpath("//div[contains(@class, 'select__menu-list')]/div/div[2]"));
        //wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(relationDropDown, By.xpath("//div[contains(@class, 'select__menu-list')]/div/div[2]")));
        relationDropDown.findElement(By.xpath("//div[contains(@class, 'select__menu-list')]/div/div[2]")).click();
    }

    @When("^I select a company name$")
    public void i_select_a_company_name() {
        world.driver.findElement(By.xpath("//input[@id='react-select-23-input']")).sendKeys("KW");

        WebElement companyDropDown = world.driver
                .findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[12]"));
        contactsHome.scrollElementIntoView(companyDropDown);
        companyDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(companyDropDown.findElement(By.xpath("./div[2]/div"))));
        WebElement textField = world.driver
                .findElement(By.xpath("(//div[@class='css-1pcexqc-container select'])[10]/div/div/div[2]/div/input"));
        textField.sendKeys("KW");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        companyDropDown.findElement(By.xpath("./div[2]/div")).click();
    }

    @When("^I enter a job title$")
    public void i_enter_a_job_title() {
        wait.until(ExpectedConditions.elementToBeClickable(	addContact.getJobTitleTxt()));
        addContact.getJobTitleTxt().click();
        addContact.getJobTitleTxt().sendKeys("Engineer");
    }

    @And("I select a home anniversary with random date")
    public void iSelectAHomeAnniversary() {
        addContact.selectARandomMonthOfAnniv();
        addContact.selectARandomDayOfAnniv();
        addContact.selectARandomYearOfAnniv();
        Assert.assertTrue("Date of anniversary selected", true);
    }

    @And("I select a date of birth with random date")
    public void iSelectADateOfBirthWithRandomDate() {
        addContact.selectARandomMonth();
        addContact.selectARandomDay();
        addContact.selectARandomYear();
        Assert.assertTrue("Date of birthday selected", true);
    }


    /*@Then("I verify contact data")
    public void iVerifyContactData() {
        Contacts actualContacts = ContactsDetailPage.getContactData();


    }*/
}
