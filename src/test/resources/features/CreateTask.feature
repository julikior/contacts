@CreateTask
Feature: Contact Management - Create Task for a Contact

  Background: 
    Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  @CreateTask1
  Scenario Outline: Create Task
    #When I clear all filters
    And I search for contact 'YuliiaPuziuk'
    And I select a contact 'YuliiaPuziuk' to see contact details
    And clicks on Tasks tab
    And clicks on Add Task button
    Then validate the task UI
      | Task Name | All Day | Due Date | Task Description | Add hyperlink |
    When user enters the task details "<task_name>","<task_desc>","<task_url>"
    And clicks on Create Task button
    Then the task is successfully created "<task_name>"

    Examples: 
      | task_name     | task_desc     | task_url                |
      | New Test Task | New Test Task | https://www.youtube.com |
