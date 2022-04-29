Feature: Order products logged in-1

  Logged in Customer should be able to order items with delivery as courier or
  in-store pickup if available. Also Customer should be able to order as
  a Company. All order payment options should be available to use.

  Scenario: Login and Order with courier delivery and card payment (click same shipping address checkbox)

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he clicks the same shipping address checkbox
    And he selects card payment
    Then he should ensure that he is on the payment page

  Scenario: Login and Order with courier delivery and transfer payment (click same shipping address checkbox)

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he clicks the same shipping address checkbox
    And he selects transfer payment
    Then he should ensure that he is on the payment page

  Scenario: Login and Order with courier delivery and pickup payment (click same shipping address checkbox)

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he clicks the same shipping address checkbox
    And he selects pickup payment
    Then he should ensure that he is on the payment page

  Scenario: Login and Order with courier delivery and card payment

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he selects card payment
    Then he should ensure that he is on the payment page

  Scenario: Login and Order with courier delivery and transfer payment

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he selects transfer payment
    Then he should ensure that he is on the payment page

  Scenario: Login and Order with courier delivery and pickup payment

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he selects pickup payment
    Then he should ensure that he is on the payment page

  Scenario: Login and Order with courier delivery and card payment (changes shipping address)

    Given that Oscar is logged in 1
    When he orders "mug" using courier delivery
    And he changes shipping address
    And he selects card payment
    Then he should ensure that he is on the payment page



