package com.carlomatulessy.demobankapp.cucumber.resources;

import android.support.test.InstrumentationRegistry;

import com.carlomatulessy.demobankapp.cucumber.resources.objects.Screen;
import com.carlomatulessy.demobankapp.cucumber.resources.objects.UIElement;

import java.util.HashMap;

import cucumber.runtime.CucumberException;

/**
 * Created by CMATULES on 14-11-2016.
 *
 * This class household the parsed data from the json files. It can also update testdata during a test so you can keep track
 * of certain testdata.
 */

public class ResourceManager {

    private static ResourceManager instance = null;

    private HashMap<String, UIElement> uiElementHashMap;
    private HashMap<String, Screen> screenHashMap;

    protected ResourceManager() {
        ResourceLoader loader = new ResourceLoader();
        uiElementHashMap = loader.getHashMapWithParsedUIElements();
        screenHashMap = loader.getHashMapWithParsedScreens();
    }

    public static ResourceManager getResourceManager() {
        if(instance == null) {
            instance = new ResourceManager();
        }

        return instance;
    }

    public int getResourceIdFromUIElement(String resourceObjectKey) {
        if(uiElementHashMap.containsKey(resourceObjectKey)) {
            return getResourceIdFromResourceObjectKey(uiElementHashMap.get(resourceObjectKey).getAndroid());
        } else {
            throw new CucumberException("ResourceObjectKey "+resourceObjectKey+" could not be found, plesae consult your uielements.json!");
        }
    }

    public int[] getResourceIdsFromScreen(String screenName) {
        if(screenHashMap.containsKey(screenName)) {
            int[] resourceIds = new int[screenHashMap.get(screenName).getAndroid().length];

            for(int i=0; i< resourceIds.length; i++) {
                resourceIds[i] = getResourceIdFromResourceObjectKey(screenHashMap.get(screenName).getAndroid()[i]);
            }

            return resourceIds;
        } else {
            throw new CucumberException("Screen "+screenName+" could not be found, plesae consult your screens.json!");
        }
    }

    private int getResourceIdFromResourceObjectKey(String resourceObjectKey) {
        return InstrumentationRegistry.getTargetContext().getResources().getIdentifier(resourceObjectKey, "id", InstrumentationRegistry.getTargetContext().getPackageName());
    }


}
