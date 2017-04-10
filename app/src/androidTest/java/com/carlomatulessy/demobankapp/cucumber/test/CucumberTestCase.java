package com.carlomatulessy.demobankapp.cucumber.test;

import junit.framework.TestCase;

import cucumber.api.CucumberOptions;

/**
 * Created by CarloMatulessy on 08/08/16.
 */
@CucumberOptions(
        features = "features",
        tags = "",
        glue = "com.carlomatulessy.demobankapp.cucumber.gluecode")
public class CucumberTestCase extends TestCase{
}
