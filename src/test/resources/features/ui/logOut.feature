Feature: Log out of the current session
  Scenario: User should be able to log out
    Given the user can verify if is logged
    When Validate the sign up modal
    Then Click log out and validate text without user name specified