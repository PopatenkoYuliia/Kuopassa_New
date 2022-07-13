Feature: Kuopassa functionally
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


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
      | quantity of product|
      | 1                  |
      | 2                  |

    Scenario: Check quantity of product and price
      Given User opens home page
      When Get product list
      And Check quantity equals expected
      Then Check that minimal quantity of product has expected price

  Scenario: Check availability purchased goods in cart
    Given User opens home page
    When Get first product
    And Get title and price first product
    And Add product to cart
    And Open cart
    Then Check this product in the cart

  Scenario: Check filter of product by price
    Given User on filter page
    When User sees no filter price of product and click on filter by price
    Then User sees that products are filtered by price



