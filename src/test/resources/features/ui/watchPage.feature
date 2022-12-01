Feature: Check inside Watch Page
  Scenario: User should be able to navigate into Watch page and back to Homepage
    Given the user logged goes to watch page
    When validate that at least one carousel is present
    And Click on the second card in the first carousel
    Then Go back to the landing page