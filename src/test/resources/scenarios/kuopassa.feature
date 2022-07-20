Feature: Kuopassa functionally
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  @Smoke @Regression
  Scenario: Check Customer Service Page
    Given User opens home page
    When User click on link Customer Service
    Then The user sees new page with title Customer Service

  Scenario Outline: Check add product to shopping cart
    Given User opens home page
    When User click on purple duck
    And The user set '<quantity of product>'
    And User clicks add to cart
    Then The user sees '<quantity of product>'in shopping cart
    Examples:
      | quantity of product |
      | 1                   |
      | 2                   |

  @Regression
  Scenario Outline: Check quantity of product and price
    Given User opens home page
    When Get product list
    And Check quantity equals expected
    Then Check that at least '<number of products>' have '<expected price>'
    Examples:
      | number of products | expected price |
      | 2                  | 20.00          |


  Scenario Outline: Check availability purchased goods in cart
    Given User opens home page
    When Get '<number of product>' on Product Page
    And Get title and price of product
    And Add product to cart
    And Open cart
    Then Check this product in the cart
    Examples:
      | number of product |
      | 1                 |

  Scenario: Check filter of product by price new
    Given User on filter page
    When User click on filter by price
    Then User sees that products are filtered


