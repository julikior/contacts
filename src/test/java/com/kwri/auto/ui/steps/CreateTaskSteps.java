package com.kwri.auto.ui.steps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.pages.CreateTaskPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CreateTaskSteps {
	@Inject
	CreateTaskPage ctPage;

	@When("clicks on Tasks tab")
	public void clicks_on_Tasks_tab() {
		ctPage.clickTaskTab();
	}

	@When("clicks on Add Task button")
	public void clicks_on_Add_Task_button() {
		ctPage.clickAddTask();
	}

	@Then("validate the task UI")
	public void validate_the_task_UI(DataTable resData) {
		List<String> all_elements = new ArrayList<String>();
		all_elements = ctPage.getLabelText();
		List<String> list = resData.asList(String.class);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertEquals(all_elements.get(i), list.get(i));
		}
	}

	@When("user enters the task details {string},{string},{string}")
	public void user_enters_the_task_details(String arg1, String arg2, String arg3) {
		ctPage.getTaskName().sendKeys(arg1);
		ctPage.getTaskDesc().sendKeys(arg2);
		ctPage.getHyperlink().sendKeys(arg3);
	}

	@When("clicks on Create Task button")
	public void clicks_on_Create_Task_button() {
		ctPage.createTask();
	}

	@Then("the task is successfully created {string}")
	public void the_task_is_successfully_created(String arg1) {
//		String taskName = ctPage.verifyTask();
		ctPage.verifyTask(arg1);
		//Assert.assertEquals(arg1, taskName);
	}
}