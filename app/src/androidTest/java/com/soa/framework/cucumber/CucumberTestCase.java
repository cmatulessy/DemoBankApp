package com.soa.framework.cucumber;

import junit.framework.TestCase;

import cucumber.api.CucumberOptions;

/**
 * Created by CarloMatulessy on 08/08/16.
 */
@CucumberOptions(
        features = "features",
        tags = "@test",
        glue = "com.soa.app")
public class CucumberTestCase extends TestCase{
}
