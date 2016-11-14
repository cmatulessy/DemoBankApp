package com.carlomatulessy.demobankapp.cucumber.resources;

/**
 * Created by CMATULES on 14-11-2016.
 *
 * This class household the parsed data from the json files. It can also update testdata during a test so you can keep track
 * of certain testdata.
 */

public class ResourceManager {

    private ResourceManager instance = null;

    protected ResourceManager() {}

    public ResourceManager getResourceManager() {
        if(instance == null) {
            instance = new ResourceManager();
        }

        return instance;
    }
}
