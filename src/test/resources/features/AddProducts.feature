Feature: Add products using Post API
  @PostStatusCode
  Scenario: Verify the post products api status code works correctly
    Given I configure the url of post products api endpoint
    When I pass the request body of product
    Then I receive the response code as 200

  @PostId
  Scenario Outline: Verify the post products api response body works correctly
    Given I configure the url of post products api endpoint
    When I pass the request body of product
    Then I receive the response body with id as "<id>"
    Examples:
      | id  |
      | 21  |
