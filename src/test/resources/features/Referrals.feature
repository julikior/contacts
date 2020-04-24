@ReferralsNavigation
Feature: Switch across the Referrals tab

  Background:
    Given I navigate to Command home page
    When I login to Console
    And I open referrals page

    @ClickMyReferralsTab
    Scenario: Switch between tabs on the Referral  page
      When I open referrals page
      And I open My Referrals
      And I open Map tab
      And I select My Network tab
      And I click Track Referral button
      And I close modal popup
      And I click Grow My Network button
      And I click Dashboard tab
      And I select Search field
      And I enter name of agent into the Search field like 'QA Agent'
      And I click Sorting drop-down
      And I click Favorite filter

