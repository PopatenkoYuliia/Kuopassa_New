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

