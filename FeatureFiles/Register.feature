Feature: Register with New user

  @Register @One
  Scenario: New User Registration
    Given User navigate to My Account button
    And click on register option
    When Enter the valid details
      | First Name | Ram           |
      | Last Name  | Das           |
      | Email      | ram@gmail.com |
      | Password   | Test@123      |
    And Click on subscribe button
    And Click on Privacy Policy button
    And Click on Continue button
    Then Validate account successfully Created
    And Validate My Account Category exists

  @Register @Two
  Scenario: Create user with blank mandatory field
    Given User navigate to My Account button
    And click on register option
    When Click on Continue button
    Then User Account should not created
    And User should see the error messages
    
    
