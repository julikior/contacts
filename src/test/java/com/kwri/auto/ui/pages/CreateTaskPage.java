package com.kwri.auto.ui.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	private static Logger LOG = LoggerFactory.getLogger(LoginPage.class);
	WebDriverWait wait = new WebDriverWait(world.driver, 20);

	String firstContactName = "";
	String newTask = "New Test Task";
	Calendar now = Calendar.getInstance();

	public static int day;

	public static final String popupText = ".alert > div:nth-child(2)";
	@FindBy(css = popupText)
	public WebElement label_popupText;

	public static final String firstContact = "//div[@class='rt-tbody']/div[1]/div/div[2]/div/a";
	@FindBy(xpath = firstContact)
	public WebElement link_firstContact;

	public static final String contactName = "//h3[@class='txt-h3']";
	@FindBy(xpath = contactName)
	public WebElement label_contactName;

	public static final String backContact = "//a[@class='link d-inline-block cursor-pointer']";
	@FindBy(xpath = backContact)
	public WebElement link_backContact;

	public static final String taskTab = "//* [contains(text(), 'Tasks')]//parent::span";
	@FindBy(xpath = taskTab)
	public WebElement link_taskTab;

	public static final String addTask = "//div[contains(text(), '')]/p/span";
	@FindBy(xpath = addTask)
	public WebElement link_addTask;

	public static final String taskModal = "//div[@class='modal__content']";
	@FindBy(xpath = taskModal)
	public WebElement window_taskModal;

	public static final String modalTitle = "//div[contains(text(), 'New Task')]";
	@FindBy(xpath = modalTitle)
	public WebElement label_modalTitle;

	public static final String modalUI = "//div[@class='modal__content']//div[contains(@label, '')]/div/label";
	@FindBy(xpath = modalUI)
	public List<WebElement> label_modalUI;

	public static final String taskName = "taskName";
	@FindBy(name = taskName)
	public WebElement txtbx_taskName;

	public static final String getCal = "//input[@name='dueDate']";
	@FindBy(xpath = getCal)
	public WebElement icon_getCal;

	public static final String taskDesc = "taskDesc";
	@FindBy(name = taskDesc)
	public WebElement txtbx_taskDesc;

	public static final String hyperLink = "hyperlink";
	@FindBy(name = hyperLink)
	public WebElement txtbx_hyperLink;

	public static final String browseImage = "//span[@class='icon icon--upload icon--medium text-aqua mr-3']";
	@FindBy(xpath = browseImage)
	public WebElement icon_browseImage;

	public static final String createBtn = "//button[text()='Create Task']";
	@FindBy(xpath = createBtn)
	public WebElement btn_createTask;

	public static final String taskLabel = "//div[@class='styles__task-desc___Twrqm ml-3 position-relative']/h5";
	@FindBy(xpath = taskLabel)
	public WebElement label_task;

	public static final String newTaskLabel = "//div[@class='styles__task_list_scroll___22sFg']/div[1]/div/div[2]/div/span/h4";
	@FindBy(xpath = newTaskLabel)
	public WebElement label_newTask;

	public static final String pastDueBtn = "//div[@class='styles__task_list_scroll___22sFg']/div[1]/div/div[2]/div/span/div";
	@FindBy(xpath = pastDueBtn)
	public WebElement btn_pastDue;

	public static final String snoozeBtn = "//div[@class='styles__task_list_scroll___22sFg']/div[1]/div/div[3]/button[1]/span";
	@FindBy(xpath = snoozeBtn)
	public WebElement btn_snooze;

	public static final String deleteBtn = "//div[@class='styles__task_list_scroll___22sFg']/div[1]/div/div[3]/button[2]/span";
	@FindBy(xpath = deleteBtn)
	public WebElement btn_delete;

	public void clickContact() {
		common.waitToDisappear(10, label_popupText);
		common.waitForElement(10, link_firstContact);
		firstContactName = link_firstContact.getText();
		LOG.info("printing contact name from the list " + firstContactName);
		try {
			link_firstContact.click();
			LOG.info("Clicked on the contact name");
			// common.waitForElement(10, link_backContact);
			common.waitForElement(10, label_contactName);
		} catch (Exception ex) {
			link_firstContact.click();
			LOG.info("Clicked on the contact name");
			// common.waitForElement(10, link_backContact);
			common.waitForElement(10, label_contactName);

		}

		int index = label_contactName.getText().indexOf(" ");
		LOG.info("print index " + index);
		LOG.info("printing contact name from the edit contact " + label_contactName.getText().substring(0, index));
		Assert.assertEquals(firstContactName, label_contactName.getText().substring(0, index));

	}

	public void clickTaskTab() {
		common.waitAndClick(1000, link_taskTab);
		link_taskTab.click();
		common.waitAndClick(10, link_addTask);
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
		return txtbx_taskName;
	}

	public WebElement getTaskDesc() {
		return txtbx_taskDesc;
	}

	public WebElement getHyperlink() {
		return txtbx_hyperLink;
	}

	public void createTask() {
		btn_createTask.click();
		common.waitToDisappear(10, window_taskModal);
	}

	public void verifyTask(String taskName) {
		// wait for task list to load
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("styles__task_list_col___1uHk4")));

		//verify task is added to time line
		List<WebElement> taskList = world.driver
				.findElements(By.xpath("//h4[@class='txt-h4 styles__task-title-head___3MAXK d-inline-block']"));
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println("task list item : " + i + " = " + taskList.get(i).getText());
			if (taskList.get(i).getText() == taskName)
				System.out.println("Task with name : " + taskList.get(i).getText() + " successfully created");
		}
	}
}
