package com.carlomatulessy.demobankapp.cucumber.resources;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.carlomatulessy.demobankapp.cucumber.resources.objects.Screen;
import com.carlomatulessy.demobankapp.cucumber.resources.objects.UIElement;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;



/**
 * Created by CMATULES on 14-11-2016
 *
 * This class is used to parse the json to the correct object formats
 */

public class ResourceLoader {

    private static final String BASE_PATH = "resources/";
    private static final String UIELEMENTS_PATH = BASE_PATH + "uielements.json";
    private static final String SCREENS_PATH = BASE_PATH + "screens.json";

    // AppContext is used to get the json, targetContext to find the ids
    private Context mAppContext;

    public ResourceLoader() {
        mAppContext = InstrumentationRegistry.getContext();
    }

    public HashMap<String, UIElement> getHashMapWithParsedUIElements() {
        HashMap<String, UIElement> uiElementHashMap = new HashMap<>();

        try{
            InputStream inputStream = mAppContext.getAssets().open(UIELEMENTS_PATH);
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));

            final UIElement[] uiElements = new Gson().fromJson(jsonReader, UIElement[].class);
            jsonReader.close();

            for(UIElement uiElement : uiElements) {
                String key = uiElement.getKey().toLowerCase();

                if(!uiElementHashMap.containsKey(key)) {
                    uiElementHashMap.put(key, uiElement);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return uiElementHashMap;
    }

    public HashMap<String, Screen> getHashMapWithParsedScreens() {
        HashMap<String, Screen> screenHashMap = new HashMap<>();

        try{
            InputStream inputStream = mAppContext.getAssets().open(SCREENS_PATH);
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));

            final Screen[] screens = new Gson().fromJson(jsonReader, Screen[].class);
            jsonReader.close();

            for(Screen screen : screens) {
                String key = screen.getKey().toLowerCase();

                if(!screenHashMap.containsKey(key)) {
                    screenHashMap.put(key, screen);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return screenHashMap;
    }

}
