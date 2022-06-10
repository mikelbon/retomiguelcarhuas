@challenge

Feature: Rimac Seguros - Reto Tecnico

  Background:
    Given I access the ebay website

  Scenario: Flow 1 - Shoe price comparison
    When I find sneaker "zapatilla deportiva"
    And I filter by Blanco and Rojo color
    And brand is
      | brands |
      | adidas |
      | wilson |
   Then I get the price of the third shoe

  Scenario: Flow 2 - Price Validation
    When buyer goes to "House and Garden"
    And buyer goes to "materiales de bricolaje"
    And buyer goes to "Puertas de Garage"
    And buyer select ditec option
    Then price should be "19 EUR"