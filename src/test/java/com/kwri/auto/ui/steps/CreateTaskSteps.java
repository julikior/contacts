package com.kwri.auto.ui.steps;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.And;
import org.testng.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.pages.CreateTaskPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

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
		all_elements = ctPage.clickLabelText();
		List<String> list = resData.asList(String.class);
		assertReflectionEquals("Incorrect field names", all_elements, list);
	}

	@When("user enters the task details {string},{string},{string}")
	public void user_enters_the_task_details(String arg1, String arg2, String arg3) {
		ctPage.fillTaskInfo(arg1, arg2, arg3);
	}

	@When("clicks on Create Task button")
	public void clicks_on_Create_Task_button() {
		ctPage.createTask();
	}

	@Then("the task is successfully created")
	public void the_task_is_successfully_created() {
		ctPage.verifyTaskName();
	}

	@And("the task added to the list {string}")
	public void theTaskAddedToTheList(String taskName) {
		ctPage.verifyTaskNameInTheList(taskName);
	}
}
