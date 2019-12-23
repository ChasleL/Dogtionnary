package com.example.dogtionary.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogRestAPI {
    static final String BASE_URL = "https://dog.ceo/api/";
    private static DogAPI instanceAPI;

    public static DogAPI getInstance() {
        // If instanceAPI doesn't exist, create it before using it
        if(instanceAPI == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            // Create the instanceAPI of DiceAPI
            instanceAPI = retrofit.create(DogAPI.class);
        }
        // Set instanceAPI of api
        return instanceAPI;
    }
}
