package com.kwri.auto.ui.pages;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

public class CreateTaskPage extends BasePage {

	@Inject
	public CreateTaskPage(World world) {
		super(world);

	}

	Common common = new Common(world.driver);
	public static Logger LOG = LoggerFactory.getLogger(LoginPage.class);

	private static final String contactName = "//h3[@class='txt-h3']";
	@FindBy(xpath = contactName)
	private WebElement label_contactName;

	private static final String backContact = "//a[@class='link d-inline-block cursor-pointer']";
	@FindBy(xpath = backContact)
	private WebElement link_backContact;

	private static final String taskTab = "//* [contains(text(), 'Tasks')]//parent::span";
	@FindBy(xpath = taskTab)
	private WebElement link_taskTab;

	private static final String addTask = "//div[contains(text(), '')]/p/span";
	@FindBy(xpath = addTask)
	private WebElement link_addTask;

	private static final String taskModal = "//div[@class='modal__content']";
	@FindBy(xpath = taskModal)
	private WebElement window_taskModal;

	private static final String modalTitle = "//div[contains(text(), 'New Task')]";
	@FindBy(xpath = modalTitle)
	private WebElement label_modalTitle;

	private static final String modalUI = "//div[@class='modal__content']//div[contains(@label, '')]/div/label";
	@FindBy(xpath = modalUI)
	public List<WebElement> label_modalUI;

	private static final String taskName = "taskName";
	@FindBy(name = taskName)
	private WebElement txtbx_taskName;

	private static final String getCal = "//input[@name='dueDate']";
	@FindBy(xpath = getCal)
	private WebElement icon_getCal;

	private static final String taskDesc = "taskDesc";
	@FindBy(name = taskDesc)
	private WebElement txtbx_taskDesc;

	private static final String hyperLink = "hyperlink";
	@FindBy(name = hyperLink)
	private WebElement txtbx_hyperLink;

	private static final String createBtn = "//button[text()='Create Task']";
	@FindBy(xpath = createBtn)
	private WebElement btn_createTask;

	private static final String taskCreatedMessage = "//*[contains(text(), 'Task successfully created')]";
	@FindBy(xpath = taskCreatedMessage)
	private WebElement msg_taskCreated;

	private static final String verifyTaskName = "//*[contains(@class, 'txt-h4')]//parent::span";
	@FindBy(xpath = verifyTaskName)
	public WebElement label_taskName;


	public void clickTaskTab() {
		common.waitAndClick(1000, link_taskTab);
		link_taskTab.click();
	}

	public void clickAddTask() {
		//link_addTask.click();
		common.waitAndClick(10, link_addTask);
	}

	public List<String> getLabelText() {
		List<String> all_elements = new ArrayList<String>();
		for (int i = 0; i < label_modalUI.size(); i++) {
			all_elements.add(i, label_modalUI.get(i).getText());
		}
		return all_elements;
	}

	public WebElement getTaskName() {
		common.waitForElement(10, txtbx_taskName);
		return txtbx_taskName;
	}

	public void fillTaskInfo(String taskName, String taskDescription, String taskLink) {
		txtbx_taskName.sendKeys(taskName);
		txtbx_taskDesc.sendKeys(taskDescription);
		txtbx_hyperLink.sendKeys(taskLink);
	}

	public WebElement getTaskDesc() {
		common.waitForElement(10, txtbx_taskDesc);
		return txtbx_taskDesc;
	}

	public WebElement getHyperlink() {
		common.waitForElement(10, txtbx_hyperLink);
		return txtbx_hyperLink;
	}

	public void createTask() {
		common.waitAndClick(500, btn_createTask);
	}

	public boolean verifyTaskName(String TaskName) {
		WebDriverWait wait = new WebDriverWait(world.driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(msg_taskCreated));
			Assert.assertEquals(msg_taskCreated.getText(), "Task successfully created");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
