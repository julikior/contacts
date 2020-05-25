package com.kwri.auto.ui.steps;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.eyesApplitools.EyesApplitools;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginSteps extends BasePage  {
	@Inject
	public LoginSteps(World world) {
		super(world);
	}
	
	@Inject
	EyesApplitools applitools;
	
	@Inject
	LoginPage loginPage;
	
	//Common common = new Common(world.driver);
	
	@Given("I navigate to Command home page")
	public void i_navigate_to_Command_home_page() {
		loginPage.navigateTo_HomePage();
	}
	
	@Given("I login to Console")
	public void i_login_to_Console() {
		loginPage.login();
		loginPage.acceptCookieConsent();
	}
	
	@Given("I login to Console as Agent")
	public void i_login_to_Console_as_Agent() {
		loginPage.LoginAsAgent();
		loginPage.acceptCookieConsent();
	}
	
	@Given("^I navigate to Contact Management application$")
	public void i_navigate_to_Contact_Management_application() throws Throwable {
		loginPage.navigateTo_ContactsHome();
	}
	
	@Then("^I log out of Console$")
	public void i_log_out_of_Console() throws Throwable {
		loginPage.logout();
	}
	
	@Then("screenshot")
	public void screenshot() {
	  applitools.takeScreenshot();
	}
}
