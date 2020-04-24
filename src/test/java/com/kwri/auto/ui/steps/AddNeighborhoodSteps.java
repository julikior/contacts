package com.kwri.auto.ui.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;
import com.kwri.auto.ui.pages.ContactsDetailPage;
import com.kwri.auto.ui.pages.ContactsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddNeighborhoodSteps extends BasePage {
	@Inject
	public AddNeighborhoodSteps(World world) {
		super(world);
	}

	@Inject
	ContactsPage contactsHome;

	@Inject
	ContactsDetailPage contactDetails;

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);
	WebElement neighborSelection;
	String neighborhoodText;

	/**
	 * Steps to add neighborhood
	 */
	
	@When("I click on {string} link")
	public void i_click_on_link(String string) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(contactDetails.getLink_addNeighborhoods()));
		contactDetails.getLink_addNeighborhoods().click();
	}

	@When("I search and select for neighborhood {string}")
	public void i_search_and_select_for_neighborhood(String neighborhoodName) {
		wait.until(ExpectedConditions.visibilityOf(contactDetails.getTxt_neighborhoodSearch()));
		contactsHome.scrollElementIntoView(contactDetails.getTxt_neighborhoodSearch());
		wait.until(ExpectedConditions.visibilityOf(contactDetails.getTxt_neighborhoodSearch()));
		contactDetails.getTxt_neighborhoodSearch().click();
		contactDetails.getTxt_neighborhoodSearch().sendKeys(neighborhoodName);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='styles__result___3vkU1'])[1]")));

		WebElement neighborhoodOption = world.driver
				.findElement(By.xpath("(//div[@class='styles__result___3vkU1'])[1]"));
		neighborhoodText = neighborhoodOption.getText();
		neighborhoodOption.click();
	}

	@Then("I verify that neighborhood map is addded to contact details")
	public void i_verify_that_neighborhood_map_is_addded_to_contact_details(String neighborhoodName) {
		List<WebElement> neighborhoodTiles = world.driver.findElements(By.xpath("chip chip--default my-1 mr-1"));
		for(int i=0; i<neighborhoodTiles.size(); i++) {
			if(neighborhoodTiles.get(i).getText() == neighborhoodName)
				System.out.println("Neighborhood with name : " + neighborhoodName + " found");
		}
	}

	@Then("I verify that {string} neighborhood is added to the timeline")
	public void i_verify_that_neighborhood_is_added_to_the_timeline(String neighnorhoodName) {

	}
	
	/**
	 * Steps to remove neighborhood
	 */
	
	@When("I remove neighborhood {string}")
	public void i_remove_neighborhood(String neighborhoodName) {
	   
	}

	@Then("I verify that neighborhood map is removed from contact details")
	public void i_verify_that_neighborhood_map_is_removed_from_contact_details() {
	 
	}

	@Then("I verify that {string} neighborhood is removed to the timeline")
	public void i_verify_that_neighborhood_is_removed_to_the_timeline(String neighborhoodName) {
	  
	}
}