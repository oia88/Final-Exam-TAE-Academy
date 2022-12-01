Feature: Sign up functionality
  Scenario Outline: User should be able to Sign up successful
    Given the user is on sign up section
    When user enters the correct data credentials
    Then the user should be create a new account and logged in <firstName><lastName><email><password>

    Examples:
      | firstName      | lastName | email                | password    |
      | "testTAEone"   | "tae"    | "tTaeOne@gmail.com   | "Proof1234" |
      | "testTAEtwo"   | "tae"    | "tTaeTwo@gmail.com   | "Proof5678" |
      | "testTAEthree" | "tae"    | "tTaeThree@gmail.com | "Proof9876" |