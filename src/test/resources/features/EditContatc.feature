Feature: Contact Management - Edit Contact

  Background:
    Given I navigate to Command home page
    Then screenshot
    And I login to Console
    Then screenshot
    And I navigate to Contact Management application
    Then screenshot

    @EditContactDetails
    Scenario: Edit Contact Detail
      When I search and open first contact page starting with 'AutoUser'
      And I click on edit icon

