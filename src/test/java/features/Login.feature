Feature: LoginFeature
  This feature is responsible for testing Login scenarios of application


  Scenario: Check Login with correct username and password
    Given I navigate to the modular login page
    When I enter a valid UserName
    And I enter a valid Password
    Then I click login button
    Then I should be logged in to Admin Page

  Scenario: Check Login with correct username and empty password
    Given I navigate to the modular login page
    When I enter a valid UserName
    And I enter an empty Password
    Then I click login button
    Then I get password field required message

  Scenario: Check Login with empty username and correct password
    Given I navigate to the modular login page
    When I enter an empty UserName
    And I enter a valid Password
    Then I click login button
    Then I get username field required message

  Scenario: Check Login with incorrect username and correct password
    Given I navigate to the modular login page
    When I enter an incorrect UserName
    And I enter a valid Password
    Then I click login button
    Then I get username or password is incorrect message

  Scenario: Check Login with correct username and incorrect password
    Given I navigate to the modular login page
    When I enter a valid UserName
    And I enter an incorrect Password
    Then I click login button
    Then I get username or password is incorrect message

  Scenario: Check Login button is disabled after click
    Given I navigate to the modular login page
    When I enter a valid UserName
    And I enter a valid Password
    Then I click login button
    And login button should be disabled

