package com.soa.framework.app;

import com.carlomatulessy.demobankapp.R;
import com.soa.framework.app.configuration.Settings;
import com.soa.framework.core.actors.Actor;
import com.soa.framework.core.actors.ActorManager;
import com.soa.framework.core.interactions.Enter;

import cucumber.api.java.en.Given;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class Common extends Settings{

    @Given("^([^\"]*) has an account on the DemoBankApp$")
    public void carloHasAnAccountOnTheDemoBankApp(String actorName) throws Throwable {
        assertNotNull(getActivity());

        Actor selectedActor = ActorManager.getInstance().getSelectedActorByName(actorName);
        selectedActor.attemptsTo(Enter.theValue("test").into(R.id.mutation_transfer_button));
    }
}
