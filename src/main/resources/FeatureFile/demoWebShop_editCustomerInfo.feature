Feature: Edit Customer Info Functionality

  Scenario: Edit first name and last name
    Given User navigate to demo web shop
    And User login to account
    When User navigate to customer info page
    And User update first name and last name
    Then First name and last name should be updated

  Scenario: Edit email address
    Given User navigate to demo web shop
    And User login to account
    When User navigate to customer info page
    And User update email address
    Then Email address should be updated