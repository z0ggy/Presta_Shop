Feature: choose and order product

  Scenario:
    Given User logged in to CodersLab shop
    When User click on product
    And User check is the product on discount 20
    And User will choose the size XL of the product
    And User will choose 5 pieces
    And User will add item to cart
    And User will proceed to checkout
    And User will proceed to checkout from shopping cart
    And User will fill address form
    And User will choose delivery method
    And User will choose payment option "Pay by check"
    Then User will click order with an obligation to pay
    And close browser

