Feature: Sign up functionality
  Scenario: User should be able to Sign up successful
    Given the user is on sign up section
    When user enters the correct data credentials
    And hits sign up button
    Then the user should be create a new account and logged in


Feature:     