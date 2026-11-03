@sanity

Feature: Creation of new user go rest website

  Scenario Outline: Validate cretion of new user go rest
    Given user establish connection with server
    And user sends a payload body
    When user hits the go rest endpoint with details as "<endpoint>"
    Then user validates the response time and status code as "<status_code>"

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
