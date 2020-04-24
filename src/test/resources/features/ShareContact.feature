Feature: Contact Management - Share contact

  Background:
    Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  @ShareSingleContact
  Scenario: Share a single contact
   #When I clear all filters
    And I search for contact 'Interactions XXX'
    And I click on ellipses icon
    And I click on Share contact link
    And On share contact modal, I select a Team
    And I select members of team to share contact
    And I enable the toggle for agents to edit contacts
    And I click on share button
    And I verify that contact is successfully shared


  @ShareBulkContacts
  Scenario: Share bulk contacts
    When I click on Select Bulk action dropdown
    And I select "Share Contacts" option
    And I select members of team to share contact
    And I enable the toggle for agents to edit contacts
    And I click on share button
    And I verify that contact is successfully shared

  @After
    And I log out of Console
