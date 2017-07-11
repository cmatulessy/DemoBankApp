package com.soa.framework.core.actors;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.carlomatulessy.demobankapp.cucumber.resources.objects.UIElement;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Carlo Matulessy on 11-7-17.
 */

public class ActorsLoader {

    private static final String BASE_PATH = "resources/";
    private static final String ACTORS_PATH= BASE_PATH + "actors.json";

    private Context mAppContext;

    public ActorsLoader() {
        mAppContext = InstrumentationRegistry.getContext();
    }

    public HashMap<String, Actor> getAllActors() {
        HashMap<String, Actor> actorsList = new HashMap<>();
        try{
            InputStream inputStream = mAppContext.getAssets().open(ACTORS_PATH);
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));

            final Actor[] actors = new Gson().fromJson(jsonReader, Actor[].class);
            jsonReader.close();

            for(Actor actor : actors) {
                String name = actor.getName().toLowerCase();

                if(!actorsList.containsKey(name)) {
                    actorsList.put(name, actor);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return actorsList;
    }
}
