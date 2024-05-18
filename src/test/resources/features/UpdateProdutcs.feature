Feature: Update products using Put API
  Scenario Outline: Verify the put products api status code works correctly
    Given I hit the url of put products api endpoint
    When I pass the url of products in the request with "<ProductId>"
    Then I catch the response code as 200
    Examples:
      | ProductId |
      |  7        |

  Scenario Outline: Verify the put products api response body works correctly
    Given I hit the url of put products api endpoint
    When I pass the url of products in the request with "<ProductId>"
    Then I catch the response body with id as "<id>"
    Examples:
      | ProductId | id |
      |  7        | 7 |