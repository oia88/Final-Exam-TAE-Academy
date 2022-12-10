Feature: Disneyland App functionality
  Scenario: The user should be able to check if the hotels option is available in the list
    Given the user should start the app and navigate until the dashboard
    When Look for the map button then tap it
    And find the category list
    Then validate if the hotels option is available in the list

  Scenario: The user should be able to see a Privacy & Legal list of options
    Given the user should start the app and navigate until the dashboard
    When tap on menu button scrolling down until bottom of the screen
    Then tap on Privacy & Legal
    And validate if a list of options is visible

  Scenario: The user should be able to check if the reserve dining option is in the list
    Given the user should start the app and navigate until the dashboard
    When tap on add plans button
    Then check if the reserve dining option is in the list