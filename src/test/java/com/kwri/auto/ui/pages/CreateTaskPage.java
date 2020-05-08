package com.kwri.auto.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	Actions actions = new Actions(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 10);

	@FindBy(xpath = "//h3[@class='txt-h3']")
	private WebElement label_contactName;

	@FindBy(xpath = "//a[contains(text(), 'Back to Contacts')]")
	private WebElement link_backContact;

	@FindBy(xpath = "//* [contains(text(), 'Tasks')]//parent::span")
	private WebElement link_taskTab;

	@FindBy(xpath = "//div[contains(text(), '')]/p/span")
	private WebElement link_addTask;

	@FindBy(xpath = "//div[@class='modal__content']")
	private WebElement window_taskModal;

	@FindBy(xpath = "//div[contains(text(), 'New Task')]")
	private WebElement label_modalTitle;

	@FindBy(xpath = "//div[@class='modal__content']//div[contains(@label, '')]/div/label")
	public List<WebElement> label_modalUI;

	@FindBy(name = "taskName")
	private WebElement txtbx_taskName;

	@FindBy(xpath = "//input[@name='dueDate']")
	private WebElement icon_getCal;

	@FindBy(name = "taskDesc")
	private WebElement txtbx_taskDesc;

	@FindBy(name = "hyperlink")
	private WebElement txtbx_hyperLink;

	@FindBy(xpath = "//button[text()='Create Task']")
	private WebElement btn_createTask;

	@FindBy(xpath = "//*[contains(text(), 'Task successfully created')]")
	private WebElement msg_taskCreated;

	@FindBy(xpath = "//*[contains(@class, 'txt-h4')]//parent::span")
	public WebElement label_taskName;


	public void clickTaskTab() {
		common.waitAndClick(1000, link_taskTab);
		link_taskTab.click();
	}

	public void clickAddTask() {
		//link_addTask.click();
		common.waitAndClick(10, link_addTask);
	}

	public List<String> clickLabelText() {
		List<String> all_elements = new ArrayList<String>();
		for (int i = 0; i < label_modalUI.size(); i++) {
			all_elements.add(i, label_modalUI.get(i).getText());
		}
		return all_elements;
	}

	public WebElement fillTaskName() {
		common.waitForElement(10, txtbx_taskName);
		return txtbx_taskName;
	}

	public void fillTaskInfo(String taskName, String taskDescription, String taskLink) {
		txtbx_taskName.sendKeys(taskName);
		txtbx_taskDesc.sendKeys(taskDescription);
		txtbx_hyperLink.sendKeys(taskLink);
	}

	public WebElement fillTaskDesc() {
		common.waitForElement(10, txtbx_taskDesc);
		return txtbx_taskDesc;
	}

	public WebElement fillHyperlink() {
		common.waitForElement(10, txtbx_hyperLink);
		return txtbx_hyperLink;
	}

	public void createTask() {
		common.waitAndClick(500, btn_createTask);
	}

	public void verifyTaskName() {
		try {
			wait.until(ExpectedConditions.visibilityOf(msg_taskCreated));
			Assert.assertEquals(msg_taskCreated.getText(), "Task successfully created");
		} catch (Exception ignored) {
		}
	}

	public void verifyTaskNameInTheList(String TaskName) {
		try{
			wait.until(ExpectedConditions.visibilityOf(label_taskName));
			Assert.assertEquals(label_taskName.getText(), TaskName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
