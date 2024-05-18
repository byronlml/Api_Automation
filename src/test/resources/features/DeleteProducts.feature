Feature: Delete products using DELETE API
  @DeleteResponseCode
  Scenario Outline: Verify the delete products api status code works correctly
    Given I hit the url of delete products api endpoint
    When I pass the url of delete products in the request with "<ProductId>"
    Then I get the response code as 200
    Examples:
      | ProductId |
      |  7        |