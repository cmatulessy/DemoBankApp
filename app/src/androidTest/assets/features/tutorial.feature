# (1) Write a gherkin feature that tests doing a complete payment by only
# tapping on user interface elements
# and by entering test data (typing text)
# You only need to write Gherkin to complete this assignment.
# The beginning is there. Just add some steps
# Good luck!

# Extra Instructions:
# -------------------
# Steps you need to finish this assignment, prefixed each with either Given, When, Then or And:
# I tap on button (.*)
# I enter (.*) in the (.*) field

@test
Feature: Payments
  Scenario: As a user I want to make a payment

  #Given ......
  #When .....
  #And .....
  #Then .....
    Given I tap on button transfer



# (2) add a scenario to the payment feature by only writing Gherkin.
# now tap the first transaction and then complete the payment
# Start by un-commenting the next line and then add Given-When-Then lines.
#
# Extra Instructions:
# -------------------
# Steps you can use, prefix each with either Given, When, Then or And:
# I tap on button (.*)
# I enter (.*) in the (.*) field
# I tap on the first mutation item

# Scenario: As a user I want to quickly do a payment to the first mutation item from the transaction list.


# (3) add a scenario to make a payment until confirmation screen and then navigate back to transaction screen.
# Start by un-commenting the next line. (Add back action to your code)

# Scenario: As a user I want to be able to navigate back to transactions if I do not want to confirm the payment.



# (4) Android only extra challenge (Need Coding skills!): webview testing
# Write a Gherkin test script that automates tapping through the webview. Navigate from the dashboard to the settings menu and click "Werken bij Capgemini" or About -> one of the displayed buttons
