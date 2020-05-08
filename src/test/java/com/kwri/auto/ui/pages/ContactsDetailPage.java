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

	@FindBy(xpath = "//div[@id='activityModal']")
	private WebElement link_AddActivity;

	@FindBy(xpath = "//div[@class='checkbox-wrapper']/child::input")
	//
	//input[@id='lead-checkbox']
	private WebElement chbox_MarkAsLead;

	@FindBy(xpath = "//*[@id=\"contactIntro\"]/div[2]/span[2]/span")
	private WebElement span_EditIcon;

	@FindBy(xpath = "//*[contains(text(), 'Timeline')]//parent::div")
	private WebElement tab_Timeline;

	public WebElement clickIcon_archive() { return icon_archive; }

	public WebElement clickLink_AddActivity() { return link_AddActivity; }

	public WebElement clicklbl_ViewedNewListing() {
		return lbl_ViewedNewListing;
	}

	public WebElement clickspan_EditIcon() {
		return span_EditIcon;
	}

	public WebElement clickchbox_MarkAsLead() {
		return chbox_MarkAsLead;
	}

	public WebElement clicklbl_SourceChanged() {
		return lbl_SourceChanged;
	}

	public WebElement clicklbl_LoggedIntoAgentSite() {
		return lbl_LoggedIntoAgentSite;
	}

	public WebElement clickLink_addNeighborhoods() {
		return link_addNeighborhoods;
	}

	public WebElement clickTxt_neighborhoodSearch() {
		return txt_neighborhoodSearch;
	}

	public enum TimelineItems {
		TODAY, WEEK, MONTH, ALL
	};

	public void clickEditIcon (String Edit) {
		common.waitAndClick(30, span_EditIcon);
	}

	/*public void WebElement clickTimelineTab() {
		common.waitForElement(10, tab_Timeline);
	}*/

	public void clickAddActivityLink () {
		this.wait.until(ExpectedConditions.visibilityOf(clickLink_AddActivity()));
		this.clickLink_AddActivity().click();
	}
}
