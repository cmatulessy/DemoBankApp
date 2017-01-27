package com.carlomatulessy.demobankapp.cucumber.spoon;

import cucumber.api.Scenario;

/**
 * Created by CarloMatulessy on 27/01/2017.
 */

public class TestCaseManager {

    private static TestCaseManager instance = null;

    private BaseTestCase currentTestCase;
    private Scenario currentScenario;

    public static TestCaseManager getManager() {
        if(instance == null) {
            instance = new TestCaseManager();
        }

        return instance;
    }

    public void setCurrentTestCase(BaseTestCase currentTestCase) {
        this.currentTestCase = currentTestCase;
    }

    public void setCurrentScenario(Scenario currentScenario) {
        this.currentScenario = currentScenario;
    }

    public BaseTestCase getCurrentTestCase() {
        return currentTestCase;
    }

    public Scenario getCurrentScenario() {
        return currentScenario;
    }
}

