package com.soa.framework.app;

import com.soa.framework.app.configuration.Settings;

import cucumber.api.java.en.Given;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class Common extends Settings{

    @Given("^([^\"]*) has an account on the DemoBankApp$")
    public void carloHasAnAccountOnTheDemoBankApp(String actorName) throws Throwable {
        assertNotNull(getActivity());

        //TODO create actor
    }
}
