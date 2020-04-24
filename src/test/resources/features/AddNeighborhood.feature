Feature: Contact Management - Add neighborhood to a contact

  Background: 
    Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  @AddNeighborhood
  Scenario: Add a neighborhood to an existing contact
    #When I clear all filters
    And I search for contact 'NeighborhoodUser'
    And I select a contact 'NeighborhoodUser' to see contact details
    And I click on 'Add Neighborhoods' link
    And I search and select for neighborhood 'Barton Hills'
    #Then I verify that 'Barton Hills' neighborhood map is addded to contact details
    And I verify that 'Barton Hills' neighborhood is added to the timeline
    #And I log out of Console

  @RemoveNeighborhood
  Scenario: Add a neighborhood to an existing contact
    #When I clear all filters
    And I search for contact 'NeighborhoodUser'
    And I select a contact 'NeighborhoodUser' to see contact details
    And I remove neighborhood 'Barton Hills'
    And I search and select for neighborhood 'Barton Hills'
    Then I verify that neighborhood map is removed from contact details
    And I verify that 'Barton Hills' neighborhood is removed to the timeline
    #And I log out of Console
