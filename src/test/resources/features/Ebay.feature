@challenge

Feature: Rimac Seguros - Reto Tecnico

  Background:
    Given I access the ebay website

  Scenario: Flow 1 - Shoe price comparison
    When I find sneaker "zapatilla deportiva"
    And I filter by Blanco and Rojo color
#    And brand is
#      | adidas |
#      | wilson |
#    Then I get the price of the third shoe