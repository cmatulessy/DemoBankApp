package com.carlomatulessy.demobankapp.cucumber.resources;

import com.carlomatulessy.demobankapp.cucumber.resources.objects.UiElement;

import java.util.HashMap;

import cucumber.runtime.CucumberException;

/**
 * Created by CMATULES on 14-11-2016.
 *
 * This class household the parsed data from the json files. It can also update testdata during a test so you can keep track
 * of certain testdata.
 */

public class ResourceManager {

    private ResourceManager instance = null;

    private HashMap<String, UiElement> uiElementHashMap;

    protected ResourceManager() {
        ResourceParser parser = new ResourceParser();

    }

    public ResourceManager getResourceManager() {
        if(instance == null) {
            instance = new ResourceManager();
        }

        return instance;
    }

    public String getResourceIdFromUIElement(String resourceObjectKey) {
        if(uiElementHashMap.containsKey(resourceObjectKey)) {
            return uiElementHashMap.get(resourceObjectKey).toString();
        } else {
            throw new CucumberException("ResourceObjectKey "+resourceObjectKey+" could not be found, plesae consult your uielements.json!");
        }
    }


}
