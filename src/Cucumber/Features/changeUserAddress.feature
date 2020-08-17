Feature: Change user address

  Scenario Outline: Add new address
    Given Log in to CodersLab shop
    When User click on user name
    And User click on Addresses tile
    And User set following alias "<alias>"
    And User set following address "<address>"
    And User set following city "<city>"
    And User set following post code "<postCode>"
    And User set following country "<country>"
    And User set following phone "<phone>"
    Then User submits add new address form
    And User delete address
    And User check the address is deleted
    And close driver
    Examples:
      | alias      | city        | postCode | country        | phone        | address         |
      | Grunwald   | Ladek Zdroj | 00-000   | United Kingdom | 004878965033 | Kolejowa street |
    #  | Zasadniczo | Praga       | 000-001  | United Kingdom | 0045876921   | Ogorkowa        |