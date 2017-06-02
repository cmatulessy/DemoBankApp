Feature: Payments
  * amount above 100 euro are charged with fee
  * ABN recipients don't pay a transfer fee
  * ING recipients pay a transfer fee

  Scenario Outline: Calculate the transfer fee and add it to the amount to pay
    Given the <recipient> is from
    When I do a payment to <amount> is
    Then the customer is charged with <fee>

  Examples:
  | recipient | amount | fee |
  | ABN       | 10     | 0.00|
  | ING       | 10     | 1.00| 