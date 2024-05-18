Feature: Get all the products using API
  @GetResponseCode
  Scenario: Verify the get api for products
    Given I configure the url of get products api endpoint
    When I pass the url of products in the request
    Then I validate the response code as 200

  @GetRateValidation
  Scenario Outline: Verify the rate of the first product is correct
    Given I configure the url of get products api endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is "<FirstProductRate>"
    Examples:
      | FirstProductRate |
      | 3.9.0              |