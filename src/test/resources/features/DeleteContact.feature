Feature: Contact Management - Delete an existing contact

  Background:
    Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  @ArchiveContactFromDashboard @COM-11781
  Scenario: Archive a Contact from the Dashboard
    #When I clear all filters
    And I search and select first contact starting with 'AutoUser'
    And I click on ellipses icon
    And I click on Archive link
    And I click on Archive button on Confirm Archive modal
    Then I verify that 'AutoUser' is archived from contact list
    And I log out of Console

  @ArchiveContactFromDetailsPage @COM-11783
  Scenario: Archive a contact from contact details
    #When I clear all filters
    And I search and open first contact page starting with 'AutoUser'
    And I click on archive icon
    And I click on Archive button on Confirm Archive modal
    Then I verify that 'AutoUser' is archived from contact list
    And I log out of Console

  #@DeleteContact @After(" @ArchiveContact")
  #Scenario: Delete a contact
    #When I navigate to settings page
    #And I go to Contacts Archive tab
    #And I search for contact 'Interactions XXX'
    #And I click on delete icon
    #And I accept confirm delete pop up
    #Then I verify that 'Interactions XXX' is archived from contact list
    #And I log out of Console
