@sanity

Feature: Create a new user for reqres

  Scenario Outline: Validate Creation of new user reqres
    Given user hits the reqres server with baseuri
    And user passes the payload data along with request and hits the "<endpoint>"
    When user gets the response from the server
    Then user validates the reponse with "<response_code>"

    Examples: 
      | endpoint  | response_code |
      | api/users |           201 |
