Feature: ESPN webpage functionality
  Scenario: The user should be able to create an account, navigate into watch page and see the carousels and then log out
    Given the user should be able to go to the log in section and get inside sign up
    And the user should be created with firstname: "testTAEFour", lastname: "tae", email: "tTae37@gmail.com" and password: "Proof1234"
    When Once logged in, go to watch and validate that at least one carousel is present
    And Click on the second card in the first carousel and validate
    Then Go back to the landing page and log out
