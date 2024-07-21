Feature: Register with New user

  Scenario: New User Registration
    Given User navigate to My Account button
    And click on register option
    When Enter the valid details
      | First Name | Ram1           |
      | Last Name  | Das            |
      | Email      | ram1@gmail.com |
      | Password   | Test@123       |
    And Click on subscribe button
    And Click on Privacy Policy button
    And Click on Continue button
    Then Validate account successfully Created
    And Validate My Account Category exists
