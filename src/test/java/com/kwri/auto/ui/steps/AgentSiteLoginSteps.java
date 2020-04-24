package com.kwri.auto.ui.steps;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.eyesApplitools.EyesApplitools;
import com.kwri.auto.ui.managers.FileReaderManager;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.AddContactModal;
import com.kwri.auto.ui.pages.AgentSitePage;
import com.kwri.auto.ui.pages.BasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AgentSiteLoginSteps extends BasePage  {
	@Inject
	public AgentSiteLoginSteps(World world) {
		super(world);
	}
	
	
	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 30);
	
	
	@Inject
	EyesApplitools applitools;
	
	@Inject
	AgentSitePage agentSitePage;
	
	@Inject
	AddContactModal addContact;
	
	@Given("I navigate to Agent Site")
	public void i_navigate_to_Agent_Site() {
		world.driver.get(FileReaderManager.getInstance().getConfigReader().getPropertyValue("agentSiteUrl"));
	}

	@Given("I click on Sign Up button")
	public void i_click_on_Sign_Up_button() {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.getbtn_SignUp()));
		agentSitePage.getbtn_SignUp().click();
	}

	@Given("Fill the form with {string}, {string}, newemail and password")
	public void fill_the_form_with_newemail_and_password(String string, String string2) {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.gettxt_FirstName()));
		agentSitePage.gettxt_FirstName().sendKeys(string);

		agentSitePage.gettxt_LastName().sendKeys(string2);

		agentSitePage.gettxt_EmailAddress().sendKeys(CreateRandomEmail());
		
		agentSitePage.gettxt_Password().sendKeys(FileReaderManager.getInstance().getConfigReader().getPropertyValue("consumerPassword"));
			
	}
	@When("I create a contact with email")
	public void i_fill_in_Add_Contacts_Modal_with_following_data() {
		
		// Full Name
		wait.until(ExpectedConditions.visibilityOf(addContact.getTxt_fullName()));
		addContact.getTxt_fullName().sendKeys("First Last");

		// Primary Email Address
		addContact.getTxt_primaryEmail().sendKeys(CreateRandomEmail());
		
	}
	
	@Given("Fill the form with {string}, {string}, emailInUse and password")
	public void fill_the_form_with_emailIUse_and_password(String string, String string2) {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.gettxt_FirstName()));
		agentSitePage.gettxt_FirstName().sendKeys(string);
		
		agentSitePage.gettxt_LastName().sendKeys(string2);

		agentSitePage.gettxt_EmailAddress().sendKeys(CreateRandomEmail());

		
		agentSitePage.gettxt_Password().sendKeys(FileReaderManager.getInstance().getConfigReader().getPropertyValue("consumerPassword"));
	}
	
	@Given("I click on Sign Up button in the modal")
	public void i_click_on_Sign_Up_button_in_the_modal() {
		agentSitePage.getbtn_ModalSignUp().click();	
	}

	@Then("My account has been created")
	public void my_account_has_been_created() {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.getdiv_AllSet()));
		agentSitePage.getdiv_AllSet().getText().contains("You�re all set!");
	}
	
	@Given("I click on Continue")
	public void i_click_on_Continue() {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.getdiv_AllSet()));
		agentSitePage.getbtn_Continue().click();	
	}
	@Given("I look for {string}")
	public void i_look_for(String string) {
		
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.getinput_City()));
		agentSitePage.getinput_City().sendKeys(string);
		agentSitePage.getbtn_Search().click();
		
	}
	@Given("I click on the first option")
	public void i_click_on_the_first_option() {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.getbtn_picture1()));
		agentSitePage.getbtn_picture1().click();
		
	}
	
	@Then("I Log In with credentials")
	public void i_Log_In_with_credentials() {
	    wait.until(ExpectedConditions.visibilityOf(agentSitePage.gettxt_EmailAddress()));

		agentSitePage.gettxt_EmailAddress().sendKeys(CreateRandomEmail());

		agentSitePage.gettxt_Password().sendKeys(FileReaderManager.getInstance().getConfigReader().getPropertyValue("consumerPassword"));
	}
	
	@When("I click on Log In button")
	public void i_click_on_Log_In_button() {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.getbtn_SignUp()));
		agentSitePage.getbtn_Login().click();
	}
	
	@Then("I click on Log In button in the modal")
	public void i_click_on_Log_In_button_in_the_modal() {
		agentSitePage.getbtn_ModalLogIn().click();	
	}
	
	@When("I click on SignOut")
	public void i_click_on_SignOut() {
		wait.until(ExpectedConditions.visibilityOf(agentSitePage.get_AvatarIcon()));
		agentSitePage.get_AvatarIcon().click();	
		agentSitePage.getbtn_SignOut().click();	
	}

	
	
	public String CreateRandomEmail()
    {      
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        return timeStamp+"@kw.com";
    }
}