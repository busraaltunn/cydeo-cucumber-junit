Feature: User should be able to login using correct credential

Background: user is on the login page
  Given user is on the login page of the web table app

  Scenario: Positive login scenario
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains order


  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains order


  Scenario: User should be able to see all 12 months in months dropdown
    When user enters below credentials
      | username     | Test   |
      | password     | Tester |
    Then user should see url contains order

