Feature: Wikipedia search functionality and verification

  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Bill Gates" in the wiki search box
    And User clicks wiki search button
    Then User sees "Bill Gates" is in the main header

  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title
@scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header

  @soccerPlayers
    Examples: search values we are going to be using in this scenario is as below
      | searchValue       | expectedTitle     | expectedMainHeader |
      | Steve Jobs        | Steve Jobs        | Steve Jobsss       |
      | Cristiano Ronaldo | Cristiano Ronaldo | Cristiano Ronaldo  |
      | Bob Marley        | Bob Marley        | Bob Marley         |
      | Chuck Norris      | Chuck Norris      | Chuck Norris       |
      | Marie Curie       | Marie Curie       | Marie Curie        |