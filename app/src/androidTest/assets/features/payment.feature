Feature: Payments

    As an user I want to make a payment to a known account

  @test
  Scenario: Carlo wants to make a transaction to his friend Samuel
    Given Carlo has an account on the DemoBankApp
    When Carlo wants to make a transfer from 11.08 euro's to his friend Samuel
    Then Carlo should see the transaction on his dashboard

