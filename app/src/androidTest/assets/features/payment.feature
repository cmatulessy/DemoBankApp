Feature: Payments
  * amount above 100 euro are charged with fee
  * ABN recipients don't pay a transfer fee
  * ING recipients pay a transfer fee


  @test
  Scenario Outline: Calculate the transfer fee and add it to the amount to pay
    Given the user <recipient bank name>
    When I create a payment with <amount>
    Then the customer is charged with <fee>

  Examples:
  | recipient bank name | amount  | fee   |
  | ABN                 | 1.00    | 0.00  |
  | ING                 | 1.00    | 0.25  |