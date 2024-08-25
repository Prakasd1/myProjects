Feature: Valid login successfully

  @Login @One
  Scenario: successful login
    Given User navigate to myAccount button
    When User enter email as "ranip@gmail.com" and password as "rani@123"
    And Click on Login button
    Then Validate user on myAccount page

  @Login @Two
  Scenario: Unsuccessful login
    Given User navigate to myAccount button
    When User enter email as "ranipp@gmail.com" and password as "rani@1234"
    And Click on Login button
    Then I should see an error message informing the User about invalid credentials

  @Login @Three
  Scenario: Login without providing any credential details
    Given User navigate to myAccount button
    When User leave the field as blank
    Then I should see an error message informing the User about invalid credentials
