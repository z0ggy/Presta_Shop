Feature:

  Scenario: Shopping pay and screenshot
    Given zaloguje się na tego samego użytkownika z zadania 1,
    When wybierze do zakupu Hummingbird Printed Sweater
    And wybierze rozmiar M
    And wybierze 5 sztuk według parametru podanego w teście
    And dodaj produkt do koszyka,
    And przejdzie do opcji - checkout,
    And potwierdzi address (możesz go dodać wcześniej ręcznie),
    And wybierze metodę odbioru - PrestaShop "pick up in store",
    And wybierze opcję płatności - Pay by Check,
    And kliknie na "order with an obligation to pay",
    Then zrobi screenshot z potwierdzeniem zamówienia i kwotą.
