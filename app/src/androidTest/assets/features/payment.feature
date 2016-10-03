Feature: Payments
  Making a payment from my own account

  @test
  Scenario Outline: As a user I want to make a payment

    #Make a transaction to account Espresso

    Examples:
      | name     | account number         |
      | Espresso | NL34 INGB 0001 1234 56 |
