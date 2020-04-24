Feature: Contact Management - Import a new contact

  Background:
   Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  @ImportNewContact
  Scenario: Import a new contact
    When I click on Import Contact button
    And I browse and upload contact csv file
    And I click on Import Contacts button to finish importing
    Then I verify the success message with title "Submitted!"
    And I click on Finish button
    And I verify that the new contact is added to the contact list
    And I log out of Console