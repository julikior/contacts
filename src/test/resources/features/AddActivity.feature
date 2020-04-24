Feature: Contact Management - Add Activitiy

  Background:
    Given I navigate to Command home page
    Then screenshot
    And I login to Console
    Then screenshot
    And I navigate to Contact Management application
    Then screenshot

  @AddMeetingActivity @COM-32601
  Scenario: Create a new meeting activity
    When I search and open first contact page starting with 'AutoUser'
    And I click on Add Activity link on contact details page
    And I fill up Add Activity modal with meeting data
    And I click on 'Save' button of the activity
    And I verify that the activity is added to the timeline
    And I log out of Console

  @AddCallActivity @COM-32603
  Scenario: Create a new call activity
    When I search and open first contact page starting with 'AutoUser'
    And I click on Add Activity link on contact details page
    And I fill up Add Activity modal with call data
    And I click on 'Save' button of the activity
    And I verify that the activity is added to the timeline
    And I log out of Console

  @AddTextActivity @COM-32604
  Scenario: Create a new text activity
    When I search and open first contact page starting with 'AutoUser'
    And I click on Add Activity link on contact details page
    And I fill up Add Activity modal with text data
    And I click on 'Save' button of the activity
    And I verify that the activity is added to the timeline
    And I log out of Console

  @AddQuickNoteActivity @COM-32606
  Scenario: Create a new quick note activity
    When I search and open first contact page starting with 'AutoUser'
    And I click on Add Activity link on contact details page
    And I fill up Add Activity modal with quick note data
    And I click on 'Save' button of the activity
    And I verify that the activity is added to the timeline
    And I log out of Console

  @AddNewNote
  Scenario: Create a new note activity
    When I search for contact 'Interactions XXX'
    And I click on ellipses icon
    Then screenshot
    And I click on Add Note link
    Then screenshot
    And I fill up Add New Note modal with note data
    And I click on 'Save' button of the activity
    Then I select a contact 'Interactions XXX' to see contact details
    Then screenshot
    And I verify that the activity is added to the timeline
    And I log out of Console
