Feature: ResetPassword
  This feature is responsible for testing password reset function

  Scenario: User goes to login page and then resets password
    Given User navigates to the modular login page
    And I click on forgotten password link
    When I enter my username on reset password page
    And I click request a reset link
    Then I get a message with Email sent

