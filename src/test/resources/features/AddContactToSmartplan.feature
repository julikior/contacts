Feature: Contact Management - Add a contact to smartplan

  Background: 
    Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  #@AddAContactToSmartplanFromContactsHomePage
  #Scenario: Add a contact to smartplan
    #When I clear all filters
    #And I search for contact 'SmartPlanTest'
    #And I select all contact by clicking on Select All check box
    #And I select 'Add To SmartPlan' from bulk action dropdown
    #And I add selected contacts to 'Monthly Neighborhood Nurture' smartplan
    #Then I verify that selected contacts are added to 'Monthly Neighborhood Nurture' smartplan
    #And I log out of Console
#
  #@AddAContactToSmartplanFromContactDetailsPage
  #Scenario: Add a neighborhood to an existing contact
    #When I clear all filters
    #And I search for contact 'NeighborhoodUser'
    #And I select a contact 'NeighborhoodUser' to see contact details
    #And I click on 'Add To Smartplan' link
    #And I add smartplan with name 'Monthly Neighborhood Nurture'
    #Then I verify that 'Monthly Neighborhood Nurture' smartplan appears in Smartplans tab
    #And I log out of Console
#
  #@RemoveAContactFromSmartplanFromContactDetailsPage
  #Scenario: Add a neighborhood to an existing contact
    #When I clear all filters
    #And I search for contact 'NeighborhoodUser'
    #And I select a contact 'NeighborhoodUser' to see contact details
    #And I click on 'SmaprtPlans' tab in timeline
    #And I delete the smartplan with name 'Monthly Neighborhood Nurture'
    #And I accept the confirmation pop-up to delete smartplan
    #Then I verify that 'Monthly Neighborhood Nurture' smartplan doesnot appear in Smartplans tab
    #And I log out of Console
