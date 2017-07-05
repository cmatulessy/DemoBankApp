package com.soa.framework.app.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class Payments {

    @Given("^([^\"]*) has an account on the DemoBankApp$")
    public void carloHasAnAccountOnTheDemoBankApp(String actorName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^([^\"]*) wants to make a transfer from ([^\"]*) euro's to his friend ([^\"]*)$")
    public void carloWantsToMakeATransferFromEuroSToHisFriendSamuel(String actorName, String amount, String secondActorName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Carlo should see the transaction on his dashboard$")
    public void carloShouldSeeTheTransactionOnHisDashboard(String actorName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
