Feature: Valid login successfully

  Scenario: successful login
    Given User navigate to myAccount button
    When User enter email as "ranip@gmail.com" and password as "rani@123"
    And Click on Login button
    Then Validate user on myAccount page
