Feature: Contact Matching

@RegistrationNewEmail
Scenario: Consumer registration through Agent site using new email
Given I navigate to Agent Site
And screenshot
And I click on Sign Up button
And screenshot
And Fill the form with "First", "Last", newemail and password
And screenshot
And I click on Sign Up button in the modal
And screenshot
And My account has been created
And screenshot
When I navigate to Command home page
And screenshot
And  I login to Console
And screenshot
And I navigate to Contact Management application
And screenshot
And I search for contact "First Last"
And screenshot
And I Click on the contact "First Last"
And screenshot
Then I Verify that "Source Changed to Command Web Pages" note is present in Timeline
And screenshot
And I Verify that "Logged Into Agent Site" activity note is present in Timeline
And screenshot
And  I Verify that Mark as Lead checkbox is checked
And screenshot
And I log out of Console



@RegistgrationEmailAlreadyInUse 
Scenario: Consumer registration through Agent site using email already in use
Given I navigate to Command home page
And screenshot
And  I login to Console
And screenshot
And I navigate to Contact Management application
And screenshot
And I click on 'Add new contact' button
And screenshot
And I create a contact with email
And screenshot
And I click on 'Save Contact' button
And screenshot
And I navigate to Agent Site
And screenshot
And I click on Sign Up button
And screenshot
And Fill the form with 'First', 'Last', emailInUse and password
And screenshot
And I click on Sign Up button in the modal
And screenshot
And My account has been created
And screenshot
When I navigate to Command home page
And screenshot
And I navigate to Contact Management application
And screenshot
And I search for contact 'First Last'
And screenshot
And I Click on the contact 'First Last'
And screenshot
Then  I Verify that "Logged Into Agent Site" activity note is present in Timeline
And screenshot
And  I Verify that Mark as Lead checkbox is unchecked
And screenshot
And I log out of Console

@LogInNewEmail
Scenario: Log In Agent site using new email
Given I navigate to Agent Site
And screenshot
And I click on Sign Up button
And screenshot
And Fill the form with "First", "Last", newemail and password
And screenshot
And I click on Sign Up button in the modal
And screenshot
And My account has been created
And screenshot
And I navigate to Command home page
And screenshot
And  I login to Console
And screenshot
And I navigate to Contact Management application
And screenshot
And I search for contact "First Last"
And screenshot
When I Click on the contact "First Last"
And screenshot
And  I Verify that "Source Changed to Command Web Pages" note is present in Timeline
And screenshot
And I Verify that "Logged Into Agent Site" activity note is present in Timeline
And screenshot
And  I Verify that Mark as Lead checkbox is checked
And screenshot
And I navigate to Agent Site
And screenshot
And I click on SignOut
And screenshot
And I click on Log In button
And screenshot
Then I Log In with credentials
And screenshot
And  I click on Log In button in the modal
And screenshot
And I navigate to Command home page
And screenshot
And I navigate to Contact Management application
And screenshot
And I search for contact "First Last"
And screenshot
And I Click on the contact "First Last"
And screenshot
And I Verify that "Logged Into Agent Site" activity note is present in Timeline
And screenshot
And I log out of Console

@LogInEmailAlreadyCreated
Scenario: Log In using email already created
Given I navigate to Command home page
And screenshot
And  I login to Console
And screenshot
And I navigate to Contact Management application
And screenshot
And I click on 'Add new contact' button
And screenshot
And I create a contact with email
And screenshot
And I click on 'Save Contact' button
And screenshot
And I navigate to Agent Site
And screenshot
And I click on Sign Up button
And screenshot
And Fill the form with 'First', 'Last', emailInUse and password
And screenshot
And I click on Sign Up button in the modal
And screenshot
And My account has been created
And screenshot
When I navigate to Command home page
And screenshot
And I navigate to Contact Management application
And screenshot
And I search for contact 'First Last'
And screenshot
And I Click on the contact 'First Last'
And screenshot
And I Verify that "Logged Into Agent Site" activity note is present in Timeline
And screenshot
And  I Verify that Mark as Lead checkbox is unchecked
And screenshot
And I navigate to Agent Site
And screenshot
And I click on SignOut
And screenshot
And I click on Log In button
And screenshot
Then I Log In with credentials
And screenshot
And  I click on Log In button in the modal
And screenshot
And I navigate to Command home page
And screenshot
And I navigate to Contact Management application
And screenshot
And I search for contact "First Last"
And screenshot
And I Click on the contact "First Last"
And screenshot
And I Verify that "Logged Into Agent Site" activity note is present in Timeline
And screenshot
And I log out of Console


@AddListingActivity
Scenario: Add Listing Activity
Given I navigate to Agent Site
And screenshot
And I click on Sign Up button
And Fill the form with "First", "Last", newemail and password
And screenshot
And I click on Sign Up button in the modal
And My account has been created
And screenshot
And I click on Continue
When I look for "Texas"
And screenshot
And I click on the first option
And screenshot
And I navigate to Command home page
And screenshot
And  I login to Console as Agent
And I navigate to Contact Management application
And screenshot
And I search for contact "First  Last"
And screenshot
Then I Click on the contact "First  Last"
And  I Verify that "Source Changed to Command Web Pages" note is present in Timeline
And screenshot
And I Verify that "Logged Into Agent Site" activity note is present in Timeline
And I Verify that "Viewed a new Listing" interaction note is present in Timeline
And I log out of Console
