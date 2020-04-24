package com.kwri.auto.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

public class ContactsDetailPage extends BasePage {
	@Inject
	public ContactsDetailPage(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);

	@FindBy(xpath = "//span[contains(@class, 'icon icon--archive')]")
	private WebElement icon_archive;

	@FindBy(xpath = "//a[text()='Add Neighborhoods']")
	private WebElement link_addNeighborhoods;

	@FindBy(xpath = "//input[@name='neighborhood-keyword']")
	private WebElement txt_neighborhoodSearch;

	@FindBy(xpath = "//h5[contains(text(),'Source Changed to Command Web Pages')]")
	private WebElement lbl_SourceChanged;

	@FindBy(xpath = "//div[@id='timelineLoginRegister' or @class='cursor-pointer']")
	private WebElement lbl_LoggedIntoAgentSite;

	@FindBy(xpath = "//h5[contains(text(),'Viewed a New Listing')]")
	private WebElement lbl_ViewedNewListing;

	@FindBy(xpath = "//p[text()='Add Activity']")
	private WebElement link_AddActivity;

	@FindBy(xpath = "//div[@class='checkbox-wrapper']/child::input")
	//
	//input[@id='lead-checkbox']
	private WebElement chbox_MarkAsLead;

	@FindBy(xpath = "//*[@id=\"contactIntro\"]/div[2]/span[2]/span")

	//span[contains(@class,'icon--edit icon--medium text')]
	private WebElement span_EditIcon;

	public WebElement getIcon_archive() { return icon_archive; }

	public WebElement getLink_AddActivity() { return link_AddActivity; }

	public WebElement getlbl_ViewedNewListing() {
		return lbl_ViewedNewListing;
	}

	public WebElement getspan_EditIcon() {
		return span_EditIcon;
	}

	public WebElement getchbox_MarkAsLead() {
		return chbox_MarkAsLead;
	}

	public WebElement getlbl_SourceChanged() {
		return lbl_SourceChanged;
	}

	public WebElement getlbl_LoggedIntoAgentSite() {
		return lbl_LoggedIntoAgentSite;
	}

	public WebElement getLink_addNeighborhoods() {
		return link_addNeighborhoods;
	}

	public WebElement getTxt_neighborhoodSearch() {
		return txt_neighborhoodSearch;
	}

	public enum TimelineItems {
		TODAY, WEEK, MONTH, ALL
	};

	public void clickEditIcon (String Edit) {
		common.waitAndClick(30, span_EditIcon);
	}

	public void clickTimelineTab(TimelineItems itemName) {
		List<WebElement> timelineMenu = world.driver.findElements(
				By.xpath("//div[contains(@class,'options-toggle__option')]/div[text()='" + itemName + "']"));
	}

	public void clickAddActivityLink () {
		this.wait.until(ExpectedConditions.visibilityOf(getLink_AddActivity()));
		this.getLink_AddActivity().click();
	}
}
