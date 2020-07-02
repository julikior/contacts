Feature: Contact Management - Create a new contact

  Background:
    Given I navigate to Command home page
    And I login to Console
    And I navigate to Contact Management application

  @AddContactWithRequiredFields @COM-11762
  Scenario: Create a new contact with mandatory fields
    When I click on 'Add new contact' button
    And Enter details on add new contact form
    And I click on 'Save Contact' button
    Then I verify that the a new contact is added "true" to the contact list
    And I select a contact 'AutoUser' to see contact details
    And I archive the contact
    And I log out of Console

  @BackOutOfContactCreation  @COM-11780
  Scenario: Back out of contact creation
    When I click on 'Add new contact' button
    And Enter details on add new contact form
    And I click on 'Cancel' button
    Then I verify that the a new contact is added "false" to the contact list
    And I archive the contact
    And I log out of Console

  @AddContactWithAllFields @COM-11777
  Scenario Outline: Creating a new contact with mandatory fields
    When I click on 'Add new contact' button
    And I fill in Add Contacts Modal with following data
     | Phone Number    |   Additional Phone   | Primary Address  | Apartment Num   | Legal Name  | Description   | Job Title  | Relation Name  | Company Name  |
     |  <PhoneNumber>  |  <AdditionalPhone>  | <PrimaryAddress> | <ApartmentNum>  | <LegalName> | <Description> | <JobTitle> | <RelationName> | <CompanyName> |
    And I select a date of birth with random date
    And I select a home anniversary with random date
    And I enter a job title
    And I select a stage as captured
    And I click on 'Save Contact' button
    Then I verify that the a new contact is added "true" to the contact list
    And I select a contact 'AutoUser' to see contact details
    Then I verify contact data
    And I archive the contact
    And I log out of Console

    Examples:
      | PhoneNumber  |  AdditionalPhone | PrimaryAddress        | ApartmentNum | LegalName          | Description                 | JobTitle  | RelationName    | CompanyName     |
      |  2818181011  |  2818181012      | 311 California Street | 201          | AutoUser LegalName | Contact background info...  | Engineer  | Spouse 1        | Company Juli    |
      #|  2818181013  |  2818181014      | 27 Merry Lane         | -            | Auto2 LName        | Contact info in description | CO        | McDonald        | Coffee          |

  @AddContactWithInvalidEmail @COM-11764
  Scenario Outline: Create a new contact with invalid email
    When I click on 'Add new contact' button
    And I fill in Add Contacts Modal with invalid email "<invalidEmail>"
    And I click create contact button
    Then I verify that email is invalid
    And I click on 'Cancel' button
    And I log out of Console
    Examples:
      |invalidEmail               |
      |AutoUser@AutoUser          |
      |@AutoUser                  |
      |AutoUser@                  |
      |AutoUser@AutoUser@AutoUser |

  @AddContactWithInvalidPhoneNumber @COM-29293
  Scenario Outline: Create a new contact with invalid phone number
    When I click on 'Add new contact' button
    And I fill in Add Contacts Modal with invalid phone number "<invalidPhone>"
    And I click create contact button
    Then I verify that phone is invalid
    And I click on 'Cancel' button
    And I log out of Console
    Examples:
      |invalidPhone                           |
#      |aZ                                     |
#      |$$                                     |
      |512112212132132131313131313213113132131|
      |321321                                 |

  @AddContactWithExistingEmail @COM-29150
  Scenario: Create a new contact with existing email
    When I click on 'Add new contact' button
    And I create user wih email
    And I click on 'Save Contact' button
    Then I verify that the a new contact is added "true" to the contact list
    And I click on 'Add new contact' button
    And I create user wih the same email
    And I click create contact button
    Then I verify that 'This email is already in use' error is displayed
    And I click on 'Cancel' button
    And I log out of Console
